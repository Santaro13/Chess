import java.util.Scanner;

public class Tester2 {
    public static void main(String[] args) {

        Tablero tablero = new Tablero();
        Juego juego = new Juego();
        Scanner sc = new Scanner(System.in);
        juego.setTurno(1);

        System.out.println("=== Bienvenido al Juego de Ajedrez ===");

        // simulamos 4 turnos como ejemplo
        for (int turnoNum = 0; turnoNum < 4; turnoNum++) {

            System.out.println("\n--- Tablero Actual ---");
            tablero.pintarTablero();

            // mostrar turno actual
            if (juego.getTurno() == 1) {
                System.out.println("Turno de las Blancas.");
            } else {
                System.out.println("Turno de las Negras.");
            }

            // pedir jugada
            System.out.print("Introduce tu jugada: ");
            String jugadaInput = sc.nextLine().toLowerCase();

            // validar jugada
            String error = String.valueOf(juego.jugada(jugadaInput, tablero));

            if (error == null) {
                // jugada correcta → mover la pieza
                tablero.moverPieza(juego.getMovimiento());
                System.out.println("Movimiento realizado ✅");

                // mostrar tablero actualizado
                tablero.pintarTablero();

                // cambiar turno después de mover
                juego.setTurno(juego.getTurno() == 1 ? 0 : 1);

            } else {
                // jugada inválida → mostrar mensaje
                System.out.println("❌ " + error);
                // repetir turno
                turnoNum--;
            }
        }

        System.out.println("\n=== Fin de la simulación ===");
        tablero.pintarTablero();
    }
}
