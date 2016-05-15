/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Froms;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.DateField;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;
import pidevj2me.Midlet;

/**
 *
 * @author Super Moon
 */
public class InscriptionForm extends Form implements CommandListener {

    TextField tfFristName = new TextField("First Name :", "", 15, TextField.ANY);
    TextField tfLastName = new TextField("Last Name :", "", 15, TextField.ANY);
    TextField tfEmail = new TextField("Email :", "", 15, TextField.ANY);
    TextField tfUserName = new TextField("User Name :", "", 15, TextField.ANY);
    TextField tfPassWord = new TextField("Password :", "", 15, TextField.PASSWORD);
    //DateField date = new DateField("Date de naissance", DateField.DATE);
    ChoiceGroup cg = new ChoiceGroup("Genre :", Choice.MULTIPLE);
    Command cmdInscription = new Command("Inscription", Command.OK, 2);
    Command cmdBack = new Command("Back", Command.BACK, 0);
     HttpConnection hc;
    DataInputStream dis;
    String url = "http://localhost/j2me/ajoutUser.php";
    StringBuffer sb = new StringBuffer();
    int ch;

    public InscriptionForm(String title) {
        super("Inscription");
        append(tfFristName);
        append(tfLastName);
        append(tfEmail);
        append(tfUserName);
        append(tfPassWord);
        //append(tfPassWord2);
//        append(date);
        cg.append("Femme", null);
        cg.append("Homme", null);
        addCommand(cmdInscription);
        addCommand(cmdBack);
        setCommandListener(this);

    }

    public void commandAction(Command c, Displayable d) {
          if (c == cmdInscription) {

            try {
                hc = (HttpConnection) Connector.open(url + "?username=" + tfUserName.getString().trim() + "&email=" + tfEmail.getString().trim()+ "&password=" + tfPassWord.getString().trim()+ "&firstname=" + tfFristName.getString().trim()+ "&lastname=" + tfLastName.getString().trim()+ "&email=" + tfEmail.getString().trim()+ "&password=" + tfPassWord.getString().trim()+ "&firstname=" + tfFristName.getString().trim());
                dis = new DataInputStream(hc.openDataInputStream());
                while ((ch = dis.read()) != -1) {
                    sb.append((char) ch);
                }
                if ("OK".equals(sb.toString().trim())) {
                    Midlet.m.disp.setCurrent(new AccueilForm("Accueil"));

                } else {
                    Midlet.m.disp.setCurrent(new LoginForm("Login"));
                }
                sb = new StringBuffer();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
     if (c == cmdBack) {

            Midlet.m.disp.setCurrent(new LoginForm("Login"));
        }
        if (c == cmdInscription) {

            Midlet.m.disp.setCurrent(new AccueilForm("Accueil"));
        }
    }
        public void run() {
     
        Calendar cal = Calendar.getInstance();
       // cal.setTime(date.getDate());
        String s2 = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DAY_OF_MONTH);
        System.out.println(s2);}
        
//        String getDateString(Date date) {
//    Calendar calendar = Calendar.getInstance();
//    calendar.setTime(date);
//    int year = calendar.get(Calendar.YEAR);
//    int month = calendar.get(Calendar.MONTH);
//    int day = calendar.get(Calendar.DAY_OF_MONTH);
//    if(month<10){
//    return new String(year+"-0"+month+"-"+day+"");}
//    else 
//                return new String(year+"-"+month+"-"+day+"");
//    
//}

}
