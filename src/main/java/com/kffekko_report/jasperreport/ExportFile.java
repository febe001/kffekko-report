/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kffekko_report.jasperreport;

import com.kffekko_report.mysql.MySQLAccess;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import javax.servlet.ServletOutputStream;

/**
 *
 * @author akil
 */
public class ExportFile {
    
    
    private JasperReport jasperReport;
    private JasperPrint jasperPrint;
    private MySQLAccess mysqlAccess = new MySQLAccess();
    
    public void ExportFile(){}
    
    public void toPDF() throws SQLException, IOException{
        
        try {
            File directory = new File (".");

            this.jasperReport = JasperCompileManager.compileReport(directory.getCanonicalPath()
+ "/src/main/java/com/kffekko_report/jasperreport/models/i.3.jrxml");
            
            HashMap parameters = new HashMap();
            Connection conn = DriverManager
                    .getConnection(mysqlAccess.getBdUrl() +mysqlAccess.getBdName(), mysqlAccess.getBdUser(), mysqlAccess.getBdPassword());
            jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
        
        Logger.getLogger(ExportFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
