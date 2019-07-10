package network;

import building.Building;
import building.Palace;
import human.*;
import menu.CreateServer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;


public class ClientHandler implements Runnable
{
    Client client;
    public String name;
    public int coin = 500;
    public int food = 600;
    public int wood = 1000;
    public int coinRate = 10;
    public int woodRate = -5;
    public int foodRate = -3;
    public ArrayList<Peasant> peasant = new ArrayList<>();
    public ArrayList<Building> buildings = new ArrayList<>();
    public ArrayList<Worker> workers = new ArrayList<>();
    public ArrayList<Soldier> soldiers = new ArrayList<>();
    public boolean lost = false;
    public Palace palace;
    Socket socket;
    DataInputStream in;
    DataOutputStream out;


    public ClientHandler(Client client) throws IOException
    {
        this.client = client;
        this.socket = client.socket;
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        this.name = this.client.userName;
    }


    @Override
    public void run()
    {
        System.out.println("hi : "  + this.name);

//        while (true)
//        {
//            System.out.println(this.name);
//        }
    }
}
