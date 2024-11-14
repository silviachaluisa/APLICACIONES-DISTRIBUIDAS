import java.rmi.Remote;
import java.rmi.RemoteException;

public interface interfaz extends  Remote{
    //método que el cliente puede invocar

    String mensaje() throws RemoteException;
    double operacion(double a, double b) throws RemoteException;
}