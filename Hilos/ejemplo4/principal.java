package ejemplo4;

public class principal {
    public static void main(String[] args) {
        for (int i=0; i<11;i++){
            Hilos hilo=new Hilos(i); //Crear un hilo con identificador unico
            hilo.start();
        }
    }
    
}
