package lo_que_hizo_benja;

public class Pasajero {

    private String nombreCompleto;
    private String pasaporte;
    private String correo;

    public Pasajero(String nombreCompleto, String pasaporte, String correo) {
        this.nombreCompleto = nombreCompleto;
        this.pasaporte = pasaporte;
        this.correo = correo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getPasaporte() {
        return pasaporte;
    }

}