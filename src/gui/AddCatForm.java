/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import entities.Categorie;
import services.serviceCat;

/**
 *
 * @author bhk
 */
public class AddCatForm extends Form{

    public AddCatForm(Form previous) {
        /*
        Le paramètre previous définit l'interface(Form) précédente.
        Quelque soit l'interface faisant appel à AddTask, on peut y revenir
        en utilisant le bouton back
        */
        setTitle("Ajouter une nouvelle catégorie ");
        setLayout(BoxLayout.y());
        
        TextField tfType = new TextField("","Catégorie produit");
        
        Button btnValider = new Button("Ajouter categorie");
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfType.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        Categorie t = new Categorie( tfType.getText());
                        if( serviceCat.getInstance().addCat(t))
                            Dialog.show("Success","Catégorie ajoutée",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "categorie must be a string", new Command("OK"));
                    }
                    
                }
//                LocalNotification n = new LocalNotification();
//        n.setId("demo-notification");
//        n.setAlertBody("Catégorie ajoutée");
//        n.setAlertTitle("Catégorie");
//        n.setAlertSound("/notification_sound_beep-01a.mp3");
//    // alert sound file name must begin with notification_sound
//
//        Display.getInstance().scheduleLocalNotification(
//        n,
//        System.currentTimeMillis() + 10 * 1000, // fire date/time
//        LocalNotification.REPEAT_MINUTE  // Whether to repeat and what frequency
//            ); 
                
            }
            
        });
        
        
       
        
        addAll(tfType,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK
                , e-> previous.showBack()); // Revenir vers l'interface précédente
                
    }
    
    
}
