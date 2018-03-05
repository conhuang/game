
/**
 * Write a description of class Descriptions here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Descriptions
{
    private static String [] placeDesc = {"This island is probably a safe spot for a bit.\n"+ 
    "There seems to be nothing dangerous here.", //small island 
    
    "You are on the outskirts of the island. You can see the vast ocean out before\n"+
    "you and fish jumping in the ocean. Squinting far in the distance to the west,\n"+
    "you see a small island.",//ocean
    
    "You are in a beautiful meadow. There are what appear \n"+
    "to be berry bushes and half-dead grass in sight. To the east, the meadow \n"+
    "continues, and far in the west, you see the ocean.",//meadow
    
    "You are in a beautiful meadow. There are what appear to be blueberry bushes and \n"+
    "half-dead grass in sight. On the ground, it appears somebody has left their \n"+
    "crossbow hidden in the grass.",//meadow

    "Countless trees shoot up from the ground, and you are at the edge of a huge pond.\n"+
    "Birds are chirping everywhere and you feel like you might go for a swim.",//swamp
    
    "You are on the outskirts of the island. You can see the vast ocean out before\nyou "+
    "and fish jumping in the ocean and squinting far in the\ndistance to the north, you "+
    "see a small island. A mountain rises to the couth of you.",//ocean
    
    "You are on top of a mountain. It is cold up here, but there is a hole.",//mountain
    
    "You are in the forest. Surrounding you are trees and bushes everywhere. Far into the\n"+
    "distance to the north, you make out an opening in the forest.",//forest
    
    "There is a tiny creek in your path. To your west is a large clearing.",//creek
    
    "",//clearing
    
    "",//tundra
    
    "You are in the forest",//forest
    
    "Welcome to the starting point. You are surrounded by the forest.",//start
    
    "You are in the forest. Surrounding you are trees and bushes everywhere.",//forest
    
    "",//waterfall
    
    "",//desert
    
    "",//hut
        
    "You are in the forest. Surrounding you are trees and bushes everywhere.",//forest
    
    "You are in the forest. Surrounding you are trees and bushes everywhere.",//forest
    
    "",//plateau
    
    "",//wall
    
    "",//outhouse
    
    "",//shrine
    
    "",//cave
    
    ""//ocean
    };  
    
    private static String [] foeDesc = {
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    ""
    };
    public static String[] getDesc(){
        return placeDesc;
    }
    public static String[] getFoeDesc(){
        return foeDesc;
    }
}
