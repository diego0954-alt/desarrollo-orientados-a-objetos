public class Personaje {
    String nombre;
    String apellido; 
    int vida;
    boolean esta_vivo = true;


    public void setearVida(int vida){
        this.vida = vida;
        if(vida < 0){
            this.vida = 0;
        } else {
            this.vida = vida;
        }

    }
}
