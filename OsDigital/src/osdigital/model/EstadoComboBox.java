/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osdigital.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author HJ-Sistemas
 */
public class EstadoComboBox extends AbstractListModel implements ComboBoxModel {

    private List lista;
    private Object selectedItem;

    public EstadoComboBox() {
        lista = new ArrayList();
    }

    public EstadoComboBox(List lista) {
        this();
        this.lista.addAll(lista);
    }

    @Override
    public int getSize() {
        return lista.size();
    }

    @Override
    public Object getElementAt(int index) {
        return lista.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

    public void changeList(List lista) {
        this.lista = lista;
        fireContentsChanged(this, 0, 0);
    }

  
}



