package Piezas;
import ajedrez.Movimiento;
public class Torre extends Pieza {

    public Torre(int color) {
        super(color);
        this.setNombre("torre");
    }

    @Override
    public boolean movimientoValido(Movimiento mov) {
        if (mov.esHorizontal() || mov.esVertical()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String pintarPieza() {
            return getColor() == 0 ? "[♖]" : "[♜]";

    }


}
