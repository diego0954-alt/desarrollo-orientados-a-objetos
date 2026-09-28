package academia;

import java.util.ArrayList;
import java.util.Scanner;

public class Main3 {

    static ArrayList<Material> Inventario = new ArrayList<>();
    static Scanner consola = new Scanner(System.in);

    public static void main(String[] args) {
        MostrarMenu();
    }

    static public void MostrarMenu() {
        boolean Corriendo = true;

        while (Corriendo) {

            System.out.println("==== BIBLIOTECA MUNICIPAL ====");
            System.out.println("1. Registrar material");
            System.out.println("2. listar catalogo");
            System.out.println("3. buscar material por revista");
            System.out.println("4. prestar material");
            System.out.println("5. resumen del catalogo");
            System.out.println("6. salir");
            System.out.println("7.insertar datos");
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
                    BuscarPorAutor();
                    break;

                case "4":
                    break;

                case "5":
                    break;

                case "6":
                    Corriendo = false;
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
        boolean CorriendoSub = true;

        while (CorriendoSub) {

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
                    CorriendoSub = false;
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

        Material libros = new Libros(NumPaginas, Titulo, Autor, CantidadDisponible);
        Inventario.add(libros);
        System.out.println("se inserto los libros");

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

        Material revista = new Revistas(MesPublicacion, Titulo, Autor, CantidadDisponible);
        Inventario.add(revista);
        System.out.println("se insertaron las revistas");

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

    static void BuscarPorAutor() {
        System.out.println("Busque por autors");
        String Busqueda = consola.nextLine();

        if (Inventario.isEmpty()) {
            System.out.println("no hay nada dentro del invemtario");
            return;
        }

        boolean EncontradoBusqueda = false;

        for (int i = 0; i < Inventario.size(); i++) {
            Material B = Inventario.get(i);

            if (B.getAutor().toLowerCase().contains(Busqueda.toLowerCase())) {
                EncontradoBusqueda = true;
                System.out.println("fue encontrado como: " + B.mostrarInfo());
            }
        }
            if (!EncontradoBusqueda) {
                System.out.println("no se encontro nada relacionado con el titulo");
            
        }
    }

    static void InsertarDatos(){
        System.out.println("######## DATOS INSERTADOS #########");
        Inventario.add(new Revistas("febrero", "buscado a nemo", "sandia orellana", 4));
        Inventario.add(new Revistas("marzo", "buscado a nemo", "limon orellana", 10));
        Inventario.add(new Revistas("febrero", "buscado a nemo", " frutilla orellana", 23));

        Inventario.add(new Libros(200, "buscado a doris", "gustavo orellana", 60));
        Inventario.add(new Libros(90, "buscado a doris2", "carlos salvador", 4));
        Inventario.add(new Libros(504, "buscado a merlin", "romina", 4));
    }

}
