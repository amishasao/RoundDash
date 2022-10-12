/**
 * This is the first level of the game.
 */

import mayflower.*;
public class Level1 extends Worlds
{
    private Cat c;
    private Dog d;
    private String[][] grid;
    public String character;
    
    public Level1(String character)
    {
        this.character = character;
        setBackground("img/backgrounds/bg1.jpg");

        grid = new String[7][12];

        //creates 2 new objects
        d = new Dog();
        c = new Cat();
        
        //adds the dog object after user input 
        if(character.equals("dog"))
            addObject(d, 100, 100);
        else
            addObject(c, 100, 100);

        grid[1][1] = "character";

        buildWorld();
        addRandomObjects();
        
        //setText
        showText("Level 1", 50, 30, 50, Color.WHITE);

        
    }

    public void act(){

        //animatedWorld();
        updateText();

    }

    void buildWorld(){
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[i].length; j++)
                grid[i][j] = "";
                
        for(int i = 0; i < grid[0].length; i++){
            grid[6][i] = "ground";
            addObject(new Ground(), i * 100, 600);
        }
    }
    
    public void addRandomObjects()
    {
        int row = 0, col = 0;
        int numAdded = 0;
        int numCoinsToAdd = 3;
        int numSkullsToAdd = 3;

        //add randomly placed blocks
        numAdded = 12;
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
                    numAdded--;
                }
            }
        }

    }

    //removes the coin from the world
    public void disappearC(Coin coin){
        removeObject(coin);
    }

    //removes the skull from the world
    public void disappearS(Skull skull){
        removeObject(skull);
    }

    //updates the text
    private void updateText()
    {
        if(character.equals("dog"))
            showText("Score: "+ d.getScore() + " Lives: "+ d.getHealth(), 30, 330, 50, Color.WHITE);
        else
            showText("Score: "+ c.getScore() + " Lives: "+ c.getHealth(), 30, 330, 50, Color.WHITE);
    }
}