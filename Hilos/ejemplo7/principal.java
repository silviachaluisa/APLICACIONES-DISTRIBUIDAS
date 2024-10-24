package ejemplo7;

public class principal {
    public static void main(String[] args){
        Hilo1 h1=new Hilo1();
        Hilo2 h2= new Hilo2();

        //Instancias objetos de la clase Thread pasandos los objetos anteriores
        
        Thread t1 = new Thread(h1);
        Thread t2 = new Thread(h2);

        t1.start();
        t2.start();
        //Imprimier numeros
        imprimir();
    }
    public static void imprimir() {
        for (int c = 0; c <= 10; c++) {
            System.out.println("Hilo Principal: " + "P"+c);
        } 
    }
  
}
