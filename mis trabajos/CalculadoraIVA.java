public class CalculadoraIVA {
    public static double CalcularIVA(double precio) {
        return precio * 0.19;
    }

    public static void main(String[] args) {
        double iva = CalcularIVA(1000);
        System.out.println("el IVA es: " + iva);
    }
}
