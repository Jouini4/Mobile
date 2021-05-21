/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Util;
import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
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
import entities.Produit;
import java.util.ArrayList;
import services.serviceProduit;
import static utils.Statics.BASE_URL;

/**
 *
 * @author ASUS
 */
public class ListProduit extends Form {
    Form current;
      public  ListProduit(Form previous) {

      
       setTitle("Liste des Produits");
       
       System.out.println(serviceProduit.getInstance().getAllProduit());
        ArrayList<Produit> Produits = new ArrayList();
        Produits =serviceProduit.getInstance().getAllProduit();
                for (Produit e :Produits ) {
                    
   Container cnt1 = new Container(BoxLayout.y());
   Container cnt2 = new Container(BoxLayout.x());
   //Button rent = new Button ("Rent");
  
   
              SpanLabel SLnom = new SpanLabel("Nom produit :"+e.getNom_produit());
              
                    EncodedImage enc = EncodedImage.createFromImage(Image.createImage(200,200), true);
		    String url = BASE_URL+"/uploads/"+e.getImage();
                        ImageViewer img = new ImageViewer(URLImage.createToStorage(enc, url.substring(url.lastIndexOf("/")+1, url.length()), url));
                        img.getAllStyles().setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FIT);
                        
              SpanLabel SLprix = new SpanLabel("Prix :"+e.getPrix());
                        Button rent = new Button ("Ajouter au panier");
                        Button description = new Button ("Description");
                        cnt1.add(img);
                        cnt1.add(SLnom);
                        cnt1.add(SLprix);
                        cnt1.add(rent);
                        cnt1.add(description);
       
                        
        cnt2.add(cnt1);
      
//    
//         rent.addActionListener(new ActionListener(){
//    @Override
//       public void actionPerformed(ActionEvent evt){
//
//               AddReservation Reserver=new AddReservation( m ,form);
//               Reserver.getF().show();
////           }else{
////                //VarGlobales.setusername(username.getText());
////               new Home(current).show();
////            }
//            }
//    });



               description.addPointerPressedListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    
                  
                    Form f2 = new Form("Description",BoxLayout.y());

                    Toolbar tb = f2.getToolbar();

                    tb.addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK
                , e-> previous.showBack());
                    


                    SpanLabel sp1 = new SpanLabel("Nom :" + e.getNom_produit());
                    SpanLabel sp2 = new SpanLabel("Prix :" + e.getPrix());
                    SpanLabel sp3 = new SpanLabel("Description :" + e.getDescription());
                    Style s = UIManager.getInstance().getComponentStyle("MultiLine1");
                    FontImage p = FontImage.createMaterial(FontImage.MATERIAL_PORTRAIT, s);
                    EncodedImage placeholder;
                    placeholder = EncodedImage.createFromImage(Image.createImage(p.getWidth() * 3, p.getWidth() * 3), false);
                    System.out.println("");
                    System.out.println("Image :" + e.getImage());
                    ImageViewer sp4 = new ImageViewer(URLImage.createToStorage(placeholder, e.getImage(), e.getImage()));
                    System.out.println(sp3.toString());
                    f2.add(sp1);
                    f2.add(sp2);
                    f2.add(sp3);
                    f2.add(sp4);
                    Button pdf = new Button("PDF");
                    f2.add(pdf);
                    f2.show();
                    
                    
                    pdf.addPointerPressedListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
//                        Form hi = new Form("PDF Viewer", BoxLayout.y());
//                        Button devGuide = new Button("Show PDF");
//                        devGuide.addActionListener(e -> {
//                        tb.addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK
//                             , e-> previous.showBack());
                        
                        FileSystemStorage fs = FileSystemStorage.getInstance();
                        String fileName = fs.getAppHomePath() + "pdf-sample.pdf";
                        if(!fs.exists(fileName)) {
                        Util.downloadUrlToFile("http://www.polyu.edu.hk/iaee/files/pdf-sample.pdf", fileName, true);
                             }
                        Display.getInstance().execute(fileName);
//                                  });
//                        hi.add(devGuide);

//                        hi.show();
                        
                    }
                    });

                }
                                    
            });
    
    add(cnt2);
    
    
                        
}
                getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK
                , e-> previous.showBack()); // Revenir vers l'interface précédente
 }
        //add();
       
       
       
       
       
       
         
   
 
//        
//      
//        serviceProduit es = new serviceProduit();
//        ArrayList<Produit> list = es.getAllProduit();
//
//        {
//           
//            for (Produit r : list) {
//
//          
// 
//                Container c3 = new Container(BoxLayout.y());
//                SpanLabel cat= new SpanLabel("nom_produit :" + r.getNom_produit());
//                  SpanLabel cat3= new SpanLabel("prix :" + r.getPrix());
//                  SpanLabel cat2= new SpanLabel("Image :" + r.getImage());
//                  SpanLabel cat4= new SpanLabel("description:" + r.getDescription());
//                 
//               
//               
//                     
//                       c3.add(cat);
//                       c3.add(cat3);
//                       c3.add(cat2);
//                       c3.add(cat4);
//       
//                         Button Delete =new Button("Delete","LoginButton");
//         c3.add(Delete);
//            Delete.getAllStyles().setBgColor(0xF36B08);
//            Delete.addActionListener(e -> {
//               Dialog alert = new Dialog("Warning");
//                SpanLabel message = new SpanLabel("Are you sure you want to delete your produit?\nThis action once done cannot be reverted!");
//                alert.add(message);
//                Button ok = new Button("Proceed");
//                Button cancel = new Button(new Command("Cancel"));
//                //User clicks on ok to delete account
//                ok.addActionListener(new ActionListener() {
//                  
//                    public void actionPerformed(ActionEvent evt) {
//                       es.Delete(r.getId());
//                     
//                        alert.dispose();
//                        refreshTheme();
//                    }
//                    
//                }
//                
//                
//                );
//
//                alert.add(cancel);
//                alert.add(ok);
//                alert.showDialog();
//                
//                new ListProduit(previous).show();
//              
//                
//             
//            });
//                       
//                        
//           System.out.println("");
//              
//  add(c3);
//              
//            
//          getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK
//                , e-> previous.showBack()); // Revenir vers l'interface précédente
//                
//            }
//          
//        }
//     
//    }
    
}
