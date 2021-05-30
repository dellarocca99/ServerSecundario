package modeloInfo;

import java.util.Stack;

public class InfoClientesAtendidos implements Informable{

    private Stack<InfoClienteAtendido> pilaClientesAtendidos;

    public Stack<InfoClienteAtendido> getPilaClientesAtendidos() {
        return pilaClientesAtendidos;
    }

    public void setPilaClientesAtendidos(Stack<InfoClienteAtendido> pilaClientesAtendidos) {
        this.pilaClientesAtendidos = pilaClientesAtendidos;
    }

    @Override
    public int getIdOperacion() {
        return 0;
    }
}
