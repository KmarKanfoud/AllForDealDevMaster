/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevj2me;

import form.MessageForm;
import form.MessageList;
import form.PanierList;
import form.ProduitList;
import form.ReclamationForm;
import form.ServiceForm;
import form.UserForm;
import java.io.IOException;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/**
 *
 * @author maroo
 */
public class Accueil extends Canvas implements CommandListener {

    Image img;
    Image imgf;
    //Displayable d;
    int w = getWidth();
    int h = getHeight();
    int etat = 0;

    String url = "/images/Accueilu.png";

    protected void paint(Graphics g) {

        try {

            img = Image.createImage(url);
            g.drawImage(img, w / 2, h / 2, Graphics.HCENTER | Graphics.VCENTER);
            g.drawString("" + etat, w / 2, h / 2, Graphics.BASELINE | Graphics.HCENTER);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    protected void keyPressed(int keyCode) {
        int gameAction = getGameAction(keyCode);

        if (gameAction == RIGHT) {
            if (etat == 0) {
                url = "/images/Accueilp.png";
                etat = 1;
                repaint();
            }
            else if (etat == 1) {
                url = "/images/Accueils.png";
                etat = 2;
                repaint();
            }
        
        
            else if (etat == 2) {
                url = "/images/Accueilr.png";
                etat = 3;
                repaint();
            }
            else if (etat == 3) {
                url = "/images/Accueilm.png";
                
                etat = 4;
                repaint();
            }
            else  if (etat == 4) {
                url = "/images/Accueilpn.png";
                etat = 5;
                repaint();
            }
           else if (etat == 5) {
                url = "/images/Accueilp.png";
                etat = 1;
                repaint();
            }

        }
        if (gameAction == LEFT) {
            if (etat == 0) {
                url = "/images/Accueilp.png";
                etat = 1;
                repaint();
            }
            else if (etat == 1) {
                url = "/images/Accueilpn.png";
                etat = 5;
                repaint();
            }
        
        
            else if (etat == 5) {
                url = "/images/Accueilm.png";
                etat = 4;
                repaint();
            }
            else if (etat == 4) {
                url = "/images/Accueilr.png";
                etat = 3;
                repaint();
            }
            else  if (etat == 3) {
                url = "/images/Accueils.png";
                etat = 2;
                repaint();
            }
           else if (etat == 2) {
                url = "/images/Accueilp.png";
                etat = 1;
                repaint();
            }

        }
         if (gameAction == UP) {
              url = "/images/Accueilu.png";
              etat = 0;
              repaint();
             
         }
         if (gameAction == DOWN) {
              url = "/images/Accueilu.png";
              etat = 0;
              repaint();
             
         }
        if (gameAction == FIRE) {
            
            if (etat == 0) {
                   Midlet.m.disp.setCurrent(new UserForm(""));
               
            }
            else if (etat == 1) {
             Midlet.m.disp.setCurrent(new ProduitList(""));
            }
        
        
            else if (etat == 5) {
             Midlet.m.disp.setCurrent(new PanierList(""));
            }
            else if (etat == 4) {
              Midlet.m.disp.setCurrent(new MessageList("ListMessage"));
            }
            else  if (etat == 3) {
                  Midlet.m.disp.setCurrent(new ReclamationForm(""));
               
            }
           else if (etat == 2) {
                Midlet.m.disp.setCurrent(new ServiceForm(""));
               
            }

        }

    }

    public void commandAction(Command c, Displayable d) {

    }

}
