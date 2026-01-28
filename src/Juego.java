public class Juego {
    private int turno; // 0 para negras, 1 para blancas
    private Movimiento mov;

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;

    }

    public Movimiento jugada(String jugada, Tablero tablero) {

        String s = jugada.trim().toLowerCase();
        if (s.length() != 4) {
            System.out.println(Constantes.MSG_INTRODUCE_JUGADA);
        }


        char columna1 = s.charAt(0);
        char fila1 = s.charAt(1);
        char columna2 = s.charAt(2);
        char fila2 = s.charAt(3);

        if (columna1 < 'a' || columna1 > 'h' || columna2 < 'a' || columna2 > 'h') {
            System.out.println(Constantes.MSG_INTRODUCE_JUGADA);
            return null;

        } else if (fila1 < '1' || fila1 > '8' || fila2 < '1' || fila2 > '8') {
            System.out.println(Constantes.MSG_INTRODUCE_JUGADA);
            return null;
        }

        int col1 = columna1 - 'a';
        int fil1 = fila1 - '1';
        int col2 = columna2 - 'a';
        int fil2 = fila2 - '1';

        Posicion posIni = new Posicion(fil1, col1);
        Posicion posFin = new Posicion(fil2, col2);
        Pieza p1 = tablero.devuelvePieza(posIni);
        Pieza p2 = tablero.devuelvePieza(posFin);

        if (!tablero.hayPieza(fil1, col1)) {
            System.out.println(Constantes.MSG_JUGADA_NO_VALIDA);
            return null;
        } else if (p1.getColor() != turno) {
            System.out.println(Constantes.MSG_TURNO_INVALIDO);
            return null;

        }else if (p2!=null){
            if (p1.getColor()== p2.getColor()) {
                System.out.println(Constantes.MSG_CANIBALISMO);
                return null;
            }
        }


        this.mov= new Movimiento(posIni, posFin);

        
        
        
//        switch (p.getNombre()) {
//            case "rey":
//                if (!((Rey) p).movimientoValido(mov)) {
//
//                    return null;
//                }
//                break;
//            case "dama":
//                if (!((Dama) p).movimientoValido(mov)) {
//
//                    return null;
//                }
//                break;
//            case "torre":
//                if (!((Torre) p).movimientoValido(mov)) {
//
//                    return null;
//                }
//                break;
//            case "alfil":
//                if (!((Alfil) p).movimientoValido(mov)) {
//
//                    return null;
//                }
//                break;
//            case "caballo":
//                if (!((Caballo) p).movimientoValido(mov)) {
//
//                    return null;
//                }
//                break;
//            case "peon":
//                if (!((Peon) p).movimientoValido(mov)) {
//
//                    return null;
//                }
//                break;
//            default:
//                System.out.println(Constantes.MSG_ERROR);
//                return null;
//        }


        return this.mov;
    }
    public Movimiento getMovimiento() {
        return this.mov;
    }
}
