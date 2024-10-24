import java.net.DatagramPacket;
import java.net.DatagramSocket;
public class servidor {
    public static void main(String[] args) {
        //Crear un socket
        int puerto = 5000;
        try {
            DatagramSocket socket = new DatagramSocket(puerto);
            System.out.println("Esperando conexiones....");
           while(true){
             //## de bytes para recibirt los datos
             byte[] bufferEntrada = new byte[1024];

             //Crear paquetes para recibir los datos del cliente
             DatagramPacket paqueteEntrada = new DatagramPacket(bufferEntrada, bufferEntrada.length);
 
             //Recibir el mensaje del cliente
             socket.receive(paqueteEntrada);
 
             HiloServidor hilo= new HiloServidor(socket, paqueteEntrada);
             hilo.start();   
           }
        } catch (Exception e) {
            //Todo auto-generated catch block
            e.printStackTrace();
        }
    }  
}
