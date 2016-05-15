/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Froms ;


import Entity.User;
import Entity.UserDAO;
import javax.microedition.lcdui.*;
import pidevj2me.Midlet;

/**
 *
 * @author lenovo
 */
public class Login extends Form implements CommandListener, Runnable {
    
    TextField tf_usr = new TextField("Username", "", 20, TextField.ANY);
    TextField tf_pwd = new TextField("Password", "", 20, TextField.PASSWORD);
    
    Command cmdlog = new Command("login", Command.SCREEN, 0);
    Command cmdBack = new Command("Exit", Command.EXIT, 0);
    Command cmdInscription = new Command("Inscription", Command.OK, 0);

    public Login() {
        super("User");

        append(tf_usr);
        append(tf_pwd);
        addCommand(cmdlog);
        addCommand(cmdBack);
        addCommand(cmdInscription);
        setCommandListener(this);
    }

    public void commandAction(Command c, Displayable d) {
        if (c == cmdBack) {
            Midlet.m.notifyDestroyed();
        }
        if (c == cmdlog) {
            Thread th = new Thread(this);
            th.start();
        }
        if (c == cmdInscription) {
              Midlet.m.disp.setCurrent(new InscriptionForm("Inscription"));
           
        }

    }

    public void run() {
        String usr = tf_usr.getString();
        String pwd = tf_pwd.getString();
        
        boolean result = new UserDAO().login(usr, pwd);
        Alert alert = new Alert("Result");
        if (result) {
            alert.setType(AlertType.CONFIRMATION);
            alert.setString("You are logged in as "+User.id+" "+User.username);
            Midlet.m.disp.setCurrent(alert,new AccueilForm("Accueil"));
        } else {
            alert.setType(AlertType.ERROR);
            alert.setString("ERROR!");
            Midlet.m.disp.setCurrent(alert);
        }
    }
    
    
}
