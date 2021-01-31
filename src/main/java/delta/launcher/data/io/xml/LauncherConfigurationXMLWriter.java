package delta.launcher.data.io.xml;

import java.io.File;

import javax.xml.transform.sax.TransformerHandler;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import delta.common.utils.io.xml.XmlWriter;
import delta.launcher.data.LauncherConfiguration;

/**
 * Writes launcher configurations to XML documents.
 * @author DAM
 */
public class LauncherConfigurationXMLWriter
{
  /**
   * Write a launcher configuration to the given output.
   * @param hd Output.
   * @param launcherConfig Configuration to write.
   * @throws SAXException If an error occurs.
   */
  public static void writeLauncheConfiguration(TransformerHandler hd, LauncherConfiguration launcherConfig) throws SAXException
  {
    AttributesImpl attrs=new AttributesImpl();
    // Main class
    String mainClass=launcherConfig.getMainClass();
    attrs.addAttribute("","",LauncherConfigurationXMLConstants.LAUNCHER_MAIN_CLASS_ATTR,XmlWriter.CDATA,mainClass);
    // Root directory
    File rootDir=launcherConfig.getRootDir();
    String rootDirStr=rootDir.getPath();
    attrs.addAttribute("","",LauncherConfigurationXMLConstants.LAUNCHER_ROOT_DIR_ATTR,XmlWriter.CDATA,rootDirStr);
    hd.startElement("","",LauncherConfigurationXMLConstants.LAUNCHER_CONFIG_TAG,attrs);
    ClasspathXMLWriter.writeClasspath(hd,launcherConfig.getClasspath());
    hd.endElement("","",LauncherConfigurationXMLConstants.LAUNCHER_CONFIG_TAG);
  }
}
