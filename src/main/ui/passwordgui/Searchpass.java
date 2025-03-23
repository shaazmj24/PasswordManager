package ui.passwordgui;

import model.Password;
import model.PasswordManager;

import java.awt.event.ActionListener;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.*;

public class Searchpass extends JPanel implements ActionListener { 
    private JButton button3; 
    private JPanel mainPanel;  
    private JButton search;  
    private String account; 
    private JTextField enterAccount; 
    private JLabel message; 
    private PasswordManager pm;  
    JButton back; 

    public Searchpass(JPanel mainPanel, PasswordManager pm) {  
        button3 = new JButton("Search Password"); 
        button3.addActionListener(this); 
        this.mainPanel = mainPanel; 
        search = new JButton("Search"); 
        search.addActionListener(this); 
        this.pm = pm; 
        back = new JButton("Back"); 
        back.addActionListener(this); 
    } 

    @Override 
    public void actionPerformed(ActionEvent e) {  
        if (e.getSource() == button3) {  
            openNewPage(); // call method to create new page 
        } 
        if (e.getSource() == search) {   
            search();  
        } 
        if (e.getSource() == back) { 
            back(); 
        }
    }

    public void openNewPage() {  
        JPanel newPage = new JPanel();  
        newPage.setLayout(new GridBagLayout()); 
        newPage.setVisible(true);
        content(newPage); 
        mainPanel.add(newPage, "Search"); 

        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();  
        cardLayout.show(mainPanel, "Search");
    }


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
        newPage.add(search, gbc); 
    }

    public void search() {  
        account = enterAccount.getText().trim(); 
        Password ps = pm.searchPassword(account); 
        messagePass(ps, account); 
    }

    public void messagePass(Password ps, String acc) {    
        JPanel panelM = new JPanel(); 
        panelM.setLayout(new GridBagLayout());
        if (ps == null) {  
            message = new JLabel("Account not found"); 
        } else {  
            String stringPassword = ps.getPassword();      
            String mess = "Password for " + acc + ": " + stringPassword;   
            message = new JLabel(mess);  
        }   
        
        message.setFont(new Font("Arial", Font.BOLD, 23));
        GridBagConstraints gbc = new GridBagConstraints(); 
        //add label 
        gbc.gridx = 0; 
        gbc.gridy = 0; 
        gbc.insets = new Insets(10, 10, 10, 10); 
        gbc.anchor = GridBagConstraints.CENTER; 
        panelM.add(message, gbc); 

        // add back below 
        gbc.gridy = 1; 
        panelM.add(back, gbc); 

        mainPanel.add(panelM, "message"); 
        CardLayout cardLayout1 = (CardLayout) mainPanel.getLayout();  
        cardLayout1.show(mainPanel, "message");
    }

    public void back() {  
        CardLayout c = (CardLayout) mainPanel.getLayout(); 
        c.show(mainPanel, "MainMenu"); 
    }

    public JButton getButton() { 
        return button3; 
    }
}













