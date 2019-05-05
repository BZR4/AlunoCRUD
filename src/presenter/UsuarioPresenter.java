/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

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

    public void testPresenterClick(){
        System.out.println("Click!");
    }
}
