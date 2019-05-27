/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import dao.UsuarioDAO;
import java.util.List;
import model.Usuario;
import util.PasswordUtil;
import view.CadastroUsuarioView;

/**
 *
 * @author BZR4
 */
public class UsuarioPresenter {
    private CadastroUsuarioView view;

    public UsuarioPresenter(CadastroUsuarioView view) {
        this.view = view;
    }

    public CadastroUsuarioView getView() {
        return view;
    }

    public void salvarNovoUsuario() throws Exception{
        Usuario usuario = new Usuario();
        usuario.setNome(view.getjTextFieldNome().getText());
        usuario.setEmail(view.getjTextFieldEmail().getText());
        usuario.setUsuario(view.getjTextFieldUsuario().getText());
        usuario.setSenha(PasswordUtil
                .converterMD5(new String(view.getjPasswordFieldSenha()
                        .getPassword())));
        UsuarioDAO dao = new UsuarioDAO();
        dao.salvarUsuario(usuario);
    }
    
    public void carregarTabela() throws Exception{
        UsuarioDAO dao = new UsuarioDAO();
        List<Usuario> usuarios = dao.buscarTodosUsuarios(); 
    }
}
