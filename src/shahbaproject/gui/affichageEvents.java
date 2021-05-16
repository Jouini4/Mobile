/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shahbaproject.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import shahbaproject.entites.evenement;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;

import java.util.ArrayList;

import shahbaproject.services.ServiceEvenement;
import static shahbaproject.utils.Statics.BASE_URL;

/**
 *
 * @author HAMMOUDA
 */
public class affichageEvents extends Form {
    /**

    public affichageEvents(Form previous) {
         setTitle("EVENTS ");
        
        SpanLabel sp = new SpanLabel();
        sp.setText(ServiceEvenement.getInstance().getALLEVENT().toString());
        add(sp);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
       
    } 
    */
     Component m;
    Form form;
      
    Form f;
    SpanLabel lb;
    Form f2;

       public affichageEvents(Form current) {
        
        
                setTitle("List of Events");
                
        
       
        
        System.out.println(ServiceEvenement.getInstance().getALLEVENT());
        ArrayList<evenement> Events = new ArrayList();
        Events =ServiceEvenement.getInstance().getALLEVENT();
                for (evenement e :Events ) {
                    
   Container cnt1 = new Container(BoxLayout.y());
   Container cnt2 = new Container(BoxLayout.x());
   //Button rent = new Button ("Rent");
  
   
        SpanLabel SLnom = new SpanLabel("Titre :"+e.getNom_event());
        SpanLabel SLprix = new SpanLabel("Prix :"+e.getPrix_event());
        SpanLabel SLdesc = new SpanLabel("Description :"+e.getDescription_event());
                SpanLabel SLqut = new SpanLabel("Adresse :"+e.getAdresse());
                    EncodedImage enc = EncodedImage.createFromImage(Image.createImage(1200,500), true);
		String url =BASE_URL+ "/uploads/"+e.getImage();
                        ImageViewer img = new ImageViewer(URLImage.createToStorage(enc, url.substring(url.lastIndexOf("/")+1, url.length()), url));
                        img.getAllStyles().setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FIT);
                        Button rent = new Button ("Rent");
                        cnt1.add(img);
                        cnt1.add(SLnom);
                        cnt1.add(SLprix);
                        cnt1.add(SLdesc);
                        cnt1.add(SLqut);
                        cnt1.add(rent);
      
       
                        
        cnt2.add(cnt1);
      
    
        
    
    add(cnt2);
}
 }
   
        
        
    }


 
    
    
