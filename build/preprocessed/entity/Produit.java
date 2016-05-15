/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author Toshiba
 */
public class Produit {

    private int id;
    private int zone_id;
    private String categorie;
    private String description;
    private float prix;
    private int user_id;
    private int quantite;
      private int ptbonus;
    private String nomP;
    private float prix1;
    private float prix2;
     private float tva;
    private float reduction; 
   private Date dateAjout;
   private int media_id;
   private String photo;

    public Produit() {
    }

    public Produit(int id, int zone_id, String categorie, String description, float prix, int user_id, int quantite, int ptbonus, String nomP, float prix1, float prix2, float tva, float reduction, Date dateAjout, int media_id, String photo) {
        this.id = id;
        this.zone_id = zone_id;
        this.categorie = categorie;
        this.description = description;
        this.prix = prix;
        this.user_id = user_id;
        this.quantite = quantite;
        this.ptbonus = ptbonus;
        this.nomP = nomP;
        this.prix1 = prix1;
        this.prix2 = prix2;
        this.tva = tva;
        this.reduction = reduction;
        this.dateAjout = dateAjout;
        this.media_id = media_id;
        this.photo = photo;
    }

    public Produit(int zone_id, String categorie, String description, float prix, int user_id, int quantite, int ptbonus, String nomP, float prix1, float prix2, float tva, float reduction, Date dateAjout, int media_id) {
        this.zone_id = zone_id;
        this.categorie = categorie;
        this.description = description;
        this.prix = prix;
        this.user_id = user_id;
        this.quantite = quantite;
        this.ptbonus = ptbonus;
        this.nomP = nomP;
        this.prix1 = prix1;
        this.prix2 = prix2;
        this.tva = tva;
        this.reduction = reduction;
        this.dateAjout = dateAjout;
        this.media_id = media_id;
    }

    public Produit(int id, String categorie, String description, float prix, int quantite, String nomP, float tva, float reduction, Date dateAjout) {
        this.id = id;
        this.categorie = categorie;
        this.description = description;
        this.prix = prix;
        this.quantite = quantite;
        this.nomP = nomP;
        this.tva = tva;
        this.reduction = reduction;
        this.dateAjout = dateAjout;
    }
    

    public int getId() {
        return id;
    }

    public int getZone_id() {
        return zone_id;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getDescription() {
        return description;
    }

    public float getPrix() {
        return prix;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getQuantite() {
        return quantite;
    }

    public int getPtbonus() {
        return ptbonus;
    }

    public String getNomP() {
        return nomP;
    }

    public float getPrix1() {
        return prix1;
    }

    public float getPrix2() {
        return prix2;
    }

    public float getTva() {
        return tva;
    }

    public float getReduction() {
        return reduction;
    }

    public Date getDateAjout() {
        return dateAjout;
    }

    public int getMedia_id() {
        return media_id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setZone_id(int zone_id) {
        this.zone_id = zone_id;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setPtbonus(int ptbonus) {
        this.ptbonus = ptbonus;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    public void setPrix1(float prix1) {
        this.prix1 = prix1;
    }

    public void setPrix2(float prix2) {
        this.prix2 = prix2;
    }

    public void setTva(float tva) {
        this.tva = tva;
    }

    public void setReduction(float reduction) {
        this.reduction = reduction;
    }

    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
    }

    public void setMedia_id(int media_id) {
        this.media_id = media_id;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String toString() {
        return "Produit{" + "id=" + id + ", zone_id=" + zone_id + ", categorie=" + categorie + ", description=" + description + ", prix=" + prix + ", user_id=" + user_id + ", quantite=" + quantite + ", ptbonus=" + ptbonus + ", nomP=" + nomP + ", prix1=" + prix1 + ", prix2=" + prix2 + ", tva=" + tva + ", reduction=" + reduction + ", dateAjout=" + dateAjout + ", media_id=" + media_id + ", photo=" + photo + '}';
    }
   
    Produit getProduit(){
        return null;
    }
}
