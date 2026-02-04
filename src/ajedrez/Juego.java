package ajedrez;

import Piezas.*;

public class Juego {
    private int turno; // 0 para negras, 1 para blancas
    private Movimiento mov;

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;

    }

    public String jugada(String jugada, Tablero tablero){
        String s = jugada.trim().toLowerCase();
        char columna1 = s.charAt(0);
        char fila1 = s.charAt(1);
        char columna2 = s.charAt(2);
        char fila2 = s.charAt(3);
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


        if (s.length() != 4) {
            System.out.println(Constantes.MSG_JUGADA_NO_VALIDA);
            System.out.println(Constantes.MSG_INTRODUCE_JUGADA);
        } else if (columna1 < 'a' || columna1 > 'h' || columna2 < 'a' || columna2 > 'h') {
            System.out.println(Constantes.MSG_INTRODUCE_JUGADA);
            System.out.println(Constantes.MSG_JUGADA_NO_VALIDA);
        } else if (fila1 < '1' || fila1 > '8' || fila2 < '1' || fila2 > '8') {
            System.out.println(Constantes.MSG_INTRODUCE_JUGADA);
            System.out.println(Constantes.MSG_JUGADA_NO_VALIDA);
        } else if (!tablero.hayPieza(fil1, col1)) {
            System.out.println(Constantes.MSG_JUGADA_NO_VALIDA);
        }else if (!p1.movimientoValido(movimiento)) {
            System.out.println(Constantes.MSG_JUGADA_NO_VALIDA);
        } else if (p1.getColor() != turno) {
            System.out.println(Constantes.MSG_TURNO_INVALIDO);
        }else if (p2!=null){
            if (p1.getColor()== p2.getColor()) {
                System.out.println(Constantes.MSG_CANIBALISMO);
            }
        }else if (block != null && !(p1 instanceof Peon)) {
            System.out.println(Constantes.MSG_HAY_PIEZA_ENTRE);
        } else if (p1 instanceof Peon) {
            if ((p1.getColor() == 1 && posFin.getFila() == 7) ||
                    (p1.getColor() == 0 && posFin.getFila() == 0)) {

                int opcion = Constantes.leerEntero(Constantes.MSG_PROMOCION);
                Pieza nueva = switch (opcion) {
                    case 1 -> new Dama(p1.getColor());
                    case 2 -> new Torre(p1.getColor());
                    case 3 -> new Alfil(p1.getColor());
                    case 4 -> new Caballo(p1.getColor());
                    default -> null;
                };
                tablero.quitaPieza(posIni);
                tablero.ponPieza(nueva,posIni);
            }
        }else {
            return null;
        }
        this.mov= new Movimiento(posIni, posFin);
        return s;
    }





    public Movimiento getMovimiento() {
        return this.mov;
    }
}
