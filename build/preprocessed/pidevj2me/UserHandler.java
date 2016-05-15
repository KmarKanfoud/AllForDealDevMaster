/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevj2me;

import Entity.User;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Super Moon
 */
public class UserHandler extends DefaultHandler{
        private Vector users;


    public UserHandler() {
        users = new Vector();
    }

    public User[] getUser() {
        User[] userss = new User[users.size()];
        users.copyInto( userss );
        return  userss ;
    }
    // VARIABLES TO MAINTAIN THE PARSER'S STATE DURING PROCESSING
    private User currentUser;

    // XML EVENT PROCESSING METHODS (DEFINED BY DefaultHandler)
    // startElement is the opening part of the tag "<tagname...>"
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("user")) {
            currentUser = new User();
            //2ème methode pour parser les attributs
            currentUser.setId(Integer.parseInt(attributes.getValue("id")));
            currentUser.setUsername(attributes.getValue("username"));
            currentUser.setEmail(attributes.getValue("email"));
           // currentUser.setRoles(attributes.getValue("RoLe"));
            currentUser.setFirstName(attributes.getValue("firstname"));
            currentUser.setLastName(attributes.getValue("lastname"));
           // currentUser.setBirth_date(attributes.getValue("date_of_birth"));
            /****/
        }
       
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("user")) {
            // we are no longer processing a <reg.../> tag
            users.addElement(currentUser);
            currentUser = null;
       
    }

    
}}

    

