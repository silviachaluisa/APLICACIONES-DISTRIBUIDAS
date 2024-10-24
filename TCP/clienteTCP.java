import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class clienteTCP {
    public static void main(String[] args) {
       try {
        //Crear un socket para conectarme al servidor
        //Socket socket_cliente = new Socket("localhost", 1234);
        Socket socket_cliente = new Socket("172.29.39.160", 3000);

        //Crear los buffers para enviar y recibir los datos

        BufferedReader buffer_entrada = new BufferedReader(new InputStreamReader(socket_cliente.getInputStream()));
        PrintWriter buffer_salida = new PrintWriter(socket_cliente.getOutputStream(), true);
         
        //Enviar Mensaje
        String mensaje_enviar="Hola soy el cliente";
        buffer_salida.println(mensaje_enviar);

        //Extraer Mensaje
        String mensaje_recibido=buffer_entrada.readLine();
        System.out.println(mensaje_recibido);

       } catch (IOException e) {
        //TODO Auto-generated catch block
        e.printStackTrace();

       }
    }
    
}
