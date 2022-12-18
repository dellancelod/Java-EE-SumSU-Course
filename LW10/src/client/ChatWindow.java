package client;

import javax.swing.*;
import java.awt.*;

public class ChatWindow extends JFrame {
    private JTextField messageField;
    private JButton sendButton;
    private JPanel panel;
    private JTextArea textMessage;


    public ChatWindow(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        pack();
        setSize(300, 600);

        SocketConnection socketConnection = new SocketConnection();

        Thread thread = new Thread(() -> {
            boolean isConnected = socketConnection.connect();

            while (!isConnected) {
                textMessage.append("З'єднання з сервером розірвано");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                isConnected = socketConnection.connect();
            }

            sendButton.addActionListener(e -> {
                String message = messageField.getText().trim();

                if (message.isBlank()) {
                    return;
                }

                socketConnection.sendMessage(message);
            });

            int savedSize = 0;

            while (true) {
                int currentSize = socketConnection.messages.size();

                if (savedSize == currentSize) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    textMessage.append(socketConnection.messages.get(currentSize - 1));
                    textMessage.append("\n");
                }
                savedSize = currentSize;
            }
        });

        thread.setDaemon(true);
        thread.start();
    }


}
