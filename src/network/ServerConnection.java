package network;

import building.Building;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerConnection implements Runnable
{
    Socket socket;
    DataInputStream in;
    DataOutputStream out;

    public ServerConnection(Socket socket) throws IOException
    {
        this.socket = socket;
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
    }


    @Override
    public void run()
    {
        System.out.println(this.socket.toString());
        while (true)
        {

        }

    }
}
