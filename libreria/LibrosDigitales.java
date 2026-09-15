package libreria;

public class LibrosDigitales extends Libros {
    private int Descuento;
    private String Formato;
    public LibrosDigitales(int Descuento, String Formato, String Titulo, int PrecioBase, int Stock){
        super(Titulo, PrecioBase, Stock);
        this.Descuento = Descuento;
        this.Formato = Formato;
    }
    public int getDescuento() {
        return Descuento;
    }
    public void setDescuento(int descuento) {
        Descuento = descuento;
    }
    public String getFormato() {
        return Formato;
    }
    public void setFormato(String formato) {
        Formato = formato;
    }


    @Override
    public int calcularPrecioFinal() {
        return PrecioBase - (PrecioBase * Descuento / 100);
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + "el descuento es del libro digital es de: $" + Descuento + " el formato es de: " + Formato + ;
    }
}
