module be.inf1.tellerapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens be.inf1.tellerapp to javafx.fxml;
    exports be.inf1.tellerapp;
}
