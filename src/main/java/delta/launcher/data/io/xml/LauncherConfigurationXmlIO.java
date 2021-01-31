package delta.launcher.data.io.xml;

import java.io.File;

import javax.xml.transform.sax.TransformerHandler;

import org.w3c.dom.Element;

import delta.common.utils.io.xml.XmlFileWriterHelper;
import delta.common.utils.io.xml.XmlWriter;
import delta.common.utils.text.EncodingNames;
import delta.common.utils.xml.DOMParsingTools;
import delta.launcher.data.LauncherConfiguration;

/**
 * XML I/O facilities for launcher configurations.
 * @author DAM
 */
public class LauncherConfigurationXmlIO
{
  /**
   * Write a launcher configuration to an XML file.
   * @param toFile File to write to.
   * @param config Data to save.
   * @return <code>true</code> if it succeeds, <code>false</code> otherwise.
   */
  public static boolean writeFile(File toFile, final LauncherConfiguration config)
  {
    XmlFileWriterHelper helper=new XmlFileWriterHelper();
    XmlWriter writer=new XmlWriter()
    {
      @Override
      public void writeXml(TransformerHandler hd) throws Exception
      {
        LauncherConfigurationXMLWriter.writeLauncheConfiguration(hd,config);
      }
    };
    boolean ret=helper.write(toFile,EncodingNames.UTF_8,writer);
    return ret;
  }

  /**
   * Parse a launcher configuration XML file.
   * @param source Source file.
   * @return Parsed directory entry.
   */
  public static LauncherConfiguration parseFile(File source)
  {
    Element root=DOMParsingTools.parse(source);
    if (root!=null)
    {
      return LauncherConfigurationXMLParser.parseLauncherConfiguration(root);
    }
    return null;
  }
}
