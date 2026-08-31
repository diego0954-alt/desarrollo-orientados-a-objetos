public class Personaje {
    String nombre;
    String apellido;
    private int vida;
    boolean esta_vivo = true;
    private int edad;

    // Si llega edad negativa, que sea 18
    public void ingresarEdad(int edad) {
        if (edad < 0) {
            System.out.println("La edad no puede ser negativa, asi que le asignamos a tu personaje la edad de 18");
            this.edad = 18;
        } else {
            this.edad = edad;
        }
    }

    public int obtenerEdad() {
        return this.edad;
    }

    public void setVida(int vida) {
        if (vida < 0) {
            System.out.print("La vida del personaje no puede ser negativa. Que demonios haces!");
            this.vida = 0;
        } else {
            this.vida = vida;
        }
    }

    public int getVida() {
        return this.vida;
    }




    }