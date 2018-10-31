/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kffekko_report.ui;

import java.awt.Component;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

/**
 *
 * Simple classe pour automatiser la création de panneau avec gridbaglayout
 * et chainer la méthode adds(Component...)
 */
public class GridBagPanel extends JPanel{

    public GridBagMatrixConstraints matrix;

    public GridBagPanel(GridBagMatrixConstraints matrix) {
        super();
        setLayout(new GridBagLayout());
        this.matrix = matrix;
    }

    public Component add(Component comp){
        matrix.initContraints();
        add(comp, matrix.constraints);
        return comp;
    }

    public GridBagPanel adds(Component... comp){
        for(int i = 0, l = comp.length; i < l; i++)
            add(comp[i]);
        return this;
    }

}

