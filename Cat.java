
/** 
Creates the main character, Cat.
If the object isAtEdge, the screen will change to the continuation of the level until instructed to change Level
The Cat class also controls the animations need to be accurate with the direction
*/

import mayflower.*;

public class Cat extends AnimatedActor {

    private int x, y, w;
    private int score;
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
    public boolean hasJetpack;
    private int delta = 1;


    public Cat() {
        x = 0;
        y = 0;
        w = 0;
        score = 0;
        health = 3;
        //sets hasJetpack to false until the cat gets a jetpack
        hasJetpack = false;


        // make list of images for walking, idling, falling, climbing, & jumping
        String[] walkImages = new String[10];
        for (int i = 0; i < walkImages.length; i++) {
            walkImages[i] = "img/cat/Walk (" + (i + 1) + ").png";
        }

        String[] idleImages = new String[10];
        for (int i = 0; i < idleImages.length; i++) {
            idleImages[i] = "img/cat/Idle (" + (i + 1) + ").png";
        }

        String[] fallImages = new String[8];
        for (int i = 0; i < fallImages.length; i++) {
            fallImages[i] = "img/cat/Fall (" + (i + 9) + ").png";
        }

        String[] climbImages = new String[10];
        for (int i = 0; i < climbImages.length; i++) {
            climbImages[i] = "img/cat/Slide (" + (i + 11) + ").png";
        }

        String[] jumpImages = new String[8];
        for (int i = 0; i < jumpImages.length; i++) {
            jumpImages[i] = "img/cat/Jump (" + (i + 9) + ").png";
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
        jumpRight = new Animation(5, jumpImages);
        jumpRight.scale(100, 87);
        jumpRight.setBounds(18, 5, 54, 80);

        jumpLeft = new Animation(5, jumpImages);
        jumpLeft.scale(100, 87);
        jumpLeft.mirrorHorizontally();
        jumpLeft.setBounds(28, 5, 54, 80);

        // set animations to the animation
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
        // isQualified();
    }

    public boolean isAtEdge() {

        // get the users input to control the object and check if it is at the edge of the screen
        if ((Mayflower.isKeyDown(Keyboard.KEY_RIGHT)) && (x + w < 1200)) {
            setLocation(x + delta, y);
        }
        return false;
    }

    // get the Circles current location
    public int getLocation() {
        int b = getX();
        return b;
    }

    public void jump() {
        double ay = 0, ymid = 0, vy = 5, vymid = 0, aymid = 0, g = 1.2, dt = 1, t = (2 * vy) / g;

        if(Mayflower.isKeyDown(Keyboard.KEY_SPACE) /*&& !isFalling()*/){
            // setLocation(x, y - 100);
            while (t > 0) {
                ay = -1 * g; // ay at beginning of interval
                ymid = y + vy * 0.5 * dt; // y at middle of interval
                vymid = vy + ay * 0.5 * dt; // vy at middle of interval
                aymid = -1 * g; // ay at middle of interval
                y += vymid * dt;
                setLocation(x, y);
                vy += aymid * dt;
                t -= dt;
            }
        }
    }

    public double calcVfinal(double v0, double a, double dt){
        double v1 = v0 + a * dt;
        return v1;
    }

    public double calcYfinal(double y0, double v0, double dt){
        double y1 = y0 + v0 * dt;
        return y1;
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
    
    //checks the number of death tokens that the circle has collected and if it is 0, the circle isDead
    public void isDead()
    {
        if(health == 0)
        {
            //play game over screen
            Mayflower.setWorld(new GameOver());
        }

    }

    //checks if the Cat object isQualified to move on to the next level
    //each World checks the score to be allowed to move onto the next level
    void isQualified(){
        if(score == 3)
            Mayflower.setWorld(new Level2("cat", score));
        else if(score == 6)
            Mayflower.setWorld(new Level3("cat", score));
        else if(score == 9)
            Mayflower.setWorld(new YouWin());
    }
}