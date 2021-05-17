/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shahbaproject.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import static com.codename1.push.PushContent.setTitle;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import java.util.ArrayList;
import shahbaproject.entites.evenement;
import shahbaproject.entites.reservation;
import shahbaproject.services.ServiceEvenement;
import shahbaproject.services.ServiceReservation;
import static shahbaproject.utils.Statics.BASE_URL;

/**
 *
 * @author HAMMOUDA
 */
public class affichageReservations {
    
     
         Component m;
    Form form;
      
    Form f;
    SpanLabel lb;
    Form f2;

       public affichageReservations(Form current) {
        f = new Form("reservations", BoxLayout.y());
        
                setTitle("List of Events");
                
        
       
        
        System.out.println(ServiceReservation.getInstance().getALLReservation());
        ArrayList<reservation> reservations = new ArrayList();
        reservations =ServiceReservation.getInstance().getALLReservation();
                for (reservation e :reservations ) {
                    
   Container cnt1 = new Container(BoxLayout.y());
   Container cnt2 = new Container(BoxLayout.x());
   //Button rent = new Button ("Rent");
  
   
        SpanLabel SLnom = new SpanLabel("Titre :"+e.getId_Event());
        SpanLabel SLprix = new SpanLabel("Prix :"+e.getApprouve());
        
        SpanLabel SLdesc = new SpanLabel("Description :"+e.getNbrplace());
              
              ;
                        Button rent = new Button ("Rent");
                       
               
                        cnt1.add(SLnom);
                   
                        cnt1.add(SLdesc);
                      
                      
                        cnt1.add(SLprix);
                        cnt1.add(rent);
                        
      
                        
                        
                        
                     
                        
       
                        
        cnt2.add(cnt1);
      
 
        
    

}
                    f.show();

        
                       }

   
    
    
    
}

