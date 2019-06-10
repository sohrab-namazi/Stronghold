package human;

public class Bowman extends Soldier
{
    public Bowman()
    {
        this.client.soldiers.add(this);
        this.damage = 6;
        this.health = 200;
    }

    @Override
    void attackTo(Object object)
    {


    }
}
