package trabajo_solitario;

public class Mago  extends Personaje{
    private int mana;
    private String echizoFavorito;

    Mago(int mana, String echizoFavorito, String nombre, int vida, int nivel){
        super(nombre, vida, nivel);
        this.mana = mana;
        this.echizoFavorito = echizoFavorito;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public String getEchizoFavorito() {
        return echizoFavorito;
    }

    public void setEchizoFavorito(String echizoFavorito) {
        this.echizoFavorito = echizoFavorito;
    }

    @Override
    public String atacar() {
        return "su mana es " + this.mana + " su hechizo favorito es " +  this.echizoFavorito;
    }
    @Override
    public String mostraInfo() {
        return super.mostraInfo() + atacar();
    }

    
}
