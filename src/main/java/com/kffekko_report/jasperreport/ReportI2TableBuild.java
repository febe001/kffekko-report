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
public class ReportI2TableBuild {
    
    public String getdata(String str_ovalue) {

        switch (str_ovalue) {
            case "a_str_name":
                str_ovalue = "POIDS THEORIQUE";
                break;
            case "b_str_name":
                str_ovalue = "POIDS REEL";
                break;
            case "c_str_name":
                str_ovalue = "ECART";
                break;
            case "d_str_name":
                str_ovalue = "TAUX DE SURTARAGE";
                break;
            default:
                str_ovalue += "1";
                break;
        }
        return str_ovalue;
    }
    
}
