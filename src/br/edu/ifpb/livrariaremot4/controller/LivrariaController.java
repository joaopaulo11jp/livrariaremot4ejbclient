/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.livrariaremot4.controller;

import br.edu.ifpb.livrariaremot4.interfaces.LivroManagerBeanRemote;
import br.edu.ifpb.livrariaremot4.model.Livro;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author joaopaulo
 */
public class LivrariaController {
    private List<Livro> livros;
    private static LivrariaController instance;
    private InitialContext ctx;
    LivroManagerBeanRemote lm;
    
        private LivrariaController(){
            try {
            Properties p = new Properties();
            p.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.impl.SerialInitContextFactory");
            ctx = new InitialContext(p);
            lm = (LivroManagerBeanRemote) ctx.lookup("LivroManager");
            this.refreshList();            
            
            } catch (NamingException ex) {
                Logger.getLogger(LivrariaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    public static LivrariaController getInstance(){
        if(instance == null) instance = new LivrariaController();
        return instance; 
    }
    
    public Livro addLivro(String titulo, String editora, String isbn, String edicao, String autor){
        Livro l = lm.cadastrar(titulo, editora, isbn, edicao, autor);
        this.refreshList();
        return l;
    }
    
    public Livro removerLivro(Long codigo){
        Livro l = lm.remover(codigo);
        this.refreshList();
        return l;
    }
    
    public Livro alterarLivro(Long codigo, String titulo, String editora, String isbn, String edicao, String autor){
        Livro l = lm.alterarLivro(new Livro(codigo, titulo, editora, isbn, edicao, autor));
        this.refreshList();
        return l;
    }
    
    public void consultaPorTitulo(String titulo){
        this.livros = lm.consultarPorTitulo(titulo);
    }
    
    public void consultaPorAutor(String autor){
        this.livros = lm.consultarPorAutor(autor);
    }
    
    public void consultaPorIsbn(String isbn){
        this.livros = lm.consultarPorISBN(isbn);
    }
    
    private void refreshList(){
        this.livros = lm.getTodosOsLivros();
    }
    
    public List<Livro> listaDeLivros(){
        return this.livros;
    }
}
