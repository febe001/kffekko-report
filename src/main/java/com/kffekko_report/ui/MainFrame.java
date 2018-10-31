/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kffekko_report.ui;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 * Application main frame
 * 
 * @author akil
 */
public class MainFrame extends JFrame {
    
    /**
     * Keep the hight given in the constructor
     * otherwise keep 80% of screen size.
     */
    private int fHeight;
    
    /**
     * Keep the width given in the constructor
     * otherwise keep 90% of screen size.
     */
    private int fWidth;
    
    /**
     * Keep the base panel in the constructor
     * otherwise keep base panel instance of BasePanel class.
     */
    private JPanel mainPanel;
    
    public MainFrame()
    {
        Dimension screanSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.fHeight = (int)(0.8 * screanSize.getHeight());
        this.fWidth = (int)(0.836 * screanSize.getWidth());
        this.mainPanel = new BasePanel();
        initFrame(this.fWidth, this.fHeight, this.mainPanel);
    }
    
    public MainFrame(int fHeight, int fWidth, JPanel mainPanel)
    {
        initFrame(this.fWidth, this.fHeight, this.mainPanel);
    }
    
    private void initFrame(int width, int height, JPanel panel)
    {
        setUndecorated(true);
        setSize(width, height);
        setLocationRelativeTo(null);
        panel.repaint();
        panel.revalidate();
        this.setContentPane(panel);               
        this.setVisible(true);
        
    }

    public int getfHeight() {
        return fHeight;
    }

    public void setfHeight(int fHeight) {
        this.fHeight = fHeight;
    }

    public int getfWidth() {
        return fWidth;
    }

    public void setfWidth(int fWidth) {
        this.fWidth = fWidth;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }
    
}
