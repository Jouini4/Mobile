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
import shahbaproject.utils.Statics;


/**
 *
 * @author HAMMOUDA
 */
public class ServiceEvenement {
    public ArrayList<evenement> events;
    
     private ConnectionRequest req;
    public static ServiceEvenement instance=null;
     
     public static ServiceEvenement getInstance() {
        if (instance == null) {
            instance = new ServiceEvenement();
        }
        return instance;
    } 
    public ServiceEvenement() {
         req = new ConnectionRequest();
    }
    
 
    
    
    
      public ArrayList<evenement> AfficheEVENTS(String jsonText){
        try {
            events=new ArrayList<>();
            JSONParser j = new JSONParser();
            /*

            Map<String,Object> EVENTJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String,Object>> list = (List<Map<String,Object>>)EVENTJson.get("root");
            for(Map<String,Object> obj : list){
               evenement ev = new evenement();
                float id = Float.parseFloat(obj.get("id").toString());
                ev.setId((int)id);
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
                evenement e = new evenement();              
                float id = Float.parseFloat(obj.get("id").toString());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                e.setId((int)id);               
                e.setNom_event(obj.get("nom_event").toString());
                e.setDescription_event(obj.get("description_event").toString());
              e.setImage(obj.get("image").toString());
                e.setAdresse(obj.get("adresse").toString());
             /**   try {
                    e.setDate(sdf.parse(obj.get("date").toString()));
                    
                } catch (ParseException ex) {
                   
                }
                **/
                
                e.setPrix_event(Double.parseDouble(obj.get("prix_event").toString()));
              //   e.setNbr_place(Integer.parseInt(obj.get("nbr_place").toString()));

                                
                //float id = Float.parseFloat(obj.get("id").toString());
                //m.setId((int)id)
              //   m.setNbrmatrres(Integer.parseInt(obj.get("nbrmatrres").toString()));
               //  m.setQuantity(Integer.parseInt(obj.get("quantity").toString()));
                 
                events.add(e);
                
            }
            
            
        } catch (IOException ex) {
            
        }

        return events;
    }
    
    public ArrayList<evenement> getALLEVENT(){
        String url = Statics.BASE_URL+"/readeventfrontj";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                events = AfficheEVENTS(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return events;
    }
    
}