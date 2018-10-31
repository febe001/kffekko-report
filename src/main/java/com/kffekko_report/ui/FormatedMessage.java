/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kffekko_report.ui;

import javax.swing.JLabel;

/**
 *
 * @author Jo
 */
public class FormatedMessage {
    
    public static String getRequired(JLabel label){
        return label.getText() + " n'est pas renseigné.";
    }

    public static String getInvalid(JLabel label){
        return label.getText() + " est mal renseigné.";
    }
}
