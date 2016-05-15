/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevj2me;

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
import javax.microedition.lcdui.TextBox;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.*;

/**
 * @author SaharS
 */
public class MidletAjoutReclamation extends MIDlet implements CommandListener, Runnable {

    public static MidletAjoutReclamation m;
    Display disp = Display.getDisplay(this);
    Form f1 = new Form("Réclamation");
    TextField tfObjet = new TextField("Objet", null, 100, TextField.ANY);
    TextBox tbMessage = new TextBox("Message", null, 100, TextField.ANY);
    Command cmdValider = new Command("valider", Command.SCREEN, 0);
    Command cmdBack = new Command("Back", Command.BACK, 0);
    Command cmdNext = new Command("Next", Command.OK, 0);
    Form f2 = new Form("Welcome");
    Form f3 = new Form("Erreur");
    Alert alerta = new Alert("Error", "Sorry", null, AlertType.ERROR);

    //Connexion
    HttpConnection hc;
    DataInputStream dis;
    String url = "http://localhost/piDev/ajoutReclamation.php";
    StringBuffer sb = new StringBuffer();
    int ch;

    public void startApp() {
        f1.append(tfObjet);
        //f1.append(tfMessage);
        f1.addCommand(cmdNext);
        f1.setCommandListener(this);
        f2.addCommand(cmdBack);
        f2.setCommandListener(this);
        tbMessage.addCommand(cmdValider);
        tbMessage.addCommand(cmdBack);
        tbMessage.setCommandListener(this);
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
        if (c == cmdNext) {
            disp.setCurrent(tbMessage);
        }
    }

    public void run() {
        System.out.println(tbMessage.getString()+" "+tfObjet.getString());
        try {
            hc = (HttpConnection) Connector.open(url + "?sujet=" + tfObjet.getString().trim() + "&description=" + tbMessage.getString().trim());
            dis = new DataInputStream(hc.openDataInputStream());
            while ((ch = dis.read()) != -1) {
                sb.append((char) ch);
            }
            if ("OK".equals(sb.toString().trim())) {

                disp.setCurrent(f2);
            } else {
                disp.setCurrent(f3);
            }
            sb = new StringBuffer();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
