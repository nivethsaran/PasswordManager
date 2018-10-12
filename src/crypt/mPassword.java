package crypt;

public class mPassword extends Password {
private String mpassword;
	public mPassword(String password) {
		super(password);
		mpassword=password;
		
	}
	public static String getEncryptedPassword(String password)
	{
		return Encrypt.aesencrypt(password);
	}
	public String getNormalPass()
	{
		return mpassword; 
	}

}
