import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class servidorTCP {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Servidor escuchando en el puerto 1234...");

            while (true) {
                Socket socket_cliente = serverSocket.accept();
                System.out.println("Cliente conectado: " + socket_cliente.getInetAddress());

                hiloClienteServ hilo = new hiloClienteServ(socket_cliente);
                hilo.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
