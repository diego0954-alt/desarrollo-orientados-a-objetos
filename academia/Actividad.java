package academia;

public abstract class Actividad {
    private String Nombre;
    private int PrecioBase;
    private int Cupos;

    public Actividad(String Nombre, int PrecioBase, int Cupos){
        this.Nombre = Nombre;
        this.PrecioBase = PrecioBase;
        this.Cupos = Cupos;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getPrecioBase() {
        return PrecioBase;
    }

    public void setPrecioBase(int precioBase) {
        PrecioBase = precioBase;
    }

    public int getCupos() {
        return Cupos;
    }

    public void setCupos(int cupos) {
        Cupos = cupos;
    }

    public abstract int CalcularCupos();

    public String MostrarInfo(){
        return "el nombre es: " + Nombre + " el precio base es: $" + PrecioBase + " los cupos son: " + Cupos;
    }
}
