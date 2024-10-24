package ejemplo5;

public class principal {
    public static void main(String[] args) {
        String[] archivos ={"Cliente A","Cliente B","Cliente C","Cliente D","Cliente E"};
        for (String archivo : archivos){
            Hilos hilo=new Hilos(archivo); //Crear un hilo con identificador unico
            hilo.start();
        }
    }
    
}
