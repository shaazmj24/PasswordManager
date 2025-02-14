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
        assertEquals(0, passwords.listPasswords().size());
        assertTrue(passwords.listAccounts().size() == 0);
    }

    @Test 
    void testAddPasswordAccount() { 
        passwords.addPasswordAccount(pass, pass.getAccount());
        assertEquals(pass, passwords.searchPassword("facebook"));
        ArrayList<Password> passS = new ArrayList<>(); 
        ArrayList<String> accountS = new ArrayList<>();
        passS.add(pass);
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
        ArrayList<Password> passS = new ArrayList<>(); 
        passS.add(pass); 
        passS.add(pass1);
        assertEquals(passS, passwords.listPasswords());
        assertEquals(2, passwords.listPasswords().size());
        passwords.addPasswordAccount(pass2, pass2.getAccount());
        assertTrue(pass2 == passwords.searchPassword("instagram"));
        passS.add(pass2); 
        assertEquals(passS, passwords.listPasswords());
        assertEquals(3, passwords.listPasswords().size());
        assertTrue(passwords.listAccounts().size() == 3);
    }

    @Test 
    void testSearchPassword() { 
        passwords.addPasswordAccount(pass1, pass1.getAccount()); 
        assertEquals(pass1, passwords.searchPassword("ubc"));
        passwords.addPasswordAccount(pass2, pass2.getAccount());
        assertEquals(pass2, passwords.searchPassword("instagram"));
        assertNull(passwords.searchPassword("email"));
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
        assertTrue(passwords.listPasswords().size() == 1);
        assertTrue(passwords.listAccounts().size() == 1);
        assertEquals("Password deleted successfully", passwords.deletePassword("facebook"));
        assertTrue(passwords.listPasswords().size() == 0);
        assertTrue(passwords.listAccounts().size() == 0);
    }
    
    @Test 
    void testDeleteMutipleTimes() {  
        passwords.addPasswordAccount(pass, pass.getAccount());
        passwords.addPasswordAccount(pass1, pass1.getAccount()); 
        passwords.addPasswordAccount(pass2, pass2.getAccount());
        assertTrue(passwords.listAccounts().size() == 3);
        assertEquals("Password deleted successfully", passwords.deletePassword("ubc"));
        assertTrue(passwords.listAccounts().size() == 2);
        assertEquals("Password deleted successfully", passwords.deletePassword("facebook"));
        assertTrue(passwords.listPasswords().size() == 1);
        assertEquals("account not found", passwords.deletePassword("email"));
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
