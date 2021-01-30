package delta.launcher.data;

import java.io.File;

/**
 * Launcher configuration.
 * @author DAM
 */
public class LauncherConfiguration
{
  private String _mainClass;
  private File _rootDir;
  private Classpath _classpath;

  /**
   * Constructor.
   */
  public LauncherConfiguration()
  {
    _mainClass="foo.bar.Main";
    _rootDir=new File("");
    _classpath=new Classpath();
  }

  /**
   * Get the main class.
   * @return a class name.
   */
  public String getMainClass()
  {
    return _mainClass;
  }

  /**
   * Set the main class.
   * @param mainClass Class name to set.
   */
  public void setMainClass(String mainClass)
  {
    _mainClass=mainClass;
  }

  /**
   * Get the root directory for the classpath.
   * @return A directory.
   */
  public File getRootDir()
  {
    return _rootDir;
  }

  /**
   * Set the root directory.
   * @param rootDir Root directory to use.
   */
  public void setRootDir(File rootDir)
  {
    _rootDir=rootDir;
  }

  /**
   * Get the classpath to use.
   * @return a classpath.
   */
  public Classpath getClasspath()
  {
    return _classpath;
  }

  /**
   * Set the classpath to use.
   * @param classpath Classpath to use.
   */
  public void setClasspath(Classpath classpath)
  {
    _classpath=classpath;
  }

  @Override
  public String toString()
  {
    return "Launcher configuration: mainClass="+_mainClass+", root directory="+_rootDir+", classpath="+_classpath;
  }
}
