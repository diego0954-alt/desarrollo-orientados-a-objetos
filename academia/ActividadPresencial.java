package academia;

public class ActividadPresencial extends Actividad {

    private int CostoSala;

    public ActividadPresencial(int CostoSala, String Nombre, int PrecioBase, int Cupos){
        super(Nombre, PrecioBase, Cupos);
        this.CostoSala = CostoSala;
    }

    public int getCostoSala() {
        return CostoSala;
    }

    public void setCostoSala(int costoSala) {
        CostoSala = costoSala;
    }

    @Override
    public int CalcularCupos() {
        return this.getPrecioBase() + this.getCostoSala();
    }

    @Override
    public String MostrarInfo() {
        return super.MostrarInfo() + "el costo de la sala es de: $" + CostoSala;
    }
    
}
