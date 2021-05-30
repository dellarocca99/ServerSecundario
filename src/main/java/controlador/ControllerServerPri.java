package controlador;

import modeloInfo.InfoPeticion;
import modeloInfo.Informable;
import repositorio.Repositorio;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ControllerServerPri implements Runnable{
    private Socket socket;

    public void run() {
        while (true){
            try {
                this.enviarPaquete(new InfoPeticion());
                ObjectInputStream ois =new ObjectInputStream(socket.getInputStream());
                Repositorio repo=(Repositorio)ois.readObject();
                Repositorio.getInstance().setCantTiempos(repo.getCantTiempos());
                Repositorio.getInstance().setPilaClientesAtendidos(repo.getPilaClientesAtendidos());
                Repositorio.getInstance().setColaClientes(repo.getColaClientes());
                Repositorio.getInstance().setTiempoAtencionPromedio(repo.getTiempoAtencionPromedio());
                socket.close();
                Thread.sleep(2000);
            } catch (IOException | ClassNotFoundException | InterruptedException e) {
                System.out.println("El server primario esta desconectado");
            }

        }
    }

    public void enviarPaquete(Informable paquete) throws IOException {
        this.socket = new Socket("localhost", 9393);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(paquete);
    }
}

