package lo_que_hizo_benja;

public class PaqueteCrucero extends PaqueteTuristico {
    private boolean tieneBalcon;

    public PaqueteCrucero(
            String destino,
            double duracion,
            Pasajero pasajero,
            boolean tieneBalcon) {
        super(destino, duracion, pasajero);
        this.tieneBalcon = tieneBalcon;
    }

    @Override
    public double calcularCosto() {
        double costo = 800000;
        if (tieneBalcon) {
            costo = costo + (costo * 25 / 100);
        }
        return costo;
    }

    @Override
    public String getTipo() {
        return "Paquete Crucero";
    }

    public boolean isTieneBalcon() {
        return tieneBalcon;
    }
}
