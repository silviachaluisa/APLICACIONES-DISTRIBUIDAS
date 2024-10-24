package ejemplo2;

public class Hilo extends Thread{

    public static void imprimir(int valor){
        for (int i=0; i< valor;i++){
            System.out.println("Hilo Secundario:" +i);
        }
    }
    public void run(){
        imprimir(5);
    }
    
}
