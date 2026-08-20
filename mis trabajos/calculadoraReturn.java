public class calculadoraReturn {

    public static int sumar(int a, int b){
        return a + b;
    }
    
    public static void main(String[] args) {
        int resultado = sumar(10, 5);
        System.out.println("la suma es: " + resultado);
    }

}