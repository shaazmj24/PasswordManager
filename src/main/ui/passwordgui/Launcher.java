package ui.passwordgui;
      
import javax.imageio.ImageIO;
import javax.swing.*;

import model.Password;
import model.PasswordManager;

import java.awt.*;

public class Launcher { 
    private static JPanel mainPanel;  
    private static PasswordManager pm = new PasswordManager(); 


    public static void main(String[] args) {  
        // creates Frame 
        JFrame frame = new JFrame();  
        frame.setTitle("Password Manager"); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application  
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
        frame.setVisible(true);
    }
 
    // EFFECT: add buttons to panel
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

 
}





