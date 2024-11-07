import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class clienteTCP {
    public static void main(String[] args) {
        try (Socket socket_cliente = new Socket("localhost", 1234);
             BufferedReader buffer_entrada = new BufferedReader(new InputStreamReader(socket_cliente.getInputStream()));
             PrintWriter buffer_salida = new PrintWriter(socket_cliente.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            String mensaje;
            while (true) {
                System.out.print("Escribe tu mensaje (o 'exit' para salir): ");
                mensaje = scanner.nextLine();
                buffer_salida.println(mensaje);

                if (mensaje.equalsIgnoreCase("exit")) {
                    System.out.println("Cerrando conexión con el servidor...");
                    break;
                }
                // Recibir respuesta del servidor
                String respuesta = buffer_entrada.readLine();
                if (respuesta == null) {
                    System.out.println("El servidor ha cerrado la conexión.");
                    break;
                }
                System.out.println("Servidor: " + respuesta);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
