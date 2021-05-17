/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shahbaproject.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import shahbaproject.entites.evenement;
import shahbaproject.entites.reservation;
import shahbaproject.utils.Statics;

/**
 *
 * @author HAMMOUDA
 */
public class ServiceReservation {
     public ArrayList<reservation> reservations;
    
     private ConnectionRequest req;
    public static ServiceReservation instance=null;
     
     public static ServiceReservation getInstance() {
        if (instance == null) {
            instance = new ServiceReservation();
        }
        return instance;
    } 
    public ServiceReservation() {
         req = new ConnectionRequest();
    }
    
 
    
    
    
      public ArrayList<reservation> AfficheReservation(String jsonText){
        try {
            reservations=new ArrayList<>();
            JSONParser j = new JSONParser();
            /*
              //  t.setStatus(((int)Float.parseFloat(obj.get("status").toString())));
               // t.setName(obj.get("name").toString());
                    //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                    ev.setNom_event(obj.get("nom_event").toString());
                    ev.setDescription_event(obj.get("description_event").toString());
                    // ev.setDate(sdf.parse(obj.get("date").toString()));
                   // ev.setAdresse(obj.get("adresse").toString());
//                    ev.setPhoto(imageUrl+obj.get("photo").toString());
                   // ev.setNbr_place((int) Float.parseFloat(obj.get("nbr_place").toString()));
                   // ev.setPrix_event((double) Float.parseFloat(obj.get("prix_event").toString()));
**/
             Map<String,Object> associationsListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            java.util.List<Map<String,Object>> list = (java.util.List<Map<String,Object>>)associationsListJson.get("root");
            for(Map<String,Object> obj : list){
                reservation e = new reservation();              
                float id = Float.parseFloat(obj.get("id").toString());
                
                e.setId((int)id);               
                e.setId_Event(obj.get("nom_event").toString());
               
                e.setApprouve(Boolean.parseBoolean(obj.get("approuve").toString()));
             
                e.setNbrplace(Integer.parseInt(obj.get("nbrplace").toString()));


                                
            
                 
                reservations.add(e);
                
            }
            
            
        } catch (IOException ex) {
            
        }

        return reservations;
    }
    
    public ArrayList<reservation> getALLReservation(){
        String url = Statics.BASE_URL+"/readreservationj";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                reservations = AfficheReservation(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return reservations;
    }
    
}
