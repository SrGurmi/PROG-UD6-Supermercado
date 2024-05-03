package salesianos.net.util;
import java.util.Random;

public class GeneradorAleatorio {
    private static final String[] nombres = {"Juan", "María", "Pedro", "Ana", "Luis", "Elena", "Carlos", "Laura", "Sara", "Pablo", "Lucía", "Diego", "Claudia", "Javier", "Silvia", "Miguel", "Carmen", "Rosa", "Daniel", "Marta"};
    private static final String[] productos = {"Leche", "Pan", "Huevos", "Queso", "Frutas", "Verduras", "Carne", "Pescado", "Cereal", "Refresco", "Agua", "Chocolate"};

    public static final Random random = new Random();

    public static String generarNombreAleatorio() {
        return nombres[random.nextInt(nombres.length)];
    }

    public static String generarProductoAleatorio() {
        return productos[random.nextInt(productos.length)];
    }
}
