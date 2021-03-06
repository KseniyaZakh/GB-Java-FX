module com.example.gbjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.desktop;

    opens com.example.gbjavafx to javafx.fxml;
    exports com.example.gbjavafx;
    exports com.example.gbjavafx.server;
    opens com.example.gbjavafx.server to javafx.fxml;
}