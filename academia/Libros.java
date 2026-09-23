package academia;

public class Libros extends Material {

    private int NumPaginas;

    public Libros(int NumPaginas, String Titulo, String Autor, int CantidadDisponible) {
        super(Titulo, Autor, CantidadDisponible);
        this.NumPaginas = NumPaginas;
    }

    public int getNumPaginas() {
        return NumPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        NumPaginas = numPaginas;
    }

    @Override
    public int calcularDiasPrestamo() {
        if (NumPaginas > 300) {
            return 14;
        } else {
            return 7;
        }
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " cantidad de paguinas: " + getNumPaginas();

    }
}
