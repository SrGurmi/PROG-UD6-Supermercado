package salesianos.net.com;

import java.util.LinkedList;
import java.util.Queue;

public class Cajero {
    private final int numero;
    private final Queue<Cliente> colaClientes;

    public Cajero(int numero) {
        this.numero = numero;
        this.colaClientes = new LinkedList<>();
    }

    public void agregarCliente(Cliente cliente) {
        colaClientes.add(cliente);
    }

    public void atenderCliente() {
        Cliente cliente = colaClientes.poll();
        if (cliente != null) {
            System.out.println("Cajero #" + numero + " atendiendo a: " + cliente.toString());
        } else {
            System.out.println("No hay clientes para atender en la cola del Cajero #" + numero);
        }
    }

    public int getTotalClientesEnCola() {
        return colaClientes.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cajero\n");
        sb.append("===================================\n");
        sb.append("* Número de caja: ").append(numero).append("\n");
        sb.append("* Total de clientes: ").append(getTotalClientesEnCola()).append("\n");
        sb.append("* Clientes en la fila:\n");
        for (Cliente cliente : colaClientes) {
            sb.append(cliente.toString());
        }
        sb.append("===================================\n");
        return sb.toString();
    }

    public String getNumero() {
        return  String.valueOf(numero);
    }
}