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
            case "INTRODUCTION : REFERENTIEL DE DONNEES REELEMENT PESEES & CONSTATEES A L'EXPORT":
                model = EnumReportModel.I_0;
                break;
                
            case "I.1 LA CERTIFICATION DES PESEES A L'EXPORT":
                model = EnumReportModel.I_1;
                break;
                
            case "I.2 L'ACTIVITE DE CONTROLE DES POIDS DECLARES ET DE PESAGES DES FEVES":
                model = EnumReportModel.I_2;
                break;
                
            case "I.3 PRELEVEMENTS ET REAJUSTEMENTS DE TAXES SUR LES FEVES":
                model = EnumReportModel.I_3;
                break;
            
            case "I.4 GROUPES EXPORTATEURS":
                model = EnumReportModel.I_4;
                break;
                
            case "I.5 LES PESEES A L'EXPORT DES FEVES":
                model = EnumReportModel.I_5;
                break;
            case "I.6 LA CERTTIFICATION A L EXPORT DES PESEE DE SEMI-FINIS":
                model = EnumReportModel.I_6;
                break;
                
            case "I.7 LES TRANSITAIRES":
                model = EnumReportModel.I_7;
                break;
          
            case "I.8 LES BANQUES":
                model = EnumReportModel.I_8;
                break;
                
            case "I.9 LES DESTINATIONS":
                model = EnumReportModel.I_9;
                break;    
        }
        return model;
    }
    
}
