package academia;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Material> Inventario = new ArrayList<>();
    static Scanner consola = new Scanner(System.in);

    public static void main(String[] args) {
        MostrarMenu();
    }

    static public void MostrarMenu() {
        boolean Funciona = true;

        while (Funciona) {

            System.out.println("==== BIBLIOTECA MUNICIPAL ====");
            System.out.println("1. Registrar material");
            System.out.println("2. listar catalogo");
            System.out.println("3. buscar material por revista");
            System.out.println("4. prestar material");
            System.out.println("5. resumen del catalogo");
            System.out.println("6. salir");
            System.out.println("7. insertar datos");
            System.out.println("seleccione una opcio:");

            String OpcionMemu = consola.nextLine();

            switch (OpcionMemu) {
                case "1":
                    MostrarSubMenu();
                    break;

                case "2":
                    ListarCatalogo();
                    break;

                case "3":
                    BuscarPorTitulo();
                    break;

                case "4":
                    break;

                case "5":
                    break;

                case "6":
                    Funciona = false;
                    System.out.println("gracias por usar la biblioteca nacional, que tenga buen dia :)");
                    break;

                case "7":
                    InsertarDatos();
                    break;
                default:
                    break;
            }
        }
    }

    static public void MostrarSubMenu() {
        boolean FuncionaSubMenu = true;

        while (FuncionaSubMenu) {

            System.out.println("1. registra libro");
            System.out.println("2. registrar revista");
            System.out.println("3. salir");

            System.out.println("seleccione una opcio:");

            String OpcionSubMenu = consola.nextLine();

            switch (OpcionSubMenu) {
                case "1":
                    registraLibro();
                    break;

                case "2":
                    registraRevista();
                    break;

                case "3":
                    FuncionaSubMenu = false;
                    System.out.println("gracias por usar el sistema de registro");
                    break;

                default:
                    break;

            }
        }
    }

    static void registraLibro() {
        System.out.println("ingrese el nombre del titulo: ");
        String Titulo = consola.nextLine();

        System.out.println("ingrese el nombre del autor: ");
        String Autor = consola.nextLine();

        System.out.println("ingrese la cantidad disponible: ");
        int CantidadDisponible = Integer.parseInt(consola.nextLine());

        System.out.println("ingrese el numero de paguinas: ");
        int NumPaginas = Integer.parseInt(consola.nextLine());
        Material likos = new Libros(NumPaginas, Titulo, Autor, CantidadDisponible);
        Inventario.add(likos);
        System.out.println("hola");

    }

    static void registraRevista() {
        System.out.println("ingrese el nombre del titulo: ");
        String Titulo = consola.nextLine();

        System.out.println("ingrese el nombre del autor: ");
        String Autor = consola.nextLine();

        System.out.println("ingrese la cantidad disponible: ");
        int CantidadDisponible = Integer.parseInt(consola.nextLine());

        System.out.println("ingrese el mes de la publicacion: ");
        String MesPublicacion = consola.nextLine();

        Material revitas = new Revistas(MesPublicacion, Titulo, Autor, CantidadDisponible);
        Inventario.add(revitas);
        System.err.println("hola");

    }

    static void ListarCatalogo() {
        System.out.println("****** Lista De Catalogo *******");

        if (Inventario.isEmpty()) {
            System.out.println("no se encuentra nada dentro del inventario");
            return;
        }
        for (int i = 0; i < Inventario.size(); i++) {
            Material L = Inventario.get(i);
            System.out.println("[" + (i + 1) + "]" + L.mostrarInfo());

        }
    }

    static void BuscarPorTitulo() {
        System.out.println("===== BUSCAR POR TITULO =====");
        String Buscar = consola.nextLine();

        if (Inventario.isEmpty()) {
            System.out.println("no hay nada en el inventario");
            return;
        }
        boolean Encontrado = false;

        for (int i = 0; i < Inventario.size(); i++) {
            Material B = Inventario.get(i);

            if (B.getAutor().toLowerCase().contains(Buscar.toLowerCase())) {
                Encontrado = true;
                System.out.println("se encontro el autor" + B.mostrarInfo());

            }
            if(Encontrado == false){
                System.out.println("no se encontro nada relacionado con el autor");
            }

        }

    }

    static void InsertarDatos() {
        System.out.println("====== DATOS INSERTADOS =======");
        Inventario.add(new Revistas("febrero", "programacion1 ", "carlos", 4));
        Inventario.add(new Revistas("febrero", "programacion2 ", "carlos", 9));
        Inventario.add(new Revistas("febrero", "programacion3 ", "carlos", 90));

        Inventario.add(new Libros(3, "programacion4 ", "carlos", 23));
        Inventario.add(new Libros(43, "programacion5 ", "carlos", 84));
        Inventario.add(new Libros(100, "programacion6 ", "carlos", 1));
    }

}
