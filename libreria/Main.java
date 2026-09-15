package libreria;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<LibrosFiscos> ColeccionLibrosFisicos = new ArrayList<>();
    static  ArrayList<LibrosDigitales> ColeccionLibrosDigitales = new ArrayList<>();
    static Scanner consola = new Scanner(System.in);

    public static void main(String[] args) {
        MostraMenu();
    }
    public static void MostraMenu() {
        boolean MostraMenu = true;

        while(MostraMenu){
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
                
            break;
             case "3":
                
            break;
             case "4":
                
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

    public static void MostrarSubMenu(){
        boolean MostrarSubMenu = true;

        while (MostrarSubMenu){

            System.out.println("1. registar libros digitales");
            System.out.println("2. registar libros fisicos");
            System.out.println("3. salir");

            System.out.println("selecione su opcion: ");

            String OpcionSubMenu = consola.nextLine();

            switch (OpcionSubMenu) {
                case "1":  
                RegistrarLibroFisico();
                break;

                case "2":
                    RegistrarLibroDigital();
                break;

                case "3":
                OpcionSubMenu = false;
                System.out.println("reistro completo de lisbros");
                break;
            
                default:
                    break;
            }

        }

    }

    static void RegistrarLibroFisico(){
        try{
            System.out.println("ingrese el nombre del titulo del libro fisico: ");
            String Titulo = consola.nextLine();

            System.out.println("ingrese el precio base del libro: ");
            int PrecioBase = Integer.parseInt(consola.nextLine());

            System.out.println("ingrese el numero de stock del libro: ");
            int Stock = Integer.parseInt(consola.nextLine());

            System.out.println("ingrese el precio del envio del libro: ");
            int CostoEnvio = Integer.parseInt(consola.nextLine());

            LibrosFiscos Libros = new LibrosFiscos(CostoEnvio, Titulo, PrecioBase, Stock);
            ColeccionLibrosFisicos.add(Libros);
            System.out.println("ingreso de libros con exito");

        }catch(IllegalArgumentException e) {
            System.out.println("no se registro el libro" + e.getMessage());
        }
    }

    static void RegistrarLibroDigital(){
        try{
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
            ColeccionLibrosDigitales.add(Libros);
            System.out.println("el libro digital se registro con exito");



        }catch(IllegalArgumentException e){
            System.out.println("el libro no se regitro con exito" + e.getMessage());
        }

    }
    
}
