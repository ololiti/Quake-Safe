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
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.*;
public class ExpoHacksProject {

    /**
     * @param args the command line arguments
     */
    protected static ArrayList<Neighborhood> neighborhoods = 
                                                new ArrayList<Neighborhood>();
    static Person myName;
    static Neighborhood myNeighborhood;
    public static void main(String[] args) {
        ObjectOutputStream output = null;
        ObjectInputStream input = null;
        try{
            input = new ObjectInputStream(new FileInputStream("accounts.bin"));
            neighborhoods = (ArrayList<Neighborhood>)input.readObject();
        } catch (FileNotFoundException e){
            System.out.println("Input file not found.");
        } catch (IOException e){
            System.out.println("Error in retrieving input file.");
        } catch (ClassNotFoundException e){
            System.out.println("Class not found.");
        }
        FindAccount f = new FindAccount();
        f.setVisible(true);
        try{
            output = new ObjectOutputStream(new FileOutputStream(new File("accounts.bin")));
            output.writeObject(neighborhoods);
            output.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
            System.out.println("Output file not found.");
        }
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
