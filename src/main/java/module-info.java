module com.ivanllc.ivanllc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.ivanllc.ivanllc to javafx.fxml;
    exports com.ivanllc.ivanllc;
    exports com.ivanllc.ivanllc.controller;
    opens com.ivanllc.ivanllc.controller to javafx.fxml;
}