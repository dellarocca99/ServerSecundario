package controlador;

import modeloInfo.InfoClientesAtendidos;
import modeloInfo.Informable;
import servicios.ServicioMonitor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ControllerMonitor implements Runnable{
    private Socket socket=null;
    private ServerSocket ss=null;
    private ServicioMonitor servicio=null;

    public ControllerMonitor(ServicioMonitor servicio){
        this.servicio=servicio;
    }

    @Override
    public void run() {
        try {
            ss=new ServerSocket(8787);
            System.out.println("Server initailized (Monitor)");
            while (true){
                socket=ss.accept();
                System.out.println("Monitor connected");
                ObjectInputStream ois= new ObjectInputStream(socket.getInputStream());
                Informable paquete= (Informable) ois.readObject();
                this.emiteMensaje(this.servicio.recuperaClientesAtendidos());
                socket.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void emiteMensaje(InfoClientesAtendidos paquete) throws IOException {
        ObjectOutputStream oos= new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(paquete);
    }
}
