package ui.passwordgui;
import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import ui.passwordgui.Storepass; 

public class Storepass extends JFrame implements ActionListener {  
    private JButton button1; 

    // EFFECT: construct button1
    public Storepass() {    
        button1 = new JButton("Store Password");  
        button1.addActionListener(this); 
    }   

    @Override 
    public void actionPerformed(ActionEvent e) {  
        if (e.getSource() == button1) {  
            openNewFrame(); // call method to create new frame 
        }
    }

    public void openNewFrame() { 
        JFrame newFrame = new JFrame("Store Password");  
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newFrame.setLayout(new FlowLayout()); 
        newFrame.setVisible(true);
    }

    public JButton getButton() { 
        return button1; 
    }



}
