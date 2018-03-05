
/**
 * Write a description of class Weapon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Weapon extends Item
{
    private int attackStrength;
    public Weapon(String n, int s)
    {
        super(n);
        attackStrength = s;
    }
    
    public int getStrength(){
        return attackStrength;
    }
   
}
