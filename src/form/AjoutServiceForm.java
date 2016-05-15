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
import javax.microedition.lcdui.TextField;
import pidevj2me.Midlet;

/**
 *
 * @author maroo
 */
public class AjoutServiceForm extends Form implements CommandListener , Runnable{
    
    TextField tfNomService = new TextField("NomService", null, 100, TextField.ANY);
    TextField tfDescription = new TextField("Description", null, 100, TextField.ANY);
    TextField tfType = new TextField("Type", null, 100, TextField.ANY);
    
    
     private String[] choices = {
        "disponible", "annulee", "exclusive",
        "pas disponible"
    };
    ChoiceGroup cgEtat = new ChoiceGroup("Etat", ChoiceGroup.POPUP, choices,null);
   
     Command cmdAjouterService = new Command("Ajouter Service", Command.SCREEN, 0);
     Command cmdNext = new Command("Next", Command.SCREEN, 0);
    Command cmdBack = new Command("cmdBack", Command.BACK, 0);
    
   Form fs2 = new Form("Welcome");
    Form fs3 = new Form("Erreur");

    Alert alerta = new Alert("Error", "Sorry", null, AlertType.ERROR);  
    
    
      //Connexion
    HttpConnection hc;
    DataInputStream dis;
    String url = "http://localhost/piDev/ajouterService.php";
    StringBuffer sb = new StringBuffer();
    int ch;

    public AjoutServiceForm(String title) {
        super(title);
           append(tfNomService);
        append(tfDescription);
        append(tfType);
        append(cgEtat);
        
        
        addCommand(cmdAjouterService);
        setCommandListener(this);
        addCommand(cmdBack);
        setCommandListener(this);
      
    }

    public void commandAction(Command c, Displayable d) {
if (c == cmdAjouterService) {
            Thread th = new Thread(this);
            th.start();
        }
        if (c == cmdBack) {
            
            Midlet.m.disp.setCurrent(new AjoutServiceForm(""));
        }    
              }

    public void run() {
 String scg= cgEtat.getString(cgEtat.getSelectedIndex());
        
        
 try {
                hc = (HttpConnection) Connector.open(url+"?nomService="+tfNomService.getString().trim()+"&description="+tfDescription.getString().trim()+"&type="+tfType.getString().trim()+"&etat="+scg.trim());
                dis = new DataInputStream(hc.openDataInputStream());
                while ((ch = dis.read()) != -1) {
                    sb.append((char)ch);
                }
                if ("OK".equals(sb.toString().trim())) {
                    Midlet.m.disp.setCurrent(fs2);
                }else{
                     Midlet.m.disp.setCurrent(fs3);
                }
                sb = new StringBuffer();
            } catch (IOException ex) {
                ex.printStackTrace();
            }        }
    
}
