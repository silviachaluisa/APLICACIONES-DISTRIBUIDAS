package ejemplo5;

public class Hilos extends Thread{
    private String archivo;
    private static  Object lock= new Object();

    //Constructor para identificar el hilo
    public Hilos(String archivo){
        this.archivo=archivo;
    }

    public void run(){
        descarga();

    }

    // Metodo imprimir
    public void descarga() {
        System.out.println("Asignando turno: " + archivo);
        try {
            synchronized (lock) { // Sincronización de hilos
                lock.wait(100); // Simulación de descarga
            }
        } catch (InterruptedException e) {
            e.printStackTrace(); // Manejo de excepciones
        }
        System.out.println("Turno asigando: " + archivo);
    }
}
