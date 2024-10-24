import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class hiloClienteServ extends Thread {
    private Socket socket_cliente;

    public hiloClienteServ(Socket socket_cliente) {
        this.socket_cliente = socket_cliente;
    }

    public void run() {
        try (BufferedReader buffer_entrada = new BufferedReader(new InputStreamReader(socket_cliente.getInputStream()));
             PrintWriter buffer_salida = new PrintWriter(socket_cliente.getOutputStream(), true)) {

            String mensaje_recibido;
            while ((mensaje_recibido = buffer_entrada.readLine()) != null) {
                System.out.println("Cliente: " + mensaje_recibido);

                // Responder al cliente
                String respuesta = "Hola, recibí tu mensaje: " + mensaje_recibido;
                buffer_salida.println(respuesta);

                // Preguntar si el cliente quiere seguir
                // buffer_salida.println("¿Deseas enviar otro mensaje? (sí/no)");
                String continuar = buffer_entrada.readLine();
                if (continuar.equalsIgnoreCase("exit")) {
                    System.out.println("El cliente ha cerrado la conexión.");
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket_cliente.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
