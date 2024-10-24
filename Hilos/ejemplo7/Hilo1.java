package ejemplo7;

public class Hilo1 implements  Runnable {
    public void run(){
        for (char c = 'a'; c <= 'z'; c++) {
            System.out.println("Hilo 1: " + c);
        }
        
    }
    
}
