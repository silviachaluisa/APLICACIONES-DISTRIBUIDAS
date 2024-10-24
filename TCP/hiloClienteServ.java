import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class hiloClienteServ extends  Thread {

    //Atributo para el cliente
    private Socket socket_cliente;
    private List<String> preguntas = List.of(
        "¿Ayudame con tu código unico de la EPN",
        "¿Quien es tu docente en la Materia de Aplicaciones Distribuidas?"
        
    );
    private List<String> respuestas_correctas = List.of(
        "345687",
        "Vanessa Guevara"

    );


    public hiloClienteServ(Socket socket_cliente){
        this.socket_cliente=socket_cliente;

    }
    public void run(){
        //Crear los buffers para enviar y recibir los datos
        try(BufferedReader buffer_entrada = new BufferedReader(new InputStreamReader(socket_cliente.getInputStream()));
        PrintWriter buffer_salida = new PrintWriter(socket_cliente.getOutputStream(), true);) {
            for (int i=0)
            
            //Enviar mensaje
            String mensaje_enviar="Hola soy el servidor";
            buffer_salida.println(mensaje_enviar);

            //Cargar Mensaje
            String mensaje_recibido=buffer_entrada.readLine();
            System.out.println(mensaje_recibido);

        } catch (IOException e) {
            //TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
