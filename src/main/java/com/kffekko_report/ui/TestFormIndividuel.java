/*
 * To change this template, choose Tools | Templates
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Jo
 */
public class TestFormIndividuel extends FormDialog{

    private final JLabel errorServer1;
    private final JLabel errorServer2;

    public TestFormIndividuel() {
        super();
        //pas de layout par défaut au formulaire, pour pouvoir utiliser un GUIBuilder
        setLayout(new BorderLayout());
        //initialise  le formulaire
        initForm();

        errorServer1 = createErrorLabel("Un méssage d'érreur serveur");
        errorServer2 = createErrorLabel("Un méssage d'érreur serveur lié à un champ");

        //création des éléments du formulaire
        JLabel jl1 = new JLabel("Expression régulière [a-zA-Zéèàê ]{1,20}");
        final StatusField tf1 = createStatusField(new JTextField());
        setDefaultValueOf(tf1, "Valeur par défault");
        //ajoute des validateurs
        addFieldValidator(tf1, CommonsValidator.required, FormatedMessage.getRequired(jl1));
        addFieldValidator(tf1, new CommonsValidator.Matcher("[a-zA-Zéèàê ]{1,20}"), FormatedMessage.getInvalid(jl1));
         //ajoute un méssage  d'information lié à un élément
        addFieldInfoMessage(tf1, "Du blabla qui éxplique à quoi correspond le champ du formulaire...");


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


        addContent(new GridBagPanel(new GridBagMatrixConstraints(){{
            gridx       = new Integer[]{0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1};
            gridy       = new Integer[]{0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6};
            gridwidth   = 1;
            gridheight  = 1;
            weightx     = new Integer[]{0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1};
            weighty     = 0;
            fill        = GridBagConstraints.HORIZONTAL;
            insets      = new Insets(2, 2, 2, 2);
            anchor      = GridBagConstraints.NORTHWEST;
        }}).adds(
            jl1, tf1, jl2, tf2, jl3, tf3, jl4, tf4, jl5, cb, jl6, tf6, jl7, tf7
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
