package level;

import building.*;
import human.Bowman;
import human.Peasant;
import human.SwordsMan;
import human.Worker;

public class Level
{
    public int grade = 1;
    Object object;


    public void setGrade(int grade)
    {
        this.grade = grade;
    }

    public Level(Object object, int grade)
    {
        this.object = object;
        this.grade = grade;

        if (this.object instanceof Palace)
        {
            Palace palace = (Palace) object;
            palace.level = this;

            switch (this.grade)
            {
                case 1 :
                    ((Palace) this.object).coinRate = 10;
                    ((Palace) this.object).foodRate = 2;
                    ((Palace) this.object).health = 200;
                    break;
                case 2 :
                    ((Palace) this.object).coinRate = 15;
                    ((Palace) this.object).foodRate = 4;
                    ((Palace) this.object).health = 400;
                    break;
                case 3 :
                    ((Palace) this.object).coinRate = 20;
                    ((Palace) this.object).foodRate = 6;
                    ((Palace) this.object).health = 600;
                    break;
                case 4 :
                    ((Palace) this.object).coinRate = 25;
                    ((Palace) this.object).foodRate = 8;
                    ((Palace) this.object).health = 800;
                    break;
                case 5 :
                    ((Palace) this.object).coinRate = 30;
                    ((Palace) this.object).foodRate = 10;
                    ((Palace) this.object).health = 1000;




            }
        }
        else if (this.object instanceof Treasury)
        {
            Treasury treasury = (Treasury) object;
            treasury.level = this;
            switch (this.grade)
            {
                case 1 :
                    ((Treasury) this.object).coinRate = 20;
                case 2 :
                    ((Treasury) this.object).coinRate = 40;
                case 3 :
                    ((Treasury) this.object).coinRate = 50;
                case 4 :
                    ((Treasury) this.object).coinRate = 80;
                case 5 :
                    ((Treasury) this.object).coinRate = 100;

            }
        }

        else if (this.object instanceof WheatFarm)
        {
            WheatFarm wheatFarm = (WheatFarm)object;
            wheatFarm.level = this;
            switch (this.grade)
            {
                case 1 :
                    ((WheatFarm) this.object).coinRate = -5;
                    ((WheatFarm) this.object).foodRate = 30;
                    ((WheatFarm) this.object).health = 50;
                    break;
                case 2 :
                    ((WheatFarm) this.object).coinRate = -10;
                    ((WheatFarm) this.object).foodRate = 50;
                    ((WheatFarm) this.object).health = 100;
                    break;
                case 3 :
                    ((WheatFarm) this.object).coinRate = -15;
                    ((WheatFarm) this.object).foodRate = 100;
                    ((WheatFarm) this.object).health = 200;
                    break;
                case 4 :
                    ((WheatFarm) this.object).coinRate = -20;
                    ((WheatFarm) this.object).foodRate = 180;
                    ((WheatFarm) this.object).health = 300;
                    break;
                case 5 :
                    ((WheatFarm) this.object).coinRate = -25;
                    ((WheatFarm) this.object).foodRate = 300;
                    ((WoodCutter) this.object).health = 500;
            }
        }
        else if (this.object instanceof WoodCutter)
        {
            WoodCutter woodCutter = (WoodCutter) object;
            woodCutter.level = this;
            ((WoodCutter) this.object).foodRate = -5;
            switch (this.grade)
            {
                case 1 :
                    ((WoodCutter) this.object).coinRate = -5;
                    ((WoodCutter) this.object).woodRate = 20;
                    ((WoodCutter) this.object).health = 50;
                    break;
                case 2 :
                    ((WoodCutter) this.object).coinRate = -10;
                    ((WoodCutter) this.object).woodRate = 35;
                    ((WoodCutter) this.object).health = 100;
                    break;
                case 3 :
                    ((WoodCutter) this.object).coinRate = -15;
                    ((WoodCutter) this.object).woodRate = 50;
                    ((WoodCutter) this.object).health = 200;
                    break;
                case 4 :
                    ((WoodCutter) this.object).coinRate = -20;
                    ((WoodCutter) this.object).woodRate = 80;
                    ((WoodCutter) this.object).health = 300;
                    break;
                case 5 :
                    ((WoodCutter) this.object).coinRate = -25;
                    ((WoodCutter) this.object).woodRate = 150;
                    ((WoodCutter) this.object).health = 500;
            }
        }
        else if (this.object instanceof Peasant)
        {
            ((Peasant) this.object).foodRate = -2;
        }
        else if (this.object instanceof Bowman)
        {
            ((Bowman) this.object).foodRate = -7;
        }
        else if (this.object instanceof SwordsMan)
        {
            ((SwordsMan) this.object).foodRate = -4;
        }
        else if (this.object instanceof Worker)
        {
            ((Worker) this.object).foodRate = -1;
        }



    }



}
