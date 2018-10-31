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
public class Author {
   
    private String id;
    private String name;
    private MySQLAccess mysqlAccess;
    
    public Author()
    {
        this.mysqlAccess = new MySQLAccess();
    }
    public Author(String id, String name)
    {
        this.id = id;
        this.name = name;
        this.mysqlAccess = new MySQLAccess();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public List<Author> getAll() throws SQLException
    {
        ResultSet resultSet = this.mysqlAccess.select("Select * from author1");
        List<Author> authors = new ArrayList<Author>();
       
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            authors.add(new Author(resultSet.getString("id"), resultSet.getString("name")));
           
        }
        
        return authors;
    }
    
    public void save() throws SQLException{
        
        String[] values = {"45", "aa"};
        
        this.mysqlAccess.insert("author1", values);
    }
}
