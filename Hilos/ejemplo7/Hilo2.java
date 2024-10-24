package ejemplo7;

public class Hilo2 implements  Runnable{
    public void run(){
        for (char c = 'A'; c <= 'Z'; c++) {
            System.out.println("Hilo 2: " + c);
        }
    }
    
}
