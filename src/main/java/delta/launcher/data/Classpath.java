package delta.launcher.data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Classpath description.
 * @author DAM
 */
public class Classpath
{
  private List<File> _elements;

  /**
   * Constructor.
   */
  public Classpath()
  {
    _elements=new ArrayList<File>();
  }

  /**
   * Add a classpath element.
   * @param element Element to add.
   */
  public void addElement(File element)
  {
    _elements.add(element);
  }

  /**
   * Get the classpath elements.
   * @return a list of classpath elements.
   */
  public List<File> getElements()
  {
    return _elements;
  }

  @Override
  public String toString()
  {
    return "Classpath: "+_elements;
  }
}
