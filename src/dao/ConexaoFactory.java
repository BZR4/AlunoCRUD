/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;


/**
 *
 * @author BZR4
 */
public class ConexaoFactory {
    static Connection connection = null;
    
    public static Connection getConexao(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/etec?user=esdras&password=donotcross");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Tipo de excecao: "+ex.getClass().getSimpleName());
            System.out.println("Mensagem: "+ex.getLocalizedMessage());
        }       
        return connection;
    }
    
    public static void fecharConexao(){
        try {
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Exception: "+ex.getLocalizedMessage());
        }
    }
}
