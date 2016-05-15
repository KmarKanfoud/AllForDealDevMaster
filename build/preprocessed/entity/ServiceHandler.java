/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Lilya Thebti
 */
public class ServiceHandler extends DefaultHandler{
    
     private Vector services;
    
  

    public ServiceHandler() {
         services = new Vector();
    }

    

    public Service[] getService() {
        Service[] servicess = new Service[services.size()];
        services.copyInto(servicess);
        return servicess;
    }
    
 private Service currentService;
 
 public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("service")) {
            currentService = new Service();
            
            currentService.setId(Integer.parseInt(attributes.getValue("id")));
            currentService.setNomService(attributes.getValue("nomService"));
            currentService.setDescription(attributes.getValue("description"));
           // currentService.setDateAjout(attributes.getValue("dateAjout"));
            currentService.setEtat(attributes.getValue("etat"));
            currentService.setType(attributes.getValue("type"));
            currentService.setUserId(Integer.parseInt(attributes.getValue("user_id")));
            currentService.setZone(Integer.parseInt(attributes.getValue("zone_id")));
            /****/
            
        }
    }
      public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("service")) {
            // we are no longer processing a <reg.../> tag
            services.addElement(currentService);
            currentService = null;
        } 
    }
    

}
