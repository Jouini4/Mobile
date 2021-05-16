/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Astuce;
import Utils.Statics;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



/**
 *
 * @author islem
 */
public class ServiceAstuce {
    public ArrayList<Astuce> astuces;
    public static ServiceAstuce instance=null;
    public boolean resultOK;
    private final ConnectionRequest req;
    
        public static ServiceAstuce getInstance() {
        if (instance == null) {
            instance = new ServiceAstuce();
        }
        return instance;
    }
    
    
    public ServiceAstuce () {
         req = new ConnectionRequest();
    }
     public ArrayList<Astuce> parseAstuces(String jsonText)  {
       try {
            astuces=new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json
            Map<String,Object> astucesListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)astucesListJson.get("root");
            
            //Parcourir la liste des tâches Json
            for(Map<String,Object> obj : list){
                //Création des tâches et récupération de leurs données
                Astuce a = new Astuce();
                float id = Float.parseFloat(obj.get("id").toString());
                a.setId((int)id);
              //  a.setStatus(((int)Float.parseFloat(obj.get("status").toString())));
                a.setTitre(obj.get("titre").toString());
                a.setImage(obj.get("image").toString());
                a.setDescription(obj.get("description").toString());
                //Ajouter la tâche extraite de la réponse Json à la liste
                astuces.add(a);
            }
            
            
        } catch (IOException ex) {
            
        }
   
        return astuces;
    }
                                
                //float id = Float.parseFloat(obj.get("id").toString());
                //m.setId((int)id)
              //   m.setNbrmatrres(Integer.parseInt(obj.get("nbrmatrres").toString()));
               //  m.setQuantity(Integer.parseInt(obj.get("quantity").toString()));
                                
                //float id = Float.parseFloat(obj.get("id").toString());
                //m.setId((int)id)
              //   m.setNbrmatrres(Integer.parseInt(obj.get("nbrmatrres").toString()));
               //  m.setQuantity(Integer.parseInt(obj.get("quantity").toString()));                                
                //float id = Float.parseFloat(obj.get("id").toString());
                //m.setId((int)id)
              //   m.setNbrmatrres(Integer.parseInt(obj.get("nbrmatrres").toString()));
               //  m.setQuantity(Integer.parseInt(obj.get("quantity").toString()));
                                
                //float id = Float.parseFloat(obj.get("id").toString());
                //m.setId((int)id)
              //   m.setNbrmatrres(Integer.parseInt(obj.get("nbrmatrres").toString()));
               //  m.setQuantity(Integer.parseInt(obj.get("quantity").toString()));
       
                 
     
    public ArrayList<Astuce> getAllAstuces(){
        String url = Statics.BASE_URL+"/astuce/AstuceJson/";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               astuces = parseAstuces(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return astuces;
    }

     
}