package client;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class SocketConnection {

    protected Socket socket;
    protected ConnectInputMessage connectInputMessage;
    protected List<String> messages = new LinkedList<>();

    public boolean connect() {
        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress("localhost", 8887), 2000);

            Thread threadSenderClient = new Thread(new ReceiveMessageFromServer(socket, this));
            threadSenderClient.setDaemon(true);
            threadSenderClient.start();

            connectInputMessage = new ConnectInputMessage(socket, this);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public void sendMessage(String message) {
        if (socket == null) {
            throw new IllegalStateException("Під'єднайтеся до серверу перед відправкою повідомлення");
        }

        try {
            connectInputMessage.sendMessage(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
