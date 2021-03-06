/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kffekko_report.mysql;


import com.kffekko_report.mysql.tables.TMontant;
import com.kffekko_report.mysql.tables.TPoids;
import com.kffekko_report.ui.ConfigPanel;
import com.kffekko_report.util.FileUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author akil
 */
public class MySQLAccess {
    
    protected String bdUser;
    protected String bdPassword;
    protected String bdName;
    protected String bdUrl;
    protected Connection connection;
    protected Statement state = null;
    
    public MySQLAccess()
    {
        List lignes = FileUtils.lireFichier("text.txt");
         this.bdUser = lignes.get(0).toString();
         this.bdPassword = lignes.get(1).toString();
         this.bdName = "kffekko";
         this.bdUrl = "jdbc:mysql://localhost/";
    }
    
    public MySQLAccess(String bdUser, String bdPassword, String bdName)
    {
        this.bdUser = bdUser;
        this.bdPassword = bdPassword;
        this.bdName = bdName;
        this.bdUrl = "jdbc:mysql://localhost/";
    }
    
    public ResultSet select(String select) throws SQLException
    {
        ResultSet resultSet= null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager
                    .getConnection(this.bdUrl, this.bdUser, this.bdPassword);
            // Statements allow to issue SQL queries to the database
            Statement statement = this.connection.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement
                    .executeQuery(select);
            
        } catch (Exception ex) {
            System.out.println(ex);
            //Logger.getLogger(MySQLAccess.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(this.connection != null){
                this.connection .close();
            }
        }
        
       return resultSet;
    }
    
    
    public void insert(String tableName, String[] values) throws SQLException
    {
        try {
            this.bdUrl += this.bdName;
            
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager
                    .getConnection(this.bdUrl, this.bdUser, this.bdPassword);
            
            
            String sqlValue = "";
            
            for(String value: values){
                sqlValue += "\"" + value + "\",";
            }
            sqlValue = sqlValue.substring(0, sqlValue.length()-1);
            String sql = "INSERT INTO "+ tableName + " VALUES ("+sqlValue + ")";
            System.out.println(sql);
            this.connection.createStatement().executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLAccess.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(this.connection != null){
                this.connection.close();
            }
        }
    }
    
    public String dropDB()
    {
        String msg = "BD suppression";
        try {
            String sql = "DROP DATABASE IF EXISTS "+ this.bdName+ ";";
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                msg = ex.getMessage().toString();
            }
            this.connection = DriverManager
                    .getConnection(this.bdUrl, this.bdUser, this.bdPassword);
            
            msg+= sql;
            Statement state = this.connection.createStatement();
            state.executeUpdate(sql);
            msg +=  "Database deleted successfully...";
        } catch (SQLException ex) {
            msg = ex.getMessage().toString();
        }finally{
            if(this.connection != null){
                try {
                    this.connection.close();
                } catch (SQLException ex) {
                    msg = ex.getMessage().toString();
                }
            }
        }
        
        return msg;
    }
    
    public String createDB()
    {
        String msg = "BD creation error";
        try {
            String sql = "CREATE DATABASE IF NOT EXISTS "+ this.bdName+ ";";
             try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                msg = ex.getMessage().toString();
            }
            this.connection = DriverManager
                    .getConnection(this.bdUrl, this.bdUser, this.bdPassword);
            msg+=sql;
            Statement state = this.connection.createStatement();
            state.executeUpdate(sql);
            this.bdUrl += this.bdName;
            msg+= "Database created successfully";
        } catch (SQLException ex) {
            msg = ex.getMessage().toString();
        }finally{
            if(this.connection != null){
                try {
                    this.connection.close();
                } catch (SQLException ex) {
                    msg = ex.getMessage().toString();
                }
            }
        }
        return msg;
    }
    
    public String initTables()
    {
        String msg;
        try {
            msg = new TPoids(this.getBdUrl()).create();
            new TMontant(this.getBdUrl()).create();
            msg += "Table initialisé avec succes";
        } catch (SQLException ex) {
            return ex.getMessage().toString();
        }
        return msg;
    }
    public String initDB()
    {
        String msg = "Init BD";
        msg +="/n" + dropDB();
        msg +="/n" + createDB();
        msg +="/n"+ initTables();
        return msg;
    }
    public String getBdUser() {
        return bdUser;
    }

    public void setBdUser(String bdUser) {
        this.bdUser = bdUser;
    }

    public String getBdPassword() {
        return bdPassword;
    }

    public void setBdPassword(String bdPassword) {
        this.bdPassword = bdPassword;
    }

    public String getBdName() {
        return bdName;
    }

    public void setBdName(String bdName) {
        this.bdName = bdName;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public String getBdUrl() {
        return bdUrl;
    }

    public void setBdUrl(String bdUrl) {
        this.bdUrl = bdUrl;
    }
    
    
}
