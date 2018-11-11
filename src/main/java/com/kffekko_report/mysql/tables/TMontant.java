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
public class TMontant extends MySQLAccess{
    
    private String bdUrl;
    private Connection conn = null;
    
    public TMontant(String bdUrl){
        
        this.bdUrl = bdUrl;
    }
    public void create() throws SQLException
    {
        String sql = "CREATE TABLE IF NOT EXISTS montant (\n" +
            "    `date_CGFCC` VARCHAR(125),\n" +
            "    `campagne` VARCHAR(125) CHARACTER SET utf8,\n" +
            "    `no_Formule` VARCHAR(125) CHARACTER SET utf8,\n" +
            "    `exportateur` VARCHAR(125) CHARACTER SET utf8,\n" +
            "    `type_Exportateur` VARCHAR(125) CHARACTER SET utf8,\n" +
            "    `categorie` VARCHAR(125) CHARACTER SET utf8,\n" +
            "    `mois` VARCHAR(125) CHARACTER SET utf8,\n" +
            "    `produit` VARCHAR(125) CHARACTER SET utf8,\n" +
            "    `nature_Produit` VARCHAR(125) CHARACTER SET utf8,\n" +
            "    `type_Produit` VARCHAR(125) CHARACTER SET utf8,\n" +
            "    `port_Embarquement` VARCHAR(125) CHARACTER SET utf8,\n" +
            "    `poids_Feves` VARCHAR(125) CHARACTER SET utf8,\n" +
            "    `poids_Reel` VARCHAR(125) CHARACTER SET utf8,\n" +
            "    `taxe_Redevance` VARCHAR(125) CHARACTER SET utf8,\n" +
            "    `valeur_Taxe` VARCHAR(125) CHARACTER SET utf8,\n" +
            "    `montant_Preleve` VARCHAR(125) CHARACTER SET utf8,\n" +
            "    `montant_Calcule` VARCHAR(125) CHARACTER SET utf8,\n" +
            "    `montant_Reel` VARCHAR(125) CHARACTER SET utf8,\n" +
            "    `reajustement` VARCHAR(125) CHARACTER SET utf8,\n" +
            "    `no_Cheque` VARCHAR(125) CHARACTER SET utf8,\n" +
            "    `date` VARCHAR(125) CHARACTER SET utf8,\n" +
            "    `banque` VARCHAR(125) CHARACTER SET utf8,\n" +
            "    `statut_Formule` VARCHAR(125) CHARACTER SET utf8\n" +
            ");";
        
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
