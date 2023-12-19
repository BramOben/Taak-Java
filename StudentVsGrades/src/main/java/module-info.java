module be.inf1.studentvsgrades {
    requires javafx.controls;
    requires javafx.fxml;

    opens be.inf1.studentvsgrades to javafx.fxml;
    exports be.inf1.studentvsgrades;
}
