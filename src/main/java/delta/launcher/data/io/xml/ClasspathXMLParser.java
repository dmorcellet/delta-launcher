package delta.launcher.data.io.xml;

import java.io.File;
import java.util.List;

import org.w3c.dom.Element;

import delta.common.utils.xml.DOMParsingTools;
import delta.launcher.data.Classpath;

/**
 * Parser for directory entries stored in XML.
 * @author DAM
 */
public class ClasspathXMLParser
{
  /**
   * Build a classpath from an XML tag.
   * @param root Root XML tag.
   * @return A classpath.
   */
  public static Classpath parseClasspath(Element root)
  {
    Classpath ret=new Classpath();
    // Classpath elements
    List<Element> childTags=DOMParsingTools.getChildTagsByName(root,ClasspathXMLConstants.CLASSPATH_ENTRY_TAG);
    for(Element childTag : childTags)
    {
      // Path
      String pathName=DOMParsingTools.getStringAttribute(childTag.getAttributes(),ClasspathXMLConstants.CLASSPATH_ENTRY_PATH_ATTR,null);
      if (pathName!=null)
      {
        File path=new File(pathName);
        ret.addElement(path);
      }
    }
    return ret;
  }
}
