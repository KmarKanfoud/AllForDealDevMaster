/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Froms;

import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;
import pidevj2me.Midlet;

/**
 *
 * @author Super Moon
 */
public class LoginForm extends Form implements CommandListener {

    TextField tfUsername = new TextField("UserName", null, 15, TextField.ANY);
    TextField tfPassword = new TextField("Mot de passe", null, 20, TextField.PASSWORD);
    Command cmdValider = new Command("Valider", Command.OK, 0);
    Command cmdBack = new Command("Back", Command.BACK, 0);
    Command cmdInscription = new Command("Inscription", Command.OK, 0);

    //Connexion
    HttpConnection hc;
    DataInputStream dis;
    String url = "http://localhost/j2me/login0.php";
    StringBuffer sb = new StringBuffer();
    int ch;

    public LoginForm(String title) {
        super(title);
        append(tfUsername);
        append(tfPassword);
        addCommand(cmdValider);
        setCommandListener(this);
        addCommand(cmdBack);
        addCommand(cmdInscription);
        setCommandListener(this);
    }

    public void commandAction(Command c, Displayable d) {
 if (c==cmdValider){
            
           try {
                hc = (HttpConnection) Connector.open(url+"?username="+tfUsername.getString().trim()+"&password="+tfPassword.getString().trim());
                dis = new DataInputStream(hc.openDataInputStream());
                while ((ch = dis.read()) != -1) {
                    sb.append((char)ch);
                }
                if ("ArrayOK".equals(sb.toString().trim())) {
                     Midlet.m.disp.setCurrent(new AccueilForm("Accueil"));
                }else{
                   Midlet.m.disp.setCurrent(new LoginForm("Login"));
                }
                sb = new StringBuffer();
           }
           catch(IOException e){
               e.printStackTrace();
           }
        }
        
      if (c == cmdInscription) {

            Midlet.m.disp.setCurrent(new InscriptionForm("Inscription"));
        }
    }

}
