package model;

// Represents a password associated with an account, 
// with functionality to encrypt and decrypt it.
public class Password { 
    private String password;  
    private String account;         
    private boolean isPassEncrypted; //whether password is encrypted (true) or not

    // EFFECT: Constructs a Password object with the given password
    // and account name and set isPassEncrypted to false.
    public Password(String password, String account) { 

    }

    // MODIFIES: this
    // EFFECT: Encrypts this password and set isPassEncrypted to true
    // if isPassEncrypted is already true, does nothing
    public void encrypt() { 

    }

    // MODIFIES: this 
    // EFFECT: Decrypt the encrypted password
    public void decrypt() { 

    }

    // EFFECT: Returns account name associated with password 
    public String getAccount() { 
        return account; 
    }

    // EFFECT: Returns the password 
    public String getPassword() { 
        return password; 
    }







    

}
