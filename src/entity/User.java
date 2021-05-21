/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author user
 */
public class User {
    
    private int id;
    private String nom ;
    private String  Prenom;
    private String e_mail;
    private String mdp;
    private Date date_de_naissance;
    private String telephone;
    private String photo;
    private int portfeuille;
    private int fidalite;
    private String role;
    private int etat;
    private Date date_de_creation;
  /**  DateFormat formate = new SimpleDateFormat("dd-mm-yyyy");
    ZoneId defaultZoneId = ZoneId.systemDefault();
    LocalDate localDate = LocalDate.now();
    public Date date =Date.from(localDate.atStartOfDay(defaultZoneId).toInstant())
     * @param nom;*
     * @param Prenom
     * @param e_mail
     * @param mdp
     * @param date_de_naissance
     * @param telephone
     * @param photo
     * @param date_de_creation*/
    

    public User(String nom, String Prenom, String e_mail, String mdp, Date date_de_naissance, String telephone, String photo, Date date_de_creation) {
        this.nom = nom;
        this.Prenom = Prenom;
        this.e_mail = e_mail;
        this.mdp = mdp;
        this.date_de_naissance = date_de_naissance;
        this.telephone = telephone;
        this.photo = photo;
        this.date_de_creation = date_de_creation;
    }

    public User(String nom, String Prenom, String e_mail, String mdp, Date date_de_naissance, String photo, String telephone, int portfeuille, int fidalite, String role, int etat, Date date_de_creation) {
        this.nom = nom;
        this.Prenom = Prenom;
        this.e_mail = e_mail;
        this.mdp = mdp;
        this.date_de_naissance = date_de_naissance;
        this.telephone = telephone;
        this.photo = photo;
        this.portfeuille = portfeuille;
        this.fidalite = fidalite;
        this.role = role;
        this.etat = etat;
        this.date_de_creation = date_de_creation;
    }

    public User(int id, String nom, String Prenom, String e_mail, String mdp, Date date_de_naissance, String telephone, String photo, int portfeuille, int fidalite, String role, int etat) {
        this.id = id;
        this.nom = nom;
        this.Prenom = Prenom;
        this.e_mail = e_mail;
        this.mdp = mdp;
        this.date_de_naissance = date_de_naissance;
        this.telephone = telephone;
        this.photo = photo;
        this.portfeuille = portfeuille;
        this.fidalite = fidalite;
        this.role = role;
        this.etat = etat;
    }

    public User(int id, String nom, String Prenom, String e_mail, String mdp, Date date_de_naissance, String photo, String telephone, int portfeuille, int fidalite, String role, int etat, Date date_de_creation) {
        this.id = id;
        this.nom = nom;
        this.Prenom = Prenom;
        this.e_mail = e_mail;
        this.mdp = mdp;
        this.date_de_naissance = date_de_naissance;
        this.photo = photo;
        this.telephone = telephone;
        this.portfeuille = portfeuille;
        this.fidalite = fidalite;
        this.role = role;
        this.etat = etat;
        this.date_de_creation = date_de_creation;
    }

    
    
    
    public User(int id, String nom, String Prenom, String e_mail, String mdp, Date date_de_naissance, String telephone, String photo) {
        this.id = id;
        this.nom = nom;
        this.Prenom = Prenom;
        this.e_mail = e_mail;
        this.mdp = mdp;
        this.date_de_naissance = date_de_naissance;
        this.telephone = telephone;
        this.photo = photo;
    }

    public User() {
    }

    public User(String nom, String Prenom, String e_mail, String mdp, Date date_de_naissance, String telephone, String photo) {
        this.nom = nom;
        this.Prenom = Prenom;
        this.e_mail = e_mail;
        this.mdp = mdp;
        this.date_de_naissance = date_de_naissance;
        this.telephone = telephone;
        this.photo = photo;
        /**this.date_de_creation =java.util.Date.from(localDate.atStartOfDay()
      .atZone(ZoneId.systemDefault())
      .toInstant());**/
    }
    

    public User(String nom, String Prenom, String e_mail, String mdp, Date date_de_naissance, String telephone, String photo, String role) {
        this.nom = nom;
        this.Prenom = Prenom;
        this.e_mail = e_mail;
        this.mdp = mdp;
        this.date_de_naissance = date_de_naissance;
        this.telephone = telephone;
        this.photo = photo;
        this.role = role;
    }
    private final StringProperty string = new SimpleStringProperty();

    public String getString() {
        return string.get();
    }

    public void setString(String value) {
        string.set(value);
    }

    public StringProperty stringProperty() {
        return string;
    }

    
    
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public String getE_mail() {
        return e_mail;
    }

    public String getMdp() {
        return mdp;
    }

    public Date getDate_de_naissance() {
        return date_de_naissance;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getPhoto() {
        return photo;
    }

    public int getPortfeuille() {
        return portfeuille;
    }

    public int getFidalite() {
        return fidalite;
    }

    public String getRole() {
        return role;
    }

    public int getEtat() {
        return etat;
    }

    public Date getDate_de_creation() {
        return date_de_creation;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setDate_de_naissance(Date date_de_naissance) {
        this.date_de_naissance = date_de_naissance;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setPortfeuille(int portfeuille) {
        this.portfeuille = portfeuille;
    }

    public void setFidalite(int fidalite) {
        this.fidalite = fidalite;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public void setDate_de_creation(Date date_de_creation) {
        this.date_de_creation = date_de_creation;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", nom=" + nom + ", Prenom=" + Prenom + ", e_mail=" + e_mail + ", mdp=" + mdp + ", date_de_naissance=" + date_de_naissance + ", telephone=" + telephone + ", photo=" + photo + ", portfeuille=" + portfeuille + ", fidalite=" + fidalite + ", role=" + role + ", etat=" + etat + ", date_de_creation=" + date_de_creation + '}';
    }
    
    
  
    
}
  