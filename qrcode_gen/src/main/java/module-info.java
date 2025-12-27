module com.projetos.qrcode_gen {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.zxing;
    requires com.google.zxing.javase;
    requires javafx.graphics;
    requires java.desktop;


    opens com.projetos.qrcode_gen to javafx.fxml;
    exports com.projetos.qrcode_gen;
}