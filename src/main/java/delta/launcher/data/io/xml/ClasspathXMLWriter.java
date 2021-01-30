package delta.launcher.data.io.xml;

import java.io.File;

import javax.xml.transform.sax.TransformerHandler;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import delta.common.utils.io.xml.XmlWriter;
import delta.launcher.data.Classpath;

/**
 * Writes classpaths to XML documents.
 * @author DAM
 */
public class ClasspathXMLWriter
{
  /**
   * Write a classpath to the given output.
   * @param hd Output.
   * @param classpath Classpath to write.
   * @throws SAXException If an error occurs.
   */
  public static void writeClasspath(TransformerHandler hd, Classpath classpath) throws SAXException
  {
    AttributesImpl attrs=new AttributesImpl();
    hd.startElement("","",ClasspathXMLConstants.CLASSPATH_TAG,attrs);
    // Child elements
    for(File entryPath : classpath.getElements())
    {
      writeClasspathElement(hd,entryPath);
    }
    hd.endElement("","",ClasspathXMLConstants.CLASSPATH_TAG);
  }

  private static void writeClasspathElement(TransformerHandler hd, File path) throws SAXException
  {
    AttributesImpl attrs=new AttributesImpl();
    // Path
    String pathName=path.getPath();
    attrs.addAttribute("","",ClasspathXMLConstants.CLASSPATH_ENTRY_PATH_ATTR,XmlWriter.CDATA,pathName);
    hd.startElement("","",ClasspathXMLConstants.CLASSPATH_ENTRY_TAG,attrs);
    hd.endElement("","",ClasspathXMLConstants.CLASSPATH_ENTRY_TAG);
  }
}
