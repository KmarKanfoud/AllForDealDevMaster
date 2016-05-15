/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author maroo
 */
public class Panier {


    int id;
    int iduser;
    String username;
    int idprod;
    String nomP;
    int nbrprod;
    String description;

    public Panier() {
    }

    public Panier(int id, String username, String nomP, int nbrprod, String description) {
        this.id = id;
        this.username = username;
        this.nomP = nomP;
        this.nbrprod = nbrprod;
        this.description = description;
    }

    
    
    public Panier(int id, int iduser, String username, int idprod, String nomP, int nbrprod, String description) {
        this.id = id;
        this.iduser = iduser;
        this.username = username;
        this.idprod = idprod;
        this.nomP = nomP;
        this.nbrprod = nbrprod;
        this.description = description;
    }

  

    public int getId() {
        return id;
    }

    public int getIduser() {
        return iduser;
    }

    public String getUsername() {
        return username;
    }

    public int getIdprod() {
        return idprod;
    }

    public String getNomP() {
        return nomP;
    }

    public int getNbrprod() {
        return nbrprod;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setIdprod(int idprod) {
        this.idprod = idprod;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    public void setNbrprod(int nbrprod) {
        this.nbrprod = nbrprod;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return "Panier{" + "id=" + id + ", iduser=" + iduser + ", username=" + username + ", idprod=" + idprod + ", nomP=" + nomP + ", nbrprod=" + nbrprod + ", description=" + description + '}';
    }

    void getNbrprod(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    


}


