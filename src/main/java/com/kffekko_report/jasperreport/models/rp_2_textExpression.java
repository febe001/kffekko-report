package com.kffekko_report.jasperreport.models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP PC
 */
public class rp_2_textExpression {

    
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
            default:
                break;
        }
        return str_ovalue;
    }

    public Double getvaluereel(String str_ovalue, Double O) {

        if (str_ovalue.equals("B_POIDS_REEL")) {
            return O;
        } else {
            return 0.0;
        }

    }
    
    public Double getvalueecart(String str_ovalue, Double O) {

        if (str_ovalue.equals("C_ECART")) {
            return O;
        } else {
            return 0.0;
        }

    }
    
    public Double getvaluetheo(String str_ovalue, Double O) {

        if (str_ovalue.equals("A_POIDS_THEORIQUE")) {
            return O;
        } else {
            return 0.0;
        }

    }
}
