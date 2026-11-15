 public class ProductoDigital extends Producto {

    private String formato;

    // Constructor de la clase hija
    public ProductoDigital(int id, String nombre,
                           double precio, int cantidad,
                           String formato) {

        // Inicializamos los atributos heredados
        super(id, nombre, precio, cantidad);

        this.formato = formato;
    }

    // Metodo exclusivo de productos digitales
    public void descargarProducto() {
        System.out.println(
                "Descargando producto en formato: " + formato
        );
    }

    // Sobrescribimos el metodo de la clase padre
    @Override
    public void mostrarInformacion() {

        super.mostrarInformacion();

        System.out.println("Tipo: Producto digital");
        System.out.println("Formato: " + formato);

        System.out.println("-------------------------");
    }
}

