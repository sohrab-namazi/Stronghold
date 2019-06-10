package human;

import network.Client;

public class Peasant
{
   public int health;
   private boolean isDead;
   public int foodRate;
   public Client client;
   public int x;
   public int y;


   public Peasant()
   {
       this.client.peasant.add(this);
       //here i supposed that peasant and workers have the same first health.
       // because the Doc hasnt mention peasant's health.
       this.health = 100;

   }

   boolean isDead()
   {
       return isDead;
   }

}
