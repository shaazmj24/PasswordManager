package model;

import model.Password;
import model.PasswordManager;
import persistence.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest {   
    private static final String TEST_FILE = "./data/passwords1.json";
    private PasswordManager passwords; 
    private Password pass2; 
    
    // Test readPassword method 
    @Test 
    void testReadPasswords() throws IOException, IndexOutOfBoundsException {    
        JsonWriter file = new JsonWriter(new File(TEST_FILE));
        pass2 = new Password("catdog", "ubc"); 
        pass2.encrypt(); 
        passwords = new PasswordManager(); 
        passwords.addPasswordAccount(pass2, "ubc");
        file.write(passwords);
        file.close(); 
        JsonReader r = new JsonReader();
        PasswordManager testPasswords = JsonReader.readPasswords(new File(TEST_FILE)); 
        assertEquals(1, testPasswords.listPasswords().size());
        assertEquals(1, testPasswords.listAccounts().size()); 
        assertEquals("fdwgrj", testPasswords.searchPassword("ubc").getPassword());
        assertTrue(testPasswords.searchPassword("ubc").getIsEncrypted());
        Password pass = testPasswords.searchPassword("ubc");  
        pass.decrypt();
        assertEquals("catdog", pass.getPassword());
        assertFalse(testPasswords.searchPassword("ubc").getIsEncrypted());
    }
}