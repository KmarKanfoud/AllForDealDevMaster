/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Gauge;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;
import javax.microedition.lcdui.Ticker;
import pidevj2me.Midlet;


/**
 *
 * @author maroo
 */
public class ProduitAjoutForm extends Form implements CommandListener, Runnable{
Alert alerte = new Alert("Ajout Produit");
    Form myForm = new Form("Ajouter Produit");
    Form f2 = new Form("Ajout avec sucées");
    Form f3 = new Form("Erreur");

    String[] categorie = {"multimédia", "électronique", "Vetements"};
    ChoiceGroup mycategorie = new ChoiceGroup("Liste des catégories", ChoiceGroup.POPUP, categorie, null);
    TextField description = new TextField("Description", null, 200, TextField.ANY);
    TextField prix = new TextField("Prix", null, 20, TextField.NUMERIC);

    Gauge qu = new Gauge("Quantite", true, 20, 1);
    StringItem sit = new StringItem("Quantité", null);

    TextField nomP = new TextField("nomP", null, 100, TextField.ANY);

    TextField tva = new TextField("tva", null, 20, TextField.DECIMAL);
    TextField reduction = new TextField("reduction", null, 20, TextField.DECIMAL);

    Command cmdValider = new Command("valider", Command.SCREEN, 0);
    Command cmdBack = new Command("cmdBack", Command.BACK, 0);

    //cnx
    HttpConnection hc;
    DataInputStream dis;
    String url = "http://localhost/Pi/ajout.php";
    StringBuffer sb = new StringBuffer();
    int ch;
    public ProduitAjoutForm(String title) {
        super(title);
          Ticker t = new Ticker("Ajout du produit");
        setTicker(t);
        append(mycategorie);
        append(description);
        append(prix);
        sit.setText("1");
        append(sit);
       append(qu);
        append(nomP);
        append(tva);
        append(reduction);

        addCommand(cmdValider);
        setCommandListener(this);
        f2.addCommand(cmdBack);
        f2.setCommandListener(this);
       
    }

    public void commandAction(Command c, Displayable d) {
  if (cmdValider == c) {
            if (description.getString().equals("")) {
                alerte.setType(AlertType.ERROR);
                alerte.setString("Veuillez ajouter une description pour ce produit !");
                alerte.setTimeout(2000);
              Midlet.m.disp.setCurrent(alerte);
        }else if (prix.getString().equals("")) {
                alerte.setType(AlertType.ERROR);
                alerte.setString("Veuillez ajouter le prix !");
                alerte.setTimeout(2000);
                 Midlet.m.disp.setCurrent(alerte);
            } else if (qu.getValue() == 0) {
                alerte.setType(AlertType.ERROR);
                alerte.setString("Veuillez entrer la quantité!");
                alerte.setTimeout(2000);
                Midlet.m.disp.setCurrent(alerte);
                 } else if (nomP.getString().equals("")) {
                alerte.setType(AlertType.ERROR);
                alerte.setString("Veuillez ajouter le nom de produit!");
                alerte.setTimeout(2000);
               Midlet.m.disp.setCurrent(alerte);
            } else if (tva.getString().equals("")) {
                alerte.setType(AlertType.ERROR);
                alerte.setString("Veuillez ajouter la TVA !");
                alerte.setTimeout(2000);
                  Midlet.m.disp.setCurrent(alerte);
            }   else if (reduction.getString().equals("")) {
                alerte.setType(AlertType.ERROR);
                alerte.setString("Veuillez ajouter la reduction !");
                alerte.setTimeout(2000);
                  Midlet.m.disp.setCurrent(alerte);
            }else {
                alerte.setType(AlertType.INFO);
                alerte.setString("Le produit est ajouté avec succes");
                alerte.setTimeout(2000);
                Thread th = new Thread(this);
                th.start(); 
            }
        if (cmdBack == c) {
            Midlet.m.disp.setCurrent(myForm);
        }
    }    }

    public void run() {
 try {
                hc = (HttpConnection) Connector.open(url+"?categorie="+mycategorie.getString(mycategorie.getSelectedIndex()).trim()+"&description="+description.getString().trim()+"&prix="+prix.getString().trim()+"&quantite="+qu.getValue()+"&nomP="+nomP.getString().trim()+"&tva="+tva.getString().trim()+"&reduction="+reduction.getString().trim());
            dis = new DataInputStream(hc.openDataInputStream());
            while ((ch = dis.read()) != -1) {
                sb.append((char) ch);
            } 
            if ("OK".equals(sb.toString().trim())) {

                 Midlet.m.disp.setCurrent(f2);
            } else {
                 Midlet.m.disp.setCurrent(f3);
            }
            sb = new StringBuffer();
        } catch (IOException ex) {
            ex.printStackTrace();
        }   
    }
    
}
