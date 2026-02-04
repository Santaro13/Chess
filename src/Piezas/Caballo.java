package Piezas;
import ajedrez.Movimiento;
public class Caballo extends Pieza {

    public Caballo(int color) {
        super(color);
        this.setNombre("caballo");
    }

    @Override
    public boolean movimientoValido(Movimiento mov) {
        if (Math.abs(mov.saltoVertical()) == 2 && Math.abs(mov.saltoHorizontal()) == 1 || Math.abs(mov.saltoVertical()) == 1 && Math.abs(mov.saltoHorizontal()) == 2){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String pintarPieza() {
        return getColor() == 0 ? "[♘]" : "[♞]";
    }


}
