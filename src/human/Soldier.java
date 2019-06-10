package human;

import human.Peasant;
import network.Client;

public abstract class Soldier extends Peasant
{
   int damage;

    public void setDamage(int damage) {
        this.damage = damage;
    }
    abstract void attackTo(Object object);

}
