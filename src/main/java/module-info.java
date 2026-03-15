module com.ivanllc.ivanllc {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.ivanllc.ivanllc to javafx.fxml;
    exports com.ivanllc.ivanllc;
}