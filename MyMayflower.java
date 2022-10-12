
import mayflower.*;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

class MyMayflower extends Mayflower{

    Clip bgMusic;
    AudioInputStream audioInputStream;
    
    public MyMayflower() throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
        super("Round Dash", 1200, 700); 

        // create AudioInputStream object 
        audioInputStream = AudioSystem.getAudioInputStream(new File("music/intro_music.wav").getAbsoluteFile()); 
          
        // create clip reference 
        bgMusic = AudioSystem.getClip(); 
          
        // open audioInputStream to the bgMusic 
        bgMusic.open(audioInputStream); 
          
        bgMusic.loop(bgMusic.LOOP_CONTINUOUSLY);
        bgMusic.start();
    }
    
    public void init()
    {
        Mayflower.setFullScreen(false);
        World intro = new IntroScreen();
        World tutorial = new TutorialWorld();
        Mayflower.setWorld(tutorial);
    }
}