package cn.amos.security.common.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

/**
 * DES加密，对称加密算法，知道秘钥可以解密密文；
 * 密钥至少为8位字符，56位的密钥以及附加的 8位奇偶校验位，每组的第8位作为奇偶校验位；
 *
 * @author Daoyuan
 */
public class EncryptionUtil {

    public static String encrypt(String sourceText, String keyString) {
        if (sourceText == null || sourceText.length() == 0) {
            return null;
        }
        try {
            // DES算法要求有一个可信任的随机数源
            Cipher cipher = getCipher(keyString, Cipher.ENCRYPT_MODE);
            byte[] data = sourceText.getBytes();
            // 加密
            byte[] encryptedData = cipher.doFinal(data);
            // 转成16进制串
            return HexString.bytes2HexStr(encryptedData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decrypt(String cipherText, String keyString) {
        if (cipherText == null || cipherText.length() == 0) {
            return null;
        }
        try {
            Cipher cipher = getCipher(keyString, Cipher.DECRYPT_MODE);
            // 将十六进制串转成字节数组
            byte[] data = HexString.hex2Byte(cipherText);
            // 解密
            byte[] decryptedData = cipher.doFinal(data);

            return new String(decryptedData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Cipher getCipher(String keyString, int decryptMode) throws Exception {
        // DES算法要求有一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
        // 从原始密钥数据创建一个DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(keyString.getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey key = keyFactory.generateSecret(dks);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance("DES");
        // 使用密钥初始化Cipher对象
        cipher.init(decryptMode, key, sr);
        return cipher;
    }

}