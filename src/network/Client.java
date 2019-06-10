package network;

import building.Building;
import building.Palace;
import human.Peasant;
import human.Soldier;
import human.Worker;

import java.util.ArrayList;

public class Client
{
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


}