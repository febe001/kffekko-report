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
public class ReportModel {
    
    public EnumReportModel getModel(String reportModel){
        EnumReportModel model = null;
        switch(reportModel){
            case "I.1 LA CERTIFICATION DES PESEES A L'EXPORT":
                model = EnumReportModel.I_1;
                break;
            case "I.2 L'ACTIVITE DE CONTROLE DES POIDS DECLARES ET DE PESAGES DES FEVES":
                model = EnumReportModel.I_2;
                break;
          
        }
        return model;
    }
    
}
