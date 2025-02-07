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
        this.password = password; 
        this.account = account; 
        isPassEncrypted = false;
    }

    // MODIFIES: this
    // EFFECT: Encrypts this password and set isPassEncrypted to true
    // if isPassEncrypted is already true, does nothing
    public void encrypt() { 
        String encryptedPass = "";
        if (isPassEncrypted == false) {   
            for (int i = 0; i < password.length(); i++) {  
                char c = (char) (password.charAt(i) + 3); 
                encryptedPass += c;
            }
            this.password = encryptedPass; 
            isPassEncrypted = true;
        }
    }

    // MODIFIES: this 
    // EFFECT: Decrypt the encrypted password
    public void decrypt() { 
        String decryptPass = "";
        for (int i = 0; i < password.length(); i++) { 
            char c = (char) (password.charAt(i) - 3); 
            decryptPass += c;
        }
        this.password = decryptPass; 
        isPassEncrypted = false; 
    }

    // EFFECT: Returns account name associated with password 
    public String getAccount() { 
        return account; 
    }

    // EFFECT: Returns the password 
    public String getPassword() { 
        return password; 
    }

    // Effect: Returns Encryption boolean
    public boolean getIsEncrypted() { 
        return isPassEncrypted;
    }







    

}
