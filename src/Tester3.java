// Reorganizo el tester: estructura similar a Tester.java, coloca un peón en a7 y deja la promoción al usuario
import java.util.Scanner;

public class Tester3 {
    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        Juego juego = new Juego();
        // Dejamos el turno en 1 (Blancas) para mover el peón que colocamos
        juego.setTurno(1);
        Scanner sc = new Scanner(System.in);

        // Preparar tablero: colocar un peón en a7 (columna 0, fila 6 en 0-based)
        // y dejar a8 libre (columna 0, fila 7)
        tablero.quitaPieza(7, 0); // limpiar a8
        tablero.quitaPieza(6, 0); // limpiar a7 por si hay otra pieza
        tablero.ponPieza(new Peon(1), 6, 0); // colocar peón (color 1) en a7

        // Bucle simple parecido a Tester.java
        for (int i = 0; i < 10; i++) {
            tablero.pintarTablero();

            if (juego.getTurno() == 1) {
                System.out.println(Constantes.MSG_TURNO_BLANCO);
            } else {
                System.out.println(Constantes.MSG_TURNO_NEGRO);
            }

            System.out.print(Constantes.MSG_INTRODUCE_JUGADA);
            String prompt = sc.nextLine().trim().toLowerCase();

            Movimiento mov = juego.jugada(prompt, tablero);

            if (mov != null) {
                tablero.moverPieza(mov);
                // no gestionamos la promoción aquí; lo harás tú manualmente si necesitas
                juego.setTurno(juego.getTurno() == 1 ? 0 : 1);
            }
        }

        sc.close();
    }
}
