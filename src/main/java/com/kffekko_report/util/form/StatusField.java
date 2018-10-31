/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kffekko_report.util.form;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;


 public class StatusField extends JPanel{

    public final Component field;
    public Container statusComponent;

    public StatusField(Form form, Component field) {
        this.field = field;
        statusComponent = form.initStatusComponent();
        statusComponent.setVisible(false);
        setLayout(new GridBagLayout());
        add(field, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        add(statusComponent, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(2, 0, 0, 0), 0, 0));
    }

    public Component add(JLabel msg){
        return statusComponent.add(msg);
    }

    public void remove(JLabel msg){
        statusComponent.remove(msg);
    }
}
