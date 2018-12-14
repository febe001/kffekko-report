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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

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
       Files.copy(file.toPath(),
        (new File(path + file.getName())).toPath(),
        StandardCopyOption.REPLACE_EXISTING);
    }
    
    public File createFile(String path)
    {
        File file = new File(path);
        file.mkdirs();
        
        return file;
    }
    
    public static List<String> lireFichier(String nomFichier){
        BufferedReader fluxEntree=null;
        String ligneLue;
        List<String> lignes = new ArrayList<String>();
        try{
            fluxEntree = new BufferedReader(new FileReader(nomFichier));
            ligneLue = fluxEntree.readLine();
            while(ligneLue!=null){
                lignes.add(ligneLue);
                ligneLue = fluxEntree.readLine();
            }
        }
        catch(IOException exc){
            exc.printStackTrace();
        }
        try{
            fluxEntree.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return lignes;
    }
    
    public static void ecrireFichier(String nomFichier, List<String> lignes){
        Writer fluxSortie=null;
        try{
            fluxSortie = new PrintWriter(new BufferedWriter(new FileWriter(
                    nomFichier)));
            for(int i=0;i<lignes.size()-1;i++){
                fluxSortie.write(lignes.get(i)+"\n");
            }
            fluxSortie.write(lignes.get(lignes.size()-1));
        }
        catch(IOException exc){
            exc.printStackTrace();
        }
        try{
            fluxSortie.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
