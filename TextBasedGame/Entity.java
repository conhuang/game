
/**
 * Abstract class Entity - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Entity
{
    private String name;
    private String description;
    private int x;
    private int y;
    
    public Entity(String n) {
        name = n;
    }
    
    public String getName() {
        return name;
    }

    public String getDesc() {
        return description;
    }

    public String toString() {
        return name + "\n" + description;
    }
}
