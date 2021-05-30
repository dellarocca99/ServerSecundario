package modeloUtil;

import java.io.Serializable;

public class TiempoAtencion implements Serializable{
    private int horas,minutos,segundos,box;

    public TiempoAtencion(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public int getHoras() {
        return horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    @Override
    public String toString() {
        return this.horas+":"+this.minutos+":"+this.segundos;
    }
}
