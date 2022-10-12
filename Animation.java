/*
    This class controls all the animations and images
*/

import mayflower.*;

public class Animation
{
    // instance variables - replace the example below with your own
    private MayflowerImage[] frames;
    private int framerate;
    private int currentFrame;

    public Animation(int x, String[] y)
    {
        frames = new MayflowerImage[y.length];
        
        for(int i = 0; i < y.length; i++){
            frames[i] = new MayflowerImage(y[i]);
        }

        currentFrame = 0;
        framerate = x;
    }

   
    public int getFrameRate()
    {
        return framerate;
    }

    public MayflowerImage getNextFrame()
    {
        MayflowerImage n = frames[currentFrame];
        currentFrame++;
        currentFrame %= frames.length;
        return n;
    }

    /**
     * Scale every image in a specific Animation
     * @param w width to be scaled to
     * @param h height to be scaled to
     */
    public void scale(int w, int h){
        for(int i = 0; i < frames.length; i++){
            frames[i].scale(w,h);
        }
    }

    /**
     * set the bounds for every image
     * @param x x-coordinate
     * @param y y-coordinate
     * @param w width
     * @param h height
     */
    public void setBounds(int x, int y, int w, int h){
        for(int i = 0; i < frames.length; i++){
            frames[i].crop(x, y, w, h);
        }
    }

    // flip every image in the animation for the left-side animation
    public void mirrorHorizontally(){
        for(int i = 0; i < frames.length; i++){
            frames[i].mirrorHorizontally();
        }
    }

}