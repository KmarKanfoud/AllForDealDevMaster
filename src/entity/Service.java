/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;


/**
 *
 * @author Super
 */
public class Service {

//    ZoneDao zoneDAO = new ZoneDao();
//    ResultSet rsName = null;
    private int id;
    private int userId;
    private String nomService;
    private String description;
    private String type;
    private String etat;
    private Date dateAjout;
    private int zone;
    private String zoneName;

    public Service() {
    }

    public Service(int id,int userId, String nomService, String description, String type, String etat, Date dateAjout, int zone) {
        this.id = id;
        this.userId = userId;
        this.nomService = nomService;
        this.description = description;
        this.type = type;
        this.etat = etat;
        this.dateAjout = dateAjout;
        this.zone = zone;
    }

    public Service(int id, String nomService, String description, String type, String etat, Date dateAjout) {
        this.id = id;
        this.nomService = nomService;
        this.description = description;
        this.type = type;
        this.etat = etat;
        this.dateAjout = dateAjout;
    }

//    public int getUserId() {
//        return FrameAccueil.getUserId();
//    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomService() {
        return nomService;
    }

    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Date getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
    }

    public int getZone() {
        return zone;
    }

//    public String getZoneName() {
//        try {
//            rsName = zoneDAO.getZoneById(zone);
//            while (rsName.next()) {
//                zoneName = rsName.getNString(1);
//
//            }//this.setResizable(false);
//        } catch (SQLException ex) {
//            Logger.getLogger(FrameAjouterService.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return zoneName;
//
//    }

    public void setZone(int zone) {
        this.zone = zone;
    }

    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.id;
        return hash;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Service other = (Service) obj;
        if (this.userId != other.userId) {
            return false;
        }
        if ((this.nomService == null) ? (other.nomService != null) : !this.nomService.equals(other.nomService)) {
            return false;
        }
        if ((this.description == null) ? (other.description != null) : !this.description.equals(other.description)) {
            return false;
        }
        if ((this.type == null) ? (other.type != null) : !this.type.equals(other.type)) {
            return false;
        }
        if ((this.etat == null) ? (other.etat != null) : !this.etat.equals(other.etat)) {
            return false;
        }
        if (this.dateAjout != other.dateAjout && (this.dateAjout == null || !this.dateAjout.equals(other.dateAjout))) {
            return false;
        }
        if (this.zone != other.zone) {
            return false;
        }
        if ((this.zoneName == null) ? (other.zoneName != null) : !this.zoneName.equals(other.zoneName)) {
            return false;
        }
        return true;
    }

   

}
