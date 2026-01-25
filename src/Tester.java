import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        Juego juego = new Juego();

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {

            tablero.pintarTablero();

            int turno = juego.getTurno();
            if (turno == 1) {
                System.out.println(Constantes.MSG_TURNO_BLANCO);
                juego.setTurno(0);
            } else {
                System.out.println(Constantes.MSG_TURNO_NEGRO);
                juego.setTurno(1);
            }



            System.out.print(Constantes.MSG_INTRODUCE_JUGADA);
            String prompt = sc.nextLine();

            juego.jugada(prompt.toLowerCase(),tablero);

        }
    }

}
