package entity;

import javax.microedition.io.*;
import javax.microedition.lcdui.*;
import javax.wireless.messaging.*;
import pidevj2me.MidletAjoutReclamation;

public class SendSms extends Form implements CommandListener, Runnable {


    private TextField toWhom;
    private TextField message;
    private Alert alert;
    private Command send, exit;
    MessageConnection clientConn;


    public SendSms() {
        super("SMS");
      
        
        toWhom = new TextField("To", "", 10, TextField.PHONENUMBER);
        message = new TextField("Message", "", 600, TextField.ANY);
        send = new Command("Send", Command.BACK, 0);
        exit = new Command("Exit", Command.SCREEN, 5);
        append(toWhom);
        append(message);
        addCommand(send);
        addCommand(exit);
        setCommandListener(this);
    }

  

    public void commandAction(Command cmd, Displayable disp) {
        if (cmd == exit) {
           MidletAjoutReclamation.m.notifyDestroyed();
        }
        if (cmd == send) {
            Thread th = new Thread(this);
            th.start();
        }
    }

    public void run() {
        String mno = toWhom.getString();
        String msg = message.getString();
        if (mno.equals("")) {
            alert = new Alert("Alert");
            alert.setString("Enter Mobile Number!!!");
            alert.setTimeout(2000);
           // MidletAjoutReclamation.m.disp.setCurrent(alert);
        } else {
            try {
                clientConn = (MessageConnection) Connector.open("sms://" + mno);
            } catch (Exception e) {
                alert = new Alert("Alert");
                alert.setString("Unable to connect to Station because of network problem");
                alert.setTimeout(2000);
         //   MidletAjoutReclamation.m.disp.setCurrent(alert);
            }
            try {
                TextMessage textmessage = (TextMessage) clientConn.newMessage(MessageConnection.TEXT_MESSAGE);
                textmessage.setAddress("sms://" + mno);
                textmessage.setPayloadText(msg);
                clientConn.send(textmessage);
            } catch (Exception e) {
                Alert alert = new Alert("Alert", "", null, AlertType.INFO);
                alert.setTimeout(Alert.FOREVER);
                alert.setString("Unable to send");
            //  MidletAjoutReclamation.m.disp.setCurrent(alert);
            }
        }
    }

}
