import mayflower.*;
public abstract class Worlds extends World
 {
    
    public Worlds() 
    {
        
    }
    
    void buildWorld(String[][] grid){
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[i].length; j++)
                grid[i][j] = "";
                
    }

    public abstract void disappearC(Coin coin);
    public abstract void disappearS(Skull skull);
}
