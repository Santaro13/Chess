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
            System.out.println(Constantes.MSG_JUGADA_NO_VALIDA);
            System.out.println(Constantes.MSG_INTRODUCE_JUGADA);
            return null;
        }


        char columna1 = s.charAt(0);
        char fila1 = s.charAt(1);
        char columna2 = s.charAt(2);
        char fila2 = s.charAt(3);

        if (columna1 < 'a' || columna1 > 'h' || columna2 < 'a' || columna2 > 'h') {
            System.out.println(Constantes.MSG_INTRODUCE_JUGADA);
            System.out.println(Constantes.MSG_JUGADA_NO_VALIDA);
            return null;

        } else if (fila1 < '1' || fila1 > '8' || fila2 < '1' || fila2 > '8') {
            System.out.println(Constantes.MSG_INTRODUCE_JUGADA);
            System.out.println(Constantes.MSG_JUGADA_NO_VALIDA);
            return null;
        }

        int col1 = columna1 - 'a';
        int fil1 = fila1 - '1';
        int col2 = columna2 - 'a';
        int fil2 = fila2 - '1';

        Posicion posIni = new Posicion(fil1, col1);
        Posicion posFin = new Posicion(fil2, col2);
        Movimiento movimiento = new Movimiento(posIni, posFin);
        Pieza p1 = tablero.devuelvePieza(posIni);
        Pieza p2 = tablero.devuelvePieza(posFin);
        Pieza block = tablero.hayPiezaEntre(movimiento);

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
        }else if (block != null && !movimiento.esDiagonal() && !(p1 instanceof Peon)) {
            System.out.println(Constantes.MSG_HAY_PIEZA_ENTRE);
            return null;

    }else if (!p1.movimientoValido(movimiento)) {
            System.out.println(Constantes.MSG_JUGADA_NO_VALIDA);
            return null;
        }
        this.mov= new Movimiento(posIni, posFin);


        return this.mov;
    }
    public Movimiento getMovimiento() {
        return this.mov;
    }
}
