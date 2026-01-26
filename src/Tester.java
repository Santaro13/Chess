import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        Juego juego = new Juego();
        juego.setTurno(1);
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {

            tablero.pintarTablero();

            if (juego.getTurno() == 1) {
                System.out.println(Constantes.MSG_TURNO_BLANCO);
            } else {
                System.out.println(Constantes.MSG_TURNO_NEGRO);
            }



            System.out.print(Constantes.MSG_INTRODUCE_JUGADA);
            String prompt = sc.nextLine();

            juego.jugada(prompt.toLowerCase(),tablero);


            tablero.moverPieza(juego.jugada(prompt,tablero));

                   juego.setTurno(juego.getTurno() == 1 ? 0 : 1);


        }
    }

}
