package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ChatServer implements Runnable {

    protected Map<Integer, Socket> clientSockets;
    protected int numClient;

    public ChatServer() {
        clientSockets = new HashMap<>();
    }

    @Override
    public void run() {
        try (ServerSocket server = new ServerSocket(8887)) {
            System.out.println("Server start");

            while (true) {
                Socket socket = server.accept();

                Thread clientThread = new Thread(new ClientThread(socket, this, ++numClient));
                clientThread.setDaemon(true);
                clientThread.start();

                clientSockets.put(numClient, socket);

                System.out.printf("Клієнта №%d підключено \n", numClient);
                printMessageToClient(
                        String.format("Вас підключено, можете починати спілкування!", numClient),
                        numClient
                );
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void printMessageInServerConsole(String message, int numSenderClient) {
        System.out.printf("Клієнт №%d: %s\n", numSenderClient, message);
    }

    public void printMessageToClient(String message, int numReceiverClient) {
        Socket clientSocket = clientSockets.get(numReceiverClient);

        if (clientSocket == null) {
            return;
        }

        try {
            PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);
            pw.println(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void printMessageToConnectedClients(String message, int numSenderClient) {
        clientSockets.forEach((key, value) -> {
            try {
                PrintWriter pw = new PrintWriter(value.getOutputStream(), true);
                pw.printf("Клієнт №%d: %s\n", numSenderClient, message);
            } catch (Exception ignored) {
            }
        });
    }

}
