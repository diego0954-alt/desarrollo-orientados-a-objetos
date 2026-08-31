package proyectos_pilares_POO;

public class Publicacion {

    int id;
    String autor;
    String fechaCreacion;
    int like;
    boolean estaActiva;
    
    public void Publicacion(int id, String autor) {
        this.id = id;
        this.autor = autor;

    
    }
    public void darLike(int like){
        this.like = like;

    }
}

