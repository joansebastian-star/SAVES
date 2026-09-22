public class Mago extends Personaje {

    public Mago(int id, String nombre, int nivel) {
        super(id, nombre, nivel);
    }

    @Override
    public String realizarAccion() {
        return getNombre() + " lanza un hechizo.";
    }
}
