package repositorio;

import modeloInfo.InfoClienteAtendido;
import modeloUtil.TiempoAtencion;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Stack;

public class Repositorio implements Serializable {

    private static Repositorio instance=null;
    private LinkedList<Integer> colaClientes=null;
    private Stack<InfoClienteAtendido> pilaClientesAtendidos=null;
    private TiempoAtencion tiempoAtencionPromedio=null;
    private int cantTiempos=0;

    private Repositorio(){
        this.colaClientes=new LinkedList<>();
        this.pilaClientesAtendidos=new Stack<InfoClienteAtendido>();
        this.tiempoAtencionPromedio=new TiempoAtencion(0,0,0);
    };

    public static Repositorio getInstance(){
        if (instance==null)
            instance=new Repositorio();
        return instance;
    }

    public LinkedList getColaClientes() {
        return colaClientes;
    }

    public void setColaClientes(LinkedList<Integer> colaClientes) {
        this.colaClientes = colaClientes;
    }

    public TiempoAtencion getTiempoAtencionPromedio() {
        return tiempoAtencionPromedio;
    }

    public void setTiempoAtencionPromedio(TiempoAtencion tiempoAtencionPromedio) {
        this.tiempoAtencionPromedio = tiempoAtencionPromedio;
    }

    public int getCantTiempos() {
        return cantTiempos;
    }

    public void setCantTiempos(int cantTiempos) {
        this.cantTiempos = cantTiempos;
    }

    public Stack getPilaClientesAtendidos() {
        return pilaClientesAtendidos;
    }

    public void setPilaClientesAtendidos(Stack<InfoClienteAtendido> pilaClientesAtendidos) {
        this.pilaClientesAtendidos = pilaClientesAtendidos;
    }
}
