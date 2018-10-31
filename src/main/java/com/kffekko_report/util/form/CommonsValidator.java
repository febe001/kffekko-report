/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kffekko_report.util.form;

import java.awt.Component;
import java.util.regex.Pattern;


public class CommonsValidator {
    
    public static final IValidator equals(final String base){
        return new IValidator(){
            public boolean valid(String value) {
                return base.equals(value);
            }
        };
    }

    public static final IValidator equalsTo(final Component base){
        return new IValidator(){
            public boolean valid(String value) {
                return Form.getValueOf(base).equals(value);
            }
        };
    }

    public static final IValidator minLength(final int min){
        return new IValidator(){
            public boolean valid(String value) {
                return value.length() >= min;
            }
        };
    }

    public static final IValidator maxLength(final int max){
        return new IValidator(){
            public boolean valid(String value) {
                return value.length() <= max;
            }
        };
    }

    public static final IValidator rangeLength(final int min, final int max){
        return new IValidator(){
            public boolean valid(String value) {
                return  value.length() >= min && value.length() <= max;
            }
        };
    }

    public static final IValidator min(final int min){
        return new IValidator(){
            public boolean valid(String value) {
                try{
                    int val = Integer.parseInt(value);
                    return  val >= min;
                }catch(Exception e){
                    return false;
                }
            }
        };
    }

    public static final IValidator max(final int max){
        return new IValidator(){
            public boolean valid(String value) {
                try{
                    int val = Integer.parseInt(value);
                    return  val <= max;
                }catch(Exception e){
                    return false;
                }
            }
        };
    }

    public static final IValidator range(final int min, final int max){
        return new IValidator(){
            public boolean valid(String value) {
                try{
                    int val = Integer.parseInt(value);
                    return  val >= min && val <= max;
                }catch(Exception e){
                    return false;
                }
            }
        };
    }

    //instance public qui teste si un text n'est pas vide
    public static final IValidator required = new IValidator(){
        public boolean valid(String value) {
            return !value.equals("");
        }
    };


    //modèle url
    private static final Pattern patternUrl = Pattern.compile("^(https?|ftp):\\/\\/(((([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(%[\\da-f]{2})|[!\\$&'\\(\\)\\*\\+,;=]|:)*@)?(((\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5]))|((([a-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(([a-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])*([a-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])))\\.)+(([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])*([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])))\\.?)(:\\d*)?)(\\/((([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(%[\\da-f]{2})|[!\\$&'\\(\\)\\*\\+,;=]|:|@)+(\\/(([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(%[\\da-f]{2})|[!\\$&'\\(\\)\\*\\+,;=]|:|@)*)*)?)?(\\?((([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(%[\\da-f]{2})|[!\\$&'\\(\\)\\*\\+,;=]|:|@)|[\\uE000-\\uF8FF]|\\/|\\?)*)?(\\#((([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(%[\\da-f]{2})|[!\\$&'\\(\\)\\*\\+,;=]|:|@)|\\/|\\?)*)?$");
     //instance public qui teste une adresse email
    public static final IValidator url = new AMatcherValidator(){
        @Override
        public Pattern getPattern() {
            return patternUrl;
        }
    };

    //modèle email
    private static final Pattern patternEmail = Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
     //instance public qui teste une adresse email
    public static final IValidator email = new AMatcherValidator(){
        @Override
        public Pattern getPattern() {
            return patternEmail;
        }
    };


    //modèle ipv4
    private static final String _255 = "(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
    private static final Pattern patternIpv4 = Pattern.compile("^(?:" + _255 + "\\.){3}" + _255 + "$");
    //instance public qui teste une adresse ipv4
    public static final IValidator ipv4 = new AMatcherValidator(){
        @Override
        public Pattern getPattern() {
            return patternIpv4;
        }
    };

    
    //modèle ipv4
    private static final Pattern patternPort = Pattern.compile("^(6553[0-5]|655[0-2]\\d|65[0-4]\\d\\d|6[0-4]\\d{3}|[1-5]\\d{4}|[1-9]\\d{0,3}|0)$");
    //instance public qui teste une adresse ipv4
    public static final IValidator port = new AMatcherValidator(){
        @Override
        public Pattern getPattern() {
            return patternPort;
        }
    };

    /*
     * Classe public qui teste une chaine en fonction d'une éxpression régulière
     */
    public static class Matcher implements IValidator{
        
        private final java.util.regex.Pattern pattern;

        public Matcher(String pattern) {
            this(java.util.regex.Pattern.compile(pattern));
        }

        public Matcher(java.util.regex.Pattern pattern) {
            this.pattern = pattern;
        }

        public boolean valid(String value) {
            return  pattern.matcher(value).matches();
        }
    }


}
