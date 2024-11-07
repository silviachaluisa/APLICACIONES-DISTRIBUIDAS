import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class hiloClienteServ extends Thread {
    private Socket socket_cliente;

    public hiloClienteServ(Socket socket_cliente) {
        this.socket_cliente = socket_cliente;
    }

    public void run() {
        try (BufferedReader buffer_entrada = new BufferedReader(new InputStreamReader(socket_cliente.getInputStream()));
             PrintWriter buffer_salida = new PrintWriter(socket_cliente.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            // Hilo para escuchar mensajes del cliente
            Thread recibirMensajes = new Thread(() -> {
                try {
                    String mensaje_recibido;
                    while ((mensaje_recibido = buffer_entrada.readLine()) != null) {
                        System.out.println("Cliente: " + mensaje_recibido);
                        if (mensaje_recibido.equalsIgnoreCase("exit")) {
                            System.out.println("El cliente ha cerrado la conexión.");
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            recibirMensajes.start();

            // Enviar mensajes al cliente
            String mensaje_servidor;
            while (true) {
                System.out.print("Escribe tu respuesta para el cliente (o 'exit' para salir): ");
                mensaje_servidor = scanner.nextLine();
                buffer_salida.println(mensaje_servidor);

                if (mensaje_servidor.equalsIgnoreCase("exit")) {
                    System.out.println("Cerrando conexión con el cliente...");
                    break;
                }
            }

            recibirMensajes.join();

        } catch (IOException | InterruptedException e) {
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
