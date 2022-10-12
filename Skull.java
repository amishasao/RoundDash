/**
    Creates a skull obstacle that if the Cat or Dog collides with it, it will cause the object to lose a life    
 */

import mayflower.*;

public class Skull extends Actor {

    private Cat c;
    private Worlds w;
    private Dog d;

    public Skull() {

        MayflowerImage skull = new MayflowerImage("img/skull.png");

        skull.scale(70, 70);
        setImage(skull);

    }

    
    //Constructors for Skull object for the Cat actor for each level
    public Skull(Cat actor, Level1 level)
    {
        w = level;
        c = actor;
        MayflowerImage skull = new MayflowerImage("img/skull.png");
        skull.scale(70,70);
        setImage(skull);
    }

    public Skull(Cat actor, Level2 level)
    {
        w = level;
        c = actor;
        MayflowerImage skull = new MayflowerImage("img/skull.png");
        skull.scale(70,70);
        setImage(skull);
    }

    public Skull(Cat actor, Level3 level)
    {
        w = level;
        c = actor;
        MayflowerImage skull = new MayflowerImage("img/skull.png");
        skull.scale(70,70);
        setImage(skull);
    }


    //Constructors for Skull object for the Dog actor for each level
    public Skull(Dog actor, Level1 level)
    {
        w = level;
        d = actor;
        MayflowerImage skull = new MayflowerImage("img/skull.png");
        skull.scale(70,70);
        setImage(skull);
    }

    public Skull(Dog actor, Level2 level)
    {
        w = level;
        d = actor;
        MayflowerImage skull = new MayflowerImage("img/skull.png");
        skull.scale(70,70);
        setImage(skull);
    }

    public Skull(Dog actor, Level3 level)
    {
        w = level;
        d = actor;
        MayflowerImage skull = new MayflowerImage("img/skull.png");
        skull.scale(70,70);
        setImage(skull);
    }

    // if the cat or dog comes in contact with the skull, it causes the health to decrement
    public void act()
    {
        if(isTouching(Cat.class)){
            c.healthDecrement();
            w.disappearS(this);
        }
        if(isTouching(Dog.class)){
            d.healthDecrement();
            w.disappearS(this);
        }
    }
}