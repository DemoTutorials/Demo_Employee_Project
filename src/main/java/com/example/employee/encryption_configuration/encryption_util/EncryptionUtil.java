package com.example.employee.encryption_configuration.encryption_util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@Component
public class EncryptionUtil {
    private static String secretKey;
    private static final String ALGORITHM="AES";

    @Value("${encryption.secretKey}")
    public void setSecretKey(String key) {
        secretKey=(key+"0123456789abcedefghi").substring(0,16);
    }

    public static String encrypt(String data) throws Exception{
        if(data==null)
            return null;
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE,new SecretKeySpec(secretKey.getBytes(),ALGORITHM));
        byte[] encoded = cipher.doFinal(data.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encoded);
    }

    public static String decrypt(String encryptedData)throws Exception {
        if(encryptedData==null)
            return null;
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE,new SecretKeySpec(secretKey.getBytes(),ALGORITHM));
        byte[] decode = Base64.getDecoder().decode(encryptedData);
        return new String(cipher.doFinal(decode),"UTF-8");
    }
}
