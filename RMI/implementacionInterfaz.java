
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class implementacionInterfaz extends UnicastRemoteObject implements interfaz {

    //Constructor
    public implementacionInterfaz() throws  RemoteException{
        super();
    }
    //Implementar los metodos indicados en la interfaz
    @Override
    public String mensaje() throws RemoteException{
        return "Hola, desde el servidor";
    }
    
    @Override
    public double operacion (double  a, double b){
        return a+b;
    }


    
}
