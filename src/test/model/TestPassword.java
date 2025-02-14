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
        assertFalse(pass.getIsEncrypted());
        assertEquals("1234", pass1.getPassword());
        assertEquals("ubc", pass1.getAccount());
        assertFalse(pass1.getIsEncrypted());
    }

    @Test 
    void testEncrypt() { 
        assertFalse(pass.getIsEncrypted());
        pass.encrypt();
        assertEquals("vkdd}456", pass.getPassword());
        assertTrue(pass.getIsEncrypted());
        assertFalse(pass1.getIsEncrypted());
        pass1.encrypt();
        assertEquals("4567", pass1.getPassword());
        assertTrue(pass1.getIsEncrypted());
    }
    
    @Test 
    void testDecrypt() { 
        pass.encrypt(); 
        assertEquals("vkdd}456", pass.getPassword());
        assertTrue(pass.getIsEncrypted());
        pass.decrypt();
        assertEquals("shaaz123", pass.getPassword());
        assertFalse(pass.getIsEncrypted());
        pass1.encrypt();
        assertEquals("4567", pass1.getPassword());
        pass1.decrypt();
        assertEquals("1234", pass1.getPassword());
        assertFalse(pass1.getIsEncrypted());
    }

    @Test 
    void testEncryptMutipleTimes() {  
        assertFalse(pass.getIsEncrypted());
        pass.encrypt();
        assertEquals("vkdd}456", pass.getPassword());
        assertTrue(pass.getIsEncrypted());
        pass.encrypt(); 
        assertTrue(pass.getIsEncrypted());
        assertEquals("vkdd}456", pass.getPassword());
    }


 
    
}
