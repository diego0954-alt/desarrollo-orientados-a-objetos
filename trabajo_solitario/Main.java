package trabajo_solitario;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        ArrayList<Personaje> Equipo = new ArrayList<>();


        System.out.println("cual es tu nombre guerrero?");
        String nombre = consola.nextLine();

        System.out.println("cual es tu nivel?");
        int nivel = Integer.parseInt(consola.nextLine());

        System.out.println("cual es tu fuerza?");
        int fuerza  = Integer.parseInt(consola.nextLine());

        System.out.println("cual es tu nivel de vida?");
        int vida = Integer.parseInt(consola.nextLine());

        System.out.println("cual es tu tipo de armadura?");
        String armadura = consola.nextLine();

        System.out.println("su nombre es: " + nombre + " | " + "su nivel es: " + nivel + " | " + "su fuerza es: " + fuerza  + " | " + "su vida es: " + vida + " | " + "su armadura esta echa de: " + armadura);
        
        Equipo.add(new Gerrero(fuerza, armadura, nombre, vida, nivel));

        for (Personaje p : Equipo) {
            System.out.println( p.atacar());

            }

        }
        
    }
    
 