import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class hiloClienteServ extends  Thread {
    private Socket socket_cliente;

    public hiloClienteServ(Socket socket_cliente){
        this.socket_cliente=socket_cliente;

    }
    public void run(){
        //Crear los buffers para enviar y recibir los datos
        try {
            BufferedReader buffer_entrada = new BufferedReader(new InputStreamReader(socket_cliente.getInputStream()));
            PrintWriter buffer_salida = new PrintWriter(socket_cliente.getOutputStream());
            //Extraer mensaje
            String mensaje_recibido=buffer_entrada.readLine();
            System.out.println(mensaje_recibido);

            //Enviar Mensaje
            String mensaje_enviar="Hola soy el servidor";
            buffer_salida.println(mensaje_enviar);

        } catch (IOException e) {
            //TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
