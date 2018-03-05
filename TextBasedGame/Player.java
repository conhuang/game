
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class Player extends Person
{
    private ArrayList<Item> bag;
    public World w;
    int x,y;
    int victories;
    boolean isAlive=true;

    public Player(String n, String d){
        super(n,d);
        w=new World(5,5);
        stamina = 50;
        bag = new ArrayList<Item>();
        victories = 0;
        x=w.numRows/2;
        y=w.numCol/2;
    }

    public String move(String n){
        String a = n.toLowerCase();

        switch(a){
            case "south":
            if(x+1>w.numCol-1)
                return("You can't go any farther.");
            else{
                x++; stamina-=10; return(currentPlace()+"\n");
            }
            
            case "north":
            if(x-1<0)
                return("You can't go any farther.");
            else{
                x--; stamina-=10; return(currentPlace()+"\n");
            }
            
            case "west": 
            if(y-1<0)
                return("You can't go any farther.");
            else{
                y--; stamina-=10; return(currentPlace()+"\n");
            }
            
            case "east":
            if(y+1>w.numRows-1)
                return("You can't go any farther.");
            else{
                y++; stamina-=10; return(currentPlace()+"\n");
            }
            
            default:
            return("You can't go there.");
        }

    }
    public boolean hasItems(){
        return bag.size()>0;
    }

    public boolean hasItem(Item i){
        for(Item j: bag)
            if(j.equals(i)){
                return true;
            }
        return false;
    }

    public Item drop(Item item) {
        if(this.bag.remove(item)) {
            return item;
        }
        else {
            return null;
        }
    }

    public boolean dropItem(String item) {
        Item dropped = null;
        for(Item i: bag)
            if (i.getName().equals(item)){
                dropped = drop(i);
                break;
            }
        if (dropped == null) {
            System.out.println("You don't have this item to drop");
            return false;
        }
        this.w.place(x,y).addItem(dropped);
        return true;
    }

    public void eat(Edible e){
        stamina += e.getHealth();
        if(this.hasItem(e))
            dropItem(e.getName());
    }

    public void sleep(){
        stamina+=45;
    }

    public void attack(Foe f, Item i){
        f.stamina -= ((Weapon)i).getStrength();
        if(f.stamina <= 0){
            victories+=1;
            System.out.println("You defeated " + f.getName() + "!\nVictories: "+victories);
        }
    }

    public boolean pickup(Item item){ 
        this.pick(item.getName());
        return true;
    }

    public void pick(String itemName) {        
        if(w.place(x,y).hasItem(itemName) && bag.size()<6)
            this.bag.add(w.place(x,y).takeItem(itemName)); 
        else if (bag.size()>5)
            System.out.println("You are holding too many items.");
    }

    public String getItems() {
        String temp="";
        for(Item i: bag)
            temp+=i.getName()+"\n";
        return temp;
    }

    public Item getItem(String s){
        for(Item i: bag)
            if(i.getName().equalsIgnoreCase(s))
                return i;
        return null;
    }

    public Place currentPlace() {
        return this.w.place(x,y);
    }   
}
