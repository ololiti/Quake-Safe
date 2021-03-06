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
        food.addActionListener(this);
        supplies.add(food);
        JMenuItem water = new JMenuItem("water");
        water.addActionListener(this);
        supplies.add(water);
        JMenuItem firstAid = new JMenuItem("first aid");
        firstAid.addActionListener(this);
        supplies.add(firstAid);
        JMenuItem generators = new JMenuItem("generators");
        generators.addActionListener(this);
        supplies.add(generators);
        JMenuItem flashlights = new JMenuItem("flashlights");
        flashlights.addActionListener(this);
        supplies.add(flashlights);
        JMenuItem clothes = new JMenuItem("clothes and blankets");
        clothes.addActionListener(this);
        supplies.add(clothes);
        JMenuItem other = new JMenuItem("other");
        other.addActionListener(this);
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
        } else if (tab.equals("food")){
            JPanel main = new JPanel();
            main.setBackground(BACKGROUND);
            main.setLayout(new GridLayout(myN.getAllPeople().size() + 1,2));
            
            JPanel suppliesPanel = new JPanel();
            supplies.setBackground(BACKGROUND);
            JLabel suppliesLabel = new JLabel("supplies: ");
            suppliesLabel.setFont(INSTRUCTIONS);
            suppliesLabel.setForeground(TEXT);
            suppliesPanel.add(suppliesLabel);
            main.add(suppliesLabel);
            
            JPanel namePanel = new JPanel();
            namePanel.setBackground(BACKGROUND);
            JLabel typeLabel = new JLabel("food");
            typeLabel.setFont(INSTRUCTIONS);
            typeLabel.setForeground(TEXT);
            namePanel.add(typeLabel);
            main.add(namePanel);
            
            for (int i = 0; i < myN.getAllPeople().size(); i++){
                JPanel j = new JPanel();
                if (i%2 == 0) j.setBackground(ALTERNATE);
                else j.setBackground(BEHIND);
                JLabel jl = new JLabel(myN.getAllPeople().get(i).toString());
                if (myN.getAllPeople().get(i).equals(name)) jl.setText("me");
                jl.setFont(INSTRUCTIONS);
                jl.setForeground(TEXT);
                j.add(jl);
                main.add(j);
                JPanel j1 = new JPanel();
                if (i%2 == 0) j1.setBackground(ALTERNATE);
                else j1.setBackground(BEHIND);
                JLabel jl1 = new JLabel(Integer.toString(myN.getAllPeople().get(i).food));
                jl1.setFont(INSTRUCTIONS);
                jl1.setForeground(TEXT);
                j1.add(jl1);
                main.add(j1);
            }
            add(main, BorderLayout.CENTER);
        } else if (tab.equals("water")){
            JPanel main = new JPanel();
            main.setBackground(BACKGROUND);
            main.setLayout(new GridLayout(myN.getAllPeople().size() + 1,2));
            
            JPanel suppliesPanel = new JPanel();
            supplies.setBackground(BACKGROUND);
            JLabel suppliesLabel = new JLabel("supplies: ");
            suppliesLabel.setFont(INSTRUCTIONS);
            suppliesLabel.setForeground(TEXT);
            suppliesPanel.add(suppliesLabel);
            main.add(suppliesLabel);
            
            JPanel namePanel = new JPanel();
            namePanel.setBackground(BACKGROUND);
            JLabel typeLabel = new JLabel("water");
            typeLabel.setFont(INSTRUCTIONS);
            typeLabel.setForeground(TEXT);
            namePanel.add(typeLabel);
            main.add(namePanel);
            
            for (int i = 0; i < myN.getAllPeople().size(); i++){
                JPanel j = new JPanel();
                if (i%2 == 0) j.setBackground(ALTERNATE);
                else j.setBackground(BEHIND);
                JLabel jl = new JLabel(myN.getAllPeople().get(i).toString());
                if (myN.getAllPeople().get(i).equals(name)) jl.setText("me");
                jl.setFont(INSTRUCTIONS);
                jl.setForeground(TEXT);
                j.add(jl);
                main.add(j);
                JPanel j1 = new JPanel();
                if (i%2 == 0) j1.setBackground(ALTERNATE);
                else j1.setBackground(BEHIND);
                JLabel jl1 = new JLabel(Integer.toString(myN.getAllPeople().get(i).water));
                jl1.setFont(INSTRUCTIONS);
                jl1.setForeground(TEXT);
                j1.add(jl1);
                main.add(j1);
            }
            add(main, BorderLayout.CENTER);
        } else if (tab.equals("first aid")){
            JPanel main = new JPanel();
            main.setBackground(BACKGROUND);
            main.setLayout(new GridLayout(myN.getAllPeople().size() + 1,2));
            
            JPanel suppliesPanel = new JPanel();
            supplies.setBackground(BACKGROUND);
            JLabel suppliesLabel = new JLabel("supplies: ");
            suppliesLabel.setFont(INSTRUCTIONS);
            suppliesLabel.setForeground(TEXT);
            suppliesPanel.add(suppliesLabel);
            main.add(suppliesLabel);
            
            JPanel namePanel = new JPanel();
            namePanel.setBackground(BACKGROUND);
            JLabel typeLabel = new JLabel("first aid");
            typeLabel.setFont(INSTRUCTIONS);
            typeLabel.setForeground(TEXT);
            namePanel.add(typeLabel);
            main.add(namePanel);
            
            for (int i = 0; i < myN.getAllPeople().size(); i++){
                JPanel j = new JPanel();
                if (i%2 == 0) j.setBackground(ALTERNATE);
                else j.setBackground(BEHIND);
                JLabel jl = new JLabel(myN.getAllPeople().get(i).toString());
                if (myN.getAllPeople().get(i).equals(name)) jl.setText("me");
                jl.setFont(INSTRUCTIONS);
                jl.setForeground(TEXT);
                j.add(jl);
                main.add(j);
                JPanel j1 = new JPanel();
                if (i%2 == 0) j1.setBackground(ALTERNATE);
                else j1.setBackground(BEHIND);
                JLabel jl1 = new JLabel(Integer.toString(myN.getAllPeople().get(i).firstAid));
                jl1.setFont(INSTRUCTIONS);
                jl1.setForeground(TEXT);
                j1.add(jl1);
                main.add(j1);
            }
            add(main, BorderLayout.CENTER);
        } else if (tab.equals("generators")){
            JPanel main = new JPanel();
            main.setBackground(BACKGROUND);
            main.setLayout(new GridLayout(myN.getAllPeople().size() + 1,2));
            
            JPanel suppliesPanel = new JPanel();
            supplies.setBackground(BACKGROUND);
            JLabel suppliesLabel = new JLabel("supplies: ");
            suppliesLabel.setFont(INSTRUCTIONS);
            suppliesLabel.setForeground(TEXT);
            suppliesPanel.add(suppliesLabel);
            main.add(suppliesLabel);
            
            JPanel namePanel = new JPanel();
            namePanel.setBackground(BACKGROUND);
            JLabel typeLabel = new JLabel("generators");
            typeLabel.setFont(INSTRUCTIONS);
            typeLabel.setForeground(TEXT);
            namePanel.add(typeLabel);
            main.add(namePanel);
            
            for (int i = 0; i < myN.getAllPeople().size(); i++){
                JPanel j = new JPanel();
                if (i%2 == 0) j.setBackground(ALTERNATE);
                else j.setBackground(BEHIND);
                JLabel jl = new JLabel(myN.getAllPeople().get(i).toString());
                if (myN.getAllPeople().get(i).equals(name)) jl.setText("me");
                jl.setFont(INSTRUCTIONS);
                jl.setForeground(TEXT);
                j.add(jl);
                main.add(j);
                JPanel j1 = new JPanel();
                if (i%2 == 0) j1.setBackground(ALTERNATE);
                else j1.setBackground(BEHIND);
                JLabel jl1 = new JLabel(Integer.toString(myN.getAllPeople().get(i).generators));
                jl1.setFont(INSTRUCTIONS);
                jl1.setForeground(TEXT);
                j1.add(jl1);
                main.add(j1);
            }
            add(main, BorderLayout.CENTER);
        } else if (tab.equals("flashlights")){
            JPanel main = new JPanel();
            main.setBackground(BACKGROUND);
            main.setLayout(new GridLayout(myN.getAllPeople().size() + 1,2));
            
            JPanel suppliesPanel = new JPanel();
            supplies.setBackground(BACKGROUND);
            JLabel suppliesLabel = new JLabel("supplies: ");
            suppliesLabel.setFont(INSTRUCTIONS);
            suppliesLabel.setForeground(TEXT);
            suppliesPanel.add(suppliesLabel);
            main.add(suppliesLabel);
            
            JPanel namePanel = new JPanel();
            namePanel.setBackground(BACKGROUND);
            JLabel typeLabel = new JLabel("flashlights");
            typeLabel.setFont(INSTRUCTIONS);
            typeLabel.setForeground(TEXT);
            namePanel.add(typeLabel);
            main.add(namePanel);
            
            for (int i = 0; i < myN.getAllPeople().size(); i++){
                JPanel j = new JPanel();
                if (i%2 == 0) j.setBackground(ALTERNATE);
                else j.setBackground(BEHIND);
                JLabel jl = new JLabel(myN.getAllPeople().get(i).toString());
                if (myN.getAllPeople().get(i).equals(name)) jl.setText("me");
                jl.setFont(INSTRUCTIONS);
                jl.setForeground(TEXT);
                j.add(jl);
                main.add(j);
                JPanel j1 = new JPanel();
                if (i%2 == 0) j1.setBackground(ALTERNATE);
                else j1.setBackground(BEHIND);
                JLabel jl1 = new JLabel(Integer.toString(myN.getAllPeople().get(i).flashlights));
                jl1.setFont(INSTRUCTIONS);
                jl1.setForeground(TEXT);
                j1.add(jl1);
                main.add(j1);
            }
            add(main, BorderLayout.CENTER);
        } else if (tab.equals("clothes and blankets")){
            JPanel main = new JPanel();
            main.setBackground(BACKGROUND);
            main.setLayout(new GridLayout(myN.getAllPeople().size() + 1,2));
            
            JPanel suppliesPanel = new JPanel();
            supplies.setBackground(BACKGROUND);
            JLabel suppliesLabel = new JLabel("supplies: ");
            suppliesLabel.setFont(INSTRUCTIONS);
            suppliesLabel.setForeground(TEXT);
            suppliesPanel.add(suppliesLabel);
            main.add(suppliesLabel);
            
            JPanel namePanel = new JPanel();
            namePanel.setBackground(BACKGROUND);
            JLabel typeLabel = new JLabel("clothes and blankets");
            typeLabel.setFont(INSTRUCTIONS);
            typeLabel.setForeground(TEXT);
            namePanel.add(typeLabel);
            main.add(namePanel);
            
            for (int i = 0; i < myN.getAllPeople().size(); i++){
                JPanel j = new JPanel();
                if (i%2 == 0) j.setBackground(ALTERNATE);
                else j.setBackground(BEHIND);
                JLabel jl = new JLabel(myN.getAllPeople().get(i).toString());
                if (myN.getAllPeople().get(i).equals(name)) jl.setText("me");
                jl.setFont(INSTRUCTIONS);
                jl.setForeground(TEXT);
                j.add(jl);
                main.add(j);
                JPanel j1 = new JPanel();
                if (i%2 == 0) j1.setBackground(ALTERNATE);
                else j1.setBackground(BEHIND);
                JLabel jl1 = new JLabel(Integer.toString(myN.getAllPeople().get(i).clothes));
                jl1.setFont(INSTRUCTIONS);
                jl1.setForeground(TEXT);
                j1.add(jl1);
                main.add(j1);
            }
            add(main, BorderLayout.CENTER);
        } else if (tab.equals("other")){
            JPanel main = new JPanel();
            main.setBackground(BACKGROUND);
            main.setLayout(new GridLayout(myN.getAllPeople().size() + 1,2));
            
            JPanel suppliesPanel = new JPanel();
            supplies.setBackground(BACKGROUND);
            JLabel suppliesLabel = new JLabel("supplies: ");
            suppliesLabel.setFont(INSTRUCTIONS);
            suppliesLabel.setForeground(TEXT);
            suppliesPanel.add(suppliesLabel);
            main.add(suppliesLabel);
            
            JPanel namePanel = new JPanel();
            namePanel.setBackground(BACKGROUND);
            JLabel typeLabel = new JLabel("other");
            typeLabel.setFont(INSTRUCTIONS);
            typeLabel.setForeground(TEXT);
            namePanel.add(typeLabel);
            main.add(namePanel);
            
            for (int i = 0; i < myN.getAllPeople().size(); i++){
                JPanel j = new JPanel();
                if (i%2 == 0) j.setBackground(ALTERNATE);
                else j.setBackground(BEHIND);
                JLabel jl = new JLabel(myN.getAllPeople().get(i).toString());
                if (myN.getAllPeople().get(i).equals(name)) jl.setText("me");
                jl.setFont(INSTRUCTIONS);
                jl.setForeground(TEXT);
                j.add(jl);
                main.add(j);
                JPanel j1 = new JPanel();
                if (i%2 == 0) j1.setBackground(ALTERNATE);
                else j1.setBackground(BEHIND);
                JLabel jl1 = new JLabel(myN.getAllPeople().get(i).other);
                jl1.setFont(INSTRUCTIONS);
                jl1.setForeground(TEXT);
                j1.add(jl1);
                main.add(j1);
            }
            add(main, BorderLayout.CENTER);
        }
    }
    public void actionPerformed(ActionEvent e){
        String message = e.getActionCommand();
        switch (message){
            case "save": myN.plan[0] = clearSpace.getText();
                         myN.plan[1] = badSpace.getText();
                         ObjectOutputStream output = null;
                        try{
                            output = new ObjectOutputStream(new FileOutputStream("accounts.bin"));
                            output.writeObject(ExpoHacksProject.neighborhoods);
                            output.close();
                        } catch (IOException g){
                            System.out.println("Output file not found.");
                            System.exit(0);
                        }
                         break;
            case "save personal": name.plan = personal.getText();
                                  ObjectOutputStream output2 = null;
                                try{
                                    output2 = new ObjectOutputStream(new FileOutputStream("accounts.bin"));
                                    output2.writeObject(ExpoHacksProject.neighborhoods);
                                    output2.close();
                                } catch (IOException g){
                                    System.out.println("Output file not found.");
                                    System.exit(0);
                                }
                                  break;
            case "save other": name.other = otherField.getText();
                               ObjectOutputStream output1 = null;
                                try{
                                    output1 = new ObjectOutputStream(new FileOutputStream("accounts.bin"));
                                    output1.writeObject(ExpoHacksProject.neighborhoods);
                                    output1.close();
                                } catch (IOException g){
                                    System.out.println("Output file not found.");
                                    System.exit(0);
                                }
                               break;
            case "neighborhood plan": MainScreen m = new MainScreen(myN, name, "neighborhood plan");
                                      m.setVisible(true);
                                      ObjectOutputStream output3 = null;
                                        try{
                                            output3 = new ObjectOutputStream(new FileOutputStream("accounts.bin"));
                                            output3.writeObject(ExpoHacksProject.neighborhoods);
                                            output3.close();
                                        } catch (IOException g){
                                            System.out.println("Output file not found.");
                                            System.exit(0);
                                        }
                                      dispose();
                                      break;
            case "personal plan":     MainScreen n = new MainScreen(myN, name, "personal plan");
                                      n.setVisible(true);
                                      ObjectOutputStream output4 = null;
                                    try{
                                        output4 = new ObjectOutputStream(new FileOutputStream("accounts.bin"));
                                        output4.writeObject(ExpoHacksProject.neighborhoods);
                                        output4.close();
                                    } catch (IOException g){
                                        System.out.println("Output file not found.");
                                        System.exit(0);
                                    }
                                      dispose();
                                      break;
            case "my supplies":     MainScreen o = new MainScreen(myN, name, "my supplies");
                                      o.setVisible(true);
                                      ObjectOutputStream output5 = null;
                                    try{
                                        output5 = new ObjectOutputStream(new FileOutputStream("accounts.bin"));
                                        output5.writeObject(ExpoHacksProject.neighborhoods);
                                        output5.close();
                                    } catch (IOException g){
                                        System.out.println("Output file not found.");
                                        System.exit(0);
                                    }
                                      dispose();
                                      break;
            case "food": MainScreen p = new MainScreen(myN, name, "food");
                                      p.setVisible(true);
                                      ObjectOutputStream output6 = null;
                                    try{
                                        output6 = new ObjectOutputStream(new FileOutputStream("accounts.bin"));
                                        output6.writeObject(ExpoHacksProject.neighborhoods);
                                        output6.close();
                                    } catch (IOException g){
                                        System.out.println("Output file not found.");
                                        System.exit(0);
                                    }
                                      dispose();
                                      break; 
            case "water": MainScreen q = new MainScreen(myN, name, "water");
                                      q.setVisible(true);
                                      ObjectOutputStream output7 = null;
                                    try{
                                        output7 = new ObjectOutputStream(new FileOutputStream("accounts.bin"));
                                        output7.writeObject(ExpoHacksProject.neighborhoods);
                                        output7.close();
                                    } catch (IOException g){
                                        System.out.println("Output file not found.");
                                        System.exit(0);
                                    }
                                      dispose();
                                      break; 
            case "generators": MainScreen r = new MainScreen(myN, name, "generators");
                                      r.setVisible(true);
                                      ObjectOutputStream output8 = null;
                                    try{
                                        output8= new ObjectOutputStream(new FileOutputStream("accounts.bin"));
                                        output8.writeObject(ExpoHacksProject.neighborhoods);
                                        output8.close();
                                    } catch (IOException g){
                                        System.out.println("Output file not found.");
                                        System.exit(0);
                                    }
                                      dispose();
                                      break; 
            case "first aid": MainScreen s = new MainScreen(myN, name, "first aid");
                                      s.setVisible(true);
                                      ObjectOutputStream output9 = null;
                                    try{
                                        output9 = new ObjectOutputStream(new FileOutputStream("accounts.bin"));
                                        output9.writeObject(ExpoHacksProject.neighborhoods);
                                        output9.close();
                                    } catch (IOException g){
                                        System.out.println("Output file not found.");
                                        System.exit(0);
                                    }
                                      dispose();
                                      break; 
            case "clothes and blankets": MainScreen t = new MainScreen(myN, name, "clothes and blankets");
                                      t.setVisible(true);
                                      ObjectOutputStream output10 = null;
                                    try{
                                        output10 = new ObjectOutputStream(new FileOutputStream("accounts.bin"));
                                        output10.writeObject(ExpoHacksProject.neighborhoods);
                                        output10.close();
                                    } catch (IOException g){
                                        System.out.println("Output file not found.");
                                        System.exit(0);
                                    }
                                      dispose();
                                      break;  
            case "flashlights": MainScreen u = new MainScreen(myN, name, "flashlights");
                                      u.setVisible(true);
                                      ObjectOutputStream output11 = null;
                                    try{
                                        output11 = new ObjectOutputStream(new FileOutputStream("accounts.bin"));
                                        output11.writeObject(ExpoHacksProject.neighborhoods);
                                        output11.close();
                                    } catch (IOException g){
                                        System.out.println("Output file not found.");
                                        System.exit(0);
                                    }
                                      dispose();
                                      break;  
            case "other": MainScreen v = new MainScreen(myN, name, "other");
                                      v.setVisible(true);
                                      ObjectOutputStream output12 = null;
                                    try{
                                        output12 = new ObjectOutputStream(new FileOutputStream("accounts.bin"));
                                        output12.writeObject(ExpoHacksProject.neighborhoods);
                                        output12.close();
                                    } catch (IOException g){
                                        System.out.println("Output file not found.");
                                        System.exit(0);
                                    }
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
