package Piezas;
import ajedrez.*;

public class Peon extends Pieza {
    public Peon(int color) {
        super(color);
        this.setNombre("peon");
    }

    @Override
    public boolean movimientoValido(Movimiento mov) {
        Posicion posIni = mov.getPosInicial();
        // BLANCAS
        if (getColor() == 1) {
            // pm
            if (posIni.getFila() == 1) {
                if (mov.esVertical() && (mov.saltoVertical() == 1 || mov.saltoVertical() == 2)) {
                    return true;
                }
            }
            if (mov.esVertical() && mov.saltoVertical() == 1) {
                return true;
            }
        }
        // NEGRAS
        if (getColor() == 0) {
            // pm
            if (posIni.getFila() == 6) {
                if (mov.esVertical() && (mov.saltoVertical() == -1 || mov.saltoVertical() == -2)) {
                    return true;
                }
            }
            if (mov.esVertical() && mov.saltoVertical() == -1) {
                return true;
            }
        }

        return false;
    }

    @Override
        public String pintarPieza () {
            return getColor() == 0 ? "[♙]" : "[♟]";
        }
}
