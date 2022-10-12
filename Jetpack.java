/**
    This class controls the jetback object that is created in level 3.
    After collecting the jetpack, there is a speed boost
 */

import mayflower.*;
public class Jetpack extends Actor
{
    Dog d;
    Cat c;
    Level3 w;

    public Jetpack(Dog actor, Level3 l3)
    {
        w = l3;
        d = actor;

        MayflowerImage jetpack = new MayflowerImage("img/jetpack.png");
        jetpack.scale(70,70);
        setImage(jetpack);
    }

    public Jetpack(Cat actor, Level3 l3)
    {
        w = l3;
        c = actor;
        MayflowerImage jetpack = new MayflowerImage("img/jetpack.png");
        jetpack.scale(70,70);
        setImage(jetpack);
    }

    public void act()
    {
        // speeds/boosts the cat/dog object when it has a jetpack
        
        if(c != null && isTouching(Cat.class)){
            c.setDelta(3);
            w.disappearJ(this);
        }

        if(d != null && isTouching(Dog.class)){
            d.setDelta(3);
            w.disappearJ(this);
        }
    }
}