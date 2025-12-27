package com.projetos.qrcode_gen;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class QRCodeService {

    private static final Path QR_CODE_DIR =
            Paths.get(System.getProperty("user.home"), "qrcodes");

    public String generateQRCode(String text) {
        try {
            Files.createDirectories(QR_CODE_DIR);

            String fileName = UUID.randomUUID() + ".png";
            Path filePath = QR_CODE_DIR.resolve(fileName);

            BitMatrix bitMatrix = new MultiFormatWriter()
                    .encode(text, BarcodeFormat.QR_CODE, 300, 300);

            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", filePath);

            return filePath.toString();

        } catch (Exception e) {
            throw new RuntimeException("Problem generating the QR Code", e);
        }
    }
}
