package com.projetos.qrcode_gen;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class QRCodeController {
    private QRCodeService qrCodeService = new QRCodeService();

    public void setQRCodeService(QRCodeService qrCodeService){
        this.qrCodeService = qrCodeService;
    }

    @FXML
    private Label responseText;

    @FXML
    private TextField textWritten;

    private boolean check = false;

    @FXML
    protected void onGenerateButtonClick(){
        String path = qrCodeService.generateQRCode(textWritten.getText());

        responseText.setText("QRCode generated with success! " +
                "Search in: " + path);
        check = true;
    }

    @FXML
    protected void onResetButtonClick(){
        textWritten.setText("");
        if(check){
            responseText.setText("Insert a text that you desire to turn as QRCode!");
        }
    }
}