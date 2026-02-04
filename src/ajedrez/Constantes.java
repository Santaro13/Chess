package ajedrez;

import java.util.Scanner;

public class Constantes {
    private static final Scanner sc = new Scanner(System.in);
    static final String MSG_TURNO_BLANCO = "Turno de las Blancas";
    static final String MSG_TURNO_NEGRO = "Turno de las Negras";
    static final String MSG_INTRODUCE_JUGADA = "Introduce tu jugada: ";
    static final String MSG_JUGADA_NO_VALIDA = "\n Jugada no valida";
    static final String MSG_TURNO_INVALIDO = "\n No es tu turno";
    static final String MSG_ERROR = "ERROR";
    static final String MSG_CANIBALISMO = "\n Pero no te comas tus piezas, animal";
    static final String MSG_HAY_PIEZA_ENTRE = "\n Una pieza bloquea tu camino";
    static final String MSG_PROMOCION = """
            Selecione el numero de la pieza a promocionar:
            1->Reina
            2->Torre
            3->Alfil
            4->Caballo
            """;

    public static String leerTexto(String mensaje) {
        System.out.println(mensaje);
        return sc.nextLine();
    }

    public static int leerEntero(String mensaje) {
        System.out.println(mensaje);
        return sc.nextInt();
    }
}
