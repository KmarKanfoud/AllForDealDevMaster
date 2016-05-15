/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import entity.Message;
import java.io.DataInputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.List;
import javax.microedition.midlet.MIDlet;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import pidevj2me.Midlet;

/**
 *
 * @author maroo
 */
public class MessageList extends Form implements CommandListener,Runnable{
 
    Command cmdParseReclam = new Command("messages", Command.SCREEN, 0);
    Command cmdBack = new Command("Back", Command.BACK, 0);
     Command cmdNew = new Command("New+", Command.OK, 0);
    Message[] messages;
     
      List lst = new List("messages", List.IMPLICIT);
    Form f = new Form("Accueil");
    Form form = new Form("Liste des messages ");
    Form loadingDialog = new Form("Please Wait");
    StringBuffer sb = new StringBuffer();
    
    public MessageList(String title) {
        super(title);
       append("Cliquer surmessages pour consulter la liste");
        addCommand(cmdParseReclam);
          addCommand(cmdNew);
        setCommandListener(this);
        lst.setCommandListener(this);
        form.addCommand(cmdBack);
        form.setCommandListener(this);
        
    }

    public void commandAction(Command c, Displayable d) {
      if (c == cmdParseReclam) {
            Midlet.m.disp.setCurrent(loadingDialog);
            Thread th = new Thread(this);
            th.start();
        }

        if (c == List.SELECT_COMMAND) {
            form.append("Liste des messages: \n");
            form.append(showMessage(lst.getSelectedIndex()));
            Midlet.m.disp.setCurrent(form);
        }

        if (c == cmdBack) {
            form.deleteAll();
            Midlet.m.disp.setCurrent(lst);
        } 
          if (c == cmdNew) {
            
            Midlet.m.disp.setCurrent(new MessageForm(""));
        }    
    }

    public void run() {
        try{
     // this will handle our XML
           //  PersonneHandler personnesHandler = new PersonneHandler();
          MessageHandler msgHandler = new      MessageHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/j2me/getXmlMessageAttributes.php");
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, msgHandler );
            // display the result
          messages = msgHandler.getReclamation();

            if (  messages.length > 0) {
                for (int i = 0; i <   messages.length; i++) {
                    lst.append(  messages[i].getSujet()+" "
                            +  messages[i].getTexte(), null);

                }
            }

        } catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
        Midlet.m.disp.setCurrent(lst);      }

    private String showMessage(int i) {
        String res = "";
        if (  messages.length > 0) {
            sb.append("* ");
            sb.append(  messages[i].getId_message());
            sb.append("\n");
            sb.append("* ");
            sb.append(  messages[i].getSujet());
            sb.append("\n");
            sb.append("* ");
            sb.append(  messages[i].getTexte());
            sb.append("\n");
        }
        res = sb.toString();
        sb = new StringBuffer("");
        return res;
    }
    
}
