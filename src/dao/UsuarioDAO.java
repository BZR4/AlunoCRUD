/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

/**
 *
 * @author BZR4
 */
public class UsuarioDAO {
    
    public boolean buscarDadosLogin(Usuario usuario) throws SQLException, ClassNotFoundException, Exception{
        String sql = "select usuario, senha from usuario where usuario = ? and senha = ?";
        boolean result = false;
        try(PreparedStatement preparedStatement = ConexaoFactory.getConexao().prepareStatement(sql);) {
            preparedStatement.setString(1, usuario.getUsuario());
            preparedStatement.setString(2, usuario.getSenha());
            ResultSet resultSet = preparedStatement.executeQuery();
            result = resultSet.next();
        } catch (Exception ex) {
             System.out.println("BuscarDadosLogin\nException: "+ex.getLocalizedMessage());
             throw new Exception(String.format("DAO -> Tipo de excecao: %s\nMensagem: %s", ex.getClass().getSimpleName(), ex.getMessage()));
        } finally{
            ConexaoFactory.fecharConexao();
        }
        return result;
    }
    
    public void salvarUsuario(Usuario usuario) throws Exception{
        String sql = "insert into usuario values(0, ?,?,?,?)";
        try(PreparedStatement preparedStatement = ConexaoFactory.getConexao().prepareStatement(sql);) {
            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getUsuario());
            preparedStatement.setString(3, usuario.getSenha());
            preparedStatement.setString(4, usuario.getEmail());
            preparedStatement.execute();
        } catch (Exception ex) {
                throw ex;
        } finally{
            ConexaoFactory.fecharConexao();
        }
    }
    
    public List<Usuario> buscarTodosUsuarios() throws Exception{
        String sql = "select * from usuario;";
        try(PreparedStatement preparedStatement = ConexaoFactory.getConexao().prepareStatement(sql);) {            
            ResultSet resultSet = preparedStatement.executeQuery(sql);
            List<Usuario> usuarios = new ArrayList<>();
            while(resultSet.next()){
                Usuario usuario = new Usuario();
                usuario.setId(resultSet.getInt("id"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setUsuario(resultSet.getString("usuario"));
                usuario.setSenha(resultSet.getString("senha"));
                usuarios.add(usuario);
            }
            return usuarios;
        } catch (Exception ex) {
                throw ex;
        } finally{
            ConexaoFactory.fecharConexao();
        }
    }
}
