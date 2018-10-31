/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kffekko_report.ui;


import com.kffekko_report.util.form.Form;
import com.kffekko_report.util.form.FormButtonListener;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;


public class CustumForm extends Form{

    public CustumForm(boolean showErrorOnlyOnFocus) {
        super(showErrorOnlyOnFocus);
        //un peu de style
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
    }

    public CustumForm() {
        this(false);
    }

    //redéfinition de la méthode pour harnomiser le style des boutons
    public void addButton(JButton button, FormButtonListener listener){
        super.addButton(button, listener);
        button.setPreferredSize(new Dimension(200, (int) button.getPreferredSize().getHeight()));
    }


    //redéfinition de la couleur des érreurs
    public Color getErrorColor(){
        return new Color(255, 0, 0);
    }

    public Container initStatusComponent(){
        JPanel ct = (JPanel) super.initStatusComponent();
        ct.setBackground(new Color(255,255,204));
        ct.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        return ct;
    }

}
