
/**
 * Write a description of class World here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class World
{
    private Place [][] world;
    int numRows=0,numCol=0;
    public World(int r, int c){
        world = new Place[r][c];
        numRows = r;
        numCol = c;
    }

    public void create(String[]p, String[]d){
        int i = 0;       
        for(int r = 0; r<world.length; r++){
            for(int c = 0; c<world[r].length; c++){
                world[r][c] = new Place(p[i],d[i]);
                i++;
            }
        }
    }
    
    public Place place(int x,int y){
        
        return world[x][y];
    }

    /*public void addItem(Item i){
        int r = (int)(Math.random() * world.length);
        int c = (int)(Math.random() * world[0].length);
        world[r][c].addItem(i);
    }
    public void addItem(Item i, int r, int c){
        world[r][c].addItem(i);
    }*/
    public boolean hasFoe(Place p){
        return p.hasFoe();
    }

    public void addPerson(Person f){
        int r = (int)(Math.random() * world.length);
        int c = (int)(Math.random() * world[0].length);
        world[r][c].addPerson(f);
    }
    public void addPerson(Person f, int r, int c){
        world[r][c].addPerson(f);
    }
    public String toString(){
        String a = "";
        for(int r = 0; r<world.length; r++){
            for(int c = 0; c<world[r].length; c++){
                a+=world[r][c].getName()+"\t";
            }
            a+="\n";
        }
        return a;
    }
}
