package building;

import level.Level;

public class WoodCutter extends Building
{

    public int woodRate;

    @Override
    void upgrade()
    {
        switch (this.level.grade)
        {
            case 1 :
                this.client.coin -= 5;
                this.client.wood -= 10;
                this.client.food -= 10;
                this.health = 100;
                break;
            case 2 :
                this.client.coin -= 15;
                this.client.wood -= 20;
                this.client.food -= 30;
                this.health = 200;
                break;
            case 3 :
                this.client.coin -= 30;
                this.client.wood -= 40;
                this.client.food -= 60;
                this.health = 300;

                break;
            case 4 :
                this.client.coin -= 50;
                this.client.wood -= 100;
                this.client.food -= 100;
                this.health = 500;
                this.level.grade ++;
        }
        this.level = new Level(this, this.level.grade + 1);

    }

    public WoodCutter()
    {

    }
}
