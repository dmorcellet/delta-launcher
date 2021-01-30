package delta.launcher;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * A debug version of URLClassLoader.
 * @author DAM
 */
public class DebugURLClassLoader extends URLClassLoader
{
  /**
   * Constructor.
   * @param urls URLs to use.
   * @param parent Parent class loader.
   */
  public DebugURLClassLoader(URL[] urls, ClassLoader parent)
  {
    super(urls,parent);
  }

  @Override
  protected Class<?> findClass(String name) throws ClassNotFoundException
  {
    Class<?> ret=super.findClass(name);
    if (ret!=null)
    {
      System.out.println("Found class: "+name);
    }
    return ret;
  }

  @Override
  public URL findResource(String name)
  {
    URL ret=super.findResource(name);
    if (ret!=null)
    {
      System.out.println("Found resource: "+name);
    }
    else
    {
      System.out.println("Resource not found: "+name);
    }
    return ret;
  }
}
