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
 * @author Toshiba
 */
public class ProduitHandler extends DefaultHandler {

    private Vector produits;
   
  
   

    public ProduitHandler() {
        produits = new Vector();
    }

    public Produit[] getProduit() {
        Produit[] produitss = new Produit[produits.size()];
        produits.copyInto(produitss);
        return produitss;
    }
    private Produit currentProduit;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
       
        if (qName.equals("produit")) {
            currentProduit = new Produit();

          /*  currentProduit.setId(Integer.parseInt(attributes.getValue("id")));
            currentProduit.setCategorie(attributes.getValue("categorie"));
            currentProduit.setDescription(attributes.getValue("description"));
           */ currentProduit.setPrix(Integer.parseInt(attributes.getValue("prix")));
            currentProduit.setQuantite(Integer.parseInt(attributes.getValue("quantite")));
            currentProduit.setNomP(attributes.getValue("nomP"));
            currentProduit.setTva(Integer.parseInt(attributes.getValue("tva")));
            currentProduit.setReduction(Integer.parseInt(attributes.getValue("reduction")));
            /**
             * *
             */
          
  
        }          
         
    }
        public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("produit")) {
            // we are no longer processing a <reg.../> tag
           produits.addElement(currentProduit);
           currentProduit = null;
        }
    }
}    
   
        
   

