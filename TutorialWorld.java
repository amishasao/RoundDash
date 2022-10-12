import mayflower.*;

public class TutorialWorld extends World
{
    private Cat testActor;
    private String[][] grid;
    private int testScore;

    public TutorialWorld(){

        setBackground("img/backgrounds/tutorial.jpg");
        testActor = new Cat();
        
        testScore = 0;

        addObject(testActor, 100, 100);
        testActor.setScore(testScore);

        grid = new String[7][12];
        grid[1][1] = "character";

        buildWorld();

        runText();
    }

    public void act(){

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

    void runText(){
        showText("Round Dash Tutorial", 60, 30, 60);
        showText("Welcome to Round Dash! The objective of this game is to get 3 coins per level and basically just survive the skulls!", 20, 30, 130);
        showText("Use the left and right arrow keys to move your player on flat surfaces", 20, 30, 170);
        showText("Use the the up arrow key to climb", 20, 30, 210);
        showText("Finally, use the space bar to jump on or off of a flat surface", 20, 30, 250);
        showText("Try it out or click enter to move to the game!", 20, 30, 290);

        if(Mayflower.isKeyDown(Keyboard.KEY_ENTER)){
            Mayflower.setWorld(new IntroScreen());
        }
    }
}
