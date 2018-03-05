
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.*;
public class Main
{   static boolean stillPlay = true;

    public static void main(String [] args){ 

        while(stillPlay){
            Player player = new Player("You","");
            player.w = new World(5,5);
            Scanner scan = new Scanner(System.in);

            //creating the map
            String[] places = {"Small Island","Ocean","Meadow","Meadow","Swamp",
                               "Ocean","Mountain","Forest","Creek","Clearing",
                               "Tundra","Forest","Start","Forest","Waterfall",
                               "Desert","Hut","Forest","Forest","Plateau",
                               "Wall","Outhouse","Shrine","Cave","Ocean"};

            String[]descriptions = new String[25];

            /*Scanner read = new Scanner(new File("game.txt"));            
            for(String s: descriptions)
            s=read.nextLine();*/

            descriptions = Descriptions.getDesc();

            player.w.create(places,descriptions); 
              

            //creating enemies
            Foe[] enemies = new Foe[10];
            String [] foeNames = {"Meredith","Derek","Jackson","Miranda","Alex",
                    "George", "Lexie","Christina", "Mark","Maggie"};
            String [] foeDes = new String[10];

            for(int i =0; i<enemies.length; i++){
                enemies[i] = new Foe(foeNames[i],foeDes[i],(int)(Math.random()*75));
                player.w.place((int)(Math.random()*5),(int)(Math.random()*5)).addPerson(enemies[i]);
            }

            //creating items
            String[] itemNames={"water","sword","cross-bow","newspaper","lantern",
                    "branch","berries","grass","trees","deer","fish"};

            player.w.place(1,2).addItem(new Weapon(itemNames[5],(int)(Math.random()*30)));
            player.w.place(2,1).addItem(new Weapon(itemNames[5],(int)(Math.random()*30)));
            player.w.place(3,2).addItem(new Weapon(itemNames[5],(int)(Math.random()*30)));
            player.w.place(2,3).addItem(new Weapon(itemNames[5],(int)(Math.random()*30)));
            player.w.place(3,3).addItem(new Weapon(itemNames[5],(int)(Math.random()*30)));
            player.w.place(1,3).addItem(new Edible(itemNames[0],5,false));
            player.w.place(0,2).addItem(new Edible(itemNames[6],0,true));
            player.w.place(0,1).addItem(new Edible(itemNames[10],10,false));
            player.w.place(1,0).addItem(new Edible(itemNames[10],10,false));
            player.w.place(4,4).addItem(new Edible(itemNames[10],10,false));
            player.w.place(1,0).addItem(new Edible(itemNames[10],10,false));
            

            //THE GAME
            System.out.println("\f=====================================");
            System.out.println("--- THE BEST TEXT-BASED ADVENTURE ---");
            System.out.print("=====================================\n");

            scan.nextLine();
            System.out.println("You and ten others have been selected randomly to survive on\na stranded island "+
                "until one person comes out alive.\nYour goal is to navigate your way around the"+
                " island and\nfind your enemies before they find you. There is no way out\n"
                +"until you have defeated every other person.\nNote: your stamina is limited."+
                " Make sure you eat and sleep as needed.\nGood luck!");

            System.out.println("\nPress enter to continue");
            scan.nextLine();
            System.out.println("Use commands to move around the island and defeat your "+
                "enemies.\n\"go north/south/west/east\", \"take/drop _____\", \"attack _____\nwith _____\","+
                " \"inventory\", \"eat/drink _____\", \"sleep\", \"exit\"."+ 
                "\nWelcome to the starting point. You are surrounded by a vast forest.");

            while (player.isAlive){
                System.out.print(">> ");
                String x = scan.nextLine();
                turn(x, player, scan);
                if(player.stamina<=0){
                    System.out.println("After running around all day, you have died from fatigue.\n");
                    player.isAlive= false;
                }  
                else if(player.stamina<=10)
                    System.out.println("Your health is low. Get some rest.\n");
            }
            if(!stillPlay)
                break;
            System.out.print("Play again? ");
            String s = scan.next();
            if(s.charAt(0)=='n' || s.charAt(0)=='N')
                stillPlay = false;                
        }
        System.out.println("Thanks for playing!");
    }

    public static void turn(String s, Player p, Scanner scan){        
        //creating array of words in string
        String[] words = s.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("[^\\w]", "");
        }

        switch(words[0].toLowerCase()){
            case "help":
            System.out.println("Use commands to move around the island and defeat your "+
                "enemies.\n\"go north/south/west/east\", \"take/drop _____\", \"attack with \n_____\","+
                " \"inventory\", \"eat/drink _____\", \"sleep\", \"exit\".");
            break;
      
            case "go":
            if(words.length==1)
                System.out.println("Where?");
            else {
                System.out.println(p.move(words[1])); 
                if(p.currentPlace().hasFoe()){
                    int x = (int)(Math.random()*3);
                    if(x == 0){
                        System.out.print("As you arrive the " + p.currentPlace().getName().toLowerCase() +", you come across somebody \n"+
                        "who looks ready for a showdown.\n"+
                        "Do you want to fight or run?\n>> ");
                        fightOrFlight(scan.nextLine().toLowerCase(),scan,p);
                    }
                    if(x == 1){
                        System.out.print("Approaching the " + p.currentPlace().getName().toLowerCase()+", you spot somebody, and\n"+
                        "immediately you hide before they are able to see you.\nYou have the choice to do what you need to"
                        +" without being caught.\n");
                    }
                    if(x == 2){                        
                        System.out.println("You have been jumped. \nYour opponent runs away as you struggle to get up\n"+
                        "from the attack. You health has diminished. \nHopefully you can recover from this setback.");
                        p.currentPlace().getRandFoe().attack(p);
                    }
                    
                }
            }
            break;

            case "take": 
            if(words.length==1)
                System.out.println("You can't just take air, you know.");
            else if(p.currentPlace().hasItem(words[1].toLowerCase())){
                p.pick(words[1]);
                System.out.println("Taken");
            }
            else
                System.out.println("You can't take that.");
            break;

            case "drop":
            if(words.length==1)
                System.out.println("What, drop dead? Please, I need more specificity out of you.");
            else {
                System.out.println("Dropped.");
                p.dropItem(words[1]);
            }
            break;

            case "attack":          
            if(words.length>1){
                if(words.length==4 && words[3].equalsIgnoreCase("with")){
                    p.attack(p.currentPlace().getRandFoe(),p.getItem(words[2]));
                    System.out.println("Your enemy has weakened!"); 
                }
                
            }else
                System.out.println("Attack what?");
            break;

            case "inventory":
            System.out.println("You are holding:\n"+p.getItems()+"\n");
            break;

            case "eat":
            if(words.length==1)
                System.out.println("Eat what?");
            else if(p.currentPlace().hasItem(words[1])||p.hasItem(Item.getItem(words[1])) 
                    ){
                if(((Edible)(p.currentPlace().getItem(words[1]))).isPoisonous()){
                    p.isAlive = false;
                    System.out.println("You just ate poisonous food. In a few hours you are"+
                        "\ngoing to drop dead and be eaten by hyenas.");
                }
                else{
                    p.eat((Edible)p.currentPlace().getItem(words[1]));
                    System.out.println("Yum.");
                }
            }else
                System.out.println("You can't eat that.");
            break;

            case "drink":
            if(words.length==1)
                System.out.println("Drink what?");
            else if(p.currentPlace().hasItem(words[1]) && p.currentPlace().getItem(words[1]) instanceof Edible){
                p.eat((Edible)p.currentPlace().getItem(words[1]));
                System.out.println("Mmmmmm. Good stuff.");
            }else
                System.out.println("You can't drink that.");
            break;

            case "sleep":
            if(p.currentPlace().canSleep()&& p.getStamina()<20){
                p.sleep();
                System.out.println("sleeping.... and the next morning, you are ready to take on a new day.");
            }
            else if(p.getStamina()>15){
                System.out.println("It's too early to sleep! Spend more time getting out of the island!");
            }
            else
                System.out.println("You can't sleep here while a murderous enemy is on the loose!");

            break;

            case "exit":
            p.isAlive = false;
            stillPlay = false;           
            break;

            default:
            System.out.print("Sorry?\n");
        }

    }

    public static void fightOrFlight(String ans, Scanner scan, Player p){
        switch(ans){
            case "run":
            String[] moves = {"north","south","west","east"};
            String s = p.move(moves[(int)(Math.random()*4)]);
            while(s.equals("You can't go any farther.")){
                s= (p.move(moves[(int)(Math.random()*4)]));
            }

            System.out.println("As quickly as you could, you ran away from your opponent\n"
                +"and hid in the nearest hiding spot."+ "\n\n" + s);
            break;

            case "fight":
            System.out.print("Choose your weapon.\n>> ");
            String h = scan.nextLine();
            if(p.hasItem(new Item(h)))
                p.attack((Foe)p.currentPlace().getFoes().get(0), p.getItem(h));
            else{
                System.out.print("You do not have this weapon. Choose another weapon or run.\n>> ");
                ans = scan.nextLine();
                fightOrFlight(ans,scan,p);
            }             
            break;

            default: 
            System.out.print("Please choose one.\n>> ");
            ans = scan.nextLine();
            fightOrFlight(ans, scan, p);
        }
    }
} 
