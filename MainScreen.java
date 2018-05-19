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
import javax.swing.event.*;
public class MainScreen extends JFrame implements ActionListener{
    public static final int WIDTH = 700;
    public static final int HEIGHT = 300;
    public static final Color BACKGROUND = new Color(234,232,255);
    public static final Color TEXT = new Color(45,49,66);
    public static final Font PLAN = new Font("Avenir", Font.PLAIN, 14);
    public static final Font INSTRUCTIONS = new Font("Avenir", Font.PLAIN, 20);
    public static final Color BEHIND = new Color(216,213,219);
    
    private Neighborhood myN;
    private Person name;
    private JTextField clearSpace;
    private JTextField badSpace;
    private JTextArea personal;
    public MainScreen(Neighborhood n, Person name, String tab){
        super("Earthquake Planner");
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setBackground(BACKGROUND);
        
        myN = n;
        this.name = name;
        
        JMenu plans = new JMenu("earthquake plans");
        JMenuItem neighborhoodPlan = new JMenuItem("neighborhood plan");
        plans.add(neighborhoodPlan);
        neighborhoodPlan.addActionListener(this);
        JMenuItem myPlan = new JMenuItem("personal plan");
        myPlan.addActionListener(this);
        plans.add(myPlan);
        
        JMenu supplies = new JMenu("emergency supplies");
        JMenuItem mySupplies = new JMenuItem("my supplies");
        supplies.add(mySupplies);
        JMenuItem food = new JMenuItem("food");
        supplies.add(food);
        JMenuItem water = new JMenuItem("water");
        supplies.add(water);
        JMenuItem firstAid = new JMenuItem("first aid");
        supplies.add(firstAid);
        JMenuItem generators = new JMenuItem("generators");
        supplies.add(generators);
        JMenuItem flashlights = new JMenuItem("flashlights");
        supplies.add(flashlights);
        JMenuItem clothes = new JMenuItem("clothes and blankets");
        supplies.add(clothes);
        JMenuItem other = new JMenuItem("other");
        supplies.add(other);
        
        JMenuBar bar = new JMenuBar();
        bar.add(plans);
        bar.add(supplies);
        setJMenuBar(bar);
        
        if (tab.equals("neighborhood plan")){
            JPanel main = new JPanel();
            main.setBackground(BACKGROUND);
            main.setLayout(new GridLayout(myN.plan.length + 1, 2));
            JLabel clear = new JLabel("safe places:");
            clear.setFont(INSTRUCTIONS);
            clear.setForeground(TEXT);
            main.add(clear);
            clearSpace = new JTextField(myN.plan[0]);
            clearSpace.setFont(PLAN);
            clearSpace.setForeground(TEXT);
            clearSpace.setBackground(BEHIND);
            main.add(clearSpace);
            JLabel dangerous = new JLabel("dangerous places:");
            dangerous.setFont(INSTRUCTIONS);
            dangerous.setForeground(TEXT);
            main.add(dangerous);
            badSpace = new JTextField(myN.plan[1]);
            badSpace.setFont(PLAN);
            badSpace.setForeground(TEXT);
            badSpace.setBackground(BEHIND);
            main.add(badSpace);
            JPanel savePanel = new JPanel();
            savePanel.setBackground(BACKGROUND);
            JButton save = new JButton("save");
            save.addActionListener(this);
            savePanel.add(save);
            main.add(savePanel);
            add(main, BorderLayout.CENTER);
        } else if (tab.equals("personal plan")){
            JPanel main = new JPanel();
            main.setBackground(BACKGROUND);
            main.setLayout(new BorderLayout());
            personal = new JTextArea(name.plan);
            personal.setBackground(BEHIND);
            personal.setForeground(TEXT);
            personal.setFont(PLAN);
            main.add(personal, BorderLayout.CENTER);
            JButton save = new JButton("save");
            save.setActionCommand("save personal");
            save.addActionListener(this);
            main.add(save, BorderLayout.SOUTH);
            add (main, BorderLayout.CENTER);
        }
    }
    public void actionPerformed(ActionEvent e){
        String message = e.getActionCommand();
        switch (message){
            case "save": myN.plan[0] = clearSpace.getText();
                         myN.plan[1] = badSpace.getText();
                         break;
            case "save personal": name.plan = personal.getText();
                                  break;
            case "neighborhood plan": MainScreen m = new MainScreen(myN, name, "neighborhood plan");
                                      m.setVisible(true);
                                      dispose();
                                      break;
            case "personal plan":     MainScreen n = new MainScreen(myN, name, "personal plan");
                                      n.setVisible(true);
                                      dispose();
                                      break;
        }
    }
    
    
}
