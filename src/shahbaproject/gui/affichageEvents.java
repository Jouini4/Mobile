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
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.plaf.UIManager;

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
        f = new Form("Events", BoxLayout.y());
        
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
               //  SpanLabel SLplace = new SpanLabel("nbr_place :"+e.getNbr_place());
                    EncodedImage enc = EncodedImage.createFromImage(Image.createImage(700,350), true);
		String url =BASE_URL+ "/uploads/"+e.getImage();
                        ImageViewer img = new ImageViewer(URLImage.createToStorage(enc, url.substring(url.lastIndexOf("/")+1, url.length()), url));
                        img.getAllStyles().setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FIT);
                        Button rent = new Button ("Rent");
                       
               
                        cnt1.add(SLnom);
                        cnt1.add(img);
                        cnt1.add(SLdesc);
                        // cnt1.add(SLplace);
                        cnt1.add(SLqut);
                        cnt1.add(SLprix);
                        cnt1.add(rent);
      
                        
                        
                        
                        rent.addPointerPressedListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {

                    f2 = new Form(BoxLayout.y());

                    Toolbar tb = f2.getToolbar();

                    tb.addMaterialCommandToLeftBar("Back", FontImage.MATERIAL_ARROW_BACK, e -> {

                        f.showBack();

                    });

                    SpanLabel sp1 = new SpanLabel("Titre :"+e.getNom_event());
        SpanLabel sp2 = new SpanLabel("Prix :"+e.getPrix_event());
        
        SpanLabel sp3 = new SpanLabel("Description :"+e.getDescription_event());
                SpanLabel sp4 = new SpanLabel("Adresse :"+e.getAdresse());
                // SpanLabel sp5 = new SpanLabel("nbr_place :"+e.getNbr_place());
                    Style s = UIManager.getInstance().getComponentStyle("MultiLine1");
                    FontImage p = FontImage.createMaterial(FontImage.MATERIAL_PORTRAIT, s);
                    EncodedImage placeholder;
                    placeholder = EncodedImage.createFromImage(Image.createImage(p.getWidth() * 3, p.getWidth() * 3), false);
                  
                    System.out.println("photo :" + e.getImage());
                    ImageViewer sp6 = new ImageViewer(URLImage.createToStorage(placeholder, e.getImage(), e.getImage()));
                    System.out.println(sp3.toString());
                    f2.add(sp6);
                    f2.add(sp1);
                    f2.add(sp2);
                      f2.add(sp3);
                    f2.add(sp4);
                     // f2.add(sp5);
                    
                    f2.show();

                }
            });
                        
       
                        
        cnt2.add(cnt1);
      
    
        
    
    add(cnt2);
}
 getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->new  HomeForm().show());
   
        
                        }}
    


 
    
    
