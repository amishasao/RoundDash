/*
 * This class creates all the animations, movement, and assigns them if needed. It also controls the timer.
 */

import mayflower.*;

public class AnimatedActor extends GravityActor
{
    private Animation animation;
    private Animation walkRight;
    private Animation idleRight;
    private Animation walkLeft;
    private Animation fallRight;
    private Animation fallLeft;
    private Animation idleLeft;
    private Animation climbRight;
    private Animation climbLeft;
    private Animation jumpRight;
    private Animation jumpLeft;
    
    private Timer animationTimer;

    private String currentAction, direction;
    
        public AnimatedActor()
        {
            walkRight = null;
            idleLeft = null;
            fallLeft = null;
            walkLeft = null;
            idleRight = null;
            fallRight = null;
            climbLeft = null;
            climbRight = null;
            direction = "right";

            animationTimer = new Timer(1000);
        }

        public void act(){
            if(animation != null){
                if(animationTimer.isDone()){
                    animationTimer.reset();
                    setImage(animation.getNextFrame());
                }   
        }
        
        super.act();
        //no movement = idleRight
        String newAction = null;
        if (currentAction == null) {
            newAction = "idleRight";
        }

        int x = getX();
        int y = getY();
        int w = getWidth();
        //right button pressed -> moves right and changes direction(image)
        if (Mayflower.isKeyDown(Keyboard.KEY_RIGHT) && (x + 1 + w <= 1200)) {
            setLocation(x + 2, y);
            newAction = "walkRight";
            direction = "right";
            if (isTouching(Block.class)) {
                setLocation(x, y - 2);
            }
        //left button pressed -> moves left and changes direction(image)
        } else if (Mayflower.isKeyDown(Keyboard.KEY_LEFT) && (x - 1 >= 0)) {    
            setLocation(x - 2, y);
            newAction = "walkLeft";
            direction = "left";
            if (isTouching(Block.class)) {
                setLocation(x, y - 2);
            }
        } else {
            if (direction != null && direction.equals("left")) {
                newAction = "idleLeft";
            } else if (direction != null && direction.equals("right")) {
                newAction = "idleRight";
            }
        }
        
        //changes the animations appearance based on the key that is pressed and direction
        if (isFalling() && direction.equals("right") && Mayflower.isKeyDown(Keyboard.KEY_SPACE) && direction != null) newAction = "jumpRight";
        else if (isFalling() && direction.equals("left") && Mayflower.isKeyDown(Keyboard.KEY_SPACE) && direction != null) newAction = "jumpLeft";
        
        else if (isFalling() && direction.equals("right") && Mayflower.isKeyDown(Keyboard.KEY_UP) && direction != null) newAction = "climbRight";
        else if (isFalling() && direction.equals("left") && Mayflower.isKeyDown(Keyboard.KEY_UP) && direction != null) newAction = "climbLeft";

        else if (isFalling() && direction.equals("right") && direction != null) newAction = "fallRight";
        else if (isFalling() && direction.equals("left") && direction != null) newAction = "fallLeft";

        //checks Action and assigns one if it doesn't have one and this checks and "animates" the cat
        if (newAction != null && !newAction.equals(currentAction)) {
            if (newAction.equals("walkRight")) {
                setAnimation(walkRight);
                currentAction = newAction;
            } else if (newAction.equals("idleLeft")) {
                setAnimation(idleLeft);
                currentAction = newAction;
            } else if (newAction.equals("idleRight")) {
                setAnimation(idleRight);
                currentAction = newAction;
            } else if (newAction.equals("walkLeft")) {
                setAnimation(walkLeft);
                currentAction = newAction;
            } else if (newAction.equals("fallRight")) {
                setAnimation(fallRight);
                currentAction = newAction;
            } else if (newAction.equals("fallLeft")) {
                setAnimation(fallLeft);
                currentAction = newAction;
            } else if (newAction.equals("climbRight")) {
                setAnimation(climbRight);
                currentAction = newAction;
            } else if (newAction.equals("climbLeft")) {
                setAnimation(climbLeft);
                currentAction = newAction;
            } else if (newAction.equals("jumpRight")) {
                setAnimation(jumpRight);
                currentAction = newAction;
            } else if (newAction.equals("jumpLeft")) {
                setAnimation(jumpLeft);
                currentAction = newAction;
            }
        }

    }

    // setting all of the animations
    void setAnimation(Animation a){
        animation = a;
    }

    void setWalkRightAnimation(Animation a){
        walkRight = a;
    }

    void setWalkLeftAnimation(Animation a){
        walkLeft = a;
    }

    void setFallLeftAnimation(Animation a){
        fallLeft = a;
    }

    void setFallRightAnimation(Animation a){
        fallRight = a;
    }

    void setIdleLeftAnimation(Animation a){
        idleLeft = a;
    }

    void setIdleRightAnimation(Animation a){
        idleRight = a;
    }

    void setClimbLeftAnimation(Animation a){
        climbLeft = a;
    }

    void setClimbRightAnimation(Animation a){
        climbRight = a;
    }

    void setJumpLeftAnimation(Animation a){
        jumpLeft = a;
    }

    void setJumpRightAnimation(Animation a){
        jumpRight = a;
    }
}