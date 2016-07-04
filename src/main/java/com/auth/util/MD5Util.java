package com.auth.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.File;
import java.security.MessageDigest;

/**
 * Created by yuxb on 16/6/22.
 */
public class MD5Util {
    static Logger logger= LoggerFactory.getLogger(MD5Util.class);
    /**
     * 取得消息摘要码
     *
     * @param b
     * @return
     */
    public static String md5Encode(byte[] b) {
        String resultString = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteArrayToHexString(md.digest(b));
        } catch (Exception ex) {
            resultString = null;
        }
        return resultString;
    }

    /**
     * 取得消息摘要码
     *
     * @param str
     * @return
     */
    public static String md5Encode(String str) {
        return md5Encode(str.getBytes());
    }

    /**
     * 取得消息摘要码
     *
     * @param file
     * @return
     */
    public static String md5Encode(File file) {
        if (file.exists() && file.isFile()) {
            try {
                byte[] b = new byte[1024];
                MessageDigest md = MessageDigest.getInstance("MD5");
                FileInputStream in = new FileInputStream(file);
                while ((in.read(b)) != -1) {
                    md.update(b);
                }
                return byteArrayToHexString(md.digest());
            } catch (Exception e) {
                logger.error(e.getMessage());
                return "";
            }
        }
        return "";
    }



    private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "a", "b", "c", "d", "e", "f" };

    private static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0, n = b.length; i < n; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n = 256 + n;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }
}
