public class Personaje {

    private int id;
    private String nombre;
    private int nivel;

    public Personaje(int id, String nombre, int nivel) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void mostrarInfo() {
        System.out.println("ID: " + id + " | Nombre: " + nombre + " | Nivel: " + nivel);
    }

    public String realizarAccion() {
        return nombre + " no realiza ninguna acción especial.";
    }
}
