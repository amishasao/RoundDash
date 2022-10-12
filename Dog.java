/** 
Creates the main character, Dog.
This class checks ff the Dog has the needed score to proceed to the next level.
The Dog class also controls the animations need to be accurate with the direction
*/

import mayflower.*;

public class Dog extends AnimatedActor {

    private int x, y, w;
    private int health;
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
    public boolean hasJetpack = false;
    private int delta = 1;
    private int score = 0;

    public Dog() {
        x = 0;
        y = 0;
        w = 0;
        health = 3;

        hasJetpack = false;

        // make list of images for walking, idling, falling, climbing, & jumping
        String[] walkImages = new String[10];
        for (int i = 0; i < walkImages.length; i++) {
            walkImages[i] = "img/dog/Walk (" + (i + 1) + ").png";
        }

        String[] idleImages = new String[10];
        for (int i = 0; i < idleImages.length; i++) {
            idleImages[i] = "img/dog/Idle (" + (i + 1) + ").png";
        }

        String[] fallImages = new String[8];
        for (int i = 0; i < fallImages.length; i++) {
            fallImages[i] = "img/dog/Fall (" + (i + 1) + ").png";
        }

        String[] climbImages = new String[10];
        for (int i = 0; i < climbImages.length; i++) {
            climbImages[i] = "img/dog/Slide (" + (i + 1) + ").png";
        }

        String[] jumpImages = new String[8];
        for (int i = 0; i < jumpImages.length; i++) {
            jumpImages[i] = "img/dog/Jump (" + (i + 1) + ").png";
        }

        // make animations for idleRight (change size and bounds) & idleLeft (but mirrored)
        idleRight = new Animation(50000000, idleImages);
        idleRight.scale(100, 87);
        idleRight.setBounds(18, 5, 54, 80);

        idleLeft = new Animation(50000000, idleImages);
        idleLeft.scale(100, 87);
        idleLeft.mirrorHorizontally();
        idleLeft.setBounds(18, 5, 54, 80);

        // make animations for walkRight (change size and bounds) & walkLeft (but mirrored)
        walkRight = new Animation(50000000, walkImages);
        walkRight.scale(100, 87);
        walkRight.setBounds(18, 5, 54, 80);

        walkLeft = new Animation(50000000, walkImages);
        walkLeft.scale(100, 87);
        walkLeft.mirrorHorizontally();
        walkLeft.setBounds(28, 5, 54, 80);

        // make animations for fallRight (change size and bounds) & fallLeft (but mirrored)
        fallRight = new Animation(50000000, fallImages);
        fallRight.scale(100, 87);
        fallRight.setBounds(18, 5, 54, 80);

        fallLeft = new Animation(50000000, fallImages);
        fallLeft.scale(100, 87);
        fallLeft.mirrorHorizontally();
        fallLeft.setBounds(28, 5, 54, 80);

        // make animations for climbRight (change size and bounds) & climbLeft (but mirrored)
        climbRight = new Animation(50000000, climbImages);
        climbRight.scale(100, 87);
        climbRight.setBounds(18, 5, 54, 80);

        climbLeft = new Animation(50000000, climbImages);
        climbLeft.scale(100, 87);
        climbLeft.mirrorHorizontally();
        climbLeft.setBounds(28, 5, 54, 80);

        // make animations for jumpRight (change size and bounds) & jumpLeft (but mirrored)
        jumpRight = new Animation(50000000, jumpImages);
        jumpRight.scale(100, 87);
        jumpRight.setBounds(18, 5, 54, 80);

        jumpLeft = new Animation(50000000, jumpImages);
        jumpLeft.scale(100, 87);
        jumpLeft.mirrorHorizontally();
        jumpLeft.setBounds(28, 5, 54, 80);

        //set animations to the animatiosn
        setIdleRightAnimation(idleRight);
        setIdleLeftAnimation(idleLeft);
        setWalkRightAnimation(walkRight);
        setWalkLeftAnimation(walkLeft);
        setFallLeftAnimation(fallLeft);
        setFallRightAnimation(fallRight);
        setClimbRightAnimation(climbRight);
        setClimbLeftAnimation(climbLeft);
        setJumpRightAnimation(jumpRight);
        setJumpLeftAnimation(jumpLeft);
    }

    public void act() {

        super.act();
        x = getX();
        y = getY();
        w = getWidth();
        

        //takes user input of arrows
        
        if ((Mayflower.isKeyDown(Keyboard.KEY_RIGHT))) {
            setLocation(x + delta, y);

        }
        if ((Mayflower.isKeyDown(Keyboard.KEY_LEFT))) {
            setLocation(x - delta, y);

        }

        if((Mayflower.isKeyDown(Keyboard.KEY_UP))){    
            climb();
        }

        jump();
        isDead();
        
    }

    //get the Dog's current location
    public int getLocation() {
        int b = getX();
        return b;
    }

    public void jump() {            
        if(Mayflower.isKeyDown(Keyboard.KEY_SPACE) && !isFalling()){
            setLocation(x, y - 100);
        }
    }
    
    public void climb(){
        setLocation(x, y-3);
    }

    public void increaseScore(int amount){
        score += amount;
        isQualified();
    }

    void healthDecrement(){
        health--;
    }

    int getHealth(){
        return health;
    }

     void setDelta(int value){
        delta = value;
    }

    void setScore(int value){
        score = value;
    }

    int getScore(){
        return score;
    }
    
    //checks the number of death tokens that the circle has collected and if it is 0, the dog is removed and the game over screen is played
    public void isDead()
    {
        if(health == 0)
        {
            //play game over screen
            Mayflower.setWorld(new GameOver());
        }

    }

    //checks if the dog isQualified to move on to the next level
    void isQualified(){
        if(score == 3)
            Mayflower.setWorld(new Level2("dog", score));
        else if(score == 6)
            Mayflower.setWorld(new Level3("dog", score));
        else if(score == 9)
            Mayflower.setWorld(new YouWin());
    }
}