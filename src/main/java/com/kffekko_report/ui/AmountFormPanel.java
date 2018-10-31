/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kffekko_report.ui;

import com.kffekko_report.util.form.CommonsValidator;
import com.kffekko_report.util.form.FormButtonListener;
import com.kffekko_report.util.form.StatusField;
import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author akil
 */
public class AmountFormPanel extends FormPanel{
    
    private final JLabel errorServer1;
    private final JLabel errorServer2;
    
    AmountFormPanel(){
        super();
        //pas de layout par défaut au formulaire, pour pouvoir utiliser un GUIBuilder
        setLayout(new BorderLayout());
        //initialise  le formulaire
        initForm();

        errorServer1 = createErrorLabel("Un méssage d'érreur serveur");
        errorServer2 = createErrorLabel("Un méssage d'érreur serveur lié à un champ");

        JLabel jl1 = new JLabel("Campagne");
        final StatusField tf1 = createStatusField(new JTextField());
        setDefaultValueOf(tf1, "ID de la campagne");
        //ajoute des validateurs
        addFieldValidator(tf1, CommonsValidator.required, FormatedMessage.getRequired(jl1));
        addFieldValidator(tf1, new CommonsValidator.Matcher("[a-zA-Zéèàê ]{1,20}"), FormatedMessage.getInvalid(jl1));
         //ajoute un méssage  d'information lié à un élément
        addFieldInfoMessage(tf1, "Veuillez entrer le nom de la campagne.");
        
        JLabel jl2 = new JLabel("N Formule");
        final StatusField tf2 = createStatusField(new JTextField());
        setDefaultValueOf(tf2, "Numeros de formule");
        //ajoute des validateurs
        addFieldValidator(tf2, CommonsValidator.required, FormatedMessage.getRequired(jl2));
        addFieldValidator(tf2, new CommonsValidator.Matcher("[a-zA-Zéèàê ]{1,20}"), FormatedMessage.getInvalid(jl2));
         //ajoute un méssage  d'information lié à un élément
        addFieldInfoMessage(tf2, "Veuillez entrer le numeros de formule");
        
        JLabel jl3 = new JLabel("REF");
        final StatusField tf3 = createStatusField(new JTextField());
        setDefaultValueOf(tf3, "Reference date base rapport");
        //ajoute des validateurs
        addFieldValidator(tf3, CommonsValidator.required, FormatedMessage.getRequired(jl3));
        addFieldValidator(tf3, new CommonsValidator.Matcher("[a-zA-Zéèàê ]{1,20}"), FormatedMessage.getInvalid(jl3));
         //ajoute un méssage  d'information lié à un élément
        addFieldInfoMessage(tf3, "Veuillez entrer la reference date base rapport.");
        
        JLabel jl4 = new JLabel("Date de saisie");
        final StatusField tf4 = createStatusField(new JTextField());
        setDefaultValueOf(tf4, "Date de saisie de la campagne");
        //ajoute des validateurs
        addFieldValidator(tf4, CommonsValidator.required, FormatedMessage.getRequired(jl4));
        addFieldValidator(tf4, new CommonsValidator.Matcher("[a-zA-Zéèàê ]{1,20}"), FormatedMessage.getInvalid(jl4));
         //ajoute un méssage  d'information lié à un élément
        addFieldInfoMessage(tf4, "Veuillez entrer la date de saisie de la campagne.");
        
        JLabel jl5 = new JLabel("Date CGFC");
        final StatusField tf5 = createStatusField(new JTextField());
        setDefaultValueOf(tf5, "Date CGFC de la campagne");
        //ajoute des validateurs
        addFieldValidator(tf5, CommonsValidator.required, FormatedMessage.getRequired(jl5));
        addFieldValidator(tf5, new CommonsValidator.Matcher("[a-zA-Zéèàê ]{1,20}"), FormatedMessage.getInvalid(jl5));
         //ajoute un méssage  d'information lié à un élément
        addFieldInfoMessage(tf5, "Veuillez entrer la date CGFC.");
 
        JLabel jl6 = new JLabel("Mois");
        final StatusField tf6 = createStatusField(new JTextField());
        setDefaultValueOf(tf6, "Mois de la campagne");
        //ajoute des validateurs
        addFieldValidator(tf6, CommonsValidator.required, FormatedMessage.getRequired(jl6));
        addFieldValidator(tf6, new CommonsValidator.Matcher("[a-zA-Zéèàê ]{1,20}"), FormatedMessage.getInvalid(jl6));
         //ajoute un méssage  d'information lié à un élément
        addFieldInfoMessage(tf6, "Mois de la campagne.");
        
        JLabel jl7 = new JLabel("Exportateur");
        final StatusField tf7 = createStatusField(new JTextField());
        setDefaultValueOf(tf7, "Exportateur de la campagne");
        //ajoute des validateurs
        addFieldValidator(tf7, CommonsValidator.required, FormatedMessage.getRequired(jl7));
        addFieldValidator(tf7, new CommonsValidator.Matcher("[a-zA-Zéèàê ]{1,20}"), FormatedMessage.getInvalid(jl7));
         //ajoute un méssage  d'information lié à un élément
        addFieldInfoMessage(tf7, "Exportateur.");
        
        JLabel jl8 = new JLabel("Type Exportateur");
        final StatusField tf8 = createStatusField(new JTextField());
        setDefaultValueOf(tf8, "Type Exportateur de la campagne");
        //ajoute des validateurs
        addFieldValidator(tf8, CommonsValidator.required, FormatedMessage.getRequired(jl8));
        addFieldValidator(tf8, new CommonsValidator.Matcher("[a-zA-Zéèàê ]{1,20}"), FormatedMessage.getInvalid(jl8));
         //ajoute un méssage  d'information lié à un élément
        addFieldInfoMessage(tf8, "TypeExportateur.");
        
        
        JLabel jl9 = new JLabel("Type Exportateur");
        final StatusField tf9 = createStatusField(new JTextField());
        setDefaultValueOf(tf9, "Type Exportateur de la campagne");
        //ajoute des validateurs
        addFieldValidator(tf9, CommonsValidator.required, FormatedMessage.getRequired(jl9));
        addFieldValidator(tf9, new CommonsValidator.Matcher("[a-zA-Zéèàê ]{1,20}"), FormatedMessage.getInvalid(jl9));
         //ajoute un méssage  d'information lié à un élément
        addFieldInfoMessage(tf9, "TypeExportateur.");
        
        
                
        JLabel jl10 = new JLabel("Categorie");
        final StatusField tf10 = createStatusField(new JTextField());
        setDefaultValueOf(tf10, "Categorie de la campagne");
        //ajoute des validateurs
        addFieldValidator(tf10, CommonsValidator.required, FormatedMessage.getRequired(jl10));
        addFieldValidator(tf10, new CommonsValidator.Matcher("[a-zA-Zéèàê ]{1,20}"), FormatedMessage.getInvalid(jl10));
         //ajoute un méssage  d'information lié à un élément
        addFieldInfoMessage(tf10, "Categorie.");
        
        JLabel jl11 = new JLabel("Specificité");
        final StatusField tf11 = createStatusField(new JTextField());
        setDefaultValueOf(tf11, "Specificité de la campagne");
        //ajoute des validateurs
        addFieldValidator(tf11, CommonsValidator.required, FormatedMessage.getRequired(jl11));
        addFieldValidator(tf11, new CommonsValidator.Matcher("[a-zA-Zéèàê ]{1,20}"), FormatedMessage.getInvalid(jl11));
         //ajoute un méssage  d'information lié à un élément
        addFieldInfoMessage(tf11, "Specificité.");
        
        JLabel jl12 = new JLabel("Transitaire");
        final StatusField tf12 = createStatusField(new JTextField());
        setDefaultValueOf(tf12, "Transitaire de la campagne");
        //ajoute des validateurs
        addFieldValidator(tf12, CommonsValidator.required, FormatedMessage.getRequired(jl12));
        addFieldValidator(tf12, new CommonsValidator.Matcher("[a-zA-Zéèàê ]{1,20}"), FormatedMessage.getInvalid(jl12));
         //ajoute un méssage  d'information lié à un élément
        addFieldInfoMessage(tf12, "Transitaire.");
        
        JLabel jl13 = new JLabel("Port embarqué");
        final StatusField tf13 = createStatusField(new JTextField());
        setDefaultValueOf(tf13, "Port embarqué de la campagne");
        //ajoute des validateurs
        addFieldValidator(tf13, CommonsValidator.required, FormatedMessage.getRequired(jl13));
        addFieldValidator(tf13, new CommonsValidator.Matcher("[a-zA-Zéèàê ]{1,20}"), FormatedMessage.getInvalid(jl13));
         //ajoute un méssage  d'information lié à un élément
        addFieldInfoMessage(tf13, "Port embarqué.");
        
        JLabel jl14 = new JLabel("Continent");
        final StatusField tf14 = createStatusField(new JTextField());
        setDefaultValueOf(tf14, "Continent de la campagne");
        //ajoute des validateurs
        addFieldValidator(tf14, CommonsValidator.required, FormatedMessage.getRequired(jl14));
        addFieldValidator(tf14, new CommonsValidator.Matcher("[a-zA-Zéèàê ]{1,20}"), FormatedMessage.getInvalid(jl14));
         //ajoute un méssage  d'information lié à un élément
        addFieldInfoMessage(tf14, "Continent.");
        
        JLabel jl15 = new JLabel("pays destinataire");
        final StatusField tf15 = createStatusField(new JTextField());
        setDefaultValueOf(tf15, "pays destinataire");
        //ajoute des validateurs
        addFieldValidator(tf15, CommonsValidator.required, FormatedMessage.getRequired(jl15));
        addFieldValidator(tf15, new CommonsValidator.Matcher("[a-zA-Zéèàê ]{1,20}"), FormatedMessage.getInvalid(jl15));
         //ajoute un méssage  d'information lié à un élément
        addFieldInfoMessage(tf15, "pays destinataire.");
        
        JLabel jl16 = new JLabel("port destinataire");
        final StatusField tf16 = createStatusField(new JTextField());
        setDefaultValueOf(tf16, "port destinataire");
        //ajoute des validateurs
        addFieldValidator(tf16, CommonsValidator.required, FormatedMessage.getRequired(jl16));
        addFieldValidator(tf16, new CommonsValidator.Matcher("[a-zA-Zéèàê ]{1,20}"), FormatedMessage.getInvalid(jl16));
         //ajoute un méssage  d'information lié à un élément
        addFieldInfoMessage(tf16, "port destinataire.");
        
        JLabel jl17 = new JLabel("produit");
        final StatusField tf17 = createStatusField(new JTextField());
        setDefaultValueOf(tf17, "produit");
        //ajoute des validateurs
        addFieldValidator(tf17, CommonsValidator.required, FormatedMessage.getRequired(jl17));
        addFieldValidator(tf17, new CommonsValidator.Matcher("[a-zA-Zéèàê ]{1,20}"), FormatedMessage.getInvalid(jl17));
         //ajoute un méssage  d'information lié à un élément
        addFieldInfoMessage(tf17, "produit.");
        
        JLabel jl18 = new JLabel("Nature du produit");
        final StatusField tf18 = createStatusField(new JTextField());
        setDefaultValueOf(tf18, "Nature du produit");
        //ajoute des validateurs
        addFieldValidator(tf18, CommonsValidator.required, FormatedMessage.getRequired(jl18));
        addFieldValidator(tf18, new CommonsValidator.Matcher("[a-zA-Zéèàê ]{1,20}"), FormatedMessage.getInvalid(jl18));
         //ajoute un méssage  d'information lié à un élément
        addFieldInfoMessage(tf18, "Nature du produit.");
        
        JLabel jl19 = new JLabel("Recolte");
        final StatusField tf19 = createStatusField(new JTextField());
        setDefaultValueOf(tf19, "Recolte");
        //ajoute des validateurs
        addFieldValidator(tf19, CommonsValidator.required, FormatedMessage.getRequired(jl19));
        addFieldValidator(tf19, new CommonsValidator.Matcher("[a-zA-Zéèàê ]{1,20}"), FormatedMessage.getInvalid(jl19));
         //ajoute un méssage  d'information lié à un élément
        addFieldInfoMessage(tf19, "Recolte.");
        
        
        JLabel jl20 = new JLabel("Prix CAF");
        final StatusField tf20 = createStatusField(new JTextField());
        setDefaultValueOf(tf20, "Recolte");
        //ajoute des validateurs
        addFieldValidator(tf20, CommonsValidator.required, FormatedMessage.getRequired(jl20));
        addFieldValidator(tf20, new CommonsValidator.Matcher("[a-zA-Zéèàê ]{1,20}"), FormatedMessage.getInvalid(jl20));
         //ajoute un méssage  d'information lié à un élément
        addFieldInfoMessage(tf20, "Recolte.");
        
        JLabel jl21 = new JLabel("Prix CAF");
        final StatusField tf21 = createStatusField(new JTextField());
        setDefaultValueOf(tf21, "Prix CAF");
        //ajoute des validateurs
        addFieldValidator(tf21, CommonsValidator.required, FormatedMessage.getRequired(jl21));
        addFieldValidator(tf21, new CommonsValidator.Matcher("[a-zA-Zéèàê ]{1,20}"), FormatedMessage.getInvalid(jl21));
         //ajoute un méssage  d'information lié à un élément
        addFieldInfoMessage(tf21, "Prix CAF.");
        
        
        
        
        /*JLabel jl1 = new JLabel("Campagne");
        final StatusField tf1 = createStatusField(new JTextField());
        setDefaultValueOf(tf1, "ID de la campagne");
        //ajoute des validateurs
        addFieldValidator(tf1, CommonsValidator.required, FormatedMessage.getRequired(jl1));
        addFieldValidator(tf1, new CommonsValidator.Matcher("[a-zA-Zéèàê ]{1,20}"), FormatedMessage.getInvalid(jl1));
         //ajoute un méssage  d'information lié à un élément
        addFieldInfoMessage(tf1, "Veuillez entrer le nom de la campagne.");


        JLabel jl2 = new JLabel("Email");
        StatusField tf2 = createStatusField(new JTextField());
        setDefaultValueOf(tf2, "xxxxxx@xxx.xx");
        addFieldValidator(tf2, CommonsValidator.required, FormatedMessage.getRequired(jl2));
        addFieldValidator(tf2, CommonsValidator.email, FormatedMessage.getInvalid(jl2));
         //ajoute un méssage  d'information lié à un élément
        addFieldInfoMessage(tf2, "Information de Email");

        JLabel jl3 = new JLabel("IPV4");
        StatusField tf3 = createStatusField(new JTextField());
        addFieldValidator(tf3, CommonsValidator.required, FormatedMessage.getRequired(jl3));
        addFieldValidator(tf3, CommonsValidator.ipv4, FormatedMessage.getInvalid(jl3));
         //ajoute un méssage  d'information lié à un élément
        addFieldInfoMessage(tf3, "Information de IPV4");


        JLabel jl4 = new JLabel("Port");
        StatusField tf4 = createStatusField(new JTextField());
        setDefaultValueOf(tf4, "3306");
        addFieldValidator(tf4, CommonsValidator.required, FormatedMessage.getRequired(jl4));
        addFieldValidator(tf4, CommonsValidator.port, FormatedMessage.getInvalid(jl4));
         //ajoute un méssage  d'information lié à un élément
        addFieldInfoMessage(tf4, "Information de Port");

        JLabel jl5 = new JLabel("ComboBox");
        StatusField cb = createStatusField(new JComboBox(new String[]{"", "Cow","Sheep","Horse"}));
        setDefaultValueOf(cb, "Cow");
        addFieldValidator(cb, CommonsValidator.required, FormatedMessage.getRequired(jl5));
        addFieldInfoMessage(cb, "Information de ComboBox");


        JLabel jl6 = new JLabel("Mot de passe");
        StatusField tf6 = createStatusField(new JPasswordField());
        addFieldValidator(tf6, CommonsValidator.required, FormatedMessage.getRequired(jl6));
        addFieldValidator(tf6, CommonsValidator.rangeLength(5, 20), FormatedMessage.getInvalid(jl6));
         //ajoute un méssage  d'information lié à un élément
        addFieldInfoMessage(tf6, "Information de Mot de passe");

        JLabel jl7 = new JLabel("Ressaisissez le mot de passe");
        StatusField tf7 = createStatusField(new JPasswordField());
        addFieldValidator(tf7, CommonsValidator.required, FormatedMessage.getRequired(jl7));
        addFieldValidator(tf7, CommonsValidator.equalsTo(tf6), FormatedMessage.getInvalid(jl7));
         //ajoute un méssage  d'information lié à un élément
        addFieldInfoMessage(tf7, "Information de Mot de passe");
        
        JLabel jl8 = new JLabel("Ressaisissez le mot de passe");
        StatusField tf8 = createStatusField(new JPasswordField());
        addFieldValidator(tf8, CommonsValidator.required, FormatedMessage.getRequired(jl8));
        addFieldValidator(tf8, CommonsValidator.equalsTo(tf6), FormatedMessage.getInvalid(jl8));
         //ajoute un méssage  d'information lié à un élément
        addFieldInfoMessage(tf8, "Information de Mot de passe");*/


        addContent(new GridBagPanel(new GridBagMatrixConstraints(){{
            gridx       = new Integer[]{0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1,
            0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1
            };
            gridy       = new Integer[]{0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7,
            8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 13, 13, 14, 14, 15, 15, 16, 16, 17, 17,
            18, 18, 19, 19, 20, 20, 21, 21};
            gridwidth   = 1;
            gridheight  = 1;
            weightx     = new Integer[]{0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1,
            0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1
            };
            weighty     = 0;
            fill        = GridBagConstraints.HORIZONTAL;
            insets      = new Insets(2, 2, 2, 2);
            anchor      = GridBagConstraints.NORTHWEST;
        }}).adds(
            jl1, tf1, jl2, tf2, jl3, tf3, jl4, tf4, jl5, tf5, jl6, tf6, jl7, tf7, jl8, tf8,
                jl9, tf9, jl10, tf10, jl11, tf11, jl12, tf12, jl13, tf13, jl14, tf14,
                jl15, tf15, jl16, tf16, jl17, tf17, jl18, tf18, jl19, tf19, jl20, tf20,
                jl21, tf21
        ));


        addSubmitButton(new JButton("Valider"), new FormButtonListener(){
            public void buttontClicked(AWTEvent e) {
                if(valid()){
                    addValidMessage("Formulaire bien validé");
                }
            }
        });

        addButton(new JButton("Valider avec érreur serveur"), new FormButtonListener(){
            public void buttontClicked(AWTEvent e) {
                if(valid()){
                    addErrorMessage(errorServer1);
                    addFieldErrorMessage(tf1, errorServer2);
                }
            }
        });

        addButton(new JButton("Reset"), new FormButtonListener(){
            public void buttontClicked(AWTEvent e) {
                reset();
            }
        });
    }
    
    
}
