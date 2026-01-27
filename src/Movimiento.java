public class Movimiento {
    Posicion posInicial;
    Posicion posFinal;

    public Movimiento(Posicion posInicial, Posicion posFinal) {
        this.posInicial = posInicial;
        this.posFinal = posFinal;
    }

    public Movimiento() {
        posInicial=new Posicion();
        posFinal = new Posicion();

    }


    public boolean esVertical(){
        if (posFinal==null || posInicial==null) {
            return false;
        }

        if (posFinal.getColumna() == posInicial.getColumna()) {
            return true;
        }else{
            return false;
        }

    }

    public boolean esHorizontal(){
        if (posInicial==null||posFinal==null) {
            return false;
        }else return posFinal.getFila() == posInicial.getFila();

    }

    public boolean esDiagonal() {
        if (posInicial == null || posFinal == null) return false;

        int dColumna = posFinal.getColumna() - posInicial.getColumna();
        int dFila = posFinal.getFila() - posInicial.getFila();

        return dColumna == dFila || dColumna == -dFila || -dColumna == -dFila || -dColumna == dFila;
    }


    public int saltoHorizontal(){
        return Math.abs(posInicial.getColumna() - posFinal.getColumna());
    }

    public int saltoVertical(){
        return Math.abs(posInicial.getFila() - posFinal.getFila());
    }


    public int saltoDiagonal() {
        return Math.abs(posFinal.getFila() - posInicial.getFila());
    }


    @Override
    public String toString() {
        return "Movimiento{" +
                "posInicial=" + posInicial +
                ", posFinal=" + posFinal +
                '}';
    }
}
