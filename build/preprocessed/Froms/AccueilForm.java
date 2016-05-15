/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Froms;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import pidevj2me.Midlet;

/**
 *
 * @author Super Moon
 */
public class AccueilForm extends Form implements CommandListener {
      Command cmdLogout = new Command("Logout", Command.BACK, 0);
  

    public AccueilForm(String title) {
        super("Accueil");
        addCommand(cmdLogout);
         setCommandListener(this);
        
    }

    public void commandAction(Command c, Displayable d) {
         if (c == cmdLogout) {

            Midlet.m.disp.setCurrent(new LoginForm("Login"));
        }

    }
    
}
