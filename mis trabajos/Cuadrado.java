public class Cuadrado {
    
    public static double calcularArea(double base, double altura) {
    return base * altura;
   } 

   public static double calcularPerimetro(double base, double altura) {
    return 2 * (base + altura);
   }

   public static double calcularArea(double lado) {
    return lado * lado;
   }
   public static void main(String[] args) {
    double area = calcularArea(5,8);
    double perimetro = calcularPerimetro(5,8);
    double cuadrado = calcularArea(8);

    System.out.println("el area del ractangulo es: " + area);
    System.out.println("el perimetro del ractangulo es: " + perimetro);
    System.out.println("el resultado del cuadrado: " + cuadrado);
   }
}
