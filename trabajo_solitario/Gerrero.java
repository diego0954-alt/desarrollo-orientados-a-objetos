package trabajo_solitario;

public class Gerrero extends Personaje{

    private int fuerza;
    private String armadura;

    Gerrero( int fuerza, String armadura, String nombre, int vida, int nivel){
        super(nombre, vida, nivel);
        this.fuerza = fuerza;
        this.armadura = armadura;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public String getArmadura() {
        return armadura;
    }

    public void setArmadura(String armadura) {
        this.armadura = armadura;
    }
    @Override
    public String atacar() {
        return  this.armadura + " su armadura " + this.fuerza + " de fuerza" ;
    }
    
    @Override
    public String mostraInfo() {
        return super.mostraInfo();
    }
}
