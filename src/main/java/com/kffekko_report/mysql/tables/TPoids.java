/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kffekko_report.mysql.tables;

import com.kffekko_report.mysql.MySQLAccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author akil
 */
public class TPoids extends MySQLAccess{
    
    private String bdUrl;
    private Connection conn = null;
    public TPoids(String bdUrl){
        
        this.bdUrl = bdUrl;
    }
    public void create() throws SQLException
    {
        String sql = "CREATE TABLE IF NOT EXISTS poids (\n" +
            "    `campagne` VARCHAR(124) CHARACTER SET utf8,\n" +
            "    `no_Formule` VARCHAR(124) CHARACTER SET utf8,\n" +
            "    `ref_Date_Base_Rapport` VARCHAR(124) CHARACTER SET utf8,\n" +
            "    `date_Saisie` VARCHAR(124) CHARACTER SET utf8,\n" +
            "    `date_CGFCC` VARCHAR(124) CHARACTER SET utf8,\n" +
            "    `mois` VARCHAR(124) CHARACTER SET utf8,\n" +
            "    `annee` VARCHAR(124) CHARACTER SET utf8,\n" +
            "    `exportateur` VARCHAR(124) CHARACTER SET utf8,\n" +
            "    `type_Exportateur` VARCHAR(124) CHARACTER SET utf8,\n" +
            "    `categorie` VARCHAR(124) CHARACTER SET utf8,\n" +
            "    `specificit_Exportateur` VARCHAR(124) CHARACTER SET utf8,\n" +
            "    `transitaire` VARCHAR(124) CHARACTER SET utf8,\n" +
            "    `port_Embarquement` VARCHAR(124) CHARACTER SET utf8,\n" +
            "    `continent_Destination` VARCHAR(124) CHARACTER SET utf8,\n" +
            "    `pays_Destination` VARCHAR(124) CHARACTER SET utf8,\n" +
            "    `port_Destination` VARCHAR(124) CHARACTER SET utf8,\n" +
            "    `produit` VARCHAR(124) CHARACTER SET utf8,\n" +
            "    `nature_Produit` VARCHAR(124) CHARACTER SET utf8,\n" +
            "    `recolte` VARCHAR(124) CHARACTER SET utf8,\n" +
            "    `type_Produit` VARCHAR(124) CHARACTER SET utf8,\n" +
            "    `prix_CAF` VARCHAR(124) CHARACTER SET utf8,\n" +
            "    `tx_Null` VARCHAR(124) CHARACTER SET utf8,\n" +
            "    `numero_CDC` VARCHAR(124) CHARACTER SET utf8,\n" +
            "    `poids_Net` VARCHAR(124) CHARACTER SET utf8,\n" +
            "    `poids_Feves` VARCHAR(124) CHARACTER SET utf8,\n" +
            "    `poids_Reel` VARCHAR(124) CHARACTER SET utf8,\n" +
            "    `statut_Formule` VARCHAR(124) CHARACTER SET utf8,\n" +
            "    `date_Pes_e_complet` VARCHAR(124) CHARACTER SET utf8,\n" +
            "    `no_Certificat` VARCHAR(124) CHARACTER SET utf8,\n" +
            "    `transit` VARCHAR(124) CHARACTER SET utf8,\n" +
            "    `recu_le` VARCHAR(124) CHARACTER SET utf8,\n" +
            "    `depot` VARCHAR(124) CHARACTER SET utf8,\n" +
            "    `depose_le` VARCHAR(124) CHARACTER SET utf8,\n" +
            "    `signe` VARCHAR(124) CHARACTER SET utf8,\n" +
            "    `signe_le` VARCHAR(124) CHARACTER SET utf8,\n" +
            "    `retire` VARCHAR(124) CHARACTER SET utf8,\n" +
            "    `retire_le` VARCHAR(124) CHARACTER SET utf8,\n" +
            "    `retirant` VARCHAR(124) CHARACTER SET utf8,\n" +
            "    `reriode` VARCHAR(124) CHARACTER SET utf8,\n" +
            "    `nomenclature` VARCHAR(124) CHARACTER SET utf8\n" +
            ")";
        try {
            
            Connection conn = DriverManager.getConnection(this.bdUrl, this.bdUser, this.bdPassword);
            // create a new table
            conn.createStatement().execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally{
            if(this.conn != null){
                conn.close();
            }
        }
    }
    
}
