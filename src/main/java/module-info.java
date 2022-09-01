module com.example.puj {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;
    requires javafx.graphics;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    //requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.example.puj to javafx.fxml;
    exports com.example.puj.model;
    exports com.example.puj;
    exports com.example.puj.controller;
    opens com.example.puj.controller to javafx.fxml;

}