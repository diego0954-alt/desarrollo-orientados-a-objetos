package academia;

public class ActividadOnline extends Actividad{
    private int Descuento;
    private String Plataforma;
    
    public ActividadOnline(int Descuento, String Plataforma, String Nombre, int PrecioBase, int Cupos){
        super(Nombre, PrecioBase, Cupos);
        this.Descuento = Descuento;
        this.Plataforma = Plataforma;
    }

    public int getDescuento() {
        return Descuento;
    }

    public void setDescuento(int descuento) {
        Descuento = descuento;
    }

    public String getPlataforma() {
        return Plataforma;
    }

    public void setPlataforma(String plataforma) {
        Plataforma = plataforma;
    }
    
    @Override
    public int CalcularCupos() {
        return 0;
    }

    @Override
    public String MostrarInfo() {
        return super.MostrarInfo() + "el descuento es de: $" + Descuento + "la plataforma es: " + Plataforma;
    } 
}
