/**
    This class operates the GameOver screen that is called if the Cat or Dog has lost all lives
 */

import mayflower.*;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class GameOver extends World 
{
    public GameOver()
    {
        // sets the background
        setBackground("img/backgrounds/gameover.jpg");
    }

    public void act()
    {
        goIntro();
    }

    // return to the introScreen after losing
    public void goIntro()
    {
        /*if(Mayflower.isKeyDown(Keyboard.KEY_ENTER))
            Mayflower.setWorld(new IntroScreen());*/

    }
}