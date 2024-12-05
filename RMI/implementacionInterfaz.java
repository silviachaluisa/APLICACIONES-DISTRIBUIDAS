import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class implementacionInterfaz extends UnicastRemoteObject implements Interfaz {

    public implementacionInterfaz() throws RemoteException {
        super();
    }

    @Override
    public double celsiusToFahrenheit(double celsius) throws RemoteException {
        return (celsius * 9/5) + 32;
    }

    @Override
    public double fahrenheitToCelsius(double fahrenheit) throws RemoteException {
        return (fahrenheit - 32) * 5/9;
    }   
}
