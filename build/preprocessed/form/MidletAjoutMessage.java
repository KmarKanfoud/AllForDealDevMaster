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
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.*;

/**
 * @author maroo
 */
public class MidletAjoutMessage extends MIDlet implements CommandListener, Runnable {


    Display disp = Display.getDisplay(this);
    //Form 1
    Form f1 = new Form("Ajout Message");
    TextField tfDest = new TextField("Destinataire", null, 100, TextField.ANY);
    TextField tfSujet = new TextField("Sujet", null, 100, TextField.ANY);
    TextField tfTexte = new TextField("Texte", null, 100, TextField.ANY);
    StringItem strmsg = new StringItem("Message envoyer", null);
    Command cmdValider = new Command("valider", Command.SCREEN, 0);
    Command cmdBack = new Command("cmdBack", Command.BACK, 0);

    Form f2 = new Form("Welcome");
    Form f3 = new Form("Erreur");

    Alert alerta = new Alert("Error", "Sorry", null, AlertType.ERROR);

    //Connexion
    HttpConnection hc;
    DataInputStream dis;
    String url = "http://localhost/j2me/ajoutMessage.php";
    StringBuffer sb = new StringBuffer();
    int ch;

    public void startApp() {
        f1.append(tfDest);
        f1.append(tfSujet);
           f1.append(tfTexte);
        
        f1.addCommand(cmdValider);
        f1.setCommandListener(this);
        f2.addCommand(cmdBack);
        f2.setCommandListener(this);
        disp.setCurrent(f1);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
        if (c == cmdValider) {
            Thread th = new Thread(this);
            th.start();
        }
        if (c == cmdBack) {
            
            disp.setCurrent(f1);
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
                    f2.append(strmsg);
                    disp.setCurrent(f2);
                }else{
                    disp.setCurrent(alerta);
                }
                sb = new StringBuffer();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
    }
}
