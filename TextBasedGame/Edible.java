
/**
 * Write a description of class Edible here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Edible extends Item
{
    private int health;
    private boolean poisonous;
    
    public Edible(String n, int h, boolean b)
    {
        super(n);
        health = h;  
        poisonous = b;
    } 
    
    public boolean isPoisonous(){
        return poisonous;
    }
    
    public int getHealth(){
        return health;
    }
}
