 import java.util.ArrayList;

public class Inventario {

    // Lista para almacenar los productos
    private ArrayList<Producto> productos;

    // Constructor
    public Inventario() {
        productos = new ArrayList<>();
    }

    // Metodo para agregar productos
    public void agregarProducto(Producto producto) {
        productos.add(producto);

        System.out.println(
                "Producto agregado correctamente."
        );
    }

    // Metodo para mostrar todos los productos
    public void mostrarInventario() {

        System.out.println("\n===== INVENTARIO =====");

        for (Producto producto : productos) {
            producto.mostrarInformacion();
        }
    }

    // Metodo para calcular el valor total
    public double calcularValorInventario() {

        double total = 0;

        for (Producto producto : productos) {
            total += producto.calcularValor();
        }

        return total;
    }

    // Metodo para buscar un producto por su ID
    public void buscarProducto(int id) {

        for (Producto producto : productos) {

            if (producto.getId() == id) {
                System.out.println(
                        "\nProducto encontrado:"
                );

                producto.mostrarInformacion();
                return;
            }
        }

        System.out.println("Producto no encontrado.");
    }
}
