/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kffekko_report.ui;

/**
 *
 * @author akil
 */
public class HomePanel extends javax.swing.JPanel {

    /**
     * Creates new form HomePanel
     */
    public HomePanel() {
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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btAdd = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btImport = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btReport = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 102, 51));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));

        jLabel1.setFont(new java.awt.Font("Menlo", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("KffeKko V2.1");

        jLabel2.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("<html>Une application qui synthétise sous forme <br/>de rapport automatisé des données d'exportations.</html>");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(583, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 220));

        jPanel3.setBackground(new java.awt.Color(238, 238, 238));

        btAdd.setBackground(new java.awt.Color(224, 224, 224));
        btAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btAddMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btAddMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btAddMouseEntered(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Monospaced", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("<html><p>Ajouter vos données d'exploitation via un formulaire </p></html>");

        jLabel8.setFont(new java.awt.Font("Monospaced", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Ajouter manuel");

        jLabel10.setIcon(new javax.swing.ImageIcon("/Users/akil/NetBeansProjects/house-outline (1).png")); // NOI18N

        javax.swing.GroupLayout btAddLayout = new javax.swing.GroupLayout(btAdd);
        btAdd.setLayout(btAddLayout);
        btAddLayout.setHorizontalGroup(
            btAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btAddLayout.createSequentialGroup()
                .addGroup(btAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(btAddLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel8))
                    .addGroup(btAddLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel10)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btAddLayout.createSequentialGroup()
                .addGap(0, 45, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        btAddLayout.setVerticalGroup(
            btAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btAddLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addContainerGap(27, Short.MAX_VALUE))
        );

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

        jLabel4.setFont(new java.awt.Font("Monospaced", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("<html><p>Importer vos fichier d'exploitation au format excel ou sql</p></html>");

        jLabel7.setFont(new java.awt.Font("Monospaced", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Import");

        jLabel9.setIcon(new javax.swing.ImageIcon("/Users/akil/NetBeansProjects/import (2).png")); // NOI18N

        javax.swing.GroupLayout btImportLayout = new javax.swing.GroupLayout(btImport);
        btImport.setLayout(btImportLayout);
        btImportLayout.setHorizontalGroup(
            btImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btImportLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(btImportLayout.createSequentialGroup()
                .addGroup(btImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(btImportLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel7))
                    .addGroup(btImportLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel9)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btImportLayout.setVerticalGroup(
            btImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btImportLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel7)
                .addGap(35, 35, 35)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jLabel5.setFont(new java.awt.Font("Monospaced", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("<html><p>Editer vos données d'exploitation en PDF ou en word</p></html>");

        jLabel6.setFont(new java.awt.Font("Monospaced", 0, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Report");

        jLabel11.setIcon(new javax.swing.ImageIcon("/Users/akil/NetBeansProjects/export-document (1).png")); // NOI18N

        javax.swing.GroupLayout btReportLayout = new javax.swing.GroupLayout(btReport);
        btReport.setLayout(btReportLayout);
        btReportLayout.setHorizontalGroup(
            btReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btReportLayout.createSequentialGroup()
                .addGroup(btReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btReportLayout.createSequentialGroup()
                        .addContainerGap(19, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(btReportLayout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btReportLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(57, 57, 57))
        );
        btReportLayout.setVerticalGroup(
            btReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btReportLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel6)
                .addGap(26, 26, 26)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(btImport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(111, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btImport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(97, 97, 97))
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 950, 510));
    }// </editor-fold>//GEN-END:initComponents

    private void btAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddMouseEntered
        // TODO add your handling code here:
        btAdd.setBackground(new java.awt.Color(252, 255, 250));
    }//GEN-LAST:event_btAddMouseEntered

    private void btAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddMouseExited
        // TODO add your handling code here:
        btAdd.setBackground(new java.awt.Color(224, 224, 224));
    }//GEN-LAST:event_btAddMouseExited

    private void btImportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btImportMouseEntered
        // TODO add your handling code here:
        btImport.setBackground(new java.awt.Color(252, 255, 250));
    }//GEN-LAST:event_btImportMouseEntered

    private void btImportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btImportMouseExited
        // TODO add your handling code here:
        btImport.setBackground(new java.awt.Color(224, 224, 224));
    }//GEN-LAST:event_btImportMouseExited

    private void btReportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btReportMouseEntered
        // TODO add your handling code here:
         btReport.setBackground(new java.awt.Color(252, 255, 250));
    }//GEN-LAST:event_btReportMouseEntered

    private void btReportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btReportMouseExited
        // TODO add your handling code here:
        btReport.setBackground(new java.awt.Color(224, 224, 224));
    }//GEN-LAST:event_btReportMouseExited

    private void btAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddMouseClicked
        // TODO add your handling code here:
        removeAll();
        add(new AddPanel(), new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 680));
        repaint();
        revalidate();
    }//GEN-LAST:event_btAddMouseClicked

    private void btImportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btImportMouseClicked
        // TODO add your handling code here:
        removeAll();
        add(new ImportPanel(), new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 680));
        repaint();
        revalidate();
    }//GEN-LAST:event_btImportMouseClicked

    private void btReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btReportMouseClicked
        // TODO add your handling code here:
        removeAll();
        add(new ReportPanel(), new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 680));
        repaint();
        revalidate();
    }//GEN-LAST:event_btReportMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btAdd;
    private javax.swing.JPanel btImport;
    private javax.swing.JPanel btReport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
