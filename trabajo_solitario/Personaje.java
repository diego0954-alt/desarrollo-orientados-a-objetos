package trabajo_solitario;

public abstract class Personaje {

    private String nombre;
    private int vida;
    private int nivel;

    public Personaje(String nombre, int vida, int nivel){
        this.nombre = nombre;
        this.vida = vida;
        this.nivel = nivel;
    }

    public String getnombre(){
        return nombre;
    }

    public int getvida(){
        return vida;
    }

    public void setnivel(int nivel){
        this.nivel = nivel;
    }

    public abstract String atacar();

    public String mostraInfo(){
        return "el nombre del personaje: " + nombre + " su vida: " + vida + " su nivel: " + nivel;
    }


    
}
