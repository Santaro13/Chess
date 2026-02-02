import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Tester2 {
    public static void main(String[] args) {
        Tablero tablero = new Tablero();

        // Limpiar tablero (por si el constructor lo inicializa con la posición estándar)
        for (int f = 0; f < 8; f++) {
            for (int c = 0; c < 8; c++) {
                tablero.quitaPieza(f, c);
            }
        }

        // Preparar la lista de piezas que queremos colocar (ambos colores)
        List<Pieza> piezas = new ArrayList<>();

        // Blanco = 1
        piezas.add(new Rey(1));
        piezas.add(new Dama(1));
        piezas.add(new Torre(1));
        piezas.add(new Torre(1));
        piezas.add(new Caballo(1));
        piezas.add(new Caballo(1));
        piezas.add(new Alfil(1));
        piezas.add(new Alfil(1));
        for (int i = 0; i < 8; i++) piezas.add(new Peon(1));

        // Negro = 0
        piezas.add(new Rey(0));
        piezas.add(new Dama(0));
        piezas.add(new Torre(0));
        piezas.add(new Torre(0));
        piezas.add(new Caballo(0));
        piezas.add(new Caballo(0));
        piezas.add(new Alfil(0));
        piezas.add(new Alfil(0));
        for (int i = 0; i < 8; i++) piezas.add(new Peon(0));

        // Generar lista de posiciones y mezclar
        List<int[]> posiciones = new ArrayList<>();
        for (int fila = 0; fila < 8; fila++) {
            for (int col = 0; col < 8; col++) {
                posiciones.add(new int[]{fila, col});
            }
        }
        Collections.shuffle(posiciones, new Random());

        // Colocar piezas usando la lista mezclada, respetando la restricción de peones
        int idxPos = 0;
        for (Pieza p : piezas) {
            // Buscar la siguiente posición válida
            boolean placed = false;
            while (idxPos < posiciones.size()) {
                int[] pos = posiciones.get(idxPos);
                int fila = pos[0];
                int col = pos[1];
                idxPos++;
                // Restricción: ningún peón en la fila 1 o 8 (índices 0 y 7)
                if (p instanceof Peon) {
                    if (fila == 0 || fila == 7) {
                        continue;
                    }
                }
                // Poner la pieza
                tablero.ponPieza(p, fila, col);
                placed = true;
                break;
            }
            if (!placed) {
                // No hay más posiciones válidas (raro). Salimos.
                System.out.println("No se pudo colocar todas las piezas: posiciones agotadas.");
                break;
            }
        }

        // Preparar juego interactivo (mismo comportamiento que Tester.java)
        Juego juego = new Juego();
        juego.setTurno(1); // empezar con blancas
        Scanner sc = new Scanner(System.in);

        System.out.println("Tablero inicial (piezas desordenadas):");

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
                juego.setTurno(juego.getTurno() == 1 ? 0 : 1);
            }
        }

        sc.close();
    }
}
