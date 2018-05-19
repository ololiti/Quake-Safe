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
import java.io.Serializable;

public class Neighborhood implements Serializable{
    private ArrayList<Person> people;
    private String name;
    public String[] plan = {"[add clear spaces in the neighborhood here]",
                            "[add places to avoid, such as power lines, here]"};
    private static ArrayList<String> neighborhoods = new ArrayList<>();
    public Neighborhood(String name) throws NameTakenException{
        setName(name);
    }
    public String getName(){
        return name;
    }
    public void setName(String name)throws NameTakenException{
        if(!neighborhoods.contains(name)){
            neighborhoods.remove(this.name);
            this.name = name;
            neighborhoods.add(name);
            people = new ArrayList<Person>();
        } else throw new NameTakenException();
    }
    public void addPerson(Person name) throws NameTakenException {
        if (people.contains(name)) throw new NameTakenException();
        else people.add(name);
    }
    public void listPeople(){
        for(Person s: people){
            System.out.println(s);
        }
    }
    public ArrayList<Person> getAllPeople(){
        return people;
    }
    public int getIndex(Person name){
        return people.indexOf(name);
    }
    public String toString(){
        return name;
    }
}
