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
            if (getColor() == 1) {
                if (posFin.getFila() == 7) {
                    Pieza nueva = null;
                    int r = Constantes.leerEntero(Constantes.MSG_PROMOCION);

                    switch (r) {
                        case 1:
                            nueva = new Dama(1);
                            this.setNombre("reina");
                            nueva.pintarPieza();
                            break;
                        case 2:
                            nueva = new Torre(1);
                            nueva.setPieza(posFin, nueva);
                            break;
                        case 3:
                            nueva = new Alfil(1);
                            this.setNombre("alfil");
                            pintarPieza();
                            break;
                        case 4:
                            nueva = new Caballo(1);
                            this.setNombre("caballo");
                            pintarPieza();
                            break;
                    }
                    if (nueva != null) {
                        this.setPieza(posFin, nueva);
                        return true;
                    }
                } else if (getColor() == 0) {
                    if (posFin.getFila() == 0) {
                        int r = Constantes.leerEntero(Constantes.MSG_PROMOCION);
                        Pieza nueva = null;
                        switch (r) {
                            case 1:
                                nueva = new Dama(0);
                                this.setNombre("Dama");
                                pintarPieza();
                                break;
                            case 2:
                                nueva = new Torre(0);
                                break;
                            case 3:
                                nueva = new Alfil(0);
                                this.setNombre("alfil");
                                pintarPieza();
                                break;
                            case 4:
                                nueva = new Caballo(0);
                                this.setNombre("caballo");
                                pintarPieza();
                                break;
                        }
                        if (nueva != null) {
                            this.setPieza(posFin, nueva);
                            return true;
                        }
                    }

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
