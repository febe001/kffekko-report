/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kffekko_report.util;

import java.awt.Component;
import java.awt.Container;
import java.io.File;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

/**
 *
 * @author akil
 */
public class FileChooser {
   
    private final boolean isFilesOnly;
    private static final FileChooser INSTANCE_FILES = new FileChooser(true);
    private static final FileChooser INSTANCE_DIRS = new FileChooser(false);

    private final JFileChooser dynamicChooser;

    public FileChooser(boolean filesOnly) {
        this.isFilesOnly = filesOnly;
        this.dynamicChooser = new JFileChooser();
        dynamicChooser.setControlButtonsAreShown(false);
        this.chooserSetup();
    }

    public FileChooser getInstance(boolean filesOnly) {
        if (filesOnly) {
            return FileChooser.INSTANCE_FILES;
        } else {
            return FileChooser.INSTANCE_DIRS;
        }
    }

    public void frameSetup(Container parent) {
        // jframe setup code
        parent.add(this.dynamicChooser);
        parent.repaint();
    }

    public void chooserSetup() {
        if (this.isFilesOnly) {
            this.dynamicChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        } else {
            this.dynamicChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        }
        this.dynamicChooser.setMultiSelectionEnabled(true);
        this.dynamicChooser.setDialogType(JFileChooser.CUSTOM_DIALOG);
    }

    public File[] showOpenDialog(Component parent, String title) {
        JDialog dialog = new JDialog(parent == null ? null : SwingUtilities.getWindowAncestor(parent), title);
        dialog.setModal(true);
        frameSetup(dialog);

        dialog.pack();
        dialog.setLocationRelativeTo(parent);

        dialog.setVisible(true);

        return dynamicChooser.getSelectedFiles();
    }
    
}
