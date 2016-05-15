/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author SaharS
 */
public class Reclamation {

    private int id_reclamation;
    private Date date;
    private String description;
    private String sujet;
    private int user_id;
    private String username;

    public Reclamation() {
    }

//    public Reclamation(Date date, String description, String sujet) {
//        this.date = date;
//        this.description = description;
//        this.sujet = sujet;
//    }
    public Reclamation(int id_reclamation, Date date, String description, String sujet) {
        this.id_reclamation = id_reclamation;
        this.date = date;
        this.description = description;
        this.sujet = sujet;
    }

    public Reclamation(int id_reclamation, Date date, String description, String sujet, int user_id) {
        this.id_reclamation = id_reclamation;
        this.date = date;
        this.description = description;
        this.sujet = sujet;
        this.user_id = user_id;

    }

    public Reclamation(String description, String sujet) {
        this.description = description;
        this.sujet = sujet;
    }
    

    public int getId_reclamation() {
        return id_reclamation;
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String toString() {
        return "Reclamation{" + "id_reclamation=" + id_reclamation + ", date=" + date + ", description=" + description + ", sujet=" + sujet + ", user_id=" + user_id + ", username=" + username + '}';
    }

    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id_reclamation;
        return hash;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reclamation other = (Reclamation) obj;
        if (this.id_reclamation != other.id_reclamation) {
            return false;
        }
        return true;
    }
    

   

}
