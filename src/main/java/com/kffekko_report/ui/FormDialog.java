/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kffekko_report.ui;


import javax.swing.JDialog;


public class FormDialog extends CustumForm{

    public JDialog dialog;

    public void setDialog(JDialog dialog){
        this.dialog = dialog;
    }

    @Override
    public void onFormChanged(){
        if(dialog != null)
            dialog.pack();
    }
}
