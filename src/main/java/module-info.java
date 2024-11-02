module co.laboratoriosokets.laboratoriosokets {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.laboratoriosokets.laboratoriosokets to javafx.fxml;
    exports co.laboratoriosokets.laboratoriosokets;
    exports co.laboratoriosokets.laboratoriosokets.controllers;
    opens co.laboratoriosokets.laboratoriosokets.controllers to javafx.fxml;
}