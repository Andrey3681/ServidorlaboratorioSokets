package co.laboratoriosokets.laboratoriosokets.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor implements Runnable {
    int puerto;
    private List<JugadorHandler> listaDeJugadores;
    public Servidor( int puerto) {
        listaDeJugadores= new ArrayList<>();
        this.puerto=puerto;
    }
    private void enviarMensajeNuevoJugador(){
        for (JugadorHandler jugadorHandler: listaDeJugadores){
            jugadorHandler.enviarMensaje("un nuevo jugador a ingresado a la sala");
        }
    }

    public void enviarMensajeGlobal(String mensaje){
        for (JugadorHandler jugadorHandler: listaDeJugadores){
            jugadorHandler.enviarMensaje(mensaje);
        }
    }

    @Override
    public void run() {
        System.out.println("entro al metodo estar ");
        try (ServerSocket serverSocket= new ServerSocket(puerto)){
            System.out.println("esta iniando un servidor en el puerto: "+ puerto);
            while (true){
                Socket socket= serverSocket.accept();
                System.out.println("Jugador  conectado al servicio  "+ socket);
                JugadorHandler jugadorHandler= new JugadorHandler(socket);
                listaDeJugadores.add(jugadorHandler);
                enviarMensajeNuevoJugador();
                new Thread(jugadorHandler).start();
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
