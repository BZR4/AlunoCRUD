/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import dao.UsuarioDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Usuario;
import util.PasswordUtil;
import view.CadastroUsuarioView;

/**
 *
 * @author BZR4
 */
public class UsuarioPresenter {
    private CadastroUsuarioView view;

    public UsuarioPresenter(CadastroUsuarioView view) throws Exception {
        this.view = view;
        carregarTabela();
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
        carregarTabela();
    }
    
    public void carregarTabela() throws Exception{
        UsuarioDAO dao = new UsuarioDAO();
        
        List<Usuario> usuarios = dao.buscarTodosUsuarios();  
        
        DefaultTableModel model = (DefaultTableModel) 
                view.getjTableAlunos().getModel();
        
        for (int i = model.getRowCount() -1 ; i >= 0; i--) {
            model.removeRow(i);
        }
        
        int i = 0;
        for (Usuario usuario : usuarios) {
            model.addRow(new String[0]);
            view.getjTableAlunos().setValueAt(usuario.getId(), i, 0);
            view.getjTableAlunos().setValueAt(usuario.getNome(), i, 1);
            view.getjTableAlunos().setValueAt(usuario.getUsuario(), i, 2);
            view.getjTableAlunos().setValueAt(usuario.getEmail(), i, 3);
            i++;
        }
    }
}
