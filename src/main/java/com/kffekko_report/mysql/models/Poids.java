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
public class Poids {
   
    private String id;
    private String campagne;
    private String no_formule;
    private String ref_Date_Base_Rapport;
    private String date_Saisie;
    private String date_CGFCC;
    private String mois;
    private String annee;
    private String exportateur;
    private String type_Exportateur;
    private String categorie;
    private String specificit_Exportateur;
    private String transitaire;
    private String port_Embarquement;
    private String continent_Destination;
    private String pays_Destination;
    private String port_Destination;
    private String produit;
    private String nature_Produit;
    private String recolte;
    private String type_Produit;
    private String prix_CAF;
    private String tx_Null;
    private String numero_CDC;
    private String poids_Net;
    private String poids_Feves;
    private String poids_Reel;
    private String statut_Formule;
    private String date_Pes_e_complet;
    private String no_Certificat;
    private String transit;
    private String recu_le;
    private String depot;
    private String depose_le;
    private String signe;
    private String signe_le;
    private String retire;
    private String retire_le;
    private String retirant;
    private String periode;
    private String nomenclature;

            
    private MySQLAccess mysqlAccess;
    
    public Poids()
    {
        this.mysqlAccess = new MySQLAccess();
    }

    public Poids(String ...properties
            ) {
        this.id = properties[1];
        this.campagne = properties[0];
        this.no_formule = properties[1];
        this.ref_Date_Base_Rapport = properties[2];
        this.date_Saisie = properties[3];
        this.date_CGFCC = properties[4];
        this.mois = properties[5];
        this.annee = properties[6];
        this.exportateur = properties[7];
        this.type_Exportateur = properties[8];
        this.categorie = properties[9];
        this.specificit_Exportateur = properties[10];
        this.transitaire = properties[11];
        this.port_Embarquement = properties[12];
        this.continent_Destination = properties[13];
        this.pays_Destination = properties[14];
        this.port_Destination = properties[15];
        this.produit = properties[16];
        this.nature_Produit = properties[17];
        this.recolte = properties[18];
        this.type_Produit = properties[19];
        this.prix_CAF = properties[20];
        this.tx_Null = properties[21];
        this.numero_CDC = properties[22];
        this.poids_Net = properties[23];
        this.poids_Feves = properties[24];
        this.poids_Reel = properties[25];
        this.statut_Formule = properties[26];
        this.date_Pes_e_complet = properties[27];
        this.no_Certificat = properties[28];
        this.transit = properties[29];
        this.recu_le = properties[30];
        this.depot = properties[31];
        this.depose_le = properties[32];
        this.signe = properties[33];
        this.signe_le = properties[34];
        this.retire = properties[35];
        this.retire_le = properties[36];
        this.retirant = properties[37];
        this.periode = properties[38];
        this.nomenclature = properties[39];
        this.mysqlAccess = new MySQLAccess();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

   
    
    public List<Poids> getAll() throws SQLException
    {
        ResultSet resultSet = this.mysqlAccess.select("Select * from poids");
        List<Poids> poids = new ArrayList<Poids>();
       
        while (resultSet.next()) {
            poids.add(new Poids(
                    resultSet.getString("id"),
                    resultSet.getString("campagne"),
                    resultSet.getString("no_formule"),
                    resultSet.getString("ref_Date_Base_Rapport"),
                    resultSet.getString("date_Saisie"),
                    resultSet.getString("date_CGFCC"),
                    resultSet.getString("mois"),
                    resultSet.getString("annee"),
                    resultSet.getString("exportateur"),
                    resultSet.getString("type_Exportateur"),
                    resultSet.getString("categorie"),
                    resultSet.getString("specificit_Exportateur"),
                    resultSet.getString("transitaire"),
                    resultSet.getString("port_Embarquement"),
                    resultSet.getString("continent_Destination"),
                    resultSet.getString("pays_Destination"),
                    resultSet.getString("port_Destination"),
                    resultSet.getString("produit"),
                    resultSet.getString("nature_Produit"),
                    resultSet.getString("recolte"),
                    resultSet.getString("type_Produit"),
                    resultSet.getString("prix_CAF"),
                    resultSet.getString("tx_Null"),
                    resultSet.getString("numero_CDC"),
                    resultSet.getString("poids_Net"),
                    resultSet.getString("poids_Feves"),
                    resultSet.getString("poids_Reel"),
                    resultSet.getString("statut_Formule"),
                    resultSet.getString("date_Pes_e_complet"),
                    resultSet.getString("no_Certificat"),
                    resultSet.getString("transit"),
                    resultSet.getString("recu_le"),
                    resultSet.getString("depot"),
                    resultSet.getString("depose_le"),
                    resultSet.getString("signe"),
                    resultSet.getString("signe_le"),
                    resultSet.getString("retire"),
                    resultSet.getString("retire_le"),
                    resultSet.getString("retirant"),
                    resultSet.getString("periode"),
                    resultSet.getString("nomenclature")
            ));
           
        }
        
        return poids;
    }
    
    public void save() throws SQLException{
        
        String[] values = {

                this.campagne,
                this.no_formule,
                this.ref_Date_Base_Rapport,
                this.date_Saisie,
                this.date_CGFCC,
                this.mois,
                this.annee,
                this.exportateur,
                this.type_Exportateur,
                this.categorie,
                this.specificit_Exportateur,
                this.transitaire,
                this.port_Embarquement,
                this.continent_Destination,
                this.pays_Destination,
                this.port_Destination,
                this.produit,
                this.nature_Produit,
                this.recolte,
                this.type_Produit,
                this.prix_CAF,
                this.tx_Null,
                this.numero_CDC,
                this.poids_Net,
                this.poids_Feves,
                this.poids_Reel,
                this.statut_Formule,
                this.date_Pes_e_complet,
                this.no_Certificat,
                this.transit,
                this.recu_le,
                this.depot,
                this.depose_le,
                this.signe,
                this.signe_le,
                this.retire,
                this.retire_le,
                this.retirant,
                this.periode,
                this.nomenclature,
            };
        
        this.mysqlAccess.insert("poids", values);
    }
}
