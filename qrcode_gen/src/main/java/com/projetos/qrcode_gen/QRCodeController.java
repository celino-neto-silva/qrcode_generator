package com.projetos.qrcode_gen;
/*
package com.projetos.qrcode_gen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class QRCodeController {
    private final QRCodeService qrCodeService;

    @FXML private TextField text;
    @FXML private Button btn;


    public QRCodeController(QRCodeService qrCodeService) {
        this.qrCodeService = qrCodeService;
    }

    @FXML
    private void handleGenerateQRCode(ActionEvent event, TextField text){
        String path = qrCodeService.generateQRCode(String.valueOf(text));
        System.out.println("QRCode created with sucess! Check on your directory file");
    }
}
*/
/*
package com.projetos.qrcode_gen;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class QRCodeController {

    @FXML
    private TextField textField;

    @FXML
    private ImageView imageView;

    @FXML
    private Label responseText;

    private final QRCodeService qrCodeService = new QRCodeService();

    public QRCodeController() {
    }

    @FXML
    private void handleGenerateQRCode() {
        String text = textField.getText();

        if (text == null || text.isBlank()) {
            return;
        }

        String path = qrCodeService.generateQRCode(text);
        imageView.setImage(new Image(new File(path).toURI().toString()));

        responseText.setText("Congratulations! Your QRCode was created search in your root directory for the file /qrcodes.");
    }
}
*/

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
        /*
        Criar rota/conexão para o Service, onde efetivamente ocorrerá o CORE da app... A geração do QRCode
        */

        //String text = textWritten.getText();
        //qrCodeService.generateQRCode(text);
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