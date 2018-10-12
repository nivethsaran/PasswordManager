package crypt;

import java.util.Base64;


import javax.crypto.Cipher;
import javax.crypto.spec.*;


class aes{
private static final String key = "aesEncryptionKey";
private static final String initVector = "encryptionIntVec";
public static String encrypt(String value) {

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