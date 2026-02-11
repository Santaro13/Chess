package Main;

import ajedrez.Constantes;
import ajedrez.Juego;
import ajedrez.Tablero;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Tablero tablero = new Tablero();
        Juego juego = new Juego();
        juego.setTurno(1);
        boolean sapo=true;
        Scanner sc = new Scanner(System.in);
        while(sapo){

            tablero.pintarTablero();

            if (juego.getTurno() == 1) {
                Constantes.print(Constantes.MSG_TURNO_BLANCO);
            } else {
                Constantes.print(Constantes.MSG_TURNO_NEGRO);
            }


            String prompt = Constantes.leerTexto(Constantes.MSG_INTRODUCE_JUGADA);

            String move = juego.jugada(prompt, tablero);

            if (move!=null) {
                tablero.moverPieza(juego.getMovimiento());
            }
            if (tablero.hayJaque(juego.getTurno())){
                Constantes.print(Constantes.MSG_JAQUE);
            }

            if (!tablero.reyRivalVivo(juego.getTurno())) {
                Constantes.print(Constantes.MSG_GANADOR);
                Constantes.print(Constantes.MSG_BLANCAS_NEGRAS);
                Constantes.print(juego.turnoString());
                sapo=false;
            }else
                juego.setTurno(juego.getTurno() == 1 ? 0 : 1);
        }
    }

}

