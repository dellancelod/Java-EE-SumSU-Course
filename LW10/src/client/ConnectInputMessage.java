package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnectInputMessage {

    protected Socket clientSocket;
    protected SocketConnection socketConnection;

    public ConnectInputMessage(Socket clientSocket, SocketConnection socketConnection) {
        this.clientSocket = clientSocket;
        this.socketConnection = socketConnection;
    }

    public void sendMessage(String messageToServer) throws IOException {
        PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);
        pw.println(messageToServer);
    }
}