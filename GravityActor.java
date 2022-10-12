/*
    This class controls the objects Gravity
*/

import mayflower.*;
public class GravityActor extends Actor
{
    public void act(){
        if(isFalling()){
            setLocation(getX(), getY() +2);    
        }
    }

    //checks if it is obstructed by an external object/block
    boolean isBlocked(){
        return isTouching(Ground.class) || isTouching(Block.class);
    }
    
    boolean isFalling(){
        boolean ret;
        //move the actor down and see if it touches a block/ is it Falling?
        setLocation(getX(), getY() + 1);
        ret = isBlocked();
        setLocation(getX(), getY() - 1);
        return !ret;
    }
}


