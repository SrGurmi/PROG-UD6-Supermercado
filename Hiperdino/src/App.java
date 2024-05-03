import java.util.Scanner;
import salesianos.net.com.Cajero;
import salesianos.net.com.Cliente;
import salesianos.net.util.GeneradorAleatorio;

class SimuladorSupermercado {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cajero cajero = new Cajero(1);
        boolean cajaAbierta = false;

        while (true) {
            System.out.println("========== MENÚ SUPERMERCADO ==========");
            System.out.println("1. Abrir caja");
            System.out.println("2. Añadir un nuevo cliente a la cola");
            System.out.println("3. Atender un cliente");
            System.out.println("4. Ver clientes pendientes");
            System.out.println("5. Cerrar supermercado");
            System.out.print("Elija una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    if (!cajaAbierta) {
                        cajaAbierta = true;
                        System.out.println("Caja abierta correctamente.");
                    } else {
                        System.out.println("La caja ya está abierta.");
                    }
                    break;
                case 2:
                    if (cajaAbierta) {
                        Cliente nuevoCliente = new Cliente(GeneradorAleatorio.generarNombreAleatorio());
                        int numProductos = GeneradorAleatorio.random.nextInt(5) + 1; // Entre 1 y 5 productos
                        for (int i = 0; i < numProductos; i++) {
                            nuevoCliente.agregarProducto(GeneradorAleatorio.generarProductoAleatorio());
                        }
                        cajero.agregarCliente(nuevoCliente);
                        System.out.println("Nuevo cliente añadido: " + nuevoCliente.toString());
                    } else {
                        System.out.println("La caja está cerrada. No se puede añadir cliente.");
                    }
                    break;
                case 3:
                    if (cajaAbierta) {
                        cajero.atenderCliente();
                    } else {
                        System.out.println("La caja está cerrada. No hay clientes para atender.");
                    }
                    break;
                case 4:
                    System.out.println("Clientes pendientes en la cola del Cajero #" + cajero.getNumero() + ":");
                    System.out.println(cajero.toString());
                    break;
                case 5:
                    if (cajaAbierta && cajero.getTotalClientesEnCola() == 0) {
                        cajaAbierta = false;
                        System.out.println("Supermercado cerrado. ¡Hasta pronto!");
                        scanner.close();
                        System.exit(0);
                    } else {
                        System.out.println("No se puede cerrar la caja con clientes pendientes.");
                    }
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, elija una opción válida.");
            }
        }
    }
}
