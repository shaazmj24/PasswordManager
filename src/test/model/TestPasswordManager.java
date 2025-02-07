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

    @Test 
    void testAddPassAccMutiple() { 
        passwords.addPasswordAccount(pass, pass.getAccount());
        passwords.addPasswordAccount(pass1, pass1.getAccount()); 
        assertEquals(pass1, passwords.searchPassword("ubc"));
        assertEquals(pass, passwords.searchPassword("facebook"));
        passwords.addPasswordAccount(pass2, pass2.getAccount());
        assertTrue(pass2 == passwords.searchPassword("instagram"));
    }

    @Test 
    void testSearchPassword() { 
        passwords.addPasswordAccount(pass1, pass1.getAccount()); 
        assertEquals(pass1, passwords.searchPassword("ubc"));
        passwords.addPasswordAccount(pass2, pass2.getAccount());
        assertEquals(pass2, passwords.searchPassword("instagram"));
    }

    @Test 
    void testSearchPasswordIncorrect() {  
        passwords.addPasswordAccount(pass1, pass1.getAccount()); 
        passwords.addPasswordAccount(pass2, pass2.getAccount());
        assertFalse(pass1 == passwords.searchPassword("instagram"));
        assertFalse(pass2 == passwords.searchPassword("ubc"));
    }

    @Test 
    void testDelete() {  
        passwords.addPasswordAccount(pass, pass.getAccount());
        assertEquals(pass, passwords.searchPassword("facebook"));
        passwords.deletePassword("facebook");
        assertTrue(passwords.listPasswords().size() == 0);
        assertTrue(passwords.listAccounts().size() == 0);
    }

    @Test 
    void testDeleteMutipleTimes() {  
        passwords.addPasswordAccount(pass, pass.getAccount());
        passwords.addPasswordAccount(pass1, pass1.getAccount()); 
        passwords.addPasswordAccount(pass2, pass2.getAccount());
        passwords.deletePassword("ubc"); 
        assertTrue(passwords.listAccounts().size() == 2);
        passwords.deletePassword("facebook");
        assertTrue(passwords.listPasswords().size() == 1);
        passwords.deletePassword("instagram");
        assertTrue(passwords.listPasswords().size() == 0);
    }

    @Test 
    void testListPasswords() { 
        ArrayList<Password> listP = new ArrayList<>(); 
        assertTrue(passwords.listPasswords().size() == 0);
        passwords.addPasswordAccount(pass, pass.getAccount());
        passwords.addPasswordAccount(pass1, pass1.getAccount());
        assertTrue(passwords.listPasswords().size() == 2);
        listP.add(pass); 
        listP.add(pass1);
        assertEquals(listP, passwords.listPasswords());
    }

    @Test  
    void testListAccounts() { 
        ArrayList<String> listA = new ArrayList<>(); 
        assertTrue(passwords.listAccounts().size() == 0);
        passwords.addPasswordAccount(pass, pass.getAccount());
        passwords.addPasswordAccount(pass1, pass1.getAccount());
        assertTrue(passwords.listAccounts().size() == 2);
        listA.add("facebook"); 
        listA.add("ubc");
        assertEquals(listA, passwords.listAccounts());
    }
    

}
