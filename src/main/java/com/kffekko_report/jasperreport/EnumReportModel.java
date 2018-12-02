/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kffekko_report.jasperreport;

/**
 *
 * @author akil
 */
public enum EnumReportModel {
    
    I_0("i.0.jrxml"),
    I_1("i.1.jrxml"), 
    I_2("i.2.jrxml"),
    I_3("i.3.jrxml"),
    I_4("i.4.jrxml"),
    I_5("i.5.jrxml"),
    I_6("i.6.jrxml"),
    I_7("i.7.jrxml"),
    I_8("i.8.jrxml"),
    I_9("i.9.jrxml");
    
    private String url;
    
    EnumReportModel(String url){
        this.url = url;
    }
    
    public String toString(){
        return url;
    }
  
}
