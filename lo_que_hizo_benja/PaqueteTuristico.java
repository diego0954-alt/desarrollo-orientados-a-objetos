package lo_que_hizo_benja;

public abstract class PaqueteTuristico {

    private String destino;
    private double duracion;
    private Pasajero pasajero;

    public PaqueteTuristico(String destino, double duracion, Pasajero pasajero) {
        this.destino = destino;
        this.duracion = duracion;
        this.pasajero = pasajero;
    }

    public String getDestino() {
        return destino;
    }

    public double getDuracion() {
        return duracion;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public abstract double calcularCosto();

    public abstract String getTipo();

    public double calcularPrecioFinal(double impuesto) {
        return calcularCosto() + (calcularCosto() * impuesto / 100);
    }
}