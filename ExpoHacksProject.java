/*
 * Aditi Talati - May 19, 2018
 * Tri Valley Youth Expo
 */
package expohacksproject;

/**
 *
 * @author Aditi
 */
import java.util.ArrayList;
import java.util.Scanner;

public class ExpoHacksProject {

    /**
     * @param args the command line arguments
     */
    protected static ArrayList<Neighborhood> neighborhoods = 
                                                new ArrayList<Neighborhood>();
    static Person myName;
    static Neighborhood myNeighborhood;
    public static void main(String[] args) {
        try{
            neighborhoods.add(new Neighborhood("Ardenwood"));
            neighborhoods.get(0).addPerson(new Person("Bob"));
            neighborhoods.add(new Neighborhood("Twenty"));
            neighborhoods.add(new Neighborhood("Dublin"));
            neighborhoods.get(0).addPerson(new Person("John"));
        }catch(NameTakenException e){}
        FindAccount f = new FindAccount();
        f.setVisible(true);
        
    }
    public static void listNeighborhoods(){
        for(Neighborhood n: neighborhoods) System.out.println(n);
    }
    public static void setName(Person name){
        myName = name;
        System.out.println(myName);
    }
    public static void setNeighborhood(Neighborhood n){
        myNeighborhood = n;
        System.out.println(myNeighborhood);
    }
}
