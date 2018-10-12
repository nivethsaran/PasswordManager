package crypt;
import java.util.*;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
public class Encrypt {
	private static final String key = "aesEncryptionKey";
	private static final String initVector = "encryptionIntVec";
 public static String encryeasy(String s)
{
	 
		int n;
		n=s.length();
		int x;
		if(n%2==1)
			 x=n-1;
		else
			 x=n;
		char []ch=s.toCharArray() ;
		for(int j=0;j<x;j=j+2)
		{
			char temp;
			temp=ch[j];
			ch[j]=ch[j+1];
			ch[j+1]=temp;
		}
		for(int j=0;j<ch.length;++j)
		{
	ch[j]=alphaMirror(ch[j]);
		}
		String b=new String(ch);
		return b;
	}


private static char alphaMirror(char c) {
 int maxAdvance = 25;

 int diff = c - ((c > 'Z') ? 'a' : 'A');

 int advance = maxAdvance - 2 * diff;

 return (char) (c + advance);
}


public static String aesencrypt(String value) {

    try {

        IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));

        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");

        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

 

        byte[] encrypted = cipher.doFinal(value.getBytes());

        return Base64.getEncoder().encodeToString(cipher.doFinal(encrypted));

    } catch (Exception ex) {

        ex.printStackTrace();

    }

    return null;

}
}