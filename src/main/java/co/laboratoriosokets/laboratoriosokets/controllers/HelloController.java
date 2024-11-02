package co.laboratoriosokets.laboratoriosokets.controllers;

import co.laboratoriosokets.laboratoriosokets.server.Servidor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField contenedorMensajes;

    @FXML
    private TextArea mensajesEntrantes;

    @FXML
    private Label welcomeText;

    ControladorPrincipal controladorPrincipal;

    @FXML
    private void initialize(){
        controladorPrincipal= ControladorPrincipal.getInstancia();
        controladorPrincipal.inicializarController(this);
        System.out.println(" porque no crea la interfaz");
    }

    @FXML
    void EnviarMensajeJugadores(ActionEvent event) {
        if(!contenedorMensajes.getText().isBlank()){
            controladorPrincipal.enviarMensajeGlobal(contenedorMensajes.getText());
        }else {
            System.out.println("no ingreso nada, no puede ser enviado");
        }
    }

    public void anexarMensaje(String comando) {
        this.mensajesEntrantes.setText(mensajesEntrantes.getText()+ comando+ "\n");
    }
}
