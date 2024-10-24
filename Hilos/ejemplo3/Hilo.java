package ejemplo3;

public class Hilo extends  Thread {
    
    public static synchronized void imprimir(String hilo) {
        for(int i=0; i<5;i++){
            System.out.println(hilo +" " +i);
        }
    }

    public void run() {
        imprimir ("Hilo secundario");
    }
    
}
