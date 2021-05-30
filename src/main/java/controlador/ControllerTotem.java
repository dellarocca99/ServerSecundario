package controlador;

import modeloInfo.InfoCliente;
import modeloInfo.InfoTiempoAtencion;
import modeloInfo.Informable;
import servicios.ServicioTotem;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class ControllerTotem implements Runnable{
    private Socket socket=null;
    private ServerSocket ss=null;
    private ServicioTotem servicio=null;

    public ControllerTotem(ServicioTotem servicio){
        this.servicio=servicio;
    }

    @Override
    public void run() {
        try {
            ss=new ServerSocket(8585);
            System.out.println("Server initailized (Totem)");
            while (true){
                socket=ss.accept();
                System.out.println("Totem connected");
                ObjectInputStream ois= new ObjectInputStream(socket.getInputStream());
                Informable paquete= (Informable) ois.readObject();
                if (paquete.getIdOperacion()==1){//es un nuevo cliente que recibo del totem (InfoNuevoCliente)
                    this.servicio.nuevoCliente((InfoCliente)paquete);
                } else if (paquete.getIdOperacion()==3){// es una petición del totem para que se le envie el tiempo de atención promedio
                    this.emiteMensaje(this.servicio.recuperaTiempoAtencionPromedio());
                }
                socket.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void emiteMensaje(InfoTiempoAtencion paquete) throws IOException {
        ObjectOutputStream oos= new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(paquete);
    }

}
