/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
/**
 *
 * @author BZR4
 */
public class TestMD5 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
         //Reading data from user
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter the message");
      String message = sc.nextLine();      
      String md5Hex = DigestUtils.md5Hex(message);     
      System.out.println(md5Hex);
    }
}
