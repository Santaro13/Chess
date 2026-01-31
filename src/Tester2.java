import java.util.Scanner;

public class Tester2 {
    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        Juego juego = new Juego();
        Scanner sc = new Scanner(System.in);

        // Secuencia de setup: alterna turnos (1 = blancas, 0 = negras)
        String[] setupMoves = {
                "e2e4", // blanco
                "d7d5", // negro
                "e4d5", // blanco captura en diagonal
                "a7a6", // negro
                "b2b3", // blanco
                "c7c5"  // negro
        };
        int[] setupTurns = {1, 0, 1, 0, 1, 0};

        // Ejecutar setup
        for (int i = 0; i < setupMoves.length; i++) {
            juego.setTurno(setupTurns[i]);
            var mov = juego.jugada(setupMoves[i], tablero);
            if (mov != null) {
                tablero.moverPieza(mov);
            } else {
                System.out.println("Setup: jugada inválida -> " + setupMoves[i]);
            }
        }

        // Mostrar tablero después del setup
        tablero.pintarTablero();
        // Empezar interacción desde el turno de las blancas
        juego.setTurno(1);

        // Bucle de prueba interactivo (igual que Tester)
        for (int i = 0; i < 8; i++) {
            tablero.pintarTablero();

            if (juego.getTurno() == 1) {
                System.out.println(Constantes.MSG_TURNO_BLANCO);
            } else {
                System.out.println(Constantes.MSG_TURNO_NEGRO);
            }

            System.out.print(Constantes.MSG_INTRODUCE_JUGADA);
            String prompt = sc.nextLine().trim().toLowerCase();

            var mov = juego.jugada(prompt, tablero);

            if (mov != null) {
                tablero.moverPieza(mov);
                juego.setTurno(juego.getTurno() == 1 ? 0 : 1);
            }
        }

        sc.close();
    }
}

