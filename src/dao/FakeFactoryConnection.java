/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author BZR4
 */
public class FakeFactoryConnection {
    public static void getConexao(){
        System.out.println("Conexao obtida com sucesso");
    }
    
    public static void edita(){
        System.out.println("Atualizacao realizada com sucesso!");
    }
    
    public static void fechaConexao(){
        System.out.println("Conexao fechada com sucesso");
    }
    
    public static void salva(){
        System.out.println("Aluno criado realizada com sucesso!");
    }
    
    public static void exclui(){
        System.out.println("Aluno removido com sucesso!");
    }
    
    public static void main(String[] args) {
        try {
            getConexao();           
            salva();
//            throw new RuntimeException("Eu fiz ferrar tudo aqui...");
            edita();
            exclui();
            fechaConexao();
        } catch (Exception e) {
            System.out.println("Class: "+e.getClass().getSimpleName());       
            System.out.println("Cause: "+e.getCause());       
            System.out.println("Exception: "+e.getLocalizedMessage());
        } finally{
            fechaConexao();
        }
    }
}
