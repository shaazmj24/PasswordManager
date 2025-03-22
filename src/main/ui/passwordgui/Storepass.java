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

public class Storepass extends JPanel implements ActionListener {  
    private JButton button1; 
    private JPanel mainPanel; 
    private JButton submit; 
    private JTextField enterPassword; 
    private JTextField enterAccount; 
    private PasswordManager pm; 

    // EFFECT: construct button1
    public Storepass(JPanel mainPanel, PasswordManager pm) {    
        button1 = new JButton("Store Password");  
        button1.addActionListener(this); 
        this.mainPanel = mainPanel; 
        submit = new JButton("Submit");
        submit.addActionListener(this);  
        this.pm = pm; 
    }   

    @Override 
    public void actionPerformed(ActionEvent e) {  
        if (e.getSource() == button1) {  
            openNewPage(); // call method to create new frame 
        } 
        if (e.getSource() == submit) {   
            String account = enterAccount.getText().trim(); 
            String password = enterPassword.getText().trim(); 
            storePassword(password, account);
            returnMain();
        }
    }

    public void openNewPage() { 
        JPanel newPage = new JPanel();  
        newPage.setLayout(new GridBagLayout()); 
        newPage.setVisible(true);
        content(newPage); 
        mainPanel.add(newPage, "StorePassword"); 

        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();  
        cardLayout.show(mainPanel, "StorePassword");
    }

    public void content(JPanel newPage) {  
        GridBagConstraints gbc = new GridBagConstraints(); 
        // Label1: Enter Password
        JLabel label1 = new JLabel("Enter Password:");  
        label1.setFont(new Font("Arial", Font.BOLD, 23)); 
        gbc.gridx = 0; 
        gbc.gridy = 1; 
        gbc.anchor = GridBagConstraints.LAST_LINE_END; 
        gbc.insets = new Insets(10, 10, 10, 10); 
        newPage.add(label1, gbc); 

        // Password field  
        enterPassword = new JTextField(); 
        enterPassword.setPreferredSize(new Dimension(250, 40));
        gbc.gridx = 1;      //1
        gbc.gridy = 1;      //1
        gbc.anchor = GridBagConstraints.LAST_LINE_START; 
        newPage.add(enterPassword, gbc);  

        // Label2: Enter Account  
        JLabel label2 = new JLabel("Enter Account:"); 
        label2.setFont(new Font("Arial", Font.BOLD, 23));
        gbc.gridx = 0; 
        gbc.gridy = 0; 
        gbc.anchor = GridBagConstraints.LINE_END; 
        newPage.add(label2, gbc); 

        // Account field  
        enterAccount = new JTextField(); 
        enterAccount.setPreferredSize(new Dimension(250, 40));
        gbc.gridx = 1;     //1 
        gbc.gridy = 0;     //0
        gbc.anchor = GridBagConstraints.LAST_LINE_START; 
        newPage.add(enterAccount, gbc); 

        // sumbit button  
        gbc.gridx = 1; 
        gbc.gridy = 2; 
        gbc.anchor = GridBagConstraints.CENTER; 
        newPage.add(submit, gbc); 
    }

    public void storePassword(String pass, String acc) {  
        Password p = new Password(pass, acc);  
        pm.addPasswordAccount(p, acc); 
    } 

    public void returnMain() {  
        CardLayout c = (CardLayout) mainPanel.getLayout(); 
        c.show(mainPanel, "MainMenu"); 
    }

    public JButton getButton() { 
        return button1; 
    }



}








