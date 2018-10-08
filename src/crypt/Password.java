package crypt;

public class Password {
		
		String encryptedPass;
		public Password(String password)
		{
				this.encryptedPass=password;
		}
		
		void changePassword(String newPassword)
		{
			encryptedPass=newPassword;
			//hello
		}
}
