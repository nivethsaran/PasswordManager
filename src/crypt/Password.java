package crypt;

public class Password {
		
		String encryptedPass;
		public Password(String password)
		{
				this.encryptedPass=encryptPassword(password);
		}
		
		public String encryptPassword(String unEnPass)
		{
			return Encrypt.encryeasy(unEnPass);
		}
		public String getEncryptedPassword()
		{
			return encryptedPass;
		}
}
