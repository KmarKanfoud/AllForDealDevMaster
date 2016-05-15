/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import entity.Service;
import entity.ServiceHandler;
import java.io.DataInputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import pidevj2me.Midlet;

/**
 *
 * @author maroo
 */
public class ServiceForm extends Form implements CommandListener , Runnable{
 Command cmdParseService = new Command("services", Command.SCREEN, 0);
 Command cmdnew = new Command("new+", Command.OK, 0);
    Command cmdBack = new Command("Back", Command.BACK, 0);
    
     Service[] services;
     
      List lst = new List("services", List.IMPLICIT);
    Form f = new Form("Accueil");
    Form form = new Form("Services disponibles");
    Form loadingDialog = new Form("Please Wait");
    StringBuffer sb = new StringBuffer();
    public ServiceForm(String title) {
        super(title);
       append("Click services to get the services_list");
       addCommand(cmdParseService);
       setCommandListener(this);
        addCommand(cmdnew);
      setCommandListener(this);
        lst.setCommandListener(this);
        form.addCommand(cmdBack);
        form.setCommandListener(this);
       
    
    }

    public void commandAction(Command c, Displayable d) {
  if (c == cmdParseService) {
            Midlet.m.disp.setCurrent(loadingDialog);
            Thread th = new Thread(this);
            th.start();
        }

        if (c == List.SELECT_COMMAND) {
            form.append("Informations Service: \n");
            form.append(showService(lst.getSelectedIndex()));
             Midlet.m.disp.setCurrent(form);
        }

        if (c == cmdBack) {
            form.deleteAll();
             Midlet.m.disp.setCurrent(lst);
        }     
        if (c == cmdnew) {
            
             Midlet.m.disp.setCurrent(new AjoutServiceForm(""));
        }     
}

    public void run() {
try {
            // this will handle our XML
           //  PersonneHandler personnesHandler = new PersonneHandler();
            ServiceHandler ServiceHandler = new ServiceHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/piDev/getXmlServices_Attributes.php");
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, ServiceHandler);
            // display the result
            services = ServiceHandler.getService();

            if (services.length > 0) {
                for (int i = 0; i < services.length; i++) {
                    lst.append(services[i].getNomService()+" "
                            +services[i].getDescription(), null);

                }
            }

        } catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
        Midlet.m.disp.setCurrent(lst);    }
    
        
         private String showService(int i) {
        String res = "";
        if (services.length > 0) {
            sb.append("* ");
            sb.append(services[i].getId());
            sb.append("\n");
            sb.append("* ");
            sb.append(services[i].getNomService());
            sb.append("\n");
            sb.append("* ");
            sb.append(services[i].getDescription());
            sb.append("\n");
        }
        res = sb.toString();
        sb = new StringBuffer("");
        return res;
    }
    
}
