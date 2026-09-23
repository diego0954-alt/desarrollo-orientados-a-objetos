package academia;

public class Revistas extends Material{

    private String MesPublicacion;

    public Revistas(String MesPublicacion, String Titulo, String Autor, int CantidadDisponible){
        super(Titulo, Autor, CantidadDisponible);
        this.MesPublicacion = MesPublicacion;
    }

    public String getMesPublicacion() {
        return MesPublicacion;
    }

    public void setMesPublicacion(String mesPublicacion) {
        MesPublicacion = mesPublicacion;
    }

    @Override
    public int calcularDiasPrestamo() {
        return 7;
       
    }

    @Override
    public String mostrarInfo() {
       return super.mostrarInfo() + " mes de publicacion: " + getMesPublicacion();
    }
}