package com.jdai.SpringBootBLog.util;

import org.springframework.util.DigestUtils;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {

    public static String jdkMd5(String password){
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter
                .printHexBinary(digest).toUpperCase();

        return myHash;
    }

    public static String springMd5(String password){
        String md5Hex = DigestUtils.md5DigestAsHex(password.getBytes());
        return md5Hex;
    }
}
