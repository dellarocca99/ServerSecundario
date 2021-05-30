package modeloInfo;

import java.util.LinkedList;

public class InfoClientesEspera implements Informable {

    private LinkedList<Integer> dnis;

    @Override
    public int getIdOperacion() {
        return 0;
    }

    public void setDnis(LinkedList<Integer> dnis){
        this.dnis = dnis;
    }

    public LinkedList<Integer> getDnis(){
        return this.dnis;
    }

}
