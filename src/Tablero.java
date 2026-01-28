public class Tablero {
    Pieza tablero[][] = new Pieza[8][8];
    Posicion pos = new Posicion();


    public Tablero() {
        //vacío
        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 8; columna++) {
                tablero[fila][columna] = null;
            }
        }
        //piezas negras
        tablero[7][1] = new Caballo(0);
        tablero[7][6] = new Caballo(0);
        tablero[7][3] = new Rey(0);
        tablero[7][4] = new Dama(0);
        tablero[7][0] = new Torre(0);
        tablero[7][7] = new Torre(0);
        tablero[7][2] = new Alfil(0);
        tablero[7][5] = new Alfil(0);

        // colocar peones
        for (int columna = 0; columna < 8; columna++) {
            tablero[1][columna] = new Peon(1);
        }


        //piezas blancas
        tablero[0][4] = new Dama(1);
        tablero[0][1] = new Caballo(1);
        tablero[0][3] = new Rey(1);
        tablero[0][6] = new Caballo(1);
        tablero[0][0] = new Torre(1);
        tablero[0][7] = new Torre(1);
        tablero[0][2] = new Alfil(1);
        tablero[0][5] = new Alfil(1);

        // colocar peones
        for (int columna = 0; columna < 8; columna++) {
            tablero[6][columna] = new Peon(0);
        }
    }


    public void pintarTablero() {
        for (int fila = 8; fila >= 1; fila--) {
            System.out.print(fila + " ");
            for (int columna = 0; columna < 8; columna++) {
                Pieza p = tablero[fila - 1][columna];
                String token = (p == null) ? "[ㅤ]" : p.pintarPieza();
                System.out.print(token + "  ");
            }
            System.out.println();
        }

        // marco
        System.out.print("   ");
        for (char letra = 'a'; letra <= 'h'; letra++) {
            System.out.print(letra + "     ");
        }
        System.out.println();
    }


    public boolean hayPieza(int fila, int columna) {
        if (fila < 0 || fila > 7 || columna < 0 || columna > 7) {
            return false;
        }
        return tablero[fila][columna] != null;
    }

    public boolean hayPieza(Posicion pos) {

        return pos != null;
    }

    public void ponPieza(Pieza figura, int fila, int columna) {
        tablero[fila][columna] = figura;
    }

    public void ponPieza(Pieza figura, Posicion pos) {
        ponPieza(figura, pos.getFila(), pos.getColumna());
    }

    public void quitaPieza(int fila, int columna) {
        tablero[fila][columna] = null;
    }

    public void quitaPieza(Pieza figura, Posicion pos) {
        quitaPieza(pos.getFila(), pos.getColumna());
    }

    public void moverPieza(Movimiento mov) {
        Posicion origen = mov.posInicial;
        Posicion destino = mov.posFinal;



        Pieza pieza1 = tablero[origen.getFila()][origen.getColumna()];
        Pieza pieza2 = tablero[destino.getFila()][origen.getColumna()];
        if (pieza1.getColor()!=pieza2.getColor()){
            quitaPieza(origen.getFila(), origen.getColumna());
            ponPieza(pieza1, destino);
        }else{
            System.out.println(Constantes.MSG_CANIBALISMO);
        }



    }

    public Pieza devuelvePieza(int fila, int columna) {
        return tablero[fila][columna];
    }

    public Pieza devuelvePieza(Posicion pos) {
        return devuelvePieza(pos.getFila(), pos.getColumna());
    }


    public Pieza hayPiezaEntre(Movimiento mov) {
        Posicion origen = mov.posInicial;
        Posicion destino = mov.posFinal;
        if (mov.esVertical()) {
            int col = pos.getColumna();
            int filaIn = Math.min(origen.getFila(), destino.getFila());
            int filaFin = Math.max(origen.getFila(), destino.getFila());

        }
        return null;
    }
}
