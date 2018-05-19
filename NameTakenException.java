/*
 * Aditi Talati - May 19, 2018
 * Tri Valley Youth Expo
 */
package expohacksproject;

/**
 *
 * @author Aditi
 */
import java.lang.Exception;
public class NameTakenException extends Exception{
    public NameTakenException(String message){
        super(message);
    }
    public NameTakenException(){
        super("This name is already taken.");
    }
}
