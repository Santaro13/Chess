public class Dama extends Pieza {

    public Dama(int color) {
        super(color);
        this.setNombre("Dama");
    }

    @Override
    public boolean movimientoValido(Movimiento mov) {
        if (mov.esDiagonal() || mov.esHorizontal() || mov.esVertical()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String pintarPieza() {
        return getColor() == 0 ? "[♕]" : "[♛]";
    }
}
