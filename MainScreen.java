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
    public static final Color ALTERNATE = new Color(176,215,255);
    
    private JTextField otherField;
    private JLabel aidLabel;
    private JLabel generatorLabel;
    private JLabel flashlightLabel;
    private JLabel clothesLabel;
    private JLabel waterLabel;
    private JLabel foodLabel;
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
        mySupplies.addActionListener(this);
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
        } else if (tab.equals("my supplies")){
            JPanel main = new JPanel();
            main.setLayout(new GridLayout(8,1));
            
            JPanel label = new JPanel();
            JLabel labellabel = new JLabel("my supplies");
            label.setBackground(BACKGROUND);
            labellabel.setFont(INSTRUCTIONS);
            labellabel.setForeground(TEXT);
            label.add(labellabel);
            main.add(label);
            
            JPanel foodPanel = new JPanel();
            foodPanel.setBackground(ALTERNATE);
            foodLabel = new JLabel("food: " + name.food);
            foodLabel.setForeground(TEXT);
            foodLabel.setFont(INSTRUCTIONS);
            foodPanel.add(foodLabel);
            JButton addFood = new JButton("+");
            addFood.addActionListener(this);
            addFood.setActionCommand("add food");
            foodPanel.add(addFood);
            JButton removeFood = new JButton("-");
            removeFood.addActionListener(this);
            removeFood.setActionCommand("remove food");
            foodPanel.add(removeFood);
            main.add(foodPanel);
            
            JPanel waterPanel = new JPanel();
            waterPanel.setBackground(BEHIND);
            waterLabel = new JLabel("water: " + name.food);
            waterLabel.setForeground(TEXT);
            waterLabel.setFont(INSTRUCTIONS);
            waterPanel.add(waterLabel);
            JButton addWater= new JButton("+");
            addWater.addActionListener(this);
            addWater.setActionCommand("add water");
            waterPanel.add(addWater);
            JButton removeWater = new JButton("-");
            removeWater.addActionListener(this);
            removeWater.setActionCommand("remove water");
            waterPanel.add(removeWater);
            main.add(waterPanel);
            
            JPanel aidPanel = new JPanel();
            aidPanel.setBackground(ALTERNATE);
            aidLabel = new JLabel("first aid: " + name.firstAid);
            aidLabel.setForeground(TEXT);
            aidLabel.setFont(INSTRUCTIONS);
            aidPanel.add(aidLabel);
            JButton addAid = new JButton("+");
            addAid.addActionListener(this);
            addAid.setActionCommand("add aid");
            aidPanel.add(addAid);
            JButton removeAid = new JButton("-");
            removeAid.addActionListener(this);
            removeAid.setActionCommand("remove aid");
            aidPanel.add(removeAid);
            main.add(aidPanel);
            
            JPanel generatorPanel = new JPanel();
            generatorPanel.setBackground(BEHIND);
            generatorLabel = new JLabel("generators: " + name.generators);
            generatorLabel.setForeground(TEXT);
            generatorLabel.setFont(INSTRUCTIONS);
            generatorPanel.add(generatorLabel);
            JButton addGenerator = new JButton("+");
            addGenerator.addActionListener(this);
            addGenerator.setActionCommand("add generator");
            generatorPanel.add(addGenerator);
            JButton removeGenerator = new JButton("-");
            removeGenerator.addActionListener(this);
            removeGenerator.setActionCommand("remove generator");
            generatorPanel.add(removeGenerator);
            main.add(generatorPanel);
            
            JPanel flashlightPanel = new JPanel();
            flashlightPanel.setBackground(ALTERNATE);
            flashlightLabel = new JLabel("flashlights: " + name.flashlights);
            flashlightLabel.setForeground(TEXT);
            flashlightLabel.setFont(INSTRUCTIONS);
            flashlightPanel.add(flashlightLabel);
            JButton addFlashlight = new JButton("+");
            addFlashlight.addActionListener(this);
            addFlashlight.setActionCommand("add flashlight");
            flashlightPanel.add(addFlashlight);
            JButton removeFlashlight = new JButton("-");
            removeFlashlight.addActionListener(this);
            removeFlashlight.setActionCommand("remove flashlight");
            flashlightPanel.add(removeFlashlight);
            main.add(flashlightPanel);
            
            JPanel clothesPanel = new JPanel();
            clothesPanel.setBackground(BEHIND);
            clothesLabel = new JLabel("clothes and blankets: " + name.clothes);
            clothesLabel.setForeground(TEXT);
            clothesLabel.setFont(INSTRUCTIONS);
            clothesPanel.add(clothesLabel);
            JButton addClothes = new JButton("+");
            addClothes.addActionListener(this);
            addClothes.setActionCommand("add clothes");
            clothesPanel.add(addClothes);
            JButton removeClothes = new JButton("-");
            removeClothes.addActionListener(this);
            removeClothes.setActionCommand("remove clothes");
            clothesPanel.add(removeClothes);
            main.add(clothesPanel);
            
            JPanel otherStuff = new JPanel();
            otherStuff.setBackground(BACKGROUND);
            JLabel otherLabel = new JLabel("other:");
            otherLabel.setFont(INSTRUCTIONS);
            otherLabel.setForeground(TEXT);
            otherStuff.add(otherLabel);
            otherField = new JTextField(15);
            otherField.setFont(PLAN);
            otherField.setForeground(TEXT);
            otherField.setText(name.other);
            otherStuff.add(otherField);
            JButton save = new JButton("save");
            save.addActionListener(this);
            save.setActionCommand("save other");
            otherStuff.add(save);
            main.add(otherStuff);
            add(main, BorderLayout.CENTER);
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
            case "save other": name.other = otherField.getText();
                               break;
            case "neighborhood plan": MainScreen m = new MainScreen(myN, name, "neighborhood plan");
                                      m.setVisible(true);
                                      dispose();
                                      break;
            case "personal plan":     MainScreen n = new MainScreen(myN, name, "personal plan");
                                      n.setVisible(true);
                                      dispose();
                                      break;
            case "my supplies":     MainScreen o = new MainScreen(myN, name, "my supplies");
                                      o.setVisible(true);
                                      dispose();
                                      break;
            case "add food": name.food ++;
                             foodLabel.setText("food: " + name.food);
                             break;
            case "remove food": name.food --;
                             foodLabel.setText("food: " + name.food);
                             break;
            case "add water": name.water ++;
                             waterLabel.setText("water: " + name.water);
                             break;
            case "remove water": name.water --;
                             waterLabel.setText("water: " + name.water);
                             break;                 
            case "add generator": name.generators ++;
                             generatorLabel.setText("generators: " + name.generators);
                             break;
            case "remove generator": name.generators --;
                             generatorLabel.setText("generators: " + name.generators);
                             break;
            case "add aid": name.firstAid ++;
                             aidLabel.setText("first aid: " + name.firstAid);
                             break;
            case "remove aid": name.firstAid --;
                             aidLabel.setText("first aid: " + name.firstAid);
                             break;                 
            case "add flashlight": name.flashlights ++;
                             flashlightLabel.setText("flashlights: " + name.flashlights);
                             break;
            case "remove flashlight": name.flashlights --;
                             flashlightLabel.setText("flashlights: " + name.flashlights);
                             break;                 
            case "add clothes": name.clothes ++;
                             clothesLabel.setText("clothes and blankets: " + name.clothes);
                             break;
            case "remove clothes": name.clothes --;
                             clothesLabel.setText("clothes and blankets: " + name.clothes);
                             break;                 
        }
        
    }
    
    
}

