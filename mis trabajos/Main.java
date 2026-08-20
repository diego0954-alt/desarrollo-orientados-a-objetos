import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        mostrarMenu();
    }



    static void mostrarMenu(){
        String opcion_elegida;
        Scanner scanner = new Scanner(System.in);
        boolean iniciar_menu = true;
        System.out.print("bienvenido al mundo de westeros");

       while (iniciar_menu) {

         System.out.println("1.- crear personaje");
        System.out.println("2.- ver personaje");
        System.out.println("3.- salir");

        System.out.print("porfavor ingrese una opcion: ");

        opcion_elegida = scanner.nextLine();

        System.out.print("la opcion elegida por usuario es: " + opcion_elegida);

        switch (opcion_elegida) {
            case "1":
                System.out.println(" creacion personaje");
                Personaje personaje_jugador = new Personaje();

                System.out.println("como se llamaras a tu héroe?");
                personaje_jugador.nombre = scanner.nextLine();
                System.out.println("el nombre del jugador es: " + personaje_jugador.nombre);

                System.out.println("cual es el apellido de tu héroe?");
                personaje_jugador.apellido = scanner.nextLine();
                System.out.println("el nombre del jugador es: " + personaje_jugador.apellido);

                System.out.println("indique la vida del héroe?");
                personaje_jugador.vida = Integer.parseInt(scanner.nextLine());
                System.out.println("el nombre del jugador es: " + personaje_jugador.vida);

                break;
            
            case "2":
                System.out.println(" ver personaje");
                System.out.println("");
                break;

            case "3":
                System.out.println(" gracias por jugar");
                iniciar_menu = false;
                break;
        
            default:
                System.out.println("porfavor ingrese una de las opciones permitidas");
                break;
        
       }
        }
    }
}
