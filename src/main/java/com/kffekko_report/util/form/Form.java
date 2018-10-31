/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kffekko_report.util.form;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;
import javax.swing.KeyStroke;
import javax.swing.ListCellRenderer;
import javax.swing.text.JTextComponent;



public class Form extends JPanel{

    //référence des classes pouvant être des champs de formulaire, 
    //mis en public pour être à compléter
    public static final Class[] fieldFromClass = new Class[]{
        JPasswordField.class,
        JTextComponent.class,
        TextComponent.class,
        JToggleButton.class,
        JComboBox.class,
        Checkbox.class
    };

    //panneau des messages
    private Container statusComponent;
    //panneau des boutons
    private Container buttonComponent;
    //l'icone des érreurs
    private ImageIcon errorIcon;
    //l'icone de validation
    private ImageIcon validIcon;
    //l'icone d'information
    private ImageIcon infoIcon;
    //la couleur du bakground en cas d'érreur
    private Color errorColor;
    //le registre des validateurs par élements
    private HashMap<Component, FieldValidators> registerValidator = new HashMap<Component,FieldValidators>();
    //le registre des validateurs par élements non validé
    private ArrayList<FieldValidators> registerUnvalidValidator = new ArrayList<FieldValidators>();
    //Registre des méssages érreurs non lié à un élément
    private HashSet<JLabel> registerError = new HashSet<JLabel>();
    //Registre des méssages érreurs lié à un élément
    private HashMap<Component, FieldError> registerFieldError = new HashMap<Component, FieldError>();
    //Registre des méssages érreurs lié à un élément
    private HashMap<Component, String> registerDefaultValues = new HashMap<Component, String>();
     //Référence vers le message de validations, pour l'éffacer si jamais on insère une érreur après
    private JLabel validLabel;
    //référence si un bouton est en train d'etre préssé, pour ne pas appliquer
    //les filtre de validation au focuslost
    private boolean buttonPressed;
    //Pour pouvoir appliquer doClick() sur un bouton, celui-ci dois avoir 
    //un listener Action. Pour ne pas déclancher 2 fois une action via initAction(voir AButtonController)
    private boolean buttonAction = false;
    //Si les érreurs lié au champ doivent être visible que lorsque le champ à le focus
    //valable que pour les champs de type Field 
    private boolean showErrorOnFocus;
    //Le registre des érreur lié à un champ en attente de valider le traitement
    //de la parte  de son focus, lorqu'un boutton est préssé (pour ne pas créer de sautillement
    //lors d'insertion d'érreur)
    private ArrayList<WaintingFocusLost> waintingFocusLost = new ArrayList<WaintingFocusLost>();
    //référrence vers le bouton de soumition
    private JButton submit;
    
    /**
     * Le constructeur vide du formulaire
     * Un appel à initForm sera nécessaire pour éviter d'appeler des méthodes
     * spécialisable dans le construteur
     */
    public  Form(){
        this(true);
    }

    /**
     * Le constructeur du formulaire
     * Un appel à initForm sera nécessaire pour éviter d'appeler des méthode
     * spécialisable dans le construteur
     * @param showErrorOnlyOnFocus  Si les érreurs lié au champ doivent être visible
     *      que lorsque le champ à le focus, valable que pour les champs de type Field
     */
    public Form(boolean showErrorOnlyOnFocus){
        this.showErrorOnFocus = showErrorOnlyOnFocus;
    }

    /**
     * Initialisation du formulaire
     * @return void
     */
    public Form initForm(){
        errorColor = initErrorColor();
        errorIcon = initErrorIcon();
        validIcon = initValidIcon();
        infoIcon = initInfoIcon();
        statusComponent = initStatusComponent();
        statusComponent.setVisible(false);
        buttonComponent = initButtonComponent();
        initInsertFormComponents();
        return this;
    }

    public void addContent(Component formContent){
        JPanel contentPan = new JPanel();
        contentPan.setLayout(new GridBagLayout());
        contentPan.add(formContent, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        add(contentPan);
    }

    /**
     * Définit comment ajouter les différent container
     * @return void
     */
    public void initInsertFormComponents(){
        //Pas de définition de layout pour pouvoir fonctionner avec un GUIBulder
        //setLayout(new BorderLayout());
        JPanel southPan = new JPanel();
        southPan.setLayout(new GridBagLayout());
        southPan.add(getStatusComponent(), new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(2, 0, 2, 0), 0, 0));
        southPan.add(getButtonComponent(), new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.NORTHEAST, GridBagConstraints.HORIZONTAL, new Insets(2, 0, 2, 0), 0, 0));
        add(southPan, BorderLayout.SOUTH);
    }

    /**
     * Défintit un panneau de message
     * @return un panneau de message, qui sur-définit la méthode add(Component)
     *      pour toujours insérer un élément au début de la pile
     */
    public Container initStatusComponent(){
        JPanel pan = new JPanel();
        pan.setLayout(new BoxLayout(pan, BoxLayout.Y_AXIS));
        return pan;
    }

    /**
     * Accesseur du panneau des messages lié au formulaire
     * @return Le panneau des messages lié au formulaire
     */
    public Container getStatusComponent(){
        return statusComponent;
    }
    
    /**
     * Initialise la couleurs des champs en cas d'erreur
     * @return La couleur en cas d'érreur
     */
    public Color initErrorColor(){
        return  new Color(255, 153, 153);
    }

    /**
     * Initialise l'image des erreurs
     * @return L'image d'érreur
     */
    public ImageIcon initErrorIcon(){
        return new ImageIcon("images\\error.png");
    }

    /**
     * Initialise l'image de validation
     * @return L'image de validation
     */
    public ImageIcon initValidIcon(){
        return new ImageIcon("images\\valid.png");
    }

    /**
     * Initialise l'image de d'information
     * @return L'image de d'information
     */
    public ImageIcon initInfoIcon(){
        return new ImageIcon("images\\info.png");
    }

    /**
     * Accesseur du panneau des messages correspondant à un élément
     * Si élément == null, alors on retourne le panneau des méssage lié au formulaire
     * @param field     Un élément pouvant être une instance de Field
     * @return Un panneau de message
     */
    private Container getStatusComponentOf(Component field){
        return field == null || !(field instanceof StatusField) ? statusComponent : ((StatusField) field).statusComponent;
    }

    /**
     * Pas le temp de faire des écouter et registre associé
     * Faudra juste redéfinir la focntion
     * Dans une prochaine version peux-etre les listener comme
     * FormChanged, messageAdded, messageRemoved .....
     * @return void
     */
    public void onFormChanged(){}

    /**
     * Affiche ou pas un panneau de méssage
     * @param ct        Le panneau concerné
     * @param insert    Si il s'agit d'une insertion
     * @return void
     */
    public void setVisibilityStatusComponent(Container ct, boolean insert){
        ct.setVisible(insert ? true : ct.getComponents().length != 0);
        onFormChanged();
    }


    /**
     * Créer un label d'érreur.
     * Peux servir pour redéfinir le style du méssage ainsi que
     * faire une "cache" des méssage d'éreurs et éviter
     * des testes conditionneles lié au traitement des méssages
     * @param msg       Le méssage d'érreur
     * @return void
     */
    public JLabel createErrorLabel(String msg){
        JLabel lab = new JLabel(msg);
        lab.setIcon(errorIcon);
        return lab;
    }


    /**
     * Ajoute un message d'érreur non lié à un champ
     * @param msg      Le message a afficher
     * @return void
     */
    public JLabel addErrorMessage(String msg){
        return addErrorMessage(createErrorLabel(msg));
    }

    /**
     * Ajoute un message d'érreur déjà définit
     * Evite de réafficher un nouveau label avec le même texte
     * @param lab      Le label a afficher
     * @return void
     */
    public JLabel addErrorMessage(JLabel label){
        statusComponent.add(label);
        registerError.add(label);
        setVisibilityStatusComponent(statusComponent, true);
        removeValidMessage();
        return label;
    }

    /**
     * Supprime un méssage d'érreur
     * @param lab      Le label
     * @return void
     */
    public void removeErrorMessage(JLabel label){
        statusComponent.remove(label);
        registerError.remove(label);
        setVisibilityStatusComponent(statusComponent, false);
    }

    /**
     * Ajoute un message d'érreur lié à un champ
     * @param msg      Le message a afficher
     * @param field    Le composant lié au message
     * @return void
     */
    public JLabel addFieldErrorMessage(Component field, String msg){
        JLabel label = createErrorLabel(msg);
        FieldError error = registerFieldError.containsKey(field) ?
            registerFieldError.get(field) : new FieldError(getStatusComponentOf(field), field);
        error.add(label);
        return label;
    }

    /**
     * Ajoute un message d'érreur déjà définit
     * Evite de réafficher un nouveau label avec le même texte
     * @param msg      Le message a afficher
     * @param field    Le composant lié au message
     * @return void
     */
    public JLabel addFieldErrorMessage(Component field, JLabel label){
        FieldError error = registerFieldError.containsKey(field) ?
            registerFieldError.get(field) : new FieldError(getStatusComponentOf(field), field);
        error.add(label);
        return label;
    }

    /**
     * Supprime un méssage d'érreur lié à un champ
     * @param msg      Le message servant de clé
     * @return void
     */
    public void removeFieldErrorMessage(Component field, JLabel lab){
        if(registerFieldError.containsKey(field)){
            registerFieldError.get(field).remove(lab);
        }
    }

    /**
     * Supprime tout les méssage d'érreur
     * @return void
     */
    public void clearErrorMessage(){
        for(FieldError error : registerFieldError.values())
            error.clear();
        Iterator<JLabel> it = registerError.iterator();
        while (it.hasNext()){
            JLabel label = it.next();
            statusComponent.remove(label);
            registerError.remove(label);
        }
        setVisibilityStatusComponent(statusComponent, false);
    }

    /**
     * Créer un label d'information.
     * Peux servir pour redéfinir le style du méssage ainsi que
     * faire une "cache" des méssage d'information et éviter
     * des testes conditionneles lié au traitement des méssages
     * @param msg       Le méssage d'information
     * @return void
     */
    public JLabel createInfoLabel(String msg){
        JLabel label = new JLabel(msg);
        label.setIcon(infoIcon);
        return label;
    }

    /**
     * Ajoute un message d'information
     * @param msg      Le message a afficher
     * @return void
     */
    public JLabel addInfoMessage(String msg){
        JLabel label = createInfoLabel(msg);
        statusComponent.add(label);
        setVisibilityStatusComponent(statusComponent, true);
        return label;
    }

    /**
     * Ajoute un message d'information déjà définit
     * @param msg      Le message a afficher
     * @return void
     */
    public JLabel addInfoMessage(JLabel label){
        statusComponent.add(label);
        setVisibilityStatusComponent(statusComponent, true);
        return label;
    }

    /**
     * Supprime un méssage d'érreur
     * @param msg      Le message servant de clé
     * @return void
     */
    public void removeInfoMessage(JLabel lab){
        statusComponent.remove(lab);
        setVisibilityStatusComponent(statusComponent, false);
    }

    /**
     * Ajoute un message d'information lié à un champ
     * @param msg      Le message a afficher
     * @param field    Le composant lié au message
     * @return void
     */
    public JLabel addFieldInfoMessage(Component field, String msg){
        JLabel label = createInfoLabel(msg);
        new FieldInfo(getStatusComponentOf(field), field, label);
        return label;
    }
    
    
    /**
     * Créer un label de validation
     * Peux servir pour redéfinir le style du méssage
     * @param msg       Le méssage de validation
     * @return void
     */
    public JLabel createValidLabel(String msg){
        JLabel label = new JLabel(msg);
        label.setIcon(validIcon);
        return label;
    }

    /**
     * Ajoute un méssage de validation et supprime tout les msg d'érreurs
     * @param msg      Le méssage a afficher
     * @return void
     */
    public JLabel addValidMessage(String msg){
        clearErrorMessage();
        JLabel msgLab = createValidLabel(msg);
        validLabel = msgLab;
        statusComponent.add(msgLab);
        setVisibilityStatusComponent(statusComponent, true);
        return msgLab;
    }

    /**
     * Ajoute un message de validation déjà définit
     * @param msg      Le message a afficher
     * @return void
     */
    public JLabel addValidMessage(JLabel label){
        clearErrorMessage();
        statusComponent.add(label);
        validLabel = label;
        setVisibilityStatusComponent(statusComponent, true);
        return label;
    }

    /**
     * Supprime le méssage de validation sans appeller setVisibilityStatusComponent
     * @return void
     */
    private void removeValid(){
        if(validLabel != null){
            statusComponent.remove(validLabel);
            validLabel = null;
        }
    }

    /**
     * Supprime le méssage de validation
     * @return void
     */
    public void removeValidMessage(){
        if(validLabel != null){
            statusComponent.remove(validLabel);
            validLabel = null;
            setVisibilityStatusComponent(statusComponent, false);
        }
    }


    /**
     * défintit le panneau des bouttons
     * @return void
     */
    public Container initButtonComponent(){
        JPanel pan = new JPanel();
        pan.setLayout(new BoxLayout(pan,BoxLayout.X_AXIS));
        pan.add(Box.createHorizontalGlue());
        return pan;
    }

    /**
     * Accesseur du panneau des boutons
     * @return Le panneau des boutons
     */
    public Container getButtonComponent(){
        return buttonComponent;
    }

    /**
     * Ajoute un écouteur d'événement clique sur un bouton
     * Evite de déclancher l'insertion de méssages à la perte du focus
     * d'un élément (déclancher seulement après le relachement du bouton)
     * Pas de class a part style FormButton , pour pouvoir etre utilisé avec
     * un GUIBulder (je connais rien au beans :) )
     * @param button        Le bouton
     * @param listener      L'écouteur
     * @return Le panneau des boutons
     */
    public void addButtonListener(JButton button, FormButtonListener listener){
        button.addMouseListener(new ButtonController(listener));
    }

    /**
     * Ajoute un bouton au panneau des boutons
     * @param button        Le bouton
     * @param listener      L'écouteur
     * @return void
     */
    public void addButton(JButton button, FormButtonListener listener){
        addButtonListener(button, listener);
        buttonComponent.add(button);
    }

    /**
     * Ajoute un bouton au panneau des boutons qui simulera
     * un click sur celui-ci lorsqu'on appuiera sur entré dans le formulaire
     * @param button        Le bouton
     * @param listener      L'écouteur
     * @return void
     */
    public JButton addSubmitButton(final JButton button, FormButtonListener listener){
        addButton(button, listener);
        button.addActionListener(new ButtonController(listener));
        getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke("ENTER" ), "action ENTER" );
        getActionMap().put("action ENTER",  new AbstractAction() {
             public void actionPerformed(ActionEvent ae) {
                 buttonAction = true;
                 button.doClick();
                 buttonAction = false;
             }
         });
        submit = button;
        if(!registerUnvalidValidator.isEmpty())
            button.setEnabled(false);
        return button;
    }

    /**
     * Ajoute un champ de formulaire pouvant recevoir une barre d'information
     * @param field         Le champ
     * @return void
     */
    public StatusField createStatusField(Component field){
        return new StatusField(this, field);
    }

    /**
     * Ajoute un validateur pour un élément
     * @param field         L'élément concerné
     * @param validator     Le valdiateur
     * @param errorMessage  Le méssage en cas d'érreur
     * @return void
     */
    public void addFieldValidator(Component field, IValidator validator, String errorMessage){
        FieldValidators validators;
        if(registerValidator.containsKey(field)){
            validators = registerValidator.get(field);
        }else{
            validators = new FieldValidators(field);
            registerValidator.put(field, validators);
            registerUnvalidValidator.add(validators);
        }
        validators.add(validator, errorMessage);
        if(submit != null)
            submit.setEnabled(false);
    }

    /**
     * Valid le formulaire
     * Boucle le registre des validateur et appèle la méthode valid de FieldValidators
     * @return vrai si le formulaire est valide
     */
    public boolean valid(){
        boolean valid = true;
        for(int i = 0; i < registerUnvalidValidator.size(); i++){
            if(!registerUnvalidValidator.get(i).valid())
                valid = false;
        }
        return valid;
    }
    
    /**
     * Ré-initialise le formulaire
     * @return void
     */
    public void reset(){
        registerUnvalidValidator.clear();
        for(FieldValidators validator : registerValidator.values())
            registerUnvalidValidator.add(validator);
        clearErrorMessage();
        removeValidMessage();
        resetComponent(getComponents());
    }

    private void resetComponent(Component[] cmps){
        OutherLoop : for(int i = 0; i < cmps.length; i++){
            Component cmp = cmps[i];
            if(registerDefaultValues.containsKey(cmp)){
                Form.setValueOf(cmp, registerDefaultValues.get(cmp));
            }else{
                for(int j = 0; j < fieldFromClass.length; j++){
                    if(fieldFromClass[j].isInstance(cmp)){
                        Form.setValueOf(cmp, "");
                        continue OutherLoop;
                    }
                }
                if(cmp instanceof Container)
                    resetComponent(((Container) cmp).getComponents());
            }
        }
    }


    /**
     * Affecte une valeur par défault à un champ
     * @param field         L'élément concerné
     * @param value         La valeur à affecter
     * @return vrai si le formulaire est valide
     */
    public void setDefaultValueOf(Component field, String value){
        registerDefaultValues.put(field, value);
        Form.setValueOf(field, value);
    }

    /**
     * Class perméttant de retarder le traitement à la perte du focus d'un champ
     * si un boutton est préssé. Si c'est le cas référence l'instance
     * dans le registre waintingFocusLost
     */
    private abstract class WaintingFocusLost implements FocusListener{
        //le composant concerné
        public final Component field;

        /**
         * Le constructeur
         * Ajoute un écouter focus au champ
         */
        public WaintingFocusLost(Component field) {
            this.field = field instanceof StatusField ? ((StatusField) field).field : field;
            this.field.addFocusListener(this);
        }
        /**
         * Ajoute au registre l'instance si un bouton est préssé
         * Sinon appel la méthode doFocusLost
         * @param e         L'objet event
         * @return void
         */
        public void focusLost(FocusEvent e) {
            if(buttonPressed){
                waintingFocusLost.add(this);
                return;
            }
            doFocusLost();
        }

        //a redéfinit
        public abstract void doFocusLost();
    }

    /**
     * Class servant de base à FieldInfo et FieldError
     */
    private abstract class AFieldMessage extends WaintingFocusLost{

        //la bar de status de l'élément
        public final Container statusComponent;

        public AFieldMessage(Container statusComponent, Component field) {
            super(field);
            this.statusComponent = statusComponent;
        }
        
        public void doFocusLost(){
           disable();
        }

        public abstract void enable();
        public abstract void disable();
        
    }
    
    /**
     * Class de gestion d'un méssage d'information lié à un champ
     */
    private class FieldInfo extends AFieldMessage{

        //le label d'information
        private final JLabel label;

        public FieldInfo(Container statusComponent, Component field, JLabel label) {
            super(statusComponent, field);
            this.label = label;
        }

        public void focusGained(FocusEvent e) {
            enable();
        }

        public void enable(){
            //Ajoute toujours en première position le méssage d'onformation
            statusComponent.add(label, 0);
            setVisibilityStatusComponent(statusComponent, true);
        }

        public void disable(){
            statusComponent.remove(label);
            setVisibilityStatusComponent(statusComponent, false);
        }

    }

    /**
     * Classe de gestion des méssages d'érreurs lié à un champ
     */
    private class FieldError extends AFieldMessage{

        //la couleur par défaut du champ
        private Color defaultColor;
        //le registre des méssage d'érreur
        private final HashSet<JLabel> register = new HashSet<JLabel>();
        //Si les méssages d'érreur sont visible que quand le champ à le fous
        private final boolean showErrorOnFocus;
        //bug l&f windows, impossible de changer de couleur le background
        //retien le renderer du combo
        private ListCellRenderer cellRenderer;
        //bug l&f windows, impossible de changer de couleur le background
        private final boolean isCombo;

        /**
         * Le constructeur
         * Définit showErrorOnFocus, defaultColor et ajoute l'instance au registre
         * des érreurs liè à un champ
         */
        public FieldError(Container statusComponent, Component field) {
            super(statusComponent, field);
            showErrorOnFocus = !(field instanceof StatusField) ? true : Form.this.showErrorOnFocus;
            if(showErrorOnFocus)
                defaultColor = this.field.getBackground();
            registerFieldError.put(field, this);

            isCombo = this.field instanceof JComboBox;
            if(isCombo && showErrorOnFocus){
                cellRenderer = ((JComboBox) FieldError.this.field).getRenderer();
                //applique le renderer à la combo
                ((JComboBox) FieldError.this.field).setRenderer(new ListCellRenderer() {
                    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                        Component renderer = cellRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                        if(renderer instanceof JLabel
                                && !FieldError.this.field.isFocusOwner()
                                && !register.isEmpty()){
                            ((JLabel) renderer).setBackground(errorColor);
                            ((JLabel) renderer).setOpaque(true);
                        }
                        return renderer;
                    }
                });
            }
        }

        public void focusGained(FocusEvent e) {
            enable();
        }
        
        public void enable(){
            //si les érreurs sont toujours affiché, ou que le registre est vide
            //ne rien faire
            if(showErrorOnFocus && !register.isEmpty()){
                if(!isCombo)
                    field.setBackground(defaultColor);
                setErrorVisibility(true);
                removeValid();
                setVisibilityStatusComponent(statusComponent, true);
            }
        }

        public void disable(){
            //si les érreurs sont toujours affiché, ou que le registre est vide
            //ne rien faire
            if(showErrorOnFocus && !register.isEmpty()){
                if(!isCombo)
                    field.setBackground(errorColor);
                setErrorVisibility(false);
                setVisibilityStatusComponent(statusComponent, false);
            }
        }

        /**
         * Ajoute un méssage d'érreur liè à l'élément
         * l'affiche ou pas en fonction de showErrorOnFocus
         * et met a jour sa couleur
         * @param labError     Le label d'érreur
         * @return void
         */
        public void add(JLabel labError){
            register.add(labError);
            if(showErrorOnFocus){
                //on devrait testé aussi && !isCombo
                //mais ca beug, il n'affiche pas la bonne couleur (blanc) 
                if(register.size() == 1)
                    field.setBackground(errorColor);
            }else{
                statusComponent.add(labError);
                setVisibilityStatusComponent(statusComponent, true);
            }
            removeValid();
        }

        /**
         * Supprime un méssage d'érreur liè à l'élément
         * et met a jour sa couleur
         * @param labError     Le label d'érreur
         * @return void
         */
        public void remove(JLabel labError){
            statusComponent.remove(labError);
            if(showErrorOnFocus && register.isEmpty())
                field.setBackground(defaultColor);
            register.remove(labError);
            setVisibilityStatusComponent(statusComponent, false);
        }

        /**
         * Supprime tous les méssage et met a jour sa couleur
         * @return void
         */
        public void clear(){
            Iterator<JLabel> it = register.iterator();
            while (it.hasNext())
                statusComponent.remove(it.next());
            register.clear();
            if(showErrorOnFocus)
                 field.setBackground(defaultColor);
            setVisibilityStatusComponent(statusComponent, false);
        }
        

        /**
         * Rend visible ou  pas les méssages
         * @return void
         */
        private void setErrorVisibility(boolean visible){
            Iterator<JLabel> it = register.iterator();
            while (it.hasNext()){
                if(visible){
                    statusComponent.add(it.next());
                }else statusComponent.remove(it.next());
            }
        }
    }


    /*
     * Classe privé référencant tout les validateur d'un champ
     */
    private class FieldValidators extends WaintingFocusLost{

        //le registre des validateurs de l'élément
        public final ArrayList<FieldValidator> register = new ArrayList<FieldValidator>();
        //si l'élément à déjà été traité par la validation
        public  boolean init = false;
        //si valide les validations
        public boolean valid = false;
        //si requit
        public boolean required = false;
        //l'instance FieldError lié à l'élément
        public final FieldError error;

        /**
         * le constructeur du registre des validateurs d'élément
         * @param field Un élément de type champ de formulaire
         */
        public FieldValidators(Component field) {
            super(field);
            //retrouve l'insatnce FieldError si déjà definit, sinon la créé
            error = registerFieldError.containsKey(field) ?
                registerFieldError.get(field) : new FieldError(getStatusComponentOf(field), field);
        }


        public void focusGained(FocusEvent e) {}

        /**
         * Ajoute un validateur au registre
         * @param validator Le validateur de type IValidator
         * @param errorMessage Le message d'érreur à afficher
         * @return void
         */
        public void add(IValidator validator, String errorMessage){
            register.add(new FieldValidator(validator, errorMessage));
            if(validator.equals(CommonsValidator.required))
                required = true;
        }

        /**
         * Lance le traitement ou pas de la validation
         * @return vrai si l'élément du formulaire valide tout ses validateurs
         */
        public boolean valid(){
            // si le traitement de la validation n'a pas été éffectué , ou que le focus est sur le champ
            if(!init || field.isFocusOwner())
                doFocusLost();
            return valid;
        }

        /**
         * Permet de valider ou pas l'élément
         * Parcour l'ensemble des validateur de l'élément, test si valide,
         * sinon, affiche un méssage d'érreur, bloque les autres teste, et supprime les éventuel autre msg d'érreurs déjà définit
         */
         public void doFocusLost(){
            boolean invalid = false;
            String value = Form.getValueOf(field);
            if(!required && value.equals("")){
                valid = true;
            }else{
                for(int i = 0; i < register.size(); i++){
                    FieldValidator fieldValidator = register.get(i);
                    if(!invalid && !fieldValidator.validator.valid(value)){
                        fieldValidator.initErrorMessage();
                        invalid = true;
                    }else if(fieldValidator.label != null)
                        error.remove(fieldValidator.label);
                }
                valid = !invalid;
            }
            init = true;
            if(valid)
                registerUnvalidValidator.remove(this);
            if(registerUnvalidValidator.isEmpty())
                submit.setEnabled(true);
        }


        /**
         * Classe privé référencant pour chaque validateur, son message d'érreur et son label
         */
        private class FieldValidator{

            public final IValidator validator;
            public final String message;
            public JLabel label;

            public FieldValidator(IValidator validator, String message) {
                this.validator = validator;
                this.message = message;
            }

            public void initErrorMessage(){
                if(label == null)
                    label = createErrorLabel(message);
                error.add(label);
            }
        }
    }

   

    /*
     * Classe d'action des bouttons
     * Nécéssaire pour ne pas l'ancer les évènements à la perte du focus d'un champ
     * lors d'un clique ou simulation d'un clicque sur un bouton
     */
    private class ButtonController extends MouseAdapter implements ActionListener{

        private final FormButtonListener listener;
        private boolean isOver;

        public ButtonController(FormButtonListener listener) {
            this.listener = listener;
        }

        public void mousePressed(MouseEvent e) {
            buttonPressed = true;
        }

        public void mouseReleased(MouseEvent e) {
            for(int i = 0; i < waintingFocusLost.size(); i++)
                waintingFocusLost.get(i).doFocusLost();
            waintingFocusLost.clear();
            buttonPressed = false;
            if(isOver)
                listener.buttontClicked(e);
        }
        
        public void actionPerformed(ActionEvent e) {
            if(!buttonAction)
                return;
            listener.buttontClicked(e);
        }

        public void mouseEntered(MouseEvent e) {
            isOver = true;
        }

        public void mouseExited(MouseEvent e) {
            isOver = false;
        }
    }


    /**
     * Expérimentale, à compléter + créer une fonction du même type pour les liste multiple (table, jlist ect...)
     * retourne la valeur d'un champ de formulaire en fonction de son type
     * @param el    Le composant de type champ de formulaire
     * @return Une valeur formater en chaine de caractère
     */
    public static String getValueOf(Component el){
        String ret = null;
        if(el instanceof StatusField)
            el = ((StatusField) el).field;

        if(el instanceof JPasswordField){
            ret = new String(((JPasswordField) el).getPassword());
        }else if(el instanceof JTextComponent){
            ret = ((JTextComponent) el).getText();
        }else if(el instanceof TextComponent){
            ret = ((TextComponent) el).getText();
        }else if(el instanceof JToggleButton){
            JToggleButton ele = (JToggleButton) el;
            ret = ele.isSelected() ? "1" : "0";
        }else if(el instanceof Checkbox){
            Checkbox ele = (Checkbox) el;
            ret = ele.getState() ? "1" : "0";
        }else if(el instanceof JComboBox){
            ret = (String) ((JComboBox) el).getSelectedItem();
        }
        return ret == null ? "" : ret;
    }

    
    /**
     * Expérimentale, à compléter + créer une fonction du même type pour les liste multiple (table, jlist ect...)
     * initialise la valeur d'un champ de formulaire en fonction de son type
     * @param el    Le composant de type champ de formulaire
     * @return void
     */
    public static void setValueOf(Component el, String value){
        if(el instanceof StatusField)
            el = ((StatusField) el).field;
        if(el instanceof JTextComponent){
            ((JTextComponent) el).setText(value);
        }else if(el instanceof TextComponent){
            ((TextComponent) el).setText(value);
        }else if(el instanceof JToggleButton){
            JToggleButton ele = (JToggleButton) el;
            ele.setSelected(value.equals("1" )? true : false);
        }else if(el instanceof Checkbox){
            Checkbox ele = (Checkbox) el;
            ele.setState(value.equals("1" )? true : false);
        }else if(el instanceof JComboBox){
            ((JComboBox) el).setSelectedItem(value);
        }

    }

}
