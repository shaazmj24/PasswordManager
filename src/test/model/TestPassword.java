package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPassword {
    private Password pass; 
    private Password pass1; 

    @BeforeEach
    void runBefore() { 
        pass = new Password("shaaz123", "facebook");
        pass1 = new Password("1234", "ubc");
    }

    @Test 
    void testConstructor() { 
        assertEquals("shaaz123", pass.getPassword());
        assertEquals("facebook", pass.getAccount());
        assertFalse(pass.isPassEncrypted);
        assertEquals("1234", pass.getPassword());
        assertEquals("ubc", pass.getAccount());
        assertFalse(pass1.isPassEncrypted);
    }

    @Test 
    void testEncrypt() { 
        assertFalse(pass.isPassEncrypted);
        pass.encrypt();
        assertEquals("vkddc123", pass.getPassword());
        assertTrue(pass.isPassEncrypted);
        assertFalse(pass1.isPassEncrypted);
        pass1.encrypt();
        assertEquals("1234", pass1.getPassword());
        assertTrue(pass1.isPassEncrypted);
    }

    @Test 
    void testDecrypt() { 
        pass.encrypt(); 
        assertEquals("vkddc123", pass.getPassword());
        pass.decrypt();
        assertEquals("shaaz123", pass.getPassword());
        pass1.encrypt();
        assertEquals("1234", pass1.getPassword());
        pass1.decrypt();
        assertEquals("1234", pass1.getPassword());
    }

    @Test 
    void testEncryptMutipleTimes() {  
        assertFalse(pass.isPassEncrypted);
        pass.encrypt();
        assertEquals("vkddc123", pass.getPassword());
        assertTrue(pass.isPassEncrypted);
        pass.encrypt(); 
        assertTrue(pass.isPassEncrypted);
        assertEquals("vkddc123", pass.getPassword());
    }



    
}
