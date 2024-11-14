import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class cliente {
    public static void main (String [] args){
        try {
            //Obtener registrp en el puerto indicado
            Registry registro = LocateRegistry.getRegistry("localhotst",1099);

            //Crear instancia de la implementacion de la interfaz
            interfaz objetoRemoto = (interfaz) registro.lookup("ClienteRemoto");

            String mensaje=objetoRemoto.mensaje();
            System.out.println();
            double respuesta=objetoRemoto.operacion(5, 8);
            System.out.println(respuesta);

            
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
    
}
