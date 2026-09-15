package proyectos_pilares_POO;

public class Intagram {
    public static void main(String[] args) {
        crearPublicacion();
    }

    static void crearPublicacion() {
        Publicacion1 publicacion1 = new Publicacion1("12", "papa");
        publicacion1.serAutor("Pepito");

        System.out.println("el nombre del autor es " + Publicacion1.class);
    }
}
