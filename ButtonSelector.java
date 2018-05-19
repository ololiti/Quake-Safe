/*
 * Aditi Talati - May 19, 2018
 * Tri Valley Youth Expo
 */
package expohacksproject;

/**
 *
 * @author Aditi
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ButtonSelector extends MouseAdapter{
    private Neighborhood n;
    private FindAccount source;
    private Person name;
    public ButtonSelector(Neighborhood n, FindAccount f){
        this.n = n;
        source = f;
    }
    public ButtonSelector(Person name, FindAccount f){
        this.name = name;
        source = f;
    }
    public void mouseClicked(MouseEvent e){
        if (n != null){
            source.currentNeighborhood = n;
        } else {
            source.currentPerson = name;
        }
        source.clickedColor((JPanel)e.getSource());
    }
}
