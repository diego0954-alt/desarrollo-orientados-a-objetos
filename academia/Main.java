package academia;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Actividad> Inventario = new ArrayList<>();
    static Scanner Pedir = new Scanner(System.in);

    public static void main(String[] args) {
        MostraMenu();
    }

    public static void MostraMenu() {
        boolean MostraMenu = true;

        while (MostraMenu) {
            System.out.println("1. registrar");
            System.out.println("2. listar");
            System.out.println("3. buscar por Nombre");
            System.out.println("4. vender");
            System.out.println("5. resumen");
            System.out.println("6. salir");
            System.out.println("7. insertar datos");

            System.out.println("selecione su opcion: ");

            String OpcionMenu = Pedir.nextLine();

            switch (OpcionMenu) {
                case "1":
                    MostraSubMenu();
                    break;

                case "2":
                    ListarInventario();
                    break;

                case "3":
                    BuscarPorNombre();
                    break;

                case "4":
                    VenderActividad();
                    break;

                case "5":
                    ResumenInventario();
                    break;

                case "6":
                    MostraMenu = false;
                    System.out.println("chao");
                    break;

                case "7":
                    DatosInsertados();
                    break;

                default:
                    break;
            }

        }

    }

    public static void MostraSubMenu() {
        boolean MostraSubMenu = true;

        while (MostraSubMenu) {
            System.out.println("1.- registrar actividad Online");
            System.out.println("2.- registrar actividad Precensial");
            System.out.println("3.- salir");

            String OpcionSubMenu = Pedir.nextLine();

            switch (OpcionSubMenu) {
                case "1":
                    ActividadOnline();
                    break;

                case "2":
                    ActividadPresencial();
                    break;

                case "3":
                    MostraSubMenu = false;
                    System.out.println("chao submenu");
                    break;

                default:
                    break;
            }

        }
    }

    static void ActividadOnline() {
        System.out.println("Ingrese el nombre de la persona: ");
        String Nombre = Pedir.nextLine();

        System.out.println("Ingrese el precio base de la actividad: ");
        int PrecioBase = Integer.parseInt(Pedir.nextLine());

        System.out.println("Ingrese los cupos de la actividad: ");
        int Cupos = Integer.parseInt(Pedir.nextLine());

        System.out.println("Ingrese el descuento de la actividad: ");
        int Descuento = Integer.parseInt(Pedir.nextLine());

        System.out.println("Ingrese la plataforma de la actividad: ");
        String Plataforma = Pedir.nextLine();

        ActividadOnline Actividad = new ActividadOnline(Descuento, Plataforma, Nombre, PrecioBase, Cupos);
        Inventario.add(Actividad);
        System.out.println("la actividad online se registro con exito, todo un pro");
    }

    static void ActividadPresencial() {
        System.out.println("Ingrese el nombre de la persona: ");
        String Nombre = Pedir.nextLine();

        System.out.println("Ingrese el precio base de la actividad: ");
        int PrecioBase = Integer.parseInt(Pedir.nextLine());

        System.out.println("Ingrese los cupos de la actividad: ");
        int Cupos = Integer.parseInt(Pedir.nextLine());

        System.out.println("Ingrese el costo de la sala presencial: ");
        int CostoSala = Integer.parseInt(Pedir.nextLine());

        ActividadPresencial Actividad = new ActividadPresencial(CostoSala, Nombre, PrecioBase, Cupos);
        Inventario.add(Actividad);
        System.out.println("se registro con exito la sala Presencial, eres el mejorrr");
    }

    static void ListarInventario() {
        System.out.println("***** Lista Del Inventario *****");

        if (Inventario.isEmpty()) {
            System.out.println("el Inventario esta vacio");
            return;
        }

        for (int i = 0; i < Inventario.size(); i++) {
            Actividad A = Inventario.get(i);
            System.out.println("[" + (i + 1) + "]" + A.MostrarInfo());

        }
        System.out.println("las actividad se encuntran en el inventario son: " + Inventario.size());
    }

    static void BuscarPorNombre() {
        System.out.println("***** Busqueda Por Nombre *****");
        String Busqueda = Pedir.nextLine();

        if (Inventario.isEmpty()) {
            System.out.println("el Inventario esta vacio");
            return;
        }
        boolean encontrado = false;

        for (int i = 0; i < Inventario.size(); i++) {
            Actividad B = Inventario.get(i);

            if (B.getNombre().toLowerCase().contains(Busqueda.toLowerCase())){
            encontrado = true;
            System.out.println("el nombre fue encontado con exito: " + B.MostrarInfo());
            }
        }
        if (encontrado == false) {
            System.out.println("el nombre no existe, porfavor intente denuevo");
        }

    }

    static void VenderActividad() {
        System.out.println("***** Vender Actividad *****");
        if(Inventario.isEmpty()){
            System.out.println("no se encuentra ndaa");
            return;
        }
        for (int i = 0; i  < Inventario.size(); i++) {
            Actividad V = Inventario.get(i);
            System.out.println("[" + (i + 1) + "]" + V.getNombre() + " | cupos" + V.getCupos() + "total: " + V.CalcularCupos());

        try {
            System.out.println("ingrese el numero del dato");
            int numero = Integer.parseInt(Pedir.next());

            if(numero < 1 || numero > Inventario.size()){
                System.out.println("el numero no es posible");
                return;
            }
            Actividad selecione = Inventario.get(numero - 1);

            System.out.println("selecione la cantidad a vender");
            int cantidad = Integer.parseInt(Pedir.nextLine());

            if(cantidad <= 0){
            System.out.println("el numero deve ser mayor a 0");
            return;
            }

            if(cantidad > selecione.getCupos()){
                System.out.println("la cantidad debe ser mayor a la cantidad disponible" + selecione.getCupos());
                return;
            }
            selecione.setCupos(selecione.getCupos() - cantidad);
            int totalVenta = selecione.CalcularCupos() * cantidad;

            System.out.println("se vendio con exito");
            System.out.println("cantidad");
            System.out.println("se vendio con exito");
            System.out.println("se vendio con exito");
            System.out.println("se vendio con exito");


        } catch (Exception e) {
            // TODO: handle exception
        }
        }
    
    }

    static void ResumenInventario() {
        System.out.println("***** Resumen Del Inventario *****");

        if (Inventario.isEmpty()) {
            System.out.println("el Inventario esta vacio");
            return;
        }

        for (int i = 0; i < Inventario.size(); i++) {
            Actividad R = Inventario.get(i);
        }

    }

    static void DatosInsertados(){
        System.out.println("############# DATOS INSERTADOS #############");

        Inventario.add(new ActividadOnline(10, "netflix", "romina", 15000, 3));
        Inventario.add(new ActividadOnline(50, "disney", "oliver", 90000, 6));
        Inventario.add(new ActividadOnline(32, "amazon", "moana", 42000, 4));

        Inventario.add(new ActividadPresencial(75000, "benjamin", 50000, 9));
        Inventario.add(new ActividadPresencial(50000, "diego", 35000, 11));
        Inventario.add(new ActividadPresencial(20000, "samanta", 80000, 17));

    }
}
