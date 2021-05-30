package servicios;

import modeloInfo.InfoClientesAtendidos;
import repositorio.Repositorio;

public class ServicioMonitor {
    public InfoClientesAtendidos recuperaClientesAtendidos() {
        InfoClientesAtendidos paquete=new InfoClientesAtendidos();
        paquete.setPilaClientesAtendidos(Repositorio.getInstance().getPilaClientesAtendidos());
        return paquete;
    }
}
