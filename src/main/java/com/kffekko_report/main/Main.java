/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kffekko_report.main;

import com.kffekko_report.mysql.MySQLAccess;
import com.kffekko_report.mysql.models.Author;
import com.kffekko_report.ui.MainFrame;
import com.kffekko_report.util.ExcelFile;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author akil
 */
public class Main {
    
   
    public static void main(String[] args) throws SQLException
    {
        new MainFrame();
        
        /*ExcelFile tab = new ExcelFile("./docs/report.xlsx", "planing");
        Object corps[][] = tab.getBody();
        System.out.println(corps[0][5]);
        List<Author> authors = new Author().getAll();
        for(Author f : authors)
            System.out.println(f.getId());
        
        Author author = new Author("1", "ben");
        author.save();*/
        
       
       
        
    }
    
    
}
