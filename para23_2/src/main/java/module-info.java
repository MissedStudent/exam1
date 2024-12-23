module com.example.para23_2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;
    requires java.desktop;

    opens com.example.para23_2 to javafx.fxml;
    exports com.example.para23_2;
}