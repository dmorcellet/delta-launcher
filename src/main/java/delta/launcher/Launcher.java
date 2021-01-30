package delta.launcher;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import delta.launcher.data.Classpath;
import delta.launcher.data.LauncherConfiguration;

/**
 * Application launcher.
 * Launches a main class using a classpath specified in a XML file.
 * @author DAM
 */
public class Launcher
{
  private static URLClassLoader buildClassLoader(LauncherConfiguration config)
  {
    File rootDir=config.getRootDir();
    Classpath classpath=config.getClasspath();
    List<URL> urls=new ArrayList<URL>();
    for(File classpathElement : classpath.getElements())
    {
      File file=new File(rootDir,classpathElement.getPath());
      URL url=buildFileURL(file);
      urls.add(url);
    }
    URL[] urlsArray=urls.toArray(new URL[urls.size()]);
    return new URLClassLoader(urlsArray,null);
  }

  private static URL buildFileURL(File file)
  {
    URL url=null;
    try
    {
      String path=file.getPath();
      if (file.isDirectory())
      {
        path=path+"/";
      }
      url=new URL("file",null,path);
    }
    catch(MalformedURLException e)
    {
      // Should not happen !
    }
    return url;
  }

  /**
   * Launch application using the given configuration.
   * @param config Launch configuration.
   */
  public static void launch(LauncherConfiguration config)
  {
    URLClassLoader classLoader=buildClassLoader(config);
    String mainClassName=config.getMainClass();
    try
    {
      // Load the target class
      Class<?> mainClass = classLoader.loadClass(mainClassName);
      Method mainMethod = mainClass.getMethod("main", String[].class);
      // Run
      String[] params = new String[0];
      mainMethod.invoke(null, (Object)params);
    }
    catch(Exception e)
    {
      throw new RuntimeException("",e);
    }
  }
}
