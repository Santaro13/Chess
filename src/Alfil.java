public class Alfil extends Pieza {

    public Alfil(int color) {
        super(color);
        this.setNombre("alfil");
    }

    @Override
    public boolean movimientoValido(Movimiento mov) {
        if (mov.esDiagonal()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String pintarPieza() {
        return getColor() == 0 ? "[♗]" : "[♝]";
    }
}
