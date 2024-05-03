package salesianos.net.com;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private List<String> cesta;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.cesta = new ArrayList<>();
    }

    public void agregarProducto(String producto) {
        cesta.add(producto);
    }

    public int getTotalProductos() {
        return cesta.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombre).append("\n");
        sb.append("* Total de productos: ").append(getTotalProductos()).append("\n");
        sb.append("* Lista de artículos en la cesta:\n");
        for (String producto : cesta) {
            sb.append(producto).append("\n");
        }
        sb.append("===================================\n");
        return sb.toString();
    }
}
