/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.arqJava.elOferton.businessEntities.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author Rodrigo
 */
public class DateAdapter extends XmlAdapter<String, Date> {
    
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
 
    @Override
    public String marshal(Date date) throws Exception {
        return dateFormat.format(date);
    }
 
    @Override
    public Date unmarshal(String string) throws Exception {
        return dateFormat.parse(string);
    }
    
    
}
