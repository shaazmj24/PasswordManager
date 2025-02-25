package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import persistence.JsonWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class JsonWriterTest { 
    private static final String TEST_FILE = "./data/testPasswords.txt";
    private JsonWriter testWriter; 
    private PasswordManager passwords; 
    private Password pass1;  

    @BeforeEach 
    void setUp() throws FileNotFoundException { 
        testWriter = new JsonWriter(new File(TEST_FILE));
        passwords = new PasswordManager(); 
        pass1 = new Password("tiger123", "facebook"); 
    } 

    @Test 
    void testWriterPasswords() throws IOException, IndexOutOfBoundsException { 
        passwords.addPasswordAccount(pass1, pass1.getAccount());

        //saves passwords in file 
        testWriter.write(passwords); 
        testWriter.close();

        // read them back in and verify the data is correct 
        PasswordManager passwords1 = Reader.readPasswords(new File(TEST_FILE)); 
        Password test = passwords1.searchPassword("facebook"); 
        assertEquals("tiger123", test);
        assertEquals(1, passwords1.listPasswords().size());
    }


}
