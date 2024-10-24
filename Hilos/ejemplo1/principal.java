package ejemplo1;
public class principal{

    public static void main (String[]args){
        //Crear los hilos
        HiloA hiloA=new HiloA();
        HiloB hiloB=new HiloB();

        //Iniciar los hilos
        hiloA.start();
        hiloB.start();
        //Mensaje del hilo principal
        for(int i=0; i<5; i++){
            System.out.println("Hilo principal; P" + i);
        }
    }
}