/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import dao.UsuarioDAO;
import javax.swing.JOptionPane;
import model.Usuario;
import org.apache.commons.lang3.StringUtils;
import util.PasswordUtil;
import view.Login;
import view.MainForm;

/**
 *
 * @author BZR4
 */
public class LoginPresenter {
    private final Login view;

    public LoginPresenter() {
        this.view = new Login(this);
        this.view.setVisible(true);
    }  
    
    public boolean validarCampos(String usuario, String senha){        
        if(StringUtils.isBlank(usuario) && StringUtils.isBlank(senha)){
            throw new RuntimeException("Nome de usuario e senha são obrigatórios!");
        }
        if(StringUtils.isBlank(usuario)){
            throw new RuntimeException("Nome de usuario é obrigatório!");
        }
        if(StringUtils.isBlank(senha)){
            throw new RuntimeException("Senha é obrigatória!");
        }
        return true;
    }    
    
    public void login(Usuario usuario){
        try {
            validarCampos(usuario.getUsuario(), usuario.getSenha());
            usuario.setSenha(PasswordUtil.converterMD5(usuario.getSenha()));
            UsuarioDAO usuarioDAO = new UsuarioDAO();        
            if(usuarioDAO.buscarDadosLogin(usuario)){
                new MainForm().setVisible(true);
                view.dispose();
            }else{
                JOptionPane.showMessageDialog(view, "Usuário ou senha inválida", "Exceção", 2);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getLocalizedMessage(), "Exceção", 0);
        }
    }  
    
    public static void main(String[] args) {
        LoginPresenter loginPresenter = new LoginPresenter();
    }
}
