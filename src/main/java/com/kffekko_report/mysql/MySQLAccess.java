/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kffekko_report.mysql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author akil
 */
public class MySQLAccess {
    
    private String bdUser;
    private String bdPassword;
    private String bdName;
    private Connection connection;
    
    public MySQLAccess()
    {
         this.bdUser = "root";
         this.bdPassword = "root";
         this.bdName = "db_name";
         try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager
                    .getConnection("jdbc:mysql://localhost/" + this.bdName + "?"
                            + "user=" + this.bdUser + "&password=" + this.bdPassword);
        } catch (Exception ex) {
            System.out.println(ex);
            //Logger.getLogger(MySQLAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public MySQLAccess(String bdUser, String bdPassword, String bdName)
    {
        this.bdUser = bdUser;
        this.bdPassword = bdPassword;
        this.bdName = bdName;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager
                    .getConnection("jdbc:mysql://localhost/" + this.bdName + "?"
                            + "user=" + this.bdUser + "&password=" + this.bdPassword);
        } catch (Exception ex) {
            System.out.println(ex);
            //Logger.getLogger(MySQLAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet select(String select) throws SQLException
    {
        // Statements allow to issue SQL queries to the database
        Statement statement = this.connection.createStatement();
            // Result set get the result of the SQL query
         ResultSet resultSet = statement
                    .executeQuery(select);
         
         return resultSet;
    }
    
    public void insert(String tableName, String[] values) throws SQLException
    {
        
        String sqlValue = "";
        
        for(String value: values){
            sqlValue += "'" + value + "',";
        }
        sqlValue = sqlValue.substring(0, sqlValue.length()-1);
        String sql = "INSERT INTO "+ tableName + " VALUES ("+sqlValue + ")";
        System.out.println(sql);
        this.connection.createStatement().executeUpdate(sql);
    }
    
}
