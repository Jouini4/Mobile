/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.io.Preferences;
import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class SessionManager {
    
    public static Preferences pref ; // 3ibara memoire sghira nsajlo fiha data 
    
    
    private static int id;
    private static String nom ;
    private static String Prenom;
    private static String email;
    private static String mdp;
    private static Date date_de_naissance;
    private static String telephone;
    private static String photo;
    private static int portfeuille;
    private static int fidalite;
    private static String role;
    private static int etat;
    private static Date date_de_creation;
    // hethom données ta3 user lyt7b tsajlhom fi session  ba3d login 
   

    public static Preferences getPref() {
        return pref;
    }

    public static void setPref(Preferences pref) {
        SessionManager.pref = pref;
    }

    public static int getId() {
        return pref.get("id",id);// kif nheb njib id user connecté apres njibha men pref 
    }

    public static void setId(int id) {
        pref.set("id",id);//nsajl id user connecté  w na3tiha identifiant "id";
    }

    public static String getFirstName() {
        return pref.get("firstname",nom);
    }

    public static void setFirstName(String firstname) {
         pref.set("firstname",firstname);
    }
     public static String getLastName() {
        return pref.get("lastname",Prenom);
    }

    public static void setLastName(String lastName) {
         pref.set("lastname",lastName);
    }

    public static String getEmail() {
        return pref.get("email",email);
    }

    public static void setEmail(String email) {
         pref.set("email",email);
    }

    public static String getDatenaissance() {
        return pref.get("datedenaissance",date_de_naissance.toString());
    }

    public static void setDatenaissance(Date passowrd) {
         pref.set("datedenaissance",passowrd.toString());
    }
     public static String getPassowrd() {
        return pref.get("passowrd",mdp);
    }

    public static void setPassowrd(String passowrd) {
         pref.set("passowrd",passowrd);
    }
     public static String getTelephone() {
        return pref.get("telephone",telephone);
    }

    public static void setTelephone(String telephone) {
         pref.set("telephone",telephone);
    }

    public static String getPhoto() {
        return pref.get("photo",photo);
    }

    public static void setPhoto(String photo) {
         pref.set("photo",photo);
    }
     public static int getportfeuille() {
        return pref.get("wallet",portfeuille);// kif nheb njib id user connecté apres njibha men pref 
    }

    public static void setportfeuille(int id) {
        pref.set("wallet",id);//nsajl id user connecté  w na3tiha identifiant "id";
    }
    public static int getfidality() {
        return pref.get("fidality",fidalite);// kif nheb njib id user connecté apres njibha men pref 
    }

    public static void setfidality(int id) {
        pref.set("fidality",id);//nsajl id user connecté  w na3tiha identifiant "id";
    }
}
