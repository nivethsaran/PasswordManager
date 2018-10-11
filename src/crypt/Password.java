package crypt;

public class Password {
		
		String encryptedPass;
		public Password(String password)
		{
				this.encryptedPass=encryptPassword(password);
		}
		
		void changePassword(String newPassword)
		{
			encryptedPass=newPassword;
			//hello
		}
		public String encryptPassword(String unEnPass)
		{
			return unEnPass;
		}
		public String getEncryptedPassword()
		{
			return encryptedPass;
		}
}
