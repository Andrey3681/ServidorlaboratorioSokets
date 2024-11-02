module co.laboratoriosokets.laboratoriosokets {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.laboratoriosokets.laboratoriosokets to javafx.fxml;
    exports co.laboratoriosokets.laboratoriosokets;
}