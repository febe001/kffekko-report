

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author akil
 */
public class BuildReport {
    
    private String periodMonthStart;
    private String periodMonthEnd;
    private String yearStart;
    private String yearEnd;
    private String product;
    private List <String> productTypes;
    private List <String> categories;
    private List <String> exporterSpecificity;
    private List <String> exporterTypes;
    private List <String> cities;
    private String modelType;
    private EnumReportModel ereportModel;
    private JasperReport jasperReport;
    private JasperPrint jasperPrint;
    private MySQLAccess mysqlAccess = new MySQLAccess();
    protected Connection connection;
    
    public BuildReport(String monthStart, String yearStart, String monthEnd, String yearEnd,
            String product, List <String> productTypes, List <String> cities,
            List <String> categories, List <String> exporterTypes, List <String> exporterSpecificity,
            String modelType){
       
        this.periodMonthStart = monthStart;
        this.yearStart = yearStart;
        this.periodMonthEnd = monthEnd;
        this.yearEnd = yearEnd;
        this.product = product;
        this.productTypes = productTypes;
        this.categories = categories;
        this.cities = cities;
        this.modelType = modelType;
        this.ereportModel = new ReportModel().getModel(modelType);
        this.exporterSpecificity = exporterSpecificity;
        this.exporterTypes = exporterTypes;
        
    }
    
    public void exportModel() throws IOException, SQLException{
        try {
            File directory = new File (".");

            this.jasperReport = JasperCompileManager.compileReport(directory.getCanonicalPath()
+ "/src/main/java/com/kffekko_report/jasperreport/models/" + this.ereportModel);
            String docPath = directory.getCanonicalPath() + "/docs/" + this.modelType + ".pdf";
            HashMap parameters = new HashMap();
            parameters.put("ANNEE_DEBUT", this.yearStart);
            parameters.put("ANNEE_FIN", this.yearEnd);
            parameters.put("MOIS_DEBUT", this.getMonthNumber(this.periodMonthStart));
            parameters.put("MOIS_FIN_int", this.getMonthNumber(this.periodMonthEnd));
            parameters.put("MOIS_FIN_STR", this.periodMonthEnd);
            parameters.put("DATE_DEBUT", this.getDateString(yearStart, this.getMonthNumber(this.periodMonthStart), "01"));
            parameters.put("DATE_FIN", this.getDateString(yearEnd, this.getMonthNumber(this.periodMonthEnd), "31"));
            parameters.put("PERIODE", this.periodMonthStart + " " + this.yearStart + " - " + this.periodMonthEnd + " "+ this.yearEnd + " (kg)");
            parameters.put("PRODUIT", this.product);
            parameters.put("PRODUIT_TYPE", this.getProductType());
            parameters.put("CATEGORIES", this.getCategory());
            parameters.put("EXPORT_TYPES", this.getExporterType());
            parameters.put("EXPORT_SPE", this.getExporterSpecificity());
            parameters.put("VILLE", this.getCity());
            
            this.connection = DriverManager
                    .getConnection(mysqlAccess.getBdUrl() +mysqlAccess.getBdName(), mysqlAccess.getBdUser(), mysqlAccess.getBdPassword());
            jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, this.connection);
            if(jasperPrint != null)
            {
                JasperExportManager.exportReportToPdfFile(jasperPrint, docPath);
//JasperViewer.viewReport(jasperPrint, false);
            }
            
        } catch (JRException ex) {
        
        Logger.getLogger(ExportFile.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(this.connection != null){
                this.connection.close();
            }
        }
    }
    
    public String getDateString(String year, String monthNumber, String day)
    {
        monthNumber = monthNumber.length() > 2 ? "0" + monthNumber : monthNumber;
        String result = year + "-" + monthNumber + "-" + day;
        
        return result;
        
    }
    public String getMonthNumber(String month)
    {
        List <String> months = this.getMonths();
        
        return String.valueOf(months.indexOf(month) + 1);   
    }
    
    public String getProductType()
    {
        
        if(this.productTypes.contains("Tous")){
           this.productTypes = this.getProductTypes();
        }
        
        return this.toString(this.productTypes);  
    }
    
    public String getCategory()
    {
        
        if(this.categories.contains("TOUS")){
           this.categories = this.getCategories();
        }
        
        return this.toString(this.categories);  
    }
    
    public String getExporterType()
    {
        
        if(this.exporterTypes.contains("TOUS")){
           this.exporterTypes = this.getExporterTypes();
        }
        
        return this.toString(this.exporterTypes);  
    }
    
    public String getExporterSpecificity()
    {
        
        if(this.exporterSpecificity.contains("TOUS")){
           this.exporterSpecificity = this.getExporterSpecificities();
        }
        
        return this.toString(this.exporterSpecificity);  
    }
    
    
    public String getCity()
    {
        
        if(this.cities.contains("TOUS")){
           this.cities = this.getCities();
        }
        
        return this.toString(this.cities);  
    }
    
    public String toString(List <String> tab)
    {
        String result = "";
        for(String value: tab){
            result += value +  ",";
        }
        result = result.substring(0, result.length() -1);
        
        return result;
    }
    public List<String> getProductTypes()
    {
        List <String> productTypes = new ArrayList<String>();
        productTypes.add("Fèves");
        productTypes.add("Fèves semi-fini");
        productTypes.add("Vertes");
        
        return productTypes;
        
    }
    
    public List<String> getCities()
    {
        List <String> cities = new ArrayList<String>();
        cities.add("Abidjan");
        cities.add("San pedro");
        
        return cities;
        
    }
    
    public List<String> getCategories()
    {
        List <String> categories = new ArrayList<String>();
        categories.add("Transformateur");
        categories.add("Non Transformateur");
        
        return categories;
    }
    
    public List<String> getExporterTypes()
    {
        List <String> exporterTypes = new ArrayList<String>();
        exporterTypes.add("MULTINATIONALE");
        exporterTypes.add("NATIONALE");
        
        return exporterTypes;
    }
    
    public List<String> getExporterSpecificities()
    {
        List <String> exporterSpecifities = new ArrayList<String>();
        exporterSpecifities.add("COOPEX");
        exporterSpecifities.add("PMEX");
        
        return exporterSpecifities;
    }
    
    public List<String> getMonths(){
        List <String> months = new ArrayList<String>();
        months.add("Janvier");
        months.add("Fevrier");
        months.add("Mars");
        months.add("Avril");
        months.add("Mai");
        months.add("Juin");
        months.add("Juillet");
        months.add("Aout");
        months.add("Septembre");
        months.add("Octobre");
        months.add("Novembre");
        months.add("Decembre");
        
        return months;
        
    }
    
}
