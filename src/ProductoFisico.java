public class ProductoFisico extends Producto {

    private double peso;

    // Constructor de la clase hija
    public ProductoFisico(int id, String nombre,
                          double precio, int cantidad,
                          double peso) {

        // Llamamos al constructor de la clase padre
        super(id, nombre, precio, cantidad);

        this.peso = peso;
    }

    // Metodo exclusivo para productos fisicos
    public double calcularCostoEnvio() {
        return peso * 50;
    }

    // Sobrescribimos el metodo de la clase padre
    @Override
    public void mostrarInformacion() {

        super.mostrarInformacion();

        System.out.println("Tipo: Producto fisico");
        System.out.println("Peso: " + peso + " kg");

        System.out.printf(
                "Costo de envio: $%.2f%n",
                calcularCostoEnvio()
        );

        System.out.println("-------------------------");
    }
}

