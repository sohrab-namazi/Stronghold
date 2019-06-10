package building;
import level.Level;
import network.Client;

public abstract class Building
{
   public int health;
   public Level level = new Level(this, 1);
   public int foodRate;
   public int coinRate;
   public boolean isDestroyed;
   public Client client;


    public void setDestroyed(boolean destroyed)
    {
        isDestroyed = destroyed;
    }

    public boolean isDestroyed()
    {
        return isDestroyed;
    }

    abstract void upgrade();
}
