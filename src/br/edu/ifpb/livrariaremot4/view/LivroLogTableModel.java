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
public class LivroLogTableModel extends AbstractTableModel{
    private String[] colunas = new String[]{"Titulo","Editora","ISBN","Edicao",
                                            "Autor","Operacao"};
    
    
    @Override
    public int getRowCount() {
        return LivrariaController.getInstance().listLog().size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch(columnIndex){
            case 0:
                String t = LivrariaController.getInstance().listLog().get(rowIndex).getTitulo();
                
                return t;
            case 1:
                return LivrariaController.getInstance().listLog().get(rowIndex).getEditora();
            case 2:
                return LivrariaController.getInstance().listLog().get(rowIndex).getIsbn();
            case 3:
                return LivrariaController.getInstance().listLog().get(rowIndex).getEdicao();
            case 4:
                return LivrariaController.getInstance().listLog().get(rowIndex).getAutor();
            case 5:
                return LivrariaController.getInstance().listLog().get(rowIndex).getOperacao();
            default:
                return LivrariaController.getInstance().listLog().get(rowIndex);
        }
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return this.colunas[columnIndex];
    }
    
    public void atualizar(){
        LivrariaController.getInstance().refreshListLog();
        fireTableDataChanged();
    }
}
