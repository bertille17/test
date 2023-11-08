import java.util.Random;
import java.util.ArrayList;
import java.util.List;

/**
 * Décrivez votre classe Kingrobot ici.
 *
 * @author (Eloise )
 * @version (2023-11-02)
 */
public class KingRobot extends Robot
{
    private Random random;
    
    public KingRobot (String name, World world) {
    super(name);
    world.newRobotIn(this);
    }
    
    public KingRobot(String name, int x, int y, Colour newColor, World world)
    {
        super(name,x,y,newColor, world);
        world.newRobotIn(this);
    }
    
    public void move()
    {
        Random random = new Random();
        int randomDir = random.nextInt(8) + 1;  //the robot randomly changes direction each time it moves
        
        int newX = getX();
        int newY=getY();

        switch(randomDir){
            case 0:
                newX++;
                break;
            case 1:
                newY++;;
                break;
            case 2:
                newX--;
                break;
            case 3:
                newY--;
                break;
            case 4:
                newY++;
                newX++;
                break;
            case 5:
                newX++;
                newY--;
                break;
            case 6:
                newX--;
                newY--;
                break;
            case 7:
                newX--;
                newY++;
                break;
        }
        // Vérifier les limites du canva pour pas que le robot sorte du canva
        if (newX < 0 ) {
            newX = 11;
        }
        if (newX > 11 ) {
            newX = 0;
        }
        if (newY < 0 ){
            newY = 11;
        }
        if (newY > 11){
            newY = 0;
        }
        
        if (getWorld().canMove(this, newX, newY)) { 
            setXPosition(newX);
            setYPosition(newY);
            draw();
        }
        else{
            move();
        }

    }
    
}
