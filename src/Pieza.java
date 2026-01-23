public abstract class Pieza {
    private final int color;
    //public static final int NEGRAS = 0;
    //public static final int BLANCAS = 1;
    private String nombre;

    //0-Negras 1-Blancas
    public Pieza(int color) {
        this.color = color;

    }

    public int getColor() {
        return color;
    }

    public abstract boolean movimientoValido(Movimiento mov);

    public String getNombre() {
        return nombre.toLowerCase();
    }
    public void setNombre(String nombre) {
        this.nombre = nombre.toLowerCase();

    }

    public abstract String pintarPieza();


    @Override
    public String toString() {
        return "Pieza{" +
                "color=" + color +
                ", nombre='" + nombre + '\'' +
                '}';
    }


}
/* public char pintarPieza(String nombre, int color) {
        switch (nombre.toLowerCase()) {
            case "rey":
                return color == 0 ? '♔' : '♚';
            case "dama":
                return color == 0 ? '♕' : '♛';
            case "torre":
                return color == 0 ? '♖' : '♜';
            case "alfil":
                return color == 0 ? '♗' : '♝';
            case "caballo":
                return color == 0 ? '♘' : '♞';
            case "peon":
                return color == 0 ? '♙' : '♟';
            default:
                return '?';

        }

 */