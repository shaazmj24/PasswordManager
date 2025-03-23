package ui.passwordgui;

import model.Password;
import model.PasswordManager;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import ui.passwordgui.Storepass;

public class Deletepass extends JPanel implements ActionListener {  
    private JButton button4; 
    private JButton delete; 
    private JPanel mainPanel; 
    private JTextField enterAccount; 
    private JButton back; 
    private PasswordManager pm;

    //EFFECT: construct a delete panel, content and its buttons
    public Deletepass(JPanel mainPanel, PasswordManager pm) {  
        button4 = new JButton("Delete Password"); 
        button4.addActionListener(this); 
        delete = new JButton("Delete"); 
        delete.addActionListener(this);  
        this.mainPanel = mainPanel; 
        this.pm = pm; 
        back = new JButton("Back"); 
        back.addActionListener(this); 
    }  

    //EFFECT: action buttons
    @Override 
    public void actionPerformed(ActionEvent e) {  
        if (e.getSource() == button4) {  
            openNewPage(); // call method to create new frame 
        } 
        if (e.getSource() == delete) {   
            String account = enterAccount.getText().trim();  
            deletePassword(account);
        }
        if (e.getSource() == back) {  
            returnMain(); 
        }
    }

    //EFFECT: create a new panel when delete button is clicked
    public void openNewPage() {  
        JPanel newPage = new JPanel();  
        newPage.setLayout(new GridBagLayout()); 
        newPage.setVisible(true);
        content(newPage); 
        mainPanel.add(newPage, "delete"); 

        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();  
        cardLayout.show(mainPanel, "delete");
    }

    //EFFECT: create delete content
    public void content(JPanel newPage) {  
        GridBagConstraints gbc = new GridBagConstraints(); 
        // Label1: Enter Account
        JLabel label1 = new JLabel("Enter Account:");  
        label1.setFont(new Font("Arial", Font.BOLD, 23)); 
        gbc.gridx = 0; 
        gbc.gridy = 1; 
        gbc.anchor = GridBagConstraints.LAST_LINE_END; 
        gbc.insets = new Insets(10, 10, 10, 10); 
        newPage.add(label1, gbc);

        // Account field  
        enterAccount = new JTextField(); 
        enterAccount.setPreferredSize(new Dimension(250, 40));
        gbc.gridx = 1; 
        gbc.gridy = 1; 
        gbc.anchor = GridBagConstraints.LAST_LINE_START; 
        newPage.add(enterAccount, gbc); 

        // sumbit button  
        gbc.gridx = 1; 
        gbc.gridy = 2; 
        gbc.anchor = GridBagConstraints.CENTER; 
        newPage.add(delete, gbc); 
    }

    //EFFECT: action when deletPass button is clicked
    public void deletePassword(String acc) {       
        String message = pm.deletePassword(acc); 
        JLabel deleteLabel = new JLabel(message); 
        deleteLabel.setFont(new Font("Arial", Font.BOLD, 23)); 
        JPanel deletePanel = new JPanel(new GridBagLayout()); 
        deletePanel.setVisible(true); 

        GridBagConstraints gbc = new GridBagConstraints(); 
        // add label 
        gbc.gridx = 0; 
        gbc.gridy = 0; 
        gbc.insets = new Insets(10, 10, 10, 10); 
        gbc.anchor = GridBagConstraints.CENTER; 
        deletePanel.add(deleteLabel, gbc); 

        // add back below 
        gbc.gridy = 1; 
        deletePanel.add(back, gbc); 

        mainPanel.add(deletePanel, "d");
        CardLayout c = (CardLayout) mainPanel.getLayout(); 
        c.show(mainPanel, "d"); 
    }

    //EFFECT: returns to main menu panel when back is clicked
    public void returnMain() {  
        CardLayout c = (CardLayout) mainPanel.getLayout(); 
        c.show(mainPanel, "MainMenu"); 
    }


    public JButton getButton() { 
        return button4; 
    }




}





