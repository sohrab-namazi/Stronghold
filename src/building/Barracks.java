package building;

import human.Bowman;
import human.Peasant;
import human.Soldier;
import human.SwordsMan;
import level.Level;

public class Barracks extends Building
{

    int bowman;
    int swordsman;
    int total = this.bowman + this.swordsman;

    @Override
    public void upgrade()
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

    public void upgradePeasant(Soldier soldier)
    {

        if (soldier instanceof Bowman)
        {
            switch (this.level.grade)
            {
                case 1:
                    this.client.coin -= 5;
                    this.client.food -= 10;
                    break;
                case 2:
                    this.client.coin -= 2;
                    this.client.food -= 10;
                    break;
                case 3:
                    this.client.coin -= 2;
                    this.client.food -= 8;
                    break;
                case 4:
                    this.client.coin -= 1;
                    this.client.food -= 4;
                    break;

            }
            Peasant peasant = this.client.peasant.get(0);
            this.client.peasant.remove(0);
            Bowman bowman = (Bowman) peasant;
            this.client.soldiers.add(bowman);
        }
        else if (soldier instanceof SwordsMan)
        {
            switch (this.level.grade)
            {
                case 1:
                    this.client.coin -= 10;
                    this.client.food -= 5;
                    break;
                case 2:
                    this.client.coin -= 7;
                    this.client.food -= 12;
                    break;
                case 3:
                    this.client.coin -= 5;
                    this.client.food -= 12;
                    break;
                case 4:
                    this.client.coin -= 3;
                    this.client.food -= 8;
                    break;
            }
            Peasant peasant = this.client.peasant.get(0);
            this.client.peasant.remove(0);
            SwordsMan swordsMan = (SwordsMan) peasant;
            this.client.soldiers.add(swordsMan);
        }
    }

}
