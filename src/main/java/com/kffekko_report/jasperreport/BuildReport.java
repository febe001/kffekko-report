/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kffekko_report.jasperreport;

import com.kffekko_report.jasperreport.models.rp_2_textExpression;
import com.kffekko_report.mysql.MySQLAccess;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author akil
 */
public class BuildReport {
    
    private String periodYear;
    private String periodMonthStart;
    private String periodMonthEnd;
    private String product;
    private List <String> productTypes;
    private List <String> cities;
    private String modelType;
    private EnumReportModel ereportModel;
    private JasperReport jasperReport;
    private JasperPrint jasperPrint;
    private MySQLAccess mysqlAccess = new MySQLAccess();
    
    public BuildReport(String year, String monthStart, String monthEnd,
            String product, List <String> productTypes, List <String> cities,
            String modelType){
       
        this.periodYear = year;
        this.periodMonthStart = monthStart;
        this.periodMonthEnd = monthEnd;
        this.product = product;
        this.productTypes = productTypes;
        this.cities = cities;
        this.ereportModel = new ReportModel().getModel(modelType);
    }
    
    public void exportModel() throws IOException, SQLException{
        try {
            File directory = new File (".");

            this.jasperReport = JasperCompileManager.compileReport(directory.getCanonicalPath()
+ "/src/main/java/com/kffekko_report/jasperreport/models/" + this.ereportModel);
            
            HashMap parameters = new HashMap();
            parameters.put("year", this.periodYear);
            parameters.put("monthStart", this.periodMonthStart);
            parameters.put("monthEnd", this.periodMonthEnd);
            parameters.put("product", this.periodMonthEnd);
            parameters.put("productType", this.periodMonthEnd);
            parameters.put("cities", this.periodMonthEnd);
            parameters.put("prameter1", new rp_2_textExpression());
            
            Connection conn = DriverManager
                    .getConnection(mysqlAccess.getBdUrl() +mysqlAccess.getBdName(), mysqlAccess.getBdUser(), mysqlAccess.getBdPassword());
            jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
        
        Logger.getLogger(ExportFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
