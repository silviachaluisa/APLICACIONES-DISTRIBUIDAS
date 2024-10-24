package ejemplo3;

public class principal {
    public static void main(String[] args) {
        Hilo hilo1 = new Hilo();
        hilo1.start();

        hilo1.imprimir("Hola Marce");

        try {
            hilo1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Todos los hilos han terminado");

    }
    
}
