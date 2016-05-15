/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevj2me;

import Entity.User;
import java.io.DataInputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.List;
import javax.microedition.midlet.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * @author Super Moon
 */
public class MidletParsingAffichageUser extends MIDlet implements CommandListener, Runnable{
   Display disp = Display.getDisplay(this);
    Command cmdParse = new Command("Users", Command.SCREEN, 0);
    Command cmdBack = new Command("Back", Command.BACK, 0);
    User[] users;
    List lst = new List("Users", List.IMPLICIT);
    Form f = new Form("Accueil");
    Form form = new Form("Infos Personne");
    Form loadingDialog = new Form("Please Wait");
    StringBuffer sb = new StringBuffer();

    public void startApp() {
        f.append("Click USERS to get your users_list");
        f.addCommand(cmdParse);
        f.setCommandListener(this);
        lst.setCommandListener(this);
        form.addCommand(cmdBack);
        form.setCommandListener(this);
        disp.setCurrent(f);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {

        if (c == cmdParse) {
            disp.setCurrent(loadingDialog);
            Thread th = new Thread(this);
            th.start();
        }

        if (c == List.SELECT_COMMAND) {
            form.append("Informations Personne: \n");
            form.append(showPersonne(lst.getSelectedIndex()));
            disp.setCurrent(form);
        }

        if (c == cmdBack) {
            form.deleteAll();
            disp.setCurrent(lst);
        }

    }

    public void run() {
       try {
            // this will handle our XML
            UserHandler userHandler = new UserHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/j2me/getXmlUser_Attributes.php");
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            
            parser.parse(dis, userHandler );
            // display the result
            users = userHandler.getUser();

            if (users.length > 0) {
                for (int i = 0; i < users.length; i++) {
                    lst.append(users[i].getFirstName()+" "
                            +users[i].getLastName(), null);

                }
            }

        } catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
        disp.setCurrent(lst);
    }

    private String showPersonne(int i) {
        String res = "";
        if (users.length > 0) {
            sb.append("* ");
            sb.append(users[i].getId());
            sb.append("\n");
            sb.append("* ");
            sb.append(users[i].getFirstName());
            sb.append("\n");
            sb.append("* ");
            sb.append(users[i].getLastName());
            sb.append("\n");
        }
        res = sb.toString();
        sb = new StringBuffer("");
        return res;
    }
}
