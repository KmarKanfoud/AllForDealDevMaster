/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;


import entity.Message;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author SaharS
 */
public class MessageHandler  extends DefaultHandler{
   private Vector messages;
    
  

    public MessageHandler() {
        messages = new Vector();
    }

    

    public Message[] getReclamation() {
         Message[] messagess = new Message[messages.size()];
         messages.copyInto(messagess);
        return messagess;
    }
    
 private Message currentMessage ;
 
 public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("message")) {
            currentMessage  = new Message ();
            
            currentMessage.setId_message(Integer.parseInt(attributes.getValue("id_message")));
            currentMessage.setFrom(attributes.getValue("fromU"));
            currentMessage.setTo(attributes.getValue("toU"));
            currentMessage.setSujet(attributes.getValue("sujet"));
            currentMessage.setTexte(attributes.getValue("texte"));
          
            /****/
            
        }
    }
      public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("message")) {
            // we are no longer processing a <reg.../> tag
            messages.addElement( currentMessage);
             currentMessage = null;
        } 
    }
    


 
    
    
}
