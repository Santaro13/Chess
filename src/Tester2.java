import java.util.Random;
import java.util.Scanner;

public class Tester2 {
    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        Juego juego = new Juego();
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        // Limpiar tablero creado por el constructor por defecto
        for (int fila = 0; fila < 8; fila++) {
            for (int col = 0; col < 8; col++) {
                tablero.quitaPieza(fila, col);
            }
        }

        // Colocar piezas aleatorias
        int piezasAleatorias = 12;
        for (int i = 0; i < piezasAleatorias; i++) {
            int fila, col;
            do {
                fila = rnd.nextInt(8);
                col = rnd.nextInt(8);
            } while (tablero.hayPieza(fila, col));

            int tipo = rnd.nextInt(6); // 0-rey,1-dama,2-torre,3-alfil,4-caballo,5-peon
            int color = rnd.nextInt(2); // 0 negras, 1 blancas
            Pieza p;
            switch (tipo) {
                case 0:
                    p = new Rey(color);
                    break;
                case 1:
                    p = new Dama(color);
                    break;
                case 2:
                    p = new Torre(color);
                    break;
                case 3:
                    p = new Alfil(color);
                    break;
                case 4:
                    p = new Caballo(color);
                    break;
                default:
                    p = new Peon(color);
                    break;
            }
            tablero.ponPieza(p, fila, col);
        }

        // Garantizar al menos un escenario donde un peón pueda comer en diagonal
        boolean escenarioCreado = false;
        for (int intento = 0; intento < 200 && !escenarioCreado; intento++) {
            int colorPeon = rnd.nextInt(2); // color del peon que intentará comer
            int filaPeon = (colorPeon == 1) ? rnd.nextInt(7) : 1 + rnd.nextInt(7); // blancas: 0..6, negras:1..7
            int colPeon = rnd.nextInt(8);
            int dir = (colorPeon == 1) ? 1 : -1;
            int lado = rnd.nextBoolean() ? 1 : -1;
            int filaObjetivo = filaPeon + dir;
            int colObjetivo = colPeon + lado;

            if (filaObjetivo < 0 || filaObjetivo > 7 || colObjetivo < 0 || colObjetivo > 7) continue;
            if (!tablero.hayPieza(filaPeon, colPeon) && !tablero.hayPieza(filaObjetivo, colObjetivo)) {
                // colocar peon y pieza enemiga en la diagonal
                tablero.ponPieza(new Peon(colorPeon), filaPeon, colPeon);
                tablero.ponPieza(new Rey(1 - colorPeon), filaObjetivo, colObjetivo);
                juego.setTurno(colorPeon); // turno del peon para poder probar la captura
                escenarioCreado = true;
                System.out.println("Escenario de prueba creado: peon en " + (char)('a' + colPeon) + (filaPeon + 1) + " puede comer pieza enemiga en " + (char)('a' + colObjetivo) + (filaObjetivo + 1));
            }
        }

        if (!escenarioCreado) {
            // fallback: colocar manualmente en posiciones centrales
            tablero.ponPieza(new Peon(1), 3, 3);
            tablero.ponPieza(new Rey(0), 4, 4);
            juego.setTurno(1);
            System.out.println("Escenario por defecto creado: peon blanco en d4 puede comer rey negro en e5");
        }

        // Bucle interactivo parecido a Tester
        for (int i = 0; i < 50; i++) {
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
