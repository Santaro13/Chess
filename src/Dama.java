public class Dama extends Pieza {

    public Dama(int color) {
        super(color);
        this.setNombre("dama");
    }

    @Override
    public boolean movimientoValido(Movimiento mov) {
        if (mov.esHorizontal() || mov.esVertical() || mov.esDiagonal()) {
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
