package proyectos_pilares_POO;

public class Publicacion1 {
    private String id;
    private String autor;
    private String fechaDeCreacion ;
    private int like;
    protected boolean estaActiva;

    Publicacion1(String id, String autor){
        this.id = id;
        this.autor = autor;
        this.like = 0;

    }

    void serAutor(String nombre){
        if(nombre.length() > 20){
            System.out.println("el nombre del autor no puede exseder los 20 caracteres");
        } else{
            this.nombre = nombre;
        }
        this.autor = nombre;
    }

    public String 

}
