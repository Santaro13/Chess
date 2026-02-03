public class Peon extends Pieza {
    public Peon(int color) {
        super(color);
        this.setNombre("peon");
    }

    @Override
    public boolean movimientoValido(Movimiento mov) {
        Posicion posIni = mov.posInicial;
        Posicion posFin = mov.posFinal;

        if (getColor() == 1 && posIni.getFila() == 1) {
            if (mov.esVertical() && mov.saltoVertical() == 2 || mov.saltoVertical() == 1) {
                return true;
            }
        }
        if (getColor() == 0 && posIni.getFila() == 6) {
            if (mov.esVertical() && mov.saltoVertical() == 2 || mov.saltoVertical() == 1) {
                return true;
            }
        }
        if (mov.esVertical() && mov.saltoVertical() == 1) {
            return true;
            }

        return false;
    }
        @Override
        public String pintarPieza () {
            return getColor() == 0 ? "[♙]" : "[♟]";
        }
}
