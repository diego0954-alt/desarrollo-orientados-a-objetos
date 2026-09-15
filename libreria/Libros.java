package libreria;

public abstract class Libros {
    private String Titulo;
    private int PrecioBase;
    private int Stock;
    
    public Libros(String Titulo, int PrecioBase, int Stock){
        this.Titulo = Titulo;
        this.PrecioBase = PrecioBase;
        this.Stock = Stock;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public int getPrecioBase() {
        return PrecioBase;
    }

    public void setPrecioBase(int precioBase) {
        PrecioBase = precioBase;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }
    
    public abstract int calcularPrecioFinal();

    public String mostrarInfo(){
        return  "el titulo del libro es: " + Titulo + " el precio del libro es: $" + PrecioBase + " el stock de los libroses :" + Stock ;

    }
}
