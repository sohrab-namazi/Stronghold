package building;
import human.Peasant;
import human.Worker;
import level.Level;
import network.Client;
import network.ClientHandler;

import java.awt.*;

public class Palace extends Building
{
    public ClientHandler client;
    public Palace()
    {

    }

    @Override
    void upgrade()
    {
       for (Building building : this.client.buildings)
       {
           if (building.level.grade < this.level.grade)
           {
               //print : you should upgrade all of your other buildings to the grade of your current palace.
               return;
           }
       }
           switch (this.level.grade)
           {
               case 1 :
                   this.client.coin -= 50;
                   this.client.wood -= 100;
                   this.client.food -= 50;
                   break;
               case 2 :
                   this.client.coin -= 150;
                   this.client.wood -= 300;
                   this.client.food -= 120;
                   break;
               case 3 :
                   this.client.coin -= 300;
                   this.client.wood -= 600;
                   this.client.food -= 200;
                   break;
               case 4 :
                   this.client.coin -= 500;
                   this.client.wood -= 1000;
                   this.client.food -= 300;
           }
           this.level = new Level(this, this.level.grade + 1);

    }
    void makeWorker()
    {
        this.client.coin -= 20;
        Peasant peasant = new Peasant();
        this.client.peasant.add(peasant);
    }

}
