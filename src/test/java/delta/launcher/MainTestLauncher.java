package delta.launcher;

import java.io.File;

import delta.launcher.data.LauncherConfiguration;
import delta.launcher.data.io.xml.LauncherConfigurationXmlIO;

/**
 * A simple launcher test.
 * @author DAM
 */
public class MainTestLauncher
{
  /**
   * Main method for this test.
   * @param args Not used.
   */
  public static void main(String[] args)
  {
    File configFile=new File("launcher.xml");
    LauncherConfiguration config=LauncherConfigurationXmlIO.parseFile(configFile);
    Launcher.launch(config);
  }
}
