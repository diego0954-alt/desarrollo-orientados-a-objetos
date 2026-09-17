package lo_que_hizo_benja;

public class PaqueteInternacional
        extends PaqueteTuristico
        implements Asegurable {

    private boolean primeraClase;
    private String companiaSeguro;

    public PaqueteInternacional(
            String destino,
            double duracion,
            Pasajero pasajero,
            boolean primeraClase) {

        super(destino, duracion, pasajero);
        this.primeraClase = primeraClase;
        this.companiaSeguro = null;
    }

    @Override
    public double calcularCosto() {
        double costo = 450000;
        if (primeraClase) {
            costo = costo + (costo * 35 / 100);
        }
        return costo;
    }

    @Override
    public String getTipo() {
        return "Paquete Internacional";
    }

    @Override
    public void contratarSeguro(String compania) {

        if (companiaSeguro == null) {
            companiaSeguro = compania;
            System.out.println("Seguro contratado correctamente.");
        } else {
            System.out.println("El paquete ya tiene un seguro contratado.");
        }
    }

    @Override
    public String consultarSeguro() {
        if (companiaSeguro == null) {
            return "Sin seguro contratado";
        }
        return "Contratado - " + companiaSeguro;
    }

    public boolean isPrimeraClase() {
        return primeraClase;
    }
}