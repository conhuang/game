
/**
 * Write a description of class Test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class Test
{
    public static void main(String[]args){
        String[] p = {"Small Island","Ocean","Meadow","Meadow","Swamp",
                      "Ocean","Mountain","Forest","Creek","Clearing",
                      "Tundra","Forest","Start","Forest","Waterfall",
                      "Desert","Hut","Forest","Forest","Plateau",
                      "Wall","Outhouse","Shrine","Cave","Ocean"};
                      
        //Scanner read = new Scanner(new File("game.txt"));
        Scanner scan = new Scanner(System.in);
        String[]d = new String[25];
        //for(String s: d)
         //   s=read.nextLine();
        World map = new World(5,5);
        map.create(p,d);
        
        Player player = new Player("you","");
        boolean alive = true;
        
        System.out.println("\f");
        while (alive){
            System.out.print(">> ");
            String x = scan.nextLine();
            turn(x, player, scan);

        }
    }
    public static void turn(String s, Player p, Scanner scan){
        ArrayList<String> words = new ArrayList<String>();
        int x = 0;
        boolean hasSpace=false;
        for(int i = 0; i<s.length(); i++){    
            if(s.charAt(i)==' '&& i!=0){
                hasSpace = true;
                words.add(s.substring(x,i));
                x=i+1;
            }
        }
        if(!hasSpace)
            words.add(s);
        switch(words.get(0)){
            case "go":
            System.out.println("go");
            break;
            
            case "take":
            System.out.println("take");
            break;
            
            case "attack":
            System.out.println("attack");
            break;
            
            case "inventory":
            System.out.println("inventory");
            break;
            
            default:
                System.out.print(">> ");
                String a = scan.nextLine();
                turn(a,p,scan);
        }
    }
}
