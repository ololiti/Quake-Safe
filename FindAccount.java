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
import javax.swing.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FindAccount extends JFrame implements ActionListener{
    Neighborhood myNeighborhood;
    Person myName;
    protected Neighborhood currentNeighborhood;
    boolean neighborhoodType;
    JTextArea newNeighborhood;
    JLabel welcomeLabel;
    protected Person currentPerson;
    
    public static final int WIDTH = 400;
    public static final int HEIGHT = 400;
    public static final Color BACKGROUND = new Color(234,232,255);
    public static final Color TEXT = new Color(45,49,66);
    public static final Font INSTRUCTIONS = new Font("Avenir", Font.PLAIN, 20);
    public static final Font BOLD_FONT = new Font("Avenir", Font.BOLD, 20);
    public static final Color[] COLORS = {new Color(216,213,219), new Color(173,172,181)};
    
    public FindAccount(){
        super("Earthquake Planner");
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setBackground(BACKGROUND);
        neighborhoodType = true;
        
        JPanel welcome = new JPanel();
        welcome.setBackground(BACKGROUND);
        welcome.setLayout(new BorderLayout());
        welcomeLabel = new JLabel("Welcome to the Earthquake Planner!");
        welcomeLabel.setFont(INSTRUCTIONS);
        welcomeLabel.setForeground(TEXT);
        welcome.add(welcomeLabel, BorderLayout.CENTER);
        JLabel instructions = new JLabel("Please select or add your neighborhood.");
        instructions.setFont(INSTRUCTIONS);
        instructions.setForeground(TEXT);
        welcome.add(instructions, BorderLayout.SOUTH);
        add(welcome, BorderLayout.NORTH);
        
        JPanel neighborhoods = new JPanel();
        neighborhoods.setLayout(new GridLayout(ExpoHacksProject.neighborhoods.size() + 1, 1));
        for (int i = 0; i < ExpoHacksProject.neighborhoods.size(); i++){
            JPanel j = new JPanel();
            j.setBackground(COLORS[i%2]);
            JLabel jl = new JLabel(ExpoHacksProject.neighborhoods.get(i).toString());
            jl.setForeground(TEXT);
            jl.setFont(INSTRUCTIONS);
            j.add(jl);
            j.addMouseListener(new ButtonSelector(ExpoHacksProject.neighborhoods.get(i), this));
            neighborhoods.add(j);
        }
        newNeighborhood = new JTextArea("new neighborhood");
        newNeighborhood.setFont(INSTRUCTIONS);
        newNeighborhood.setForeground(TEXT);
        neighborhoods.add(newNeighborhood);
        add(neighborhoods, BorderLayout.CENTER);
        
        JButton submit = new JButton("submit");
        submit.setFont(INSTRUCTIONS);
        submit.setForeground(TEXT);
        submit.addActionListener(this);
        add(submit, BorderLayout.SOUTH);
    }
    public void clickedColor(JPanel j){
        j.setBackground(BACKGROUND);
    }
    public FindAccount(Neighborhood n){
        super("Earthquake Planner");
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setBackground(BACKGROUND);
        neighborhoodType = false;
        myNeighborhood = n;
        
        JPanel welcome = new JPanel();
        welcome.setBackground(BACKGROUND);
        welcome.setLayout(new BorderLayout());
        welcomeLabel = new JLabel("Welcome to the Earthquake Planner!");
        welcomeLabel.setFont(INSTRUCTIONS);
        welcomeLabel.setForeground(TEXT);
        welcome.add(welcomeLabel, BorderLayout.CENTER);
        JLabel instructions = new JLabel("Please select or add your name.");
        instructions.setFont(INSTRUCTIONS);
        instructions.setForeground(TEXT);
        welcome.add(instructions, BorderLayout.SOUTH);
        add(welcome, BorderLayout.NORTH);
        
        JPanel neighborhoods = new JPanel();
        neighborhoods.setLayout(new GridLayout(n.getAllPeople().size() + 1, 1));
        for (int i = 0; i < n.getAllPeople().size(); i++){
            JPanel j = new JPanel();
            j.setBackground(COLORS[i%2]);
            JLabel jl = new JLabel(n.getAllPeople().get(i).toString());
            jl.setForeground(TEXT);
            jl.setFont(INSTRUCTIONS);
            j.add(jl);
            j.addMouseListener(new ButtonSelector(n.getAllPeople().get(i), this));
            neighborhoods.add(j);
        }
        newNeighborhood = new JTextArea("new name");
        newNeighborhood.setFont(INSTRUCTIONS);
        newNeighborhood.setForeground(TEXT);
        neighborhoods.add(newNeighborhood);
        add(neighborhoods, BorderLayout.CENTER);
        
        JButton submit = new JButton("submit");
        submit.setFont(INSTRUCTIONS);
        submit.setForeground(TEXT);
        submit.addActionListener(this);
        add(submit, BorderLayout.SOUTH);
    }
    public void actionPerformed(ActionEvent e){
        if (neighborhoodType){
            if (currentNeighborhood == null){
                try{
                    myNeighborhood = new Neighborhood(newNeighborhood.getText());
                } catch (NameTakenException f){
                    welcomeLabel.setText(f.getMessage());
                    welcomeLabel.setFont(BOLD_FONT);
                    return;
                }
            } else {
                myNeighborhood = currentNeighborhood;
            }
            ExpoHacksProject.setNeighborhood(myNeighborhood);
            FindAccount f = new FindAccount(myNeighborhood);
            f.setVisible(true);
            ObjectOutputStream output = null;
            try{
                output = new ObjectOutputStream(new FileOutputStream("accounts.bin"));
                output.writeObject(ExpoHacksProject.neighborhoods);
                output.close();
            } catch (IOException g){
                System.out.println("Output file not found.");
                System.exit(0);
            }
            dispose();
        } else {
            if (currentPerson == null){
                try{
                    myName = new Person(newNeighborhood.getText());
                    myNeighborhood.addPerson(myName);
                } catch (NameTakenException f){
                    welcomeLabel.setText(f.getMessage());
                    welcomeLabel.setFont(BOLD_FONT);
                    return;
                }
            } else {
                myName = currentPerson;
            }
            ExpoHacksProject.setName(myName);
            MainScreen m = new MainScreen(myNeighborhood, myName, "neighborhood plan");
            m.setVisible(true);
            dispose();
        }
    }
}
