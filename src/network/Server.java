package network;

import menu.GameEntry;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server
{
    static ServerSocket serverSocket;
    static Socket socket;
    static DataOutputStream out;
    static DataInputStream in;
    public static boolean flag = true;
    public static Integer iii;
    public static ExecutorService pool = Executors.newFixedThreadPool(2);

    public Server() throws IOException
    {

    }

    public static void main(String[] args) throws IOException
    {
      //  out = new DataOutputStream(socket.getOutputStream());
       // in = new DataInputStream(socket.getInputStream());
      //  ServerConnection serverConnection = new ServerConnection(socket);
       // new Thread(serverConnection).start();
    }

}
