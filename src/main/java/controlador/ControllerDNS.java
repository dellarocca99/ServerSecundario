package controlador;

import modeloInfo.InfoServerVivo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ControllerDNS implements Runnable{
    private Socket socket;
    private ServerSocket ss;

    @Override
    public void run() {
        try {
            ss=new ServerSocket(9191);
            System.out.println("Server initalized (DNS)");
            while (true){
                socket=ss.accept();
                System.out.println("DNS connected");
                ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
                ois.readObject();
                ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
                oos.writeObject(new InfoServerVivo());
                socket.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
