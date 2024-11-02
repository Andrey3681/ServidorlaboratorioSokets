package co.laboratoriosokets.laboratoriosokets.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public Servidor() {

    }
    public void start(int puerto){
        try (ServerSocket serverSocket= new ServerSocket(puerto)){
            System.out.println("esta iniando un servidor en el puerto: "+ puerto);
            while (true){
                Socket socket= serverSocket.accept();
                System.out.println("Jugador conectado "+ socket);
                new Thread(new JugadorHandler(socket)).start();
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static void main(String[] args) {
        Servidor servidor= new Servidor();
        servidor.start(8081);
    }
}
