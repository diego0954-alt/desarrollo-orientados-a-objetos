package libreria;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Libros> Inventario = new ArrayList<>();

    static Scanner consola = new Scanner(System.in);

    public static void main(String[] args) {
        MostraMenu();
    }

    public static void MostraMenu() {
        boolean MostraMenu = true;

        while (MostraMenu) {
            System.out.println("1. registrar");
            System.out.println("2. listar");
            System.out.println("3. buscar por titulo");
            System.out.println("4. vender");
            System.out.println("5. resumen");
            System.out.println("6. salir");

            System.out.println("selecione su opcion: ");

            String OpcionMenu = consola.nextLine();

            switch (OpcionMenu) {
                case "1":
                    MostrarSubMenu();
                    break;

                case "2":
                    ListraProductosInventario();
                    break;

                case "3":
                    BuscarLibroPorTitulo();
                    break;

                case "4":
                    VenderLibro();
                    break;

                case "5":
                    break;

                case "6":
                    MostraMenu = false;
                    System.out.println("gracias por ocupar este sisstema eres el mejor🍀");
                    break;

                default:
                    break;

            }

        }

    }

    public static void MostrarSubMenu() {
        boolean MostrarSubMenu = true;

        while (MostrarSubMenu) {

            System.out.println("1. registar libros digitales");
            System.out.println("2. registar libros fisicos");
            System.out.println("3. salir");

            System.out.println("selecione su opcion: ");

            String OpcionSubMenu = consola.nextLine();

            switch (OpcionSubMenu) {
                case "1":
                    RegistrarLibroDigital();
                    break;

                case "2":
                    RegistrarLibroFisico();
                    break;

                case "3":
                    MostrarSubMenu = false;
                    System.out.println("reistro completo de lisbros");
                    break;

                default:
                    break;
            }

        }

    }

    static void RegistrarLibroFisico() {
        try {
            System.out.println("ingrese el nombre del titulo del libro fisico: ");
            String Titulo = consola.nextLine();

            System.out.println("ingrese el precio base del libro: ");
            int PrecioBase = Integer.parseInt(consola.nextLine());

            System.out.println("ingrese el numero de stock del libro: ");
            int Stock = Integer.parseInt(consola.nextLine());

            System.out.println("ingrese el precio del envio del libro: ");
            int CostoEnvio = Integer.parseInt(consola.nextLine());

            LibrosFiscos Libros = new LibrosFiscos(CostoEnvio, Titulo, PrecioBase, Stock);
            Inventario.add(Libros);
            System.out.println("ingreso de libros con exito");

        } catch (IllegalArgumentException e) {
            System.out.println("no se registro el libro" + e.getMessage());
        }
    }

    static void RegistrarLibroDigital() {
        try {
            System.out.println("ingrese el titulo del libro digital: ");
            String Titulo = consola.nextLine();

            System.out.println("ingrese el precio base del libro digital: ");
            int PrecioBase = Integer.parseInt(consola.nextLine());

            System.out.println("ingrese el stock del libro digital: ");
            int Stock = Integer.parseInt(consola.nextLine());

            System.out.println("ingrese el descuento del libro digital: ");
            int Descuento = Integer.parseInt(consola.nextLine());

            System.out.println("ingrese el formato del libro digital: ");
            String Formato = consola.nextLine();

            if (Descuento < 0 || Descuento > 100) {
                throw new IllegalArgumentException("El descuento debe estar entre 0 y 100.");
            }
            LibrosDigitales Libros = new LibrosDigitales(Descuento, Formato, Titulo, PrecioBase, Stock);
            Inventario.add(Libros);
            System.out.println("el libro digital se registro con exito");

        } catch (IllegalArgumentException e) {
            System.out.println("el libro no se regitro con exito" + e.getMessage());
        }

    }

    static void ListraProductosInventario() {
        System.out.println("***** Inventario De Libros *****");

        if (Inventario.isEmpty()) {
            System.out.println("no se encontraron libros dentro de la lista ");
            return;
        }

        for (int i = 0; i < Inventario.size(); i++) {
            Libros I = Inventario.get(i);
            System.out.println("[" + (i + 1) + "] " + I.mostrarInfo());
        }
        System.out.println("los productos que se encuamtran en el catalogo son" + Inventario.size());
    }

    static void BuscarLibroPorTitulo() {

        System.out.println("ingrese el titulo del libro a buscar: ");
        String TituloLibroBuscar = consola.nextLine();

        if (Inventario.isEmpty()) {
            System.out.println("no se encontaron libros");
            return;
        }
        boolean encontrado = false;

        for (int i = 0; i < Inventario.size(); i++) {
            Libros T = Inventario.get(i);

            if (TituloLibroBuscar.equalsIgnoreCase(T.getTitulo())) {
                encontrado = true;
                System.out.println("los libros que se encontaron fueron: " + T.mostrarInfo());
            }

        }
        if (encontrado == false) {
            System.out.println("no se encontró ningún libro con ese título");
        }

    }

    static void VenderLibro() {
        System.out.println("***** Vender Libro *****");

        if (Inventario.isEmpty()) {
            System.out.println("no hay libros en el inventario para vender");
            return;
        }

        for (int i = 0; i < Inventario.size(); i++) {
            Libros L = Inventario.get(i);
            System.out.println("[" + (i + 1) + "] " + L.getTitulo() + " | Stock: " + L.getStock()
                    + " | Precio: $" + L.calcularPrecioFinal());
        }

        try {
            System.out.println("ingrese el numero del libro que desea vender: ");
            int numeroLibro = Integer.parseInt(consola.nextLine());

            if (numeroLibro < 1 || numeroLibro > Inventario.size()) {
                System.out.println("numero fuera de rango");
                return;
            }

            Libros libroSeleccionado = Inventario.get(numeroLibro - 1);

            System.out.println("ingrese la cantidad a vender: ");
            int cantidad = Integer.parseInt(consola.nextLine());

            if (cantidad <= 0) {
                System.out.println("la cantidad debe ser mayor a 0");
                return;
            }

            if (cantidad > libroSeleccionado.getStock()) {
                System.out.println("stock insuficiente, disponible: " + libroSeleccionado.getStock());
                return;
            }

            libroSeleccionado.setStock(libroSeleccionado.getStock() - cantidad);
            int totalVenta = libroSeleccionado.calcularPrecioFinal() * cantidad;

            System.out.println("venta realizada con exito");
            System.out.println("libro: " + libroSeleccionado.getTitulo());
            System.out.println("cantidad vendida: " + cantidad);
            System.out.println("total a pagar: $" + totalVenta);
            System.out.println("stock restante: " + libroSeleccionado.getStock());

        } catch (NumberFormatException e) {
            System.out.println("debe ingresar un numero valido");
        }
    }
}

