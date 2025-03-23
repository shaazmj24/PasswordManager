package ui.passwordgui;
      
import javax.imageio.ImageIO;
import javax.swing.*;

import model.Password;
import model.PasswordManager;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

// PasswordManager GUI 
public class Launcher { 
    private static JPanel mainPanel;  
    private static PasswordManager pm = new PasswordManager(); 
    private static final String JSON_STORE = "./data/passwordstore.json";
    private static JsonWriter jw; 
    private static JFrame frame; 

    public static void main(String[] args) {  
        // creates Frame 
        frame = new JFrame();  
        frame.setTitle("Password Manager"); 
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // exit out of application  
        frame.setSize(400, 400);  
        
        // JPanel = Gui component that functions as a container to hold other component
        // create panel with cardlayout which switch pages within this frame
        mainPanel = new JPanel(new CardLayout()); 

        // create menu panel 
        JPanel mainMenuPanel = new JPanel(); 
        mainMenuPanel.setLayout(new BoxLayout(mainMenuPanel, BoxLayout.Y_AXIS)); // Y_axis for vertical alignment

        addButtons(mainPanel, mainMenuPanel, 30); 
        // add panels to the main panel with cardlayout 
        mainPanel.add(mainMenuPanel, "MainMenu"); 

        // add mainpanel to frame 
        frame.add(mainPanel);
        // pop up load option
        int loadChoice = JOptionPane.showConfirmDialog(null, "Would you like to load saved passwords?", 
                   "Load Passwords", JOptionPane.YES_NO_OPTION); 

        if (loadChoice == JOptionPane.YES_OPTION) { 
            load(); 
        }
        frame.setVisible(true);
        saveOption(); 
    }

    //EFFECT: save passwords
    public static void saveOption() {   
        frame.addWindowListener(new WindowAdapter() { 
            @Override 
            public void windowClosing(WindowEvent e) { 
                int saveChoice = JOptionPane.showConfirmDialog(null,   
                         "Would you like to save your passwords before exiting?", "Save Passwords", 
                         JOptionPane.YES_NO_OPTION); 

                        if (saveChoice == JOptionPane.YES_OPTION) {  
                            save();  
                        } 
                        System.exit(0);  
                    } 
                }); 
    }
 
    // EFFECT: add buttons to main panel
    public static void addButtons(JPanel mainPanel, JPanel panel, int space) {    

        Storepass button1 = new Storepass(mainPanel, pm); 
        Searchpass button3 = new Searchpass(mainPanel, pm);
        Deletepass button4 = new Deletepass(mainPanel, pm);
        // add button options and vertical glue at top and bottom to center
        panel.add(Box.createVerticalGlue()); 
        panel.add(Box.createVerticalStrut(space)); 
        panel.add(createButton(button1.getButton())); 
        panel.add(Box.createVerticalStrut(space)); 
        panel.add(createButton(button3.getButton())); 
        panel.add(Box.createVerticalStrut(space)); 
        panel.add(createButton(button4.getButton())); 
        panel.add(Box.createVerticalStrut(space)); 
        panel.add(Box.createVerticalGlue()); 
    }

    // EFFECT: helper method to create buttons with consistent and alignement 
    public static JButton createButton(JButton button) {  
        button.setPreferredSize(new Dimension(300, 100));
        button.setMaximumSize(new Dimension(500, 350)); 
        button.setAlignmentX(Component.CENTER_ALIGNMENT); // centers the button in box layout 
        return button; 
    } 

    // MODIFIES: this
    // EFFECT: saves the data to file 
    private static void save() {     
        try {   
            jw = new JsonWriter(new File(JSON_STORE)); 
            jw.write(pm);
            jw.close(); 
        } catch (FileNotFoundException e) { 
            System.out.println("not found");
        } 
    } 

    // EFFECT: loads data from file
    private static void load() {  
        try { 
            PasswordManager load = JsonReader.readPasswords(new File(JSON_STORE));  
            pm.setMap(load.passwords);
        } catch (IOException e) { 
            System.out.println("Unable to read from file:" + JSON_STORE);
        }
    }  

 
}





