/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;

/**
 *
 * @author BZR4
 */
public class UsuarioDAO {
    
    public boolean buscarDadosLogin(Usuario usuario){
        String sql = "select usuario, senha from usuario where usuario = ? and senha = ?";
        boolean result = false;
        try(PreparedStatement preparedStatement = ConexaoFactory.getConexao().prepareStatement(sql);) {
            preparedStatement.setString(1, usuario.getUsuario());
            preparedStatement.setString(2, usuario.getSenha());
            ResultSet resultSet = preparedStatement.executeQuery();
            result = resultSet.next();
        } catch (SQLException ex) {
             System.out.println("BuscarDadosLogin\nException: "+ex.getLocalizedMessage());
        } finally{
            ConexaoFactory.fecharConexao();
        }
        return result;
    }
    
    public void salvarUsuario(Usuario usuario){
        String sql = "insert into usuario values(0, ?,?,?,?)";
        try(PreparedStatement preparedStatement = ConexaoFactory.getConexao().prepareStatement(sql);) {
            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getUsuario());
            preparedStatement.setString(3, usuario.getSenha());
            preparedStatement.setString(4, usuario.getEmail());
            preparedStatement.execute();
        } catch (SQLException ex) {
             System.out.println("Exception: "+ex.getLocalizedMessage());
        } finally{
            ConexaoFactory.fecharConexao();
        }
    }
}
