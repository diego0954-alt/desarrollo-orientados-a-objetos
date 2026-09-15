package proyecto_prueba;

import java.util.ArrayList;
import java.util.Scanner;

public class Tienda {

    static ArrayList<ProductoFisico> coleccion_juegos_fisicos = new ArrayList<>();

    static ArrayList<ProductoDigital> coleccion_juegos_digitales = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            mostrarMenu();
        } catch (Exception e) {
            System.out.println("Error inesperado en el programa: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    public static void mostrarMenu() {
        boolean mostrar_menu = true;

        while (mostrar_menu) {
            System.out.println("1. Registrar producto");
            System.out.println("2. Listar inventario");
            System.out.println("3. Buscar producto por nombre");
            System.out.println("4. Vender producto");
            System.out.println("5. Resumen del inventario");
            System.out.println("6. Salir");

            System.out.println("Ingrese su opción: ");

            String opcion_menu = sc.nextLine();

            try {
                switch (opcion_menu) {
                    case "1":
                        registrarProducto();
                        break;
                    case "2":
                        listarInventario();
                        break;
                    case "3":
                        System.out.println("Opción aún no implementada.");
                        break;
                    case "4":
                        System.out.println("Opción aún no implementada.");
                        break;
                    case "5":
                        System.out.println("Opción aún no implementada.");
                        break;
                    case "6":
                        mostrar_menu = false;
                        System.out.println("Saliendo de la tienda...");
                        break;
                    default:
                        System.out.println("Opción no válida. Elija un número del 1 al 6.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("No se pudo completar la opción: " + e.getMessage());
            }
        }
    }

    static public void registrarProducto() {
        boolean mostrar_menu = true;

        while (mostrar_menu) {
            System.out.println("1. Registrar producto Físico");
            System.out.println("2. Registrar producto digital");
            System.out.println("3. Volver al menu");

            System.out.println("Elija su opción: ");

            String opcion_registro_juego = sc.nextLine();

            switch (opcion_registro_juego) {
                case "1":
                    registrarProductoFisico();
                    break;
                case "2":
                    registrarProductoDigital();
                    break;
                case "3":
                    mostrar_menu = false;
                    break;

                default:
                    break;
            }

        }
    }

    static public void registrarProductoFisico() {
        try {
            System.out.println("Ingrese nombre del juego");
            String nombre = sc.nextLine();

            int precioBase = leerEntero("Ingrese precio base del juego");
            int stock = leerEntero("Ingrese stock del juego");
            int costo_envio = leerEntero("Ingrese costo de envio del juego");

            validarDatosProducto(nombre, precioBase, stock);

            ProductoFisico juego = new ProductoFisico(nombre, precioBase, stock, costo_envio);
            coleccion_juegos_fisicos.add(juego);
            System.out.println("Producto físico registrado.");
        } catch (IllegalArgumentException e) {
            System.out.println("No se registró el producto: " + e.getMessage());
        }
    }

    static public void registrarProductoDigital() {
        try {
            System.out.println("Ingrese nombre del juego");
            String nombre = sc.nextLine();

            int precioBase = leerEntero("Ingrese precio base del juego");
            int stock = leerEntero("Ingrese stock del juego");
            int descuento = leerEntero("Ingrese el descuento del juego");

            System.out.println("Ingrese la plataforma del juego");
            String plataforma = sc.nextLine();

            validarDatosProducto(nombre, precioBase, stock);

            if (descuento < 0 || descuento > 100) {
                throw new IllegalArgumentException("El descuento debe estar entre 0 y 100.");
            }

            ProductoDigital juego = new ProductoDigital(nombre, precioBase, stock, descuento, plataforma);
            coleccion_juegos_digitales.add(juego);
            System.out.println("Producto digital registrado.");
        } catch (IllegalArgumentException e) {
            System.out.println("No se registró el producto: " + e.getMessage());
        }
    }

    static public void listarInventario() {
        System.out.println("****Listado de juegos Físicos****");
        if (coleccion_juegos_fisicos.isEmpty()) {
            System.out.println("No hay juegos físicos registrados.");
        } else {
            for (ProductoFisico productoFisico : coleccion_juegos_fisicos) {
                System.out.println(productoFisico.mostrarInfo());
            }
        }

        System.out.println("****Listado de juegos Digitales****");
        if (coleccion_juegos_digitales.isEmpty()) {
            System.out.println("No hay juegos digitales registrados.");
        } else {
            for (ProductoDigital productoDigital : coleccion_juegos_digitales) {
                System.out.println(productoDigital.mostrarInfo());
            }
        }
    }

    static int leerEntero(String mensaje) {
        while (true) {
            System.out.println(mensaje);
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número entero. Intente de nuevo.");
            }
        }
    }

    static void validarDatosProducto(String nombre, int precioBase, int stock) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (precioBase < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        }
    }


}

