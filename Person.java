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
import java.io.*;
public class Person implements Serializable{
    String name;
    String plan = "DROP, COVER, and HOLD ON to strong furniture!"
            + "\nIf you are in bed, hold on and cover your head."
            + "\nStay indoors until you are absolutely sure it is safe to exit."
            + "\nIf you smell gas, leave and go as far away as possible."
            + "\n[Add an escape route here.]"
            + "\n[Add location of first aid here]"
            + "\nBe prepared for aftershocks."
            + "\nLook for small fires and extinguish them."
            + "\n[Add location of fire extinguisher.]"
            + "\n[Add location of radio and radio station here.]"
            + "\n[Add phone numbers to call here.]";
    int food;
    int water;
    int firstAid;
    int generators;
    int flashlights;
    int clothes;
    String phone;
    String other = new String();
    public Person(String name){
        this.name = name;
    }
    public void addPhone(String number){
        phone = number;
    }
    public boolean equals(Object other){
        if (other.getClass()!=this.getClass()) return false;
        if (((Person)other).name == this.name) return true;
        return false;
    }
    public String toString (){
        return name;
    }
}
