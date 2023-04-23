package com.viruswar.logging;

import javax.swing.*;

public class LoggingService {
    public static void logging(String newInfo,
                               JTextArea jTextArea,
                               String my_name) {
        if (jTextArea != null) {
            String info = jTextArea.getText();
            info += newInfo + "\n";
            jTextArea.setText(info);
        }
    }
}