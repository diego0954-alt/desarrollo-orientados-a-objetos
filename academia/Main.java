package academia;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Actividad> Inventario = new ArrayList<>();

    static Scanner Consola = new Scanner(System.in);

    public static void main(String[] args) {
        MostraMenu();
    }

    static void MostraMenu() {
        boolean MostraMenu = true;

        while (MostraMenu) {
            System.out.println("1. registrar");
            System.out.println("2. listar");
            System.out.println("3. buscar por titulo");
            System.out.println("4. vender");
            System.out.println("5. resumen");
            System.out.println("6. salir");

            System.out.println("selecione su opcion: ");

            String OpcionMenu = Consola.nextLine();

            switch (OpcionMenu) {
                case "1":
                    break;

                case "2":
                    break;

                case "3":
                    break;

                case "4":
                    break;

                case "5":
                    break;

                case "6":
                    MostraMenu = false;
                    System.out.println("cierre del sistema");
                    break;
            
                default:
                    break;
            }

        }
    }
    static void MostarSubMenu(){
        boolean MostarSubMenu = true;

        while (MostarSubMenu) {
            System.out.println("1. Presencial");
            System.out.println("2. Online");
            System.out.println("3. salir");

            System.out.println("porfavor elija una opcion");

            String OpcionSubMenu = Consola.nextLine();

            switch (OpcionSubMenu) {
                case "1":
                    RegistrarPrecensial();
                    break;

                case "2":
                    RegistrarOnline();
                    break;

                case "3":
                    break;
            
                default:
                    break;
            }
            
        }
    }
    static void RegistrarPrecensial(){
        try{
        System.out.println("ingrese su nombre: ");
        String Nombre = Consola.nextLine();

        System.out.println("ingrese el precio base: ");
        int PrecioBase = Integer.parseInt(Consola.nextLine());

        System.out.println("ingrese el cupo: ");
        int Cupos = Integer.parseInt(Consola.nextLine());

        System.out.println("ingrese el costo de la sala: ");
        int CostoSala = Integer.parseInt(Consola.nextLine());


        ActividadPresencial Actividad = new ActividadPresencial(CostoSala, Nombre, PrecioBase, Cupos);
        Inventario.add(Actividad);
        System.out.println("se ingreso correctamnete la actividad");

        } catch(IllegalArgumentException e){
            System.out.println("lalal" + e.getMessage());
        }
    }

    static void RegistrarOnline(){

    }

}
