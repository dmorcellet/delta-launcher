package delta.launcher.data.io.xml;

import java.io.File;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

import delta.common.utils.xml.DOMParsingTools;
import delta.launcher.data.Classpath;
import delta.launcher.data.LauncherConfiguration;

/**
 * Parser for launcher configurations stored in XML.
 * @author DAM
 */
public class LauncherConfigurationXMLParser
{
  /**
   * Build a launcher configuration from an XML tag.
   * @param root Root XML tag.
   * @return A launcher configuration.
   */
  public static LauncherConfiguration parseLauncherConfiguration(Element root)
  {
    LauncherConfiguration ret=new LauncherConfiguration();
    NamedNodeMap attrs=root.getAttributes();
    // Main class
    String mainClass=DOMParsingTools.getStringAttribute(attrs,LauncherConfigurationXMLConstants.LAUNCHER_MAIN_CLASS_ATTR,"");
    ret.setMainClass(mainClass);
    // Root directory
    String rootDirStr=DOMParsingTools.getStringAttribute(attrs,LauncherConfigurationXMLConstants.LAUNCHER_ROOT_DIR_ATTR,"");
    File rootDir=new File(rootDirStr);
    ret.setRootDir(rootDir);
    // Classpath
    Element classpathTag=DOMParsingTools.getChildTagByName(root,ClasspathXMLConstants.CLASSPATH_TAG);
    if (classpathTag!=null)
    {
      Classpath classpath=ClasspathXMLParser.parseClasspath(classpathTag);
      ret.setClasspath(classpath);
    }
    return ret;
  }
}
