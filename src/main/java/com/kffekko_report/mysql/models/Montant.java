/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kffekko_report.mysql.models;

import com.kffekko_report.mysql.MySQLAccess;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author akil
 */
public class Montant {
   
    private String id;
    private String date_CGFCC;
    private String campagne;
    private String no_formule;
    private String exportateur;
    private String type_Exportateur;
    private String categorie;
    private String mois;
    private String produit;
    private String nature_Produit;
    private String type_Produit;
    private String port_Embarquement;
    private String poids_Feves;
    private String poids_Reel;
    private String taxe_Redevance;
    private String valeur_Taxe;
    private String montant_Preleve;
    private String montant_Calcule;
    private String montant_Reel;
    private String reajustement;
    private String no_Cheque;
    private String date;
    private String banque;
    private String statut_Formule;
    
            
    private MySQLAccess mysqlAccess;
    
    public Montant()
    {
        this.mysqlAccess = new MySQLAccess();
    }


    public Montant(String ...properties
            ) {
        this.id = properties[1];
        this.date_CGFCC = properties[0];
        this.campagne = properties[1];
        this.no_formule = properties[2];
        this.exportateur = properties[3];
        this.type_Exportateur = properties[4];
        this.categorie = properties[5];
        this.mois = properties[6];
        this.produit = properties[7];
        this.nature_Produit = properties[8];
        this.type_Produit = properties[9];
        this.port_Embarquement = properties[10];
        this.poids_Feves = properties[11];
        this.poids_Reel = properties[12];
        this.taxe_Redevance = properties[13];
        this.valeur_Taxe = properties[14];
        this.montant_Preleve = properties[15];
        this.montant_Calcule = properties[16];
        this.montant_Reel = properties[17];
        this.reajustement = properties[18];
        this.no_Cheque = properties[19];
        this.date = properties[20];
        this.banque = properties[21];
        this.statut_Formule = properties[22];
        
        this.mysqlAccess = new MySQLAccess();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

   
    
    public List<Montant> getAll() throws SQLException
    {
        ResultSet resultSet = this.mysqlAccess.select("Select * from poids");
        List<Montant> montants = new ArrayList<Montant>();
       
        while (resultSet.next()) {
            montants.add(new Montant(
                    resultSet.getString("id"),
                    resultSet.getString("campagne"),
                    resultSet.getString("no_formule"),
                    resultSet.getString("exportateur"),
                    resultSet.getString("type_Exportateur"),
                    resultSet.getString("categorie"),
                    resultSet.getString("mois"),
                    resultSet.getString("produit"),
                    resultSet.getString("nature_Produit"),
                    resultSet.getString("port_Embarquement"),
                    resultSet.getString("poids_Feves"),
                    resultSet.getString("poids_Reel"),
                    resultSet.getString("taxe_Redevance"),
                    resultSet.getString("valeur_Taxe"),
                    resultSet.getString("montant_Preleve"),
                    resultSet.getString("montant_Calcule"),
                    resultSet.getString("montant_Reel"),
                    resultSet.getString("reajustement"),
                    resultSet.getString("no_Cheque"),
                    resultSet.getString("date"),
                    resultSet.getString("banque"),
                    resultSet.getString("statut_Formule")
            ));
           
        }
        
        return montants;
    }
    
    public void save() throws SQLException{
        
        String[] values = {
            this.date_CGFCC,
            this.campagne,
            this.no_formule,
            this.exportateur,
            this.type_Exportateur,
            this.categorie,
            this.mois,
            this.produit,
            this.nature_Produit,
            this.type_Produit,
            this.port_Embarquement,
            this.poids_Feves,
            this.poids_Reel,
            this.taxe_Redevance,
            this.valeur_Taxe,
            this.montant_Preleve,
            this.montant_Calcule,
            this.montant_Reel,
            this.reajustement,
            this.no_Cheque,
            this.date,
            this.banque,
            this.statut_Formule
            };
        
        this.mysqlAccess.insert("montant", values);
    }
}
