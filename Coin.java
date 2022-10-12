/**
    This class controls the Coin collectible that interacts and reacts to collison with either the Cat or Dog object
 */

import mayflower.*;
public class Coin extends Actor
{
    Cat c;
    Worlds w;
    Dog d;
    
    //Constructors for cat actor types
    public Coin(Cat actor, Level1 level)
    {
        w = level;
        c = actor;

        MayflowerImage coin = new MayflowerImage("img/gold-coin.png");
        coin.scale(70,70);
        setImage(coin);
    }

    public Coin(Cat actor, Level2 level)
    {
        w = level;
        c = actor;

        MayflowerImage coin = new MayflowerImage("img/gold-coin.png");
        coin.scale(70,70);
        setImage(coin);
    }

    public Coin(Cat actor, Level3 level)
    {
        w = level;
        c = actor;
        MayflowerImage coin = new MayflowerImage("img/gold-coin.png");
        coin.scale(70,70);
        setImage(coin);
    }

    //Constructors for dog actor types
    public Coin(Dog actor, Level1 level)
    {
        w = level;
        d = actor;

        MayflowerImage coin = new MayflowerImage("img/gold-coin.png");
        coin.scale(70,70);
        setImage(coin);
    }

    public Coin(Dog actor, Level2 level)
    {
        w = level;
        d = actor;

        MayflowerImage coin = new MayflowerImage("img/gold-coin.png");
        coin.scale(70,70);
        setImage(coin);
    }

    public Coin(Dog actor, Level3 level)
    {
        w = level;
        d = actor;
        MayflowerImage coin = new MayflowerImage("img/gold-coin.png");
        coin.scale(70,70);
        setImage(coin);
    }

    //the Cat or Dog will come in contact with the coin, it will disappear
    public void act()
    {
        if(isTouching(Cat.class)){
            c.increaseScore(1);
            w.disappearC(this);
        }

        if(isTouching(Dog.class)){
            d.increaseScore(1);
            w.disappearC(this);
        }
    }
} 