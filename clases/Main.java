import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        mostrarMenu();
    }

    static void mostrarMenu() {
        String opcion_menu;
        boolean mantener_menu = true;

        Personaje personaje_jugador = new Personaje();

        Scanner scanner = new Scanner(System.in);

        while (mantener_menu) {
            System.out.println("Elija su opción");
            System.out.println("1.- Crear personaje");
            System.out.println("2.- Ver personaje");
            System.out.println("3.- Cerrar");
            System.out.println("4.- testeando cosas");
            opcion_menu = scanner.nextLine();

            switch (opcion_menu) {
                case "1":
                    System.out.println("Creación del Personaje");
                    System.out.println("¿Cómo llamaras al personaje?");
                    personaje_jugador.nombre = scanner.nextLine();

                    System.out.println("¿Cómo llamaras al apellido del personaje?");
                    personaje_jugador.apellido = scanner.nextLine();

                    System.out.println("Asigna la vida del personaje");
                    personaje_jugador.setVida(Integer.parseInt(scanner.nextLine()));

                    System.out.println("Asignarle la edad al personaje");
                    personaje_jugador.ingresarEdad(Integer.parseInt(scanner.nextLine()));

                    break;
                case "2":
                    System.out.println("Datos del personaje creado");
                    System.out.println("Nombre personaje: " + personaje_jugador.nombre);
                    System.out.println("Apellido personaje: " + personaje_jugador.apellido);

                    // OJITO CON ESTO, ESTO ES LA LUZ!
                    // REFLEXIONA, POR QUÉ ES MEJOR ESTO?
                    // ENCAPSULANDO
                    System.out.println("Vida personaje: " + personaje_jugador.getVida());
                    System.out.println("¿Se encuentra vivo?: " + personaje_jugador.esta_vivo);
                    System.out.println("La edad del personaje es: " + personaje_jugador.obtenerEdad());
                    break;
                case "3":
                    System.out.println("Cosas de opcion 3");
                    mantener_menu = false;
                    break;

                case "4":
                    testeando_cosas();

                default:
                    System.out.println("Por favor ingrese una opción valida");
                    break;
            }
        }
    }

    public void trabajar(){
        System.out.println("escribiendo codigo");
        GameDave GameDave = new GameDave();
        GameDave.experiencia();
        System.out.println("Experiencia de GameDave: ");
        
       
        
    }
}