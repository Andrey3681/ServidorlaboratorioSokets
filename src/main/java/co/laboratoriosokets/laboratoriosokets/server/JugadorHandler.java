package co.laboratoriosokets.laboratoriosokets.server;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class JugadorHandler implements Runnable {
    private final Socket socket;
    public JugadorHandler(Socket socket) {
        this.socket=socket;
    }

    @Override
    public void run() {
        try(ObjectOutputStream flujoSalida = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream flujoEntrada = new ObjectInputStream(socket.getInputStream())) {
            while (true){
                String comando;
                try {
                    comando=(String) flujoEntrada.readObject(); //otro tipo de entrada solo recibe strings
                    System.out.println("comando recibido "+ comando);
                }catch (EOFException e){
                    break;
                } catch (ClassNotFoundException e) {
                    break;
                }
                if(comando!=null){
                    //aca va la logica separada por metodos o directamente
                    procesarComando(comando,flujoSalida);
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    private void procesarComando(String comando, ObjectOutputStream flujoSalida) throws IOException {
        //aca se definira que va realizar el servidor

        System.out.println(" se va enviar un mensaje ");
        flujoSalida.writeObject("mensaje recibido y redactado "+ comando);
        flujoSalida.flush();
        System.out.println(" se envio un mensaje");
    }
}
