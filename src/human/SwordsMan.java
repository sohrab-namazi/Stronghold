package human;

public class SwordsMan extends Soldier
{
    public SwordsMan()
    {
        this.client.soldiers.add(this);
        this.damage = 2;
        this.health = 250;
    }

    @Override
    void attackTo(Object object)
    {

    }
}
