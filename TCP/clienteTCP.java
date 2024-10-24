import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class clienteTCP {
    public static void main(String[] args) {
        try (Socket socket_cliente = new Socket("172.29.39.160", 3000);
             BufferedReader buffer_entrada = new BufferedReader(new InputStreamReader(socket_cliente.getInputStream()));
             PrintWriter buffer_salida = new PrintWriter(socket_cliente.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            String mensaje;
            while (true) {
                System.out.print("Escribe tu mensaje: ");
                mensaje = scanner.nextLine();
                buffer_salida.println(mensaje);

                // Recibir respuesta del servidor
                String respuesta = buffer_entrada.readLine();
                System.out.println("Servidor: " + respuesta);

                // Preguntar si desea enviar otro mensaje
                System.out.print("¿Deseas enviar otro mensaje? (sí/no): ");
                String continuar = scanner.nextLine();
                buffer_salida.println(continuar);
                if (continuar.equalsIgnoreCase("no")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
