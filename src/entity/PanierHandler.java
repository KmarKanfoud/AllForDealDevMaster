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
 * @author maroo
 */
public class PanierHandler extends DefaultHandler{
      private Vector paniers;
      
          public PanierHandler() {
        paniers = new Vector();
    }
          
    public Panier[] getPanier() {
        Panier[] panierss = new Panier[paniers .size()];
        paniers.copyInto(panierss);
        return panierss;
    }
     private Panier currentPanier;
     public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
       
        if (qName.equals("panier")) {
            currentPanier = new Panier();

          /*  currentProduit.setId(Integer.parseInt(attributes.getValue("id")));
            currentProduit.setCategorie(attributes.getValue("categorie"));
            currentProduit.setDescription(attributes.getValue("description"));
           */
            currentPanier.setId(Integer.parseInt(attributes.getValue("id")));
         
            currentPanier.setIduser(Integer.parseInt(attributes.getValue("iduser")));
             currentPanier.setUsername((attributes.getValue("username")));
               currentPanier.setIdprod(Integer.parseInt(attributes.getValue("idprod")));
            currentPanier.setNbrprod(Integer.parseInt(attributes.getValue("nbrprod")));
            currentPanier.setNomP((attributes.getValue("nomP")));
           
            currentPanier.setUsername((attributes.getValue("description")));
            /**
             * *
             */
          
  
        }          
         

}
           public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("panier")) {
            // we are no longer processing a <reg.../> tag
           paniers.addElement(currentPanier);
           currentPanier = null;
        }
    }
}