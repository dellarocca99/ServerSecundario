package servicios;

import modeloInfo.*;
import modeloUtil.TiempoAtencion;
import repositorio.Repositorio;

public class ServicioEmpleado {

    public void combinaBoxYCliente(InfoBoxDisponible paquete) {
        int dni=(int) Repositorio.getInstance().getColaClientes().poll();
        InfoClienteAtendido clienteAtendido= FactoryInfoClienteAtendido.getInfoClienteAtendido(dni,paquete.getBox());
        Repositorio.getInstance().getPilaClientesAtendidos().add(clienteAtendido);
    }

    public void tiempoAtencion(InfoTiempoAtencion paquete) {
        int segundosTotales=(Repositorio.getInstance().getTiempoAtencionPromedio().getHoras()*3600+Repositorio.getInstance().getTiempoAtencionPromedio().getMinutos()*60
                +Repositorio.getInstance().getTiempoAtencionPromedio().getSegundos())*Repositorio.getInstance().getCantTiempos()+paquete.getTiempoAtencion().getHoras()*3600
                +paquete.getTiempoAtencion().getMinutos()*60+paquete.getTiempoAtencion().getSegundos();
        Repositorio.getInstance().setCantTiempos((Repositorio.getInstance().getCantTiempos())+1);
        segundosTotales=segundosTotales/Repositorio.getInstance().getCantTiempos();
        int horas=segundosTotales / 3600;
        segundosTotales=segundosTotales-horas*3600;
        int minutos=segundosTotales / 60;
        segundosTotales=segundosTotales-minutos*60;
        int segundos=segundosTotales;
        Repositorio.getInstance().setTiempoAtencionPromedio(new TiempoAtencion(horas,minutos,segundos));
    }

    public InfoClientesEspera recuperaNuevosClientes(){
        InfoClientesEspera paquete=new InfoClientesEspera();
        paquete.setDnis(Repositorio.getInstance().getColaClientes());
        return paquete;
    }

    public Informable proximoCliente() {
        int dni=-1;
        if (!Repositorio.getInstance().getColaClientes().isEmpty())
            dni=(int) Repositorio.getInstance().getColaClientes().peek();
        return FactoryInfoCliente.getPaqueteNuevoCliente(dni);
    }
}
