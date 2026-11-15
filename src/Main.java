import java.util.Scanner;

    public class Main {

        public static int leerEntero(Scanner sc, String mensaje) {
            while (true) {
                System.out.print(mensaje);

                try {
                    return Integer.parseInt(sc.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Ingresa un numero entero valido.");
                }
            }
        }

        public static double leerDecimal(Scanner sc, String mensaje) {
            while (true) {
                System.out.print(mensaje);

                try {
                    double valor = Double.parseDouble(sc.nextLine().trim());

                    if (Double.isFinite(valor)) {
                        return valor;
                    }
                } catch (NumberFormatException e) {
                    // Solicitar nuevamente el dato
                }

                System.out.println("Ingresa un numero valido.");
            }
        }

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            Inventario inventario = new Inventario();
            int opcion;

            do {
                System.out.println("\n=== GESTION DE PRODUCTOS ===");
                System.out.println("1. Registrar producto fisico");
                System.out.println("2. Registrar producto digital");
                System.out.println("3. Mostrar inventario");
                System.out.println("4. Buscar producto");
                System.out.println("5. Calcular valor del inventario");
                System.out.println("6. Salir");

                opcion = leerEntero(sc, "Selecciona una opcion: ");

                switch (opcion) {

                    case 1: {
                        System.out.println("\n--- PRODUCTO FISICO ---");

                        int id = leerEntero(sc, "ID: ");

                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine().trim();

                        double precio = leerDecimal(sc, "Precio: $");
                        int cantidad = leerEntero(sc, "Cantidad: ");
                        double peso = leerDecimal(sc, "Peso en kg: ");

                        if (id <= 0 || nombre.isEmpty() ||
                                precio < 0 || cantidad < 0 || peso <= 0) {

                            System.out.println("Datos invalidos.");
                            break;
                        }

                        ProductoFisico fisico = new ProductoFisico(
                                id, nombre, precio, cantidad, peso
                        );

                        inventario.agregarProducto(fisico);
                        break;
                    }

                    case 2: {
                        System.out.println("\n--- PRODUCTO DIGITAL ---");

                        int id = leerEntero(sc, "ID: ");

                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine().trim();

                        double precio = leerDecimal(sc, "Precio: $");
                        int cantidad = leerEntero(sc, "Cantidad: ");

                        System.out.print("Formato del archivo: ");
                        String formato = sc.nextLine().trim();

                        if (id <= 0 || nombre.isEmpty() ||
                                precio < 0 || cantidad < 0 ||
                                formato.isEmpty()) {

                            System.out.println("Datos invalidos.");
                            break;
                        }

                        ProductoDigital digital = new ProductoDigital(
                                id, nombre, precio, cantidad, formato
                        );

                        inventario.agregarProducto(digital);
                        break;
                    }

                    case 3:
                        inventario.mostrarInventario();
                        break;

                    case 4: {
                        int idBuscar = leerEntero(
                                sc, "Ingresa el ID del producto: "
                        );

                        inventario.buscarProducto(idBuscar);
                        break;
                    }

                    case 5:
                        System.out.printf(
                                "Valor total del inventario: $%.2f%n",
                                inventario.calcularValorInventario()
                        );
                        break;

                    case 6:
                        System.out.println(
                                "Gracias por utilizar el sistema."
                        );
                        break;

                    default:
                        System.out.println("Opcion no valida.");
                }

            } while (opcion != 6);

            sc.close();
        }
    }

