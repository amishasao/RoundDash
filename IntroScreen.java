/**
    This class is called to start the game, select sprites, and welcome the player
 */

import mayflower.*;

public class IntroScreen extends World 
{

    public IntroScreen()
    {
        setBackground("img/backgrounds/introscreen.jpg");
    }

    public void act(){
        goToLevel();
    }

    //allows you to pick a sprite to use throughout the whole level
    public void goToLevel()
    {
        if(Mayflower.isKeyDown(Keyboard.KEY_C))
            Mayflower.setWorld(new Level1("cat"));

        if(Mayflower.isKeyDown(Keyboard.KEY_D))
            Mayflower.setWorld(new Level1("dog"));
    }
}