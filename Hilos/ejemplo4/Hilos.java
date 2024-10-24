package ejemplo4;

public class Hilos extends Thread{
    private static final Object lock= new Object();

    private int idHilo;

    //Constructor para identificar el hilo
    public Hilos(int idHilo){
        this.idHilo=idHilo;
    }

    public void run(){
        imprimir(5, "Hilo" + idHilo);

    }

    // Metodo imprimir
    public void imprimir(int n, String nombre) {
        synchronized (lock) { // Bloqueo de la sección crítica
            System.out.println("----------" +"Inicio de hilo: " + nombre.toUpperCase() + "----------");
            for (int i = 1; i <= n; i++) {
                System.out.println("Hilo: " + nombre.toUpperCase() + ": "+ i);
            }
            System.out.println("----------" + "Fin de hilo: " + nombre.toUpperCase() + "----------");
        }
    }
}
