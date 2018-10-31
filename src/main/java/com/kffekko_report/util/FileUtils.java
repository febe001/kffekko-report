/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kffekko_report.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author akil
 */
public class FileUtils {
    
    public File file;
    
    public FileUtils(String path)
    {
        this.file = new File(path);
        
    }
    
    public void moveInDirectory(String path) throws IOException
    {
        System.out.println(path);
       Files.copy(file.toPath(),
        (new File(path + file.getName())).toPath(),
        StandardCopyOption.REPLACE_EXISTING);
    }
    
}
