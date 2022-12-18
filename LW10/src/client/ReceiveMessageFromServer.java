package client;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ReceiveMessageFromServer implements Runnable {

    protected Socket clientSocket;
    protected SocketConnection socketConnection;

    public ReceiveMessageFromServer(Socket clientSocket, SocketConnection socketConnection) {
        this.clientSocket = clientSocket;
        this.socketConnection = socketConnection;
    }

    @Override
    public void run() {
        try (Scanner scanner = new Scanner(clientSocket.getInputStream())) {
            while (true) {
                String messageFromServer = scanner.nextLine();
                socketConnection.messages.add(messageFromServer);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}