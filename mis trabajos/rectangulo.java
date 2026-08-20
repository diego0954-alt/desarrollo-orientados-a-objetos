public class rectangulo {

   public static double calcularArea(double base, double altura) {
    return base * altura;
   } 

   public static double calcularPerimetro(double base, double altura) {
    return 2 * (base + altura);
   }

   public static void main(String[] args) {
    double area = calcularArea(3,5);
    double perimetro = calcularPerimetro(5,8);

    System.out.println("el resultado del area: " + area);
    System.out.println("el resultado del perimetro: " + perimetro);
   }
}
