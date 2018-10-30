/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kffekko_report.ui;

import javax.swing.JFrame;

/**
 *
 * @author akil
 */
public class MainFrame extends JFrame {
    
    public MainFrame()
    {
        this.setUndecorated(true);
        this.setSize(1200, 735);
        this.setLocationRelativeTo(null);               
        this.setContentPane(new BasePanel());               
        this.setVisible(true);
    }
    
   
}
