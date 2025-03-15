package ui.passwordgui;
      
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class Launcher { 
    public static void main(String[] args) {  
        // creates Frame 
        JFrame frame = new JFrame();  
        frame.setTitle("Password Manager"); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application  
        frame.setSize(400, 400); 
        frame.setVisible(true);     

        // JPanel = Gui component that functions as a container to hold other components
        JPanel panel = new JPanel();  
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Y_axis for vertical alignment
        addButtons(panel, 30); 
        // add panel to frame 
        frame.add(panel);
    }
 
    // EFFECT: add buttons to panel
    public static void addButtons(JPanel panel, int space) { 
        Storepass button1 = new Storepass(); 
        Encryptpass button2 = new Encryptpass();
        Searchpass button3 = new Searchpass();
        Deletepass button4 = new Deletepass();
        // add button options and vertical glue at top and bottom to center
        panel.add(Box.createVerticalGlue()); 
        panel.add(Box.createVerticalStrut(space)); 
        panel.add(createButton(button1.getButton())); 
        panel.add(Box.createVerticalStrut(space)); 
        panel.add(createButton(button2.getButton()));  
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
 