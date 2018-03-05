
/**
 * Write a description of class Mammal here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public abstract class Person extends Entity
{
    private String description;
    int stamina;
    ArrayList<Weapon> weapons;
    public Person(String n, String d)
    {
        super(n);
        description = d;
        weapons = new ArrayList<Weapon>();
    }
    public int getStamina(){
        return stamina;
    }
    public void addWeapon(String s,int i){
        weapons.add(new Weapon(s,i));
    }
}
