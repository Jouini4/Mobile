/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import entities.Categorie;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utils.Statics;

/**
 *
 * @author bhk
 */
public class serviceCat {

    public ArrayList<Categorie> categorie;
    
    public static serviceCat instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public serviceCat() {
         req = new ConnectionRequest();
    }

    public static serviceCat getInstance() {
        if (instance == null) {
            instance = new serviceCat();
        }
        return instance;
    }

    public boolean addCat(Categorie t) {
            String url = Statics.BASE_URL + "/ajouter_categorie?nom_categorie="+ t.getNom_categorie();
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public ArrayList<Categorie> parseCat(String jsonText){
        try {
            categorie=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> catListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String,Object>> list = (List<Map<String,Object>>)catListJson.get("root");
            
            //Parcourir la liste des tâches Json
            for(Map<String,Object> obj : list){
                //Création des tâches et récupération de leurs données
                Categorie t = new Categorie();
               // float id = Float.parseFloat(obj.get("id").toString());
                t.setId((int)1);
                t.setNom_categorie(obj.get("Nom_Categorie").toString());
             
                categorie.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
         /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        return categorie;
    }
    
    public ArrayList<Categorie> getAllCat(){
         String url = Statics.BASE_URL + "/afficher_cat";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                System.out.println(new String(req.getResponseData()));
                categorie = parseCat(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return categorie;
    }
    
    
//    public boolean  Delete(int id){
//       String url = Statics.BASE_URL + "/supprimer_categorie/" +id;
//
//        req.setUrl(url);
//
//        req.addResponseListener(new ActionListener<NetworkEvent>() {
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//               
//                req.removeResponseListener(this);
//            }
//
//        });
//        NetworkManager.getInstance().addToQueueAndWait(req);
//        return resultOK;
//      
//      
//      }
}
