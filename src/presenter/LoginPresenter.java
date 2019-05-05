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
import view.LoginView;
import view.MainForm;

/**
 *
 * @author BZR4
 */
public class LoginPresenter {
    private final LoginView view;

    public LoginPresenter() {
        view = new LoginView(this);
        view.setVisible(true);
        view.setLocationRelativeTo(null);
        //Configurar botão padrao para o formulario
        view.getRootPane().setDefaultButton(view.getjButtonLogin());
    }  
    
    public boolean validarCampos(String usuario, String senha) throws Exception{        
        if(StringUtils.isBlank(usuario) && StringUtils.isBlank(senha)){
            throw new Exception("Nome de usuario e senha são obrigatórios!");
        }
        if(StringUtils.isBlank(usuario)){
            throw new Exception("Nome de usuario é obrigatório!");
        }
        if(StringUtils.isBlank(senha)){
            throw new Exception("Senha é obrigatória!");
        }
        return true;
    }    
    
    public void login(Usuario usuario){
        try {
            validarCampos(usuario.getUsuario(), usuario.getSenha());
            usuario.setSenha(PasswordUtil.converterMD5(usuario.getSenha()));
            UsuarioDAO usuarioDAO = new UsuarioDAO();        
            if(usuarioDAO.buscarDadosLogin(usuario)){
                abrirAplicacao();
            }else{
                JOptionPane.showMessageDialog(view, "Usuário ou senha inválida", "Exceção", 2);
            }
        } catch (Exception e) {
            System.out.println("Login -> Tipo de excecao: "+e.getClass().getSimpleName());
            System.out.println("Mensagem: "+e.getLocalizedMessage());
            JOptionPane.showMessageDialog(view, e.getMessage(), "Exceção", 1);
        }
    }  

    private void abrirAplicacao() {
        MainForm mainForm = new MainForm();
        mainForm.setVisible(true);
        mainForm.setLocationRelativeTo(null);
        view.dispose();
    }
    
    public static void main(String[] args) {
        LoginPresenter loginPresenter = new LoginPresenter();
    }
}
