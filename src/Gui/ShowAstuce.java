/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;


import Entities.Astuce;
import Services.ServiceAstuce;
import static Utils.Statics.BASE_URL;
import com.codename1.components.ImageViewer;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Slider;
import com.codename1.ui.URLImage;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import java.util.ArrayList;

/**
 *
 * @author islem
 */
public class ShowAstuce extends Form{
    Component m;
    Form form;
      
    Form f;
    SpanLabel lb;
    Form f2;

       public ShowAstuce(Form current) {
        
        
                setTitle("List of Astuces");
                
        
       
        
        System.out.println(ServiceAstuce.getInstance().getAllAstuces());
        ArrayList<Astuce> Astuces = new ArrayList();
        Astuces =ServiceAstuce.getInstance().getAllAstuces();
                for (Astuce e :Astuces ) {
                    
   Container cnt1 = new Container(BoxLayout.y());
   Container cnt2 = new Container(BoxLayout.x());
   //Button rent = new Button ("Rent");
  
   
        SpanLabel SLnom = new SpanLabel("Titre :"+e.getTitre());
        //SpanLabel SLnom = new SpanLabel("Prix :"+e.getPrix());
        
                
                    EncodedImage enc = EncodedImage.createFromImage(Image.createImage(1200,500), true);
		String url = BASE_URL+"/uploads/"+e.getImage();
                        ImageViewer img = new ImageViewer(URLImage.createToStorage(enc, url.substring(url.lastIndexOf("/")+1, url.length()), url));
                        img.getAllStyles().setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FIT);
                        SpanLabel SLdesc = new SpanLabel("Description :"+e.getDescription());
                        Button rent = new Button ("Rent");
                        cnt1.add(img);
                        cnt1.add(SLnom);
                        cnt1.add(SLdesc);
                      
                        cnt1.add(rent);
      
       
                        
        cnt2.add(cnt1);
      
    
       
    
   
    
    add(cnt2);
}
 }
        //add();

}