public class Caballo extends Pieza {

    public Caballo(int color) {
        super(color);
        this.setNombre("caballo");
    }

    @Override
    public boolean movimientoValido(Movimiento mov) {
        if (mov.esDiagonal()) {
            return false;
        }
        if (mov.saltoVertical() == 2 && mov.saltoHorizontal() == 1 || mov.saltoVertical() == 1 && mov.saltoHorizontal() == 2) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String pintarPieza() {
        return getColor() == 0 ? "[♘]" : "[♞]";
    }


}
