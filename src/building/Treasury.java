package building;

import level.Level;

public class Treasury extends Building
{
    @Override
    void upgrade()
    {
        switch (this.level.grade)
        {
            case 1 :
                this.client.coin -= 10;
                this.health = 100;
                break;
            case 2 :
                this.client.coin -= 20;
                this.health = 200;
                break;
            case 3 :
                this.client.coin -= 30;
                this.health = 300;

                break;
            case 4 :
                this.client.coin -= 50;
                this.health = 500;
                this.level.grade ++;
        }
        this.level = new Level(this, this.level.grade + 1);

    }
}
