/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author BZR4
 */
public class PasswordUtil {
    public static String converterMD5(String senha){
        return DigestUtils.md5Hex(senha);
    }
}
