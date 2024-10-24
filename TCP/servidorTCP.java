import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class servidorTCP{
    public static  void main(String [] args){
        try(ServerSocket socket_cliente_servidor = new ServerSocket(1234)) {
            System.out.println("Servidor escuchando en el puerto 1234...");
            
            //El while sirve para que el servidor se siga ejecutando
            while (true) { 
                //Iniciar la conexion con el cliente
                // Socket socket_cliente=socket_cliente_servidor.accept();
                Socket socket_cliente= socket_cliente_servidor.accept();
                System.out.println("Cliente conectado" +socket_cliente.getInetAddress());
                

                //Crear el hilopra manejar la conexion con el cliente
                hiloClienteServ hilo= new hiloClienteServ(socket_cliente);
                hilo.start();
                
            }

        } catch(IOException e) {
            //TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}