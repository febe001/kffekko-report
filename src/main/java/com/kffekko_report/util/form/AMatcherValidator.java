/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kffekko_report.util.form;


public abstract class AMatcherValidator  implements IValidator{
    
    public boolean valid(String value) {
        return  getPattern().matcher(value).matches();
    }

    public abstract java.util.regex.Pattern getPattern();
}
