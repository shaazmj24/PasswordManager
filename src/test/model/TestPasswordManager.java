package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestPasswordManager {
    private PasswordManager passwords;
    private Password pass;
    private Password pass1; 
    private Password pass2;
    
    @BeforeEach
    void runBefore() {
        passwords = new PasswordManager(); 
        pass = new Password("shaaz123", "facebook");
        pass2 = new Password("jello vorld", "instagram");
        pass1 = new Password("1234", "ubc");
    }

    @Test 
    void testConstructor() { 
        assertTrue(passwords.listPasswords().isEmpty());
        assertTrue(passwords.listAccounts().isEmpty());
        assertTrue(passwords.listPasswords().size() == 0);
        assertTrue(passwords.listAccounts().size() == 0);
    }

    @Test 
    void testAddPasswordAccount() { 
        passwords.addPasswordAccount(pass, pass.getAccount());
        assertEquals(pass, passwords.searchPassword("facebook"));
        ArrayList<String> passS = new ArrayList<>(); 
        ArrayList<String> accountS = new ArrayList();
        passS.add("shaaz123");
        accountS.add("facebook");
        assertEquals(passS, passwords.listPasswords());
        assertEquals(accountS, passwords.listAccounts());

    }


    

}
