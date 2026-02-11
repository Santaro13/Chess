package ajedrez;

import Piezas.*;

import java.util.Scanner;

public class Tester4 {
    public static void main(String[] args) {
        Tablero tablero = new Tablero();


        for (int f = 0; f < 8; f++) {
            for (int c = 0; c < 8; c++) {
                tablero.quitaPieza(f, c);
            }
        }

        // --- Colocar un escenario "medio" (piezas de ambos colores) ---
        // Blancas (filas bajas)
        tablero.ponPieza(new Rey(1), 0, 4);      // e1
        tablero.ponPieza(new Torre(1), 1, 4);    // e2 (torre que puede dar jaque en vertical si la columna está libre)
        tablero.ponPieza(new Dama(1), 0, 3);     // d1
        tablero.ponPieza(new Torre(1), 0, 0);    // a1
        tablero.ponPieza(new Torre(1), 0, 7);    // h1
        tablero.ponPieza(new Alfil(1), 0, 2);    // c1
        tablero.ponPieza(new Caballo(1), 0, 6);  // g1
        // Peones blancos (dejamos la columna e libre arriba para permitir jaque vertical)
        tablero.ponPieza(new Peon(1), 1, 0);
        tablero.ponPieza(new Peon(1), 1, 1);
        tablero.ponPieza(new Peon(1), 1, 2);
        // dejamos d2 (1,3) vacío para que una pieza negra pueda desplazarse por la columna d
        tablero.ponPieza(new Peon(1), 1, 5);
        tablero.ponPieza(new Peon(1), 1, 6);
        tablero.ponPieza(new Peon(1), 1, 7);

        // Negras (filas altas)
        tablero.ponPieza(new Rey(0), 7, 4);      // e8
        tablero.ponPieza(new Torre(0), 7, 0);    // a8
        tablero.ponPieza(new Torre(0), 7, 7);    // h8
        tablero.ponPieza(new Torre(0), 6, 3);     // d7 (torre negra que puede bajar a d1 para dar jaque)
        tablero.ponPieza(new Alfil(0), 7, 2);
        tablero.ponPieza(new Dama(0), 2, 4);//
        tablero.ponPieza(new Caballo(0), 7, 6);  // g8
        // Peones negros: dejamos e7 (6,4) vacío para que una torre en columna e pueda alcanzar al rey
        tablero.ponPieza(new Peon(0), 6, 0);
        tablero.ponPieza(new Peon(0), 6, 1);
        tablero.ponPieza(new Peon(0), 6, 2);
        tablero.ponPieza(new Peon(0), 6, 3);
        tablero.ponPieza(new Peon(0), 6, 5);
        tablero.ponPieza(new Peon(0), 6, 6);
        tablero.ponPieza(new Peon(0), 6, 7);

        Juego juego = new Juego();

        Scanner sc = new Scanner(System.in);

        // Permitir elegir qué color mover: así puedes probar jaque para ambos
        System.out.print("¿Qué color quieres mover? (1=Blancas, 0=Negras) [Enter=Blancas]: ");
        String colorInput = sc.nextLine().trim();
        if (colorInput.equals("0")) {
            juego.setTurno(0);
        } else {
            juego.setTurno(1);
        }

        // Mostrar estado inicial y pedir UNA jugada
        tablero.pintarTablero();
        System.out.println("Mueve UNA pieza. Ejemplos: e2e8 (torre blanca) o d7d1 (dama negra).");
        System.out.print(Constantes.MSG_INTRODUCE_JUGADA);

        String prompt = sc.nextLine().trim().toLowerCase();

        String mov = juego.jugada(prompt, tablero);

        if (mov != null) {
            tablero.moverPieza(juego.getMovimiento());

            // Mostrar tablero tras la jugada
            tablero.pintarTablero();

            // Comprobar jaque para ambos bandos
            boolean negroEnJaque = tablero.Jaque(0);
            boolean blancoEnJaque = tablero.Jaque(1);

            if (negroEnJaque) {
                System.out.println("Negras en jaque: " + Constantes.MSG_JAQUE);
            }
            if (blancoEnJaque) {
                System.out.println("Blancas en jaque: " + Constantes.MSG_JAQUE);
            }
            if (!negroEnJaque && !blancoEnJaque) {
                System.out.println("No se ha producido jaque con esa jugada.");
            }

        } else {
            System.out.println("Movimiento no válido o no realizado.");
        }

        sc.close();
    }
}
