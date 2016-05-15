/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

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
public class ProduitList extends Form implements CommandListener,Runnable{
 Command cmdParse = new Command("Produits", Command.SCREEN, 0);
    Command cmdBack = new Command("Back", Command.BACK, 0);
     Command cmdnew = new Command("New+", Command.OK, 0);
     Command cmdmap = new Command("ZoneMap", Command.OK, 0);
    Produit[] produits;
    List lst = new List("Produits", List.IMPLICIT);
    Form f = new Form("Accueil");
    Form form = new Form("Infos Produit");
    Form loadingDialog = new Form("Please Wait");
    StringBuffer sb = new StringBuffer();
    public ProduitList(String title) {
        super(title);
          append("Click PRODUITS to get your produits_list");
        addCommand(cmdParse);
          addCommand(cmdnew);
          addCommand(cmdmap);
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
            form.append("Informations Personne: \n");
            form.append(showPersonne(lst.getSelectedIndex()));
            Midlet.m.disp.setCurrent(form);
        }

        if (c == cmdBack) {
            form.deleteAll();
            Midlet.m.disp.setCurrent(lst);
        }
    if (c == cmdnew) {
           
            Midlet.m.disp.setCurrent(new ProduitAjoutForm(""));
        }  
    if (c == cmdmap  ) {
           
            Midlet.m.disp.setCurrent(new ZoneMap(Midlet.m, d,36.899313 , 10.188750));
        }  }

    public void run() {
 try {
            // this will handle our XML
            ProduitHandler produitsHandler = new ProduitHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/Pi/getxmlProdui.php");
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, produitsHandler);
            // display the result
            produits = produitsHandler.getProduit();

            if ( produits.length > 0) {
                for (int i = 0; i <  produits.length; i++) {
                 
                    lst.append(produits[i].getNomP(),null);

                }

            }

        } catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
        Midlet.m.disp.setCurrent(lst);    }
     private String showPersonne(int i) {
        String res = "";
        if ( produits.length > 0) {
            sb.append("* ");
            sb.append( produits[i].getPrix());
            sb.append("\n");
            sb.append("* ");
            sb.append( produits[i].getQuantite());
            sb.append("\n");
            sb.append("* ");
            sb.append( produits[i].getNomP());
            sb.append("\n");
             sb.append("* ");
            sb.append( produits[i].getTva());
            sb.append("\n");
             sb.append("* ");
            sb.append( produits[i].getReduction());
            sb.append("\n");
            
        }
        res = sb.toString();
        sb = new StringBuffer("");
        return res;
    }
    
}
