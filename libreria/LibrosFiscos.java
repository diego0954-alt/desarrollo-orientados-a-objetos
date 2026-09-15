package libreria;

public class LibrosFiscos extends Libros {

    private int CostoEnvio;

    public LibrosFiscos(int CostoEnvio, String Titulo, int PrecioBase, int Stock ) {
        super(Titulo, PrecioBase, Stock);
         this.CostoEnvio = CostoEnvio;
    }

    public int getCostoEnvio() {
        return CostoEnvio;
    }

    public void setCostoEnvio(int costoEnvio) {
        CostoEnvio = costoEnvio;
    }

    @Override
    public int calcularPrecioFinal() {
        return PrecioBase + CostoEnvio;
    }

   @Override
   public String mostrarInfo() {
       return super.mostrarInfo() + " el costo de envio es: $" + CostoEnvio;
   }

}
