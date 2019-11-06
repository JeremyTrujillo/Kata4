/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import view.*;
import model.*;

/**
 *
 * @author Usuario
 */
public class Kata4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String fileName = new String("email.txt");
        List<Mail> mailList = MailListReader.read(fileName);
        Histogram   histogram = MailHistogramBuilder.build(mailList);
        
        histogram.increment("ulpgc.es");
        histogram.increment("dis.ulpgc.es");
        histogram.increment("google.es");
        histogram.increment("ulpgc.es");
        histogram.increment("dis.ulpgc.es");
        histogram.increment("dis.ulpgc.es");
        histogram.increment("gmail.es");
        histogram.increment("ulpgc.es");
        histogram.increment("ulpgc.es");

         
        HistogramDisplay histogramDisplay = new HistogramDisplay(histogram,"Histograma", "Histograma JFreeChart", "Dominios emails", "Nยบ de emails");
        histogramDisplay.execute();
    }
    
}
