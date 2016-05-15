/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package form;

import entity.Panier;
import entity.PanierHandler;
import entity.Produit;
import entity.ProduitHandler;
import java.io.DataInputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import pidevj2me.Midlet;

/**
 *
 * @author maroo
 */
public class PanierList extends Form implements CommandListener,Runnable {
Command cmdParse = new Command("Produits", Command.SCREEN, 0);
    Command cmdBack = new Command("Back", Command.BACK, 0);
     Panier[] panier;
    List lst = new List("Panier", List.IMPLICIT);
    Form f = new Form("Accueil");
    Form form = new Form("Infos info");
    Form loadingDialog = new Form("Please Wait");
    StringBuffer sb = new StringBuffer();
    public PanierList(String title) {
        super(title);
           append("MonPanier Clickez");
        addCommand(cmdParse);
         
        setCommandListener(this);
       
        lst.addCommand(cmdBack);
         lst.setCommandListener(this);
        form.addCommand(cmdBack);
      
        form.setCommandListener(this);
        
    }

    public void commandAction(Command c, Displayable d) {
        if (c == cmdParse) {
            Midlet.m.disp.setCurrent(loadingDialog);
            Thread th = new Thread(this);
            th.start();
        }

        if (c == List.SELECT_COMMAND) {
            form.append("Informations Achat: \n");
            form.append(showPersonne(lst.getSelectedIndex()));
            Midlet.m.disp.setCurrent(form);
        }

        if (c == cmdBack) {
            form.deleteAll();
            Midlet.m.disp.setCurrent(lst);
        }    }

    public void run() {
        try{
 // this will handle our XML
            PanierHandler panierhandler = new PanierHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/j2me/getxmlPanier.php");
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, panierhandler);
            // display the result
            panier = panierhandler.getPanier();

            if ( panier.length > 0) {
                for (int i = 0; i <  panier.length; i++) {
                 
                    lst.append(panier[i].getNomP(),null);

                }

            }

        } catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
        Midlet.m.disp.setCurrent(lst);      }
    
  private String showPersonne(int i) {
        String res = "";
        if ( panier.length > 0) {
            sb.append("* ");
            sb.append( panier[i].getId());
            sb.append("\n");
            sb.append("* ");
            sb.append( panier[i].getIdprod());
            sb.append("\n");
            sb.append("* ");
            sb.append( panier[i].getIduser());
            sb.append("\n");
             sb.append("* ");
            sb.append( panier[i].getNbrprod());
            sb.append("\n");
             sb.append("* ");
            sb.append( panier[i].getNomP());
            sb.append("\n");
            sb.append("* ");
             sb.append( panier[i].getUsername());
            sb.append("\n");
            
        }
        res = sb.toString();
        sb = new StringBuffer("");
        return res;
    }
}
