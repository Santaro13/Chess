package ajedrez;

import Piezas.*;

import java.util.Scanner;

public class Tester5 {
    public static void main(String[] args) {
        Tablero tablero = new Tablero();

        // limpiar tablero para preparar escenario
        for (int f = 0; f < 8; f++) {
            for (int c = 0; c < 8; c++) {
                tablero.quitaPieza(f, c);
            }
        }


        tablero.ponPieza(new Rey(0), 7, 4);   // e8 (negro)
        tablero.ponPieza(new Dama(1), 6, 3);  // d7 (blanca)
        tablero.ponPieza(new Torre(1), 7, 7); // h8 (blanca)
        tablero.ponPieza(new Rey(1), 0, 4);   // e1 (blanca)

        Juego juego = new Juego();
        juego.setTurno(1); // blancas mueven

        Scanner sc = new Scanner(System.in);

        tablero.pintarTablero();
        System.out.println("Introduce tu jugada final (formato a2b3): ");
        String prompt = sc.nextLine().trim().toLowerCase();

        String mov = juego.jugada(prompt, tablero);
        if (mov != null) {
            tablero.moverPieza(juego.getMovimiento());
            tablero.pintarTablero();

            if (tablero.hayJaque(0)) System.out.println("Negras en jaque");
            if (tablero.hayJaqueMate(0)) System.out.println("Jaque mate a las negras");

        } else {
            System.out.println("Movimiento no válido");
        }

        sc.close();
    }
}

