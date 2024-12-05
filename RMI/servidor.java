import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {

    public static void main(String[] args) {
        try {
            // Crear una instancia del servidor
            Interfaz server = new implementacionInterfaz();
            
            // Registrar el objeto remoto en el RMI Registry
            Registry registry = LocateRegistry.createRegistry(1099); // Puerto por defecto 1099
            registry.rebind("Convertidor de Temperatura", server);
    
            System.out.println("Servidor de conversión de temperatura listo.");
        } catch (Exception e) {
            System.err.println("Error en el servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}