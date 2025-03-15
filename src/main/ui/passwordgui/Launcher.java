package ui.passwordgui;
      
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

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
        Storepass = new Storepass(); 
        Encryptpass = new Encryptpass();
        Searchpass = new Searchpass();
        Deletepass = new Deletepass();
        // add button options and vertical glue at top and bottom to center
        panel.add(Box.createVerticalGlue()); 
        panel.add(Box.createVerticalStrut(space)); 
        panel.add(createButton(Storepass.getButton())); 
        panel.add(Box.createVerticalStrut(space)); 
        panel.add(createButton(Encryptpass.getButton()));  
        panel.add(Box.createVerticalStrut(space)); 
        panel.add(createButton(Searchpass.getButton())); 
        panel.add(Box.createVerticalStrut(space)); 
        panel.add(createButton(Deletepass.getButton())); 
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
