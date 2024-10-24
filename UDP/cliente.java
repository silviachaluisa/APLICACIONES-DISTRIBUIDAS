import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class cliente {
    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);
            String follow;
            DatagramSocket socket = new DatagramSocket();
            //Direccion Ip del servidor
            // IP_servidor =  InetAddress.getByName("localhost");
            InetAddress IP_servidor =  InetAddress.getByName("172.29.39.160");

            do { 
                //Mensaje a enviar
                System.out.println("Escribe un mensaje para el servidor\n>");
                // String respuesta= "Hola me llamo silvia ";
                String respuesta= scanner.nextLine();

                //## de bytes para enviar los datos
                byte[] bufferSalida = respuesta.getBytes();

                //Crear paquetes para recibir los datos del cliente
                DatagramPacket paqueteSalida = new DatagramPacket(bufferSalida, bufferSalida.length, IP_servidor,3000);
                socket.send(paqueteSalida);


                //## de bytes para recibir los datos
                byte[] bufferEntrada = new byte[1024];

                //Crear paquetes para recibir los datos del cliente
                DatagramPacket paqueteEntrada = new DatagramPacket(bufferEntrada, bufferEntrada.length);

                //Recibir el mensaje del cliente
                socket.receive(paqueteEntrada);

                //Extraer la información del paquete recibido
                String mensajeRecibido = new String(paqueteEntrada.getData(),0,paqueteEntrada.getLength());
                System.out.println(mensajeRecibido);
                System.out.println("Deseas continuar? (s/n)");
                follow=scanner.nextLine().toLowerCase();
                
            } while (follow.equals("s"));

            scanner.close();

        } catch (IOException e) {
            //Todo auto-generated catch block
            e.printStackTrace();
        }
        

    }

}
