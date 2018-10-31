/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kffekko_report.ui;

import java.awt.GridBagConstraints;
import java.lang.reflect.Array;

/**
 *
 * @author Jo
 */
public class GridBagMatrixConstraints {
    public Object gridx;
    public Object gridy;
    public Object gridwidth;
    public Object gridheight;
    public Object weightx;
    public Object weighty;
    public Object insets;
    public Object fill;
    public Object anchor;
    public Object ipadx;
    public Object ipady;
    public int index;

    public GridBagConstraints constraints = new GridBagConstraints();
    
    private static final String[] constraintFields = new String[]{
        "gridx", "gridy", "gridwidth", "gridheight", "weightx",
        "weighty", "insets", "fill", "anchor", "ipadx", "ipady"
    };

    //utilise la reflection pour dynamiquement enregistrer et récuprer les valeurs 
    void initContraints(){
        for(int i = 0; i < constraintFields.length; i++){
            try {
                Object field = GridBagMatrixConstraints.class.getField(constraintFields[i]).get(this);
                if (field != null) {
                    if (field.getClass().isArray()) {
                        if (Array.getLength(field)  < index)
                            continue;
                        field = Array.get(field, index);
                        if (field == null) 
                            continue;
                    }
                    GridBagConstraints.class.getField(constraintFields[i]).set(constraints, field);
                }
            } catch (Exception ex) {}
        }
        index++;
    }

}
