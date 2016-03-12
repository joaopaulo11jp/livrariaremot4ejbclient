/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.livrariaremot4.view;

import br.edu.ifpb.livrariaremot4.controller.LivrariaController;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author joaopaulo
 */
public class LivroTableModel extends AbstractTableModel{
    private String[] colunas = new String[]{"Titulo","Editora","ISBN","Edicao",
                                            "Autor"};
    
    
    @Override
    public int getRowCount() {
        return LivrariaController.getInstance().listaDeLivros().size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch(columnIndex){
            case 0:
                String t = LivrariaController.getInstance().listaDeLivros().get(rowIndex).getTitulo();
                
                return t;
            case 1:
                return LivrariaController.getInstance().listaDeLivros().get(rowIndex).getEditora();
            case 2:
                return LivrariaController.getInstance().listaDeLivros().get(rowIndex).getIsbn();
            case 3:
                return LivrariaController.getInstance().listaDeLivros().get(rowIndex).getEdicao();
            case 4:
                return LivrariaController.getInstance().listaDeLivros().get(rowIndex).getAutor();
            default:
                return LivrariaController.getInstance().listaDeLivros().get(rowIndex);
        }
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return this.colunas[columnIndex];
    }
    
    public void add(String titulo,String editora,String isbn,String edicao,String autor){
        LivrariaController.getInstance().addLivro(titulo, editora, isbn, edicao, autor);
    }
    
    public void remove(Long id){
        LivrariaController.getInstance().removerLivro(id);
    }
    
    public void update(Long id,String titulo,String editora,String isbn,String edicao,String autor){
        LivrariaController.getInstance().alterarLivro(id, titulo, editora, isbn, edicao, autor);
    }
    
    
}
