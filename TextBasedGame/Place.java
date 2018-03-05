
/**
 * Abstract class Place - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
import java.util.*;
public class Place extends Entity
{
    private ArrayList <Item> items;
    private ArrayList <Person> people;
    private ArrayList<Place> places;
    private String description;

    public Place(String n, String d){
        super(n);
        description = d;
        items = new ArrayList<Item>();
        people = new ArrayList<Person>();
    }

    public void addItem(Item i)
    {
        items.add(i);
    }
    
    public void addPlace(String n, String d){
        places.add(new Place(n,d));
    }
        
    public Item getItem(String s){
        for(int i = 0; i < items.size(); i++)
            if(items.get(i).getName().equals(s))
                return items.get(i);
        return null;
    }
    
    public Item takeItem(String s){
        for(int i = 0; i < items.size(); i++)
            if(items.get(i).getName().equals(s))
                return items.remove(i);
        return null;
    }

    public void addPerson(Person m){
        people.add(m);
    }

    public boolean hasItem(String i){
        for(Item s: items)
            if(s.getName().equals(i))
                return true;        
        return false;
    }

    public boolean hasFoe(){
        for(Person p: people)
            if(p instanceof Foe)
                return true;
        return false;
    }
    
    public ArrayList<Person> getFoes(){
        return people;
    }
    
    public Foe getRandFoe(){
        int x = (int)(Math.random()*people.size());
        return (Foe)people.get(x);
    }
    public Foe getFoe(String f){
        for(int i = 0; i < people.size(); i++)
            if(people.get(i).getName().equals(f))
                return (Foe)people.get(i);
        return null;        
    }
    
    public boolean canSleep(){
        if(this.hasPeople())
            return false;
        return true;
    }
    
    public String getThings(){
        String temp = "";
        if(items.size()>0){
            temp="Items:\n";
            for(Item i: items)
                temp+=i.getName() + "\n";
        }
        if(people.size()>0){
            temp+="\nPeople:\n";
            for(Person p: people)
                temp+=p;  
        }
        return temp;
    }
    
    public boolean hasPeople(){
        if(people.size()>0)
            return true;
        return false;
    }
    
    public String toString(){ 
        return super.getName() + "\n" + description;
    }

}
