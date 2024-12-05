import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            // Obtener el registro RMI
            Registry registro = LocateRegistry.getRegistry("localhost", 1099);
            // Buscar el objeto remoto en el registro
            Interfaz objetoRemoto = (Interfaz) registro.lookup("Convertidor de Temperatura");

            // Crear un objeto Scanner para recibir la entrada del usuario
            Scanner scanner = new Scanner(System.in);

            int choice;
            do {
                // Mostrar el menú de opciones
                System.out.println("Seleccione el tipo de conversión:");
                System.out.println("1. Celsius a Fahrenheit");
                System.out.println("2. Fahrenheit a Celsius");
                System.out.println("3. Salir");

                // Leer la opción seleccionada
                choice = scanner.nextInt();

                // Validar la opción seleccionada
                if (choice == 1 || choice == 2) {
                    // Si es una opción válida, pedir la temperatura
                    System.out.print("Ingrese la temperatura: ");
                    double inputTemperature = scanner.nextDouble();
                    double result;

                    // Realizar la conversión según la elección del usuario
                    switch (choice) {
                        case 1:
                            result = objetoRemoto.celsiusToFahrenheit(inputTemperature);
                            System.out.println(inputTemperature + " °C = " + result + " °F");
                            break;
                        case 2:
                            result = objetoRemoto.fahrenheitToCelsius(inputTemperature);
                            System.out.println(inputTemperature + " °F = " + result + " °C");
                            break;
                    }
                } else if (choice != 3) {
                    // Si la opción es incorrecta, avisar al usuario
                    System.out.println("Opción no válida. Intente de nuevo.");
                }

            } while (choice != 3);  // Repetir hasta que el usuario elija salir (opción 3)

            System.out.println("¡Gracias por usar el convertidor de temperatura!");
            scanner.close();

        } catch (Exception e) {
            System.err.println("Error en el cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
