import server.ChatServer;

public class MainClass {
    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        Thread tChatServer = new Thread(chatServer);
        tChatServer.start();
    }
}