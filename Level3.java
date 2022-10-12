/**
    This is the third level of the game
 */

import mayflower.*;
public class Level3 extends Worlds
{
    private Cat c;
    private Dog d;
    private String[][] grid;
    private String character;
    
    public Level3(String character, int score)
    {

        this.character = character;
        setBackground("img/backgrounds/bg3.jpg");

        d = new Dog();
        c = new Cat();

        if(character.equals("dog")){
            addObject(d, 100, 100);
            d.setScore(score);
            addObject(new Jetpack(d, this), 100, 600);
        }
        else {
            addObject(c, 100, 100);
            c.setScore(score);
            addObject(new Jetpack(c, this), 100, 600);
        }

        grid = new String[7][12];
        grid[1][1] = "character";
        grid[5][1] = "jetpack";
        
        buildWorld(grid);
        addRandomObjects();

        //set text label for level
        showText("Level 3", 50, 30, 50, Color.WHITE);
        
    }

    public void act(){
        //animatedWorld();
        updateText();
    }

    
    
    // adds random objects to the world
    public void addRandomObjects()
    {
        int row = 0, col = 0;
        int numAdded = 0;
        int numCoinsToAdd = 5;
        int numSkullsToAdd = 8;
        
        //add randomly placed blocks
        numAdded = 15;
        Block b;

        while(numAdded > 0){

            row = (int)(Math.random() * grid.length + 1);
            col = (int)(Math.random() * grid[0].length + 1);
            
            if(row < grid.length && col < grid[0].length && grid[row][col] == ""){
                b = new Block();
                addObject(b, col * 100, 100 * row);
                
                grid[row][col] = "block";
                numAdded--;
                
                //add random coin collectibles
                if((row - 1) >= 0 && grid[row - 1][col] == "" && numCoinsToAdd > 0){
                    if(character.equals("dog"))
                        addObject(new Coin(d, this), col * 100, 100 * (row - 1));
                    else
                        addObject(new Coin(c, this), col * 100, 100 * (row - 1));
                    grid[row - 1][col] = "coin";
                    numCoinsToAdd--;
                }

                //add random skull objects
                if((row - 1) >= 0 && grid[row - 1][col] == "" && numSkullsToAdd > 0){
                    if(character.equals("dog"))
                        addObject(new Skull(d, this), col * 100, 100 * (row - 1));
                    else
                        addObject(new Skull(c, this), col * 100, 100 * (row - 1));
                    grid[row - 1][col] = "skull";
                    numSkullsToAdd--;
                }

            }
        }

    }
    
    public void disappearC(Coin coin){
        removeObject(coin);
    }

    public void disappearS(Skull skull){
        removeObject(skull);
    }

    public void disappearJ(Jetpack jetpack){
        removeObject(jetpack);
    }

    private void updateText()
    {
        if(character.equals("dog"))
            showText("Score: "+ d.getScore() + " Lives: "+ d.getHealth(), 30, 330, 50, Color.WHITE);
        else
            showText("Score: "+ c.getScore() + " Lives: "+ c.getHealth(), 30, 330, 50, Color.WHITE);
    }
   
}