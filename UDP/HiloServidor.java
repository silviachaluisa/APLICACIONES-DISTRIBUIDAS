import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;


public class HiloServidor extends Thread {

    private DatagramSocket socket;
    private DatagramPacket paqueteEntrada;

    public HiloServidor (DatagramSocket socket, DatagramPacket paqueteEntrada){
        this.socket = socket;
        this.paqueteEntrada=paqueteEntrada;
    }
    

    public void run() {
        Scanner scanner = new Scanner(System.in);
        //Obtener la dirección del cliente
        InetAddress IP_cliente= paqueteEntrada.getAddress();
        int puerto_cliente = paqueteEntrada.getPort();

        System.out.println("............");
        System.out.println("Direccion IP del cliente: "+IP_cliente);
        System.out.println("Puerto del cliente: "+puerto_cliente);

        //Extraer la información del paquete recibido
        String mensajeRecibido = new String(paqueteEntrada.getData(),0,paqueteEntrada.getLength());
        System.out.println("Datos Recibidos: "+mensajeRecibido);
        System.out.println("........");

        //Mensaje a enviar
        System.out.println("Escribe un mensaje para el cliente\n");
        String respuesta=scanner.nextLine();
        // String respuesta= "Hola soy el servidor";

         //## de bytes para enviar los datos
         byte[] bufferSalida = respuesta.getBytes();

         //Crear paquetes para recibir los datos del cliente
         DatagramPacket paqueteSalida = new DatagramPacket(bufferSalida, bufferSalida.length, IP_cliente,puerto_cliente);

        //Enviar paquete
        try {
            socket.send(paqueteSalida);
            
        } catch (IOException e) {
            //TODO Auto-generated catch block
            e.printStackTrace();
        }

    
        
    }
}
