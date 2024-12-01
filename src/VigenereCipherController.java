
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class VigenereCipherController {

    @FXML
    private TextField plaintextField;

    @FXML
    private TextField keyField;

    @FXML
    private TextArea ciphertextArea;

    @FXML
    private TextArea decryptedTextArea;

    @FXML
    private Button encryptButton;

    @FXML
    private Button decryptButton;

    // Encryption logic
    public String encrypt(String plaintext, String key) {
        StringBuilder ciphertext = new StringBuilder();
        key = key.toUpperCase();
        int keyIndex = 0;

        for (char plainChar : plaintext.toUpperCase().toCharArray()) {
            if (Character.isLetter(plainChar)) {
                int pi = plainChar - 'A';
                int ki = key.charAt(keyIndex % key.length()) - 'A';
                int ei = (pi + ki) % 26;
                ciphertext.append((char) (ei + 'A'));
                keyIndex++;
            } else {
                ciphertext.append(plainChar);
            }
        }

        return ciphertext.toString();
    }

    // Decryption logic
    public String decrypt(String ciphertext, String key) {
        StringBuilder plaintext = new StringBuilder();
        key = key.toUpperCase();
        int keyIndex = 0;

        for (char cipherChar : ciphertext.toUpperCase().toCharArray()) {
            if (Character.isLetter(cipherChar)) {
                int ei = cipherChar - 'A';
                int ki = key.charAt(keyIndex % key.length()) - 'A';
                int di = (ei - ki + 26) % 26;
                plaintext.append((char) (di + 'A'));
                keyIndex++;
            } else {
                plaintext.append(cipherChar);
            }
        }

        return plaintext.toString();
    }

    // Handle encrypt button click
    @FXML
    private void handleEncrypt() {
        String plaintext = plaintextField.getText();
        String key = keyField.getText();
        if (!plaintext.isEmpty() && !key.isEmpty()) {
            String ciphertext = encrypt(plaintext, key);
            ciphertextArea.setText(ciphertext);
        } else {
            ciphertextArea.setText("Please provide plaintext and key.");
        }
    }

    // Handle decrypt button click
    @FXML
    private void handleDecrypt() {
        String ciphertext = plaintextField.getText();
        String key = keyField.getText();
        if (!ciphertext.isEmpty() && !key.isEmpty()) {
            String decryptedText = decrypt(ciphertext, key);
            decryptedTextArea.setText(decryptedText);
        } else {
            decryptedTextArea.setText("Please provide ciphertext and key.");
        }
    }
    @FXML
private void handleReset() {
    plaintextField.clear();
    keyField.clear();
    ciphertextArea.clear();
    decryptedTextArea.clear();
}

}
