import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class servidor {

    public static void main(String[] args) {
         
        try {
            // Crear una instancia de la implementacion de la interfaz
         interfaz objetoRemoto = new implementacionInterfaz();

          //Crear y obtener registro RMI en un puerto específico
          Registry registro = LocateRegistry.createRegistry(1099);
          //Vincular el objeto remoto con un nombre especifico
          registro.rebind("Cliente Remoto", objetoRemoto);
            
        } catch (RemoteException e) {
            e.printStackTrace();
            
        }

    }
    
}
