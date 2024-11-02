package co.laboratoriosokets.laboratoriosokets.controllers;

import co.laboratoriosokets.laboratoriosokets.server.Servidor;

public class ControladorPrincipal {
    private static ControladorPrincipal instancia;
    private Servidor servidor;
    private HelloController controller;

    // Constructor privado para evitar la creación de instancias externas
    private ControladorPrincipal() {
        if (servidor == null) {
            System.out.println(" se va crear el servidor");
            this.servidor = new Servidor(8081);
            new Thread(servidor).start();
        }
    }

    // Método de acceso estático para obtener la única instancia de la clase
    public static synchronized ControladorPrincipal getInstancia() {
        if (instancia == null) {
            instancia = new ControladorPrincipal();
        }
        return instancia;
    }

    public void enviarMensajeGlobal(String mensaje) {
        this.servidor.enviarMensajeGlobal(mensaje);
    }
    public void actualizarTablaMensajesEnviados(String comando) {
        if(controller!=null){
            this.controller.anexarMensaje(comando);
        }
    }

    public void inicializarController(HelloController helloController) {
        this.controller=helloController;
    }
}
