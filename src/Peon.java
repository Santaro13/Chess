public class Peon extends Pieza {
    public Peon(int color) {
        super(color);
        this.setNombre("peon");
    }

    @Override
    public boolean movimientoValido(Movimiento mov) {
        Posicion posIni = mov.posInicial;
        Posicion posFin = mov.posFinal;

        if (getColor() == 1 && posIni.getFila() == 2) {
            if (mov.esVertical() && mov.saltoVertical() == 2|| mov.saltoVertical() == 1) {
                return true;
            } else if(getColor() == 0 && posIni.getFila() == 7) {
                if (mov.esVertical() && mov.saltoVertical() == 2|| mov.saltoVertical() == 1) {
                    return true;
                }
            }else {
                return false;
            }
        }else {
            return false;
        }
        return false;
    }

        @Override
        public String pintarPieza () {
            return getColor() == 0 ? "[♙]" : "[♟]";
        }
}
