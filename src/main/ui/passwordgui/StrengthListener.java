package ui.passwordgui;

import model.Password;
import model.PasswordManager;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import ui.passwordgui.Storepass; 

public class StrengthListener implements javax.swing.event.DocumentListener {  
    private JLabel strength;
    private JTextField enterPassword; 

    public StrengthListener(JLabel strength, JTextField enterPassword) {  
        this.enterPassword = enterPassword; 
        this.strength = strength; 
    }
    
    @Override 
    public void insertUpdate(javax.swing.event.DocumentEvent e) { 
        updateStrengthColor(); 
    } 
    
    @Override 
    public void removeUpdate(javax.swing.event.DocumentEvent e) { 
        updateStrengthColor(); 
    } 
    
    @Override 
    public void changedUpdate(javax.swing.event.DocumentEvent e) { 
        updateStrengthColor(); 
    }

    private void updateStrengthColor() {
        String text = enterPassword.getText();
        if (text.length() > 12) {
            strength.setForeground(Color.RED);
            strength.setText("Strength: Strong");
        } else if (text.length() >= 8) {
            strength.setForeground(Color.ORANGE);
            strength.setText("Strength: Moderate");
        } else {
            strength.setForeground(Color.GREEN.darker());
            strength.setText("Strength: Weak");
        }
    }
    
    
}
