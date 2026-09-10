package proyecto_prueba;

public abstract class Producto {
    private String nombre;
    private int precioBase;
    private int stock;

    Producto(String nombre, int precioBase, int stock){
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.stock = stock;

    }
   
    public int getprecioBase(){
        return precioBase;
    }

    public void setprecioBase(int precioBase) {
        this.precioBase = precioBase;
    }

    public String getnombre(){
        return nombre;
    }
    
    public int getstock(){
        return this.stock;
    }

    public void setstock(int stock){
        this.stock = stock;
    }

    public abstract int calcularPrecioFinal();

    public String mostrarInfo(){
        return "juego: " + this.nombre + "tiene un precio base de: " + this.precioBase + "stock: " + this.stock;
    }

  
   
}
