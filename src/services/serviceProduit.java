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
import entities.Produit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utils.Statics;

/**
 *
 * @author ASUS
 */
public class serviceProduit {
      public ArrayList<Produit> Produit;
    
    public static serviceProduit instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public serviceProduit() {
         req = new ConnectionRequest();
    }

    public static serviceProduit getInstance() {
        if (instance == null) {
            instance = new serviceProduit();
        }
        return instance;
    }

   
    public ArrayList<Produit> parseProduit(String jsonText){
        try {
           Produit=new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            /*
                On doit convertir notre réponse texte en CharArray à fin de
            permettre au JSONParser de la lire et la manipuler d'ou vient 
            l'utilité de new CharArrayReader(json.toCharArray())
            
            La méthode parse json retourne une MAP<String,Object> ou String est 
            la clé principale de notre résultat.
            Dans notre cas la clé principale n'est pas définie cela ne veux pas
            dire qu'elle est manquante mais plutôt gardée à la valeur par defaut
            qui est root.
            En fait c'est la clé de l'objet qui englobe la totalité des objets 
                    c'est la clé définissant le tableau de tâches.
            */
            Map<String,Object> ProduitListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
              /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche.               
            
            Le format Json impose que l'objet soit définit sous forme
            de clé valeur avec la valeur elle même peut être un objet Json.
            Pour cela on utilise la structure Map comme elle est la structure la
            plus adéquate en Java pour stocker des couples Key/Value.
            
            Pour le cas d'un tableau (Json Array) contenant plusieurs objets
            sa valeur est une liste d'objets Json, donc une liste de Map
            */
            List<Map<String,Object>> list = (List<Map<String,Object>>)ProduitListJson.get("root");
            
            //Parcourir la liste des tâches Json
            for(Map<String,Object> obj : list){
                //Création des tâches et récupération de leurs données
               Produit t = new Produit();
                //float id = Float.parseFloat(obj.get("id").toString());
                  t.setId((int)1);
                  t.setNom_produit(obj.get("nomProduit").toString());
                  t.setImage(obj.get("Image").toString());
                  t.setPrix(Float.parseFloat(obj.get("Prix").toString()));
                  t.setDescription(obj.get("Description").toString());
             
                Produit.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
         /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        return  Produit;
    }
    
    public ArrayList< Produit> getAllProduit(){
         String url = Statics.BASE_URL + "/afficher_produits";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                System.out.println(new String(req.getResponseData()));
                Produit = parseProduit (new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return Produit ;
    }
   
    
    
    
    
    
    
    
    
//    public boolean  Delete(int id){
//       String url = Statics.BASE_URL + "/supprimer_produit/" +id;
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
