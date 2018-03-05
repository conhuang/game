
/**
 * Write a description of class Item here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Item extends Entity
{

    public Item(String n)
    {
        super(n);
        }
    public static Item getItem(String i){
        return (new Item(i));
    }
}
