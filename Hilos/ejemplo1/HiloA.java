package ejemplo1;
public class HiloA extends Thread{

    public void run(){
        for(int i=0; i<5 ; i++){
            System.out.println("A " +i);
        }
   
    }
    
}