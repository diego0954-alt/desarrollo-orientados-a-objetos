public class Personaje {
    String nombre;
    String apellido; 
    int vida;
    boolean esta_vivo = true;
    private int edad;


    public void setearVida(int vida){
        this.vida = vida;
        if(vida < 0){
            System.out.println("la edad no puede ser negativa, asi que le asignamos a tu perosonaje 18");
            this.vida = 18;
        } else {
            this.vida = vida;
        }

    }
}

    public int obtenerEdad;
        return
