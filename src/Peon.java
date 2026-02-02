public class Peon extends Pieza {
    public Peon(int color) {
        super(color);
        this.setNombre("peon");
    }

    @Override
    public boolean movimientoValido(Movimiento mov) {
        Posicion posIni = mov.posInicial;
        Posicion posFin = mov.posFinal;
        if (mov.esVertical()&& mov.saltoVertical() == 1) {
            return true;
        }

        if (getColor() == 1 && posIni.getFila() == 1) {
            if (mov.esVertical() && mov.saltoVertical() == 2|| mov.saltoVertical() == 1) {
                return true;
            } else if(getColor() == 0 && posIni.getFila() == 6) {
                if (mov.esVertical() && mov.saltoVertical() == 2|| mov.saltoVertical() == 1) {
                    return true;
                }
            }else {
                return false;
            }
        }else {
            return false;
        }


        //if (mov.esDiagonal() && mov.saltoDiagonal() == 1 && ) {

          //  return true;
        //}

        if (getColor() == 1){
            if (posFin.getFila()==8) {
                int r=Constantes.leerEntero(Constantes.MSG_PROMOCION);
                switch (r){
                    case 1:
                        this.setNombre("reina");
                        break;
                    case 2:
                        this.setNombre("torre");
                        break;
                    case 3:
                        this.setNombre("alfil");
                        break;
                    case 4:
                        this.setNombre("caballo");
                        break;
                }
            }

         }

        return false;
    }


        @Override
        public String pintarPieza () {
            return getColor() == 0 ? "[♙]" : "[♟]";
        }
}
