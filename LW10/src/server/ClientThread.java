package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThread implements Runnable {

    protected Socket socket;
    protected ChatServer serverChat;
    protected int numClient;

    public ClientThread(Socket socket, ChatServer serverChat, int numClient) {
        this.numClient = numClient;
        this.serverChat = serverChat;
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                String message = bufferedReader.readLine();

                serverChat.printMessageInServerConsole(message, numClient);
                serverChat.printMessageToConnectedClients(message, numClient);
            }
        } catch (IOException ignored) {
        }

    }
}