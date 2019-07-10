package network;

import building.Building;
import building.Palace;
import human.Peasant;
import human.Soldier;
import human.Worker;
import java.net.Socket;
import java.util.ArrayList;

public class Client
{
    String userName;
    Socket socket;


    public Client(String name, Socket socket)
    {
     this.userName = name;
     this.socket = socket;
    }




}