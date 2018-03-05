
/**
 * Write a description of class Foe here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Foe extends Person
{
    public Foe(String s, String d, int i)
    {
        super(s,d);
        stamina = i;
    }

    public void attack(Player m){
        //System.out.println(getName()+" retaliates!");
        m.stamina -= (int)(Math.random()*25)+10;
        if(m.stamina<0){
            System.out.println("You have been defeated.");
        }
    }

}
