package servicios;

import modeloInfo.InfoCliente;
import modeloInfo.InfoTiempoAtencion;
import repositorio.Repositorio;

import java.util.LinkedList;

public class ServicioTotem {

    public void nuevoCliente(InfoCliente paquete) {
        Repositorio.getInstance().getColaClientes().add(((InfoCliente)paquete).getDni());
    }

    public InfoTiempoAtencion recuperaTiempoAtencionPromedio() {
        InfoTiempoAtencion paquete=new InfoTiempoAtencion();
        paquete.setTiempoAtencion(Repositorio.getInstance().getTiempoAtencionPromedio());
        return paquete;
    }
}
