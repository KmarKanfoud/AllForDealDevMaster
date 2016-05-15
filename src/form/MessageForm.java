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
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;
import pidevj2me.Accueil;
import pidevj2me.Midlet;

/**
 *
 * @author maroo
 */
public class MessageForm extends Form implements CommandListener , Runnable{

    //Form 1
    
    TextField tfDest = new TextField("Destinataire", null, 100, TextField.ANY);
    TextField tfSujet = new TextField("Sujet", null, 100, TextField.ANY);
    TextField tfTexte = new TextField("Texte", null, 100, TextField.ANY);
    Command cmdValider = new Command("valider", Command.SCREEN, 0);
    Command cmdBack = new Command("cmdBack", Command.BACK, 0);
   

    Form f2 = new Form("OK");
    Form f3 = new Form("Erreur");

    Alert alerta = new Alert("Error", "Sorry", null, AlertType.ERROR);

    //Connexion
    HttpConnection hc;
    DataInputStream dis;
    String url = "http://localhost/j2me/ajoutMessage.php";
    StringBuffer sb = new StringBuffer();
    int ch;
    public MessageForm(String title) {
        super("Message");
        append(tfDest);
       append(tfSujet);
           append(tfTexte);
        
        addCommand(cmdValider);
      
        setCommandListener(this);
        addCommand(cmdBack);
        setCommandListener(this);
    }

    public void commandAction(Command c, Displayable d) {
  if (c == cmdValider) {
            Thread th = new Thread(this);
            th.start();
        }
        if (c == cmdBack) {
            
            Midlet.m.disp.setCurrent(new Accueil());
        }    
      
    }

    public void run() {
try {
                hc = (HttpConnection) Connector.open(url+"?toU="+tfDest.getString().trim()+"&sujet="+tfSujet.getString().trim()+"&texte="+tfTexte.getString().trim());
                dis = new DataInputStream(hc.openDataInputStream());
                
                while ((ch = dis.read()) != -1) {
                    sb.append((char)ch);
                }
                if ("OK".equals(sb.toString().trim())) {
                    Midlet.m.disp.setCurrent(f2);
                }else{
                    Midlet.m.disp.setCurrent(f3);
                }
                sb = new StringBuffer();
            } catch (IOException ex) {
                ex.printStackTrace();
            }    }
    
}
