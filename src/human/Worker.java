package human;

import building.Building;
import human.Peasant;

public class Worker extends Peasant
{
    //the place that worker is doing his job :
    public Building building;

    public Worker(Building building)
    {
        this.client.workers.add(this);
        this.building = building;
        this.health = 100;
    }













}
