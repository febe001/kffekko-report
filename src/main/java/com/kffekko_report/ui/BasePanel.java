/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kffekko_report.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author akil
 */
public class BasePanel extends javax.swing.JPanel {

    
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
     * Creates new form BasePanel
     */
    public BasePanel() {
         Dimension screanSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.fHeight = (int)(0.8 * screanSize.getHeight());
        this.fWidth = (int)(0.9 * screanSize.getWidth());
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        sidebar = new javax.swing.JPanel();
        homeMenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        reportMenu = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        importMenu = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        configMenu = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        topbar = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        container = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btImport = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        btReport = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        btParam = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidebar.setBackground(new java.awt.Color(255, 193, 7));
        sidebar.setForeground(new java.awt.Color(255, 143, 0));
        sidebar.setPreferredSize(new java.awt.Dimension((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight(),(int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth()));

        homeMenu.setBackground(new java.awt.Color(255, 198, 38));
        homeMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMenuMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homeMenuMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homeMenuMouseEntered(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 236, 179));
        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jLabel1.setText("Accueil");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bt-home-bl.png"))); // NOI18N

        javax.swing.GroupLayout homeMenuLayout = new javax.swing.GroupLayout(homeMenu);
        homeMenu.setLayout(homeMenuLayout);
        homeMenuLayout.setHorizontalGroup(
            homeMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeMenuLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        homeMenuLayout.setVerticalGroup(
            homeMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeMenuLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(homeMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        reportMenu.setBackground(new java.awt.Color(255, 198, 38));
        reportMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportMenuMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reportMenuMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                reportMenuMouseEntered(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(255, 236, 179));
        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jLabel9.setText("Reports");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bt-export-bl.png"))); // NOI18N

        javax.swing.GroupLayout reportMenuLayout = new javax.swing.GroupLayout(reportMenu);
        reportMenu.setLayout(reportMenuLayout);
        reportMenuLayout.setHorizontalGroup(
            reportMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportMenuLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        reportMenuLayout.setVerticalGroup(
            reportMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reportMenuLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(reportMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addContainerGap())
        );

        importMenu.setBackground(new java.awt.Color(255, 198, 38));
        importMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                importMenuMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                importMenuMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                importMenuMouseEntered(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 236, 179));
        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jLabel7.setText("Imports");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bt-import-bl.png"))); // NOI18N

        javax.swing.GroupLayout importMenuLayout = new javax.swing.GroupLayout(importMenu);
        importMenu.setLayout(importMenuLayout);
        importMenuLayout.setHorizontalGroup(
            importMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(importMenuLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        importMenuLayout.setVerticalGroup(
            importMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, importMenuLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(importMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(9, 9, 9))
        );

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel11.setText("KffeKko V2.0");

        configMenu.setBackground(new java.awt.Color(255, 198, 38));
        configMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                configMenuMouseClicked(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(255, 236, 179));
        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jLabel12.setText("Parametres");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bt-settings-bl.png"))); // NOI18N

        javax.swing.GroupLayout configMenuLayout = new javax.swing.GroupLayout(configMenu);
        configMenu.setLayout(configMenuLayout);
        configMenuLayout.setHorizontalGroup(
            configMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(configMenuLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        configMenuLayout.setVerticalGroup(
            configMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, configMenuLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(configMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12))
                .addContainerGap())
        );

        javax.swing.GroupLayout sidebarLayout = new javax.swing.GroupLayout(sidebar);
        sidebar.setLayout(sidebarLayout);
        sidebarLayout.setHorizontalGroup(
            sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(homeMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(reportMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(importMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(sidebarLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel11)
                .addContainerGap(122, Short.MAX_VALUE))
            .addGroup(sidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(configMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        sidebarLayout.setVerticalGroup(
            sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(98, 98, 98)
                .addComponent(homeMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(importMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reportMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(configMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(479, Short.MAX_VALUE))
        );

        bg.add(sidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 790));

        topbar.setBackground(new java.awt.Color(255, 255, 255));
        topbar.setPreferredSize(new java.awt.Dimension((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight(),(int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth()));

        jLabel5.setBackground(new java.awt.Color(102, 0, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bt-close.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout topbarLayout = new javax.swing.GroupLayout(topbar);
        topbar.setLayout(topbarLayout);
        topbarLayout.setHorizontalGroup(
            topbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topbarLayout.createSequentialGroup()
                .addContainerGap(724, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );
        topbarLayout.setVerticalGroup(
            topbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bg.add(topbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 770, 40));

        container.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));

        jLabel6.setFont(new java.awt.Font("Roboto Mono", 1, 36)); // NOI18N
        jLabel6.setText("KffeKko V2.0");

        jLabel15.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jLabel15.setText("<html>Une application qui synthétise sous forme <br/>de rapport automatisé les données d'exportations.</html>");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(245, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        container.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 220));

        btImport.setBackground(new java.awt.Color(224, 224, 224));
        btImport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btImportMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btImportMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btImportMouseEntered(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Roboto Mono", 0, 14)); // NOI18N
        jLabel19.setText("<html><p style=\"text-align:center\">Importer vos fichier d'exploitation au format excel ou sql</p></html>");

        jLabel20.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel20.setText("Import");

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bt-import.png"))); // NOI18N

        javax.swing.GroupLayout btImportLayout = new javax.swing.GroupLayout(btImport);
        btImport.setLayout(btImportLayout);
        btImportLayout.setHorizontalGroup(
            btImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btImportLayout.createSequentialGroup()
                .addGroup(btImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(btImportLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel20))
                    .addGroup(btImportLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel21)))
                .addContainerGap(57, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btImportLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        btImportLayout.setVerticalGroup(
            btImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btImportLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel21)
                .addGap(23, 23, 23))
        );

        btReport.setBackground(new java.awt.Color(224, 224, 224));
        btReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btReportMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btReportMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btReportMouseEntered(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Roboto Mono", 0, 14)); // NOI18N
        jLabel22.setText("<html><p style=\"text-align:center\">Editer vos données d'exploitation en PDF ou en word</p></html>");

        jLabel23.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel23.setText("Report");

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bt-export.png"))); // NOI18N

        javax.swing.GroupLayout btReportLayout = new javax.swing.GroupLayout(btReport);
        btReport.setLayout(btReportLayout);
        btReportLayout.setHorizontalGroup(
            btReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btReportLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btReportLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addGap(59, 59, 59))
            .addGroup(btReportLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel23)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btReportLayout.setVerticalGroup(
            btReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btReportLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel23)
                .addGap(28, 28, 28)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel24)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        btParam.setBackground(new java.awt.Color(224, 224, 224));
        btParam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btParamMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btParamMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btParamMouseEntered(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Roboto Mono", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("<html><p style=\"text-align:center\">Personnaliser les parametres de votre application</p></html>");

        jLabel17.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel17.setText("Parametre");

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bt-settings.png"))); // NOI18N

        javax.swing.GroupLayout btParamLayout = new javax.swing.GroupLayout(btParam);
        btParam.setLayout(btParamLayout);
        btParamLayout.setHorizontalGroup(
            btParamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btParamLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel18)
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btParamLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(btParamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btParamLayout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btParamLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(61, 61, 61))))
        );
        btParamLayout.setVerticalGroup(
            btParamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btParamLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btImport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btParam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btImport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btParam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39))
        );

        container.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 800, 360));

        bg.add(container, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 770, 660));

        jLabel14.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N
        jLabel14.setText("@Copyright");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 1201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void btParamMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btParamMouseEntered
        // TODO add your handling code here:
        btParam.setBackground(Color.white);
    }//GEN-LAST:event_btParamMouseEntered

    private void btParamMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btParamMouseExited
        // TODO add your handling code here:
        btParam.setBackground(new java.awt.Color(224, 224, 224));
    }//GEN-LAST:event_btParamMouseExited

    private void btParamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btParamMouseClicked
        // TODO add your handling code here:
        container.removeAll();
        container.add(new HomePanel(), new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 700));
        container.repaint();
        container.revalidate();
    }//GEN-LAST:event_btParamMouseClicked

    private void btReportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btReportMouseEntered
        // TODO add your handling code here:
        btReport.setBackground(Color.white);
    }//GEN-LAST:event_btReportMouseEntered

    private void btReportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btReportMouseExited
        // TODO add your handling code here:
        btReport.setBackground(new java.awt.Color(224, 224, 224));
    }//GEN-LAST:event_btReportMouseExited

    private void btReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btReportMouseClicked
        // TODO add your handling code here:
        container.removeAll();
        container.add(new ReportPanel(), new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 680));
        container.repaint();
        container.revalidate();
    }//GEN-LAST:event_btReportMouseClicked

    private void btImportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btImportMouseEntered
        // TODO add your handling code here:
        btImport.setBackground(Color.white);
    }//GEN-LAST:event_btImportMouseEntered

    private void btImportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btImportMouseExited
        // TODO add your handling code here:
        btImport.setBackground(new java.awt.Color(224, 224, 224));
    }//GEN-LAST:event_btImportMouseExited

    private void btImportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btImportMouseClicked
        // TODO add your handling code here:
        container.removeAll();
        container.add(new ImportPanel(), new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 680));
        container.repaint();
        container.revalidate();
    }//GEN-LAST:event_btImportMouseClicked

    private void configMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_configMenuMouseClicked
        // TODO add your handling code here:
        container.removeAll();
        container.add(new ConfigPanel(), new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 680));
        container.repaint();
        container.revalidate();
    }//GEN-LAST:event_configMenuMouseClicked

    private void importMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_importMenuMouseEntered
        // TODO add your handling code here:
        importMenu.setBackground(new java.awt.Color(255, 198, 70));
    }//GEN-LAST:event_importMenuMouseEntered

    private void importMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_importMenuMouseExited
        // TODO add your handling code here:
        importMenu.setBackground(new java.awt.Color(255, 198, 38));
    }//GEN-LAST:event_importMenuMouseExited

    private void importMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_importMenuMouseClicked
        // TODO add your handling code here:
        container.removeAll();
        container.add(new ImportPanel(), new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 680));
        container.repaint();
        container.revalidate();
    }//GEN-LAST:event_importMenuMouseClicked

    private void reportMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportMenuMouseEntered
        // TODO add your handling code here:
        reportMenu.setBackground(new java.awt.Color(255, 198, 70));
    }//GEN-LAST:event_reportMenuMouseEntered

    private void reportMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportMenuMouseExited
        // TODO add your handling code here:
        reportMenu.setBackground(new java.awt.Color(255, 198, 38));
    }//GEN-LAST:event_reportMenuMouseExited

    private void reportMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportMenuMouseClicked
        // TODO add your handling code here:
        container.removeAll();
        container.add(new ReportPanel(), new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 680));
        container.repaint();
        container.revalidate();
    }//GEN-LAST:event_reportMenuMouseClicked

    private void homeMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMenuMouseEntered
        homeMenu.setBackground(new java.awt.Color(255, 198, 70));
    }//GEN-LAST:event_homeMenuMouseEntered

    private void homeMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMenuMouseExited
        // TODO add your handling code here:
        homeMenu.setBackground(new java.awt.Color(255, 198, 38));
    }//GEN-LAST:event_homeMenuMouseExited

    private void homeMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMenuMouseClicked
        // TODO add your handling code here:
        container.removeAll();
        container.add(new HomePanel(), new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 700));
        container.repaint();
        container.revalidate();
    }//GEN-LAST:event_homeMenuMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JPanel btImport;
    private javax.swing.JPanel btParam;
    private javax.swing.JPanel btReport;
    private javax.swing.JPanel configMenu;
    private javax.swing.JPanel container;
    private javax.swing.JPanel homeMenu;
    private javax.swing.JPanel importMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel reportMenu;
    private javax.swing.JPanel sidebar;
    private javax.swing.JPanel topbar;
    // End of variables declaration//GEN-END:variables
}
