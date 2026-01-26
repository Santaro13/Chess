public class Peon extends Pieza {
    public Peon(int color) {
        super(color);
        this.setNombre("peon");
    }

    @Override
    public boolean movimientoValido(Movimiento mov) {
        if (mov.esVertical()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String pintarPieza() {
        return getColor() == 0 ? "[♙]" : "[♟]";
    }
}
