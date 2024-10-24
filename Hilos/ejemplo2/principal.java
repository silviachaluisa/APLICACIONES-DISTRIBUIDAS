package ejemplo2;

public class principal {

    public static void imprimir(int valor){
        for (int i=0; i< valor; i++){
            System.out.println("Hilo principal: "+i);
        }
    }

    public static void main(String[] args) {
        Hilo hilo1=new Hilo();
        hilo1.start();

        imprimir(5);

        try {
            hilo1.join();
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Todos los hilos han terminadoS");

    }
    


}
