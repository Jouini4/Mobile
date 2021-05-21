/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import entities.Categorie;
import java.util.ArrayList;
import services.serviceCat;

/**
 *
 * @author bhk
 */



       
  public class ListcatForm extends Form{

     public  ListcatForm(Form previous) {

      
       setTitle("Liste des categories");
         
   
 
        
      
        serviceCat es = new serviceCat();
        ArrayList<Categorie> list = es.getAllCat();

        {
           
            for (Categorie r : list) {

          
 
                Container c3 = new Container(BoxLayout.y());
               
                 SpanLabel cat= new SpanLabel("categeorie:" + r.getNom_categorie());

               
                     
                      
                        c3.add(cat);    
                        
           System.out.println("");
              
  add(c3);
              
            
          getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK
                , e-> previous.showBack()); // Revenir vers l'interface précédente
                
            }
          
        }
     
    }
     
//      private void trier() {
////        paginator.clear();
//        String rechercheTexte = recherche.getText().toLowerCase().trim();
//         serviceCat es = new serviceCat();
//        ArrayList<Categorie> list = es.getAllCat();
//        int catId = -1;
//
//        for (Categorie p : list) {
//            if (p.getNom_categorie().toLowerCase().trim().contains(rechercheTexte)) {
//                addEmploye(p);
//            }
//        }
//    }
//
//      recherche = new TextField("", "Recherche");
//            recherche.addActionListener(a -> trier());
//            add(recherche);
//
//
// private TextField recherche;
     
     
       
//         Button Delete =new Button("Delete","LoginButton");
//         c3.add(Delete);
//            Delete.getAllStyles().setBgColor(0xF36B08);
//            Delete.addActionListener(e -> {
//               Dialog alert = new Dialog("Warning");
//                SpanLabel message = new SpanLabel("Are you sure you want to delete your product?\nThis action once done cannot be reverted!");
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

//                alert.add(cancel);
//                alert.add(ok);
//                alert.showDialog();
//                
//                new ListcatForm(previous).show();
//              
//                
//             
//            });
//                   

 
}