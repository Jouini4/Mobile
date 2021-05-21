/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author bhk
 */
public class HomeForm extends BaseForm {

    Form current;
    /*Garder traçe de la Form en cours pour la passer en paramètres 
    aux interfaces suivantes pour pouvoir y revenir plus tard en utilisant
    la méthode showBack*/
    
    public HomeForm() {
        current = this; //Récupération de l'interface(Form) en cours
        setTitle("Home");
        setLayout(BoxLayout.y());

        add(new Label("Choose an option"));
        Button btnAddTask = new Button("Ajouter Categorie");
        Button btnListTasks = new Button("Liste des categories");
        Button btnList = new Button("Liste des produits");
            

        btnAddTask.addActionListener(e -> new AddCatForm(current).show());
        btnListTasks.addActionListener(e -> new ListcatForm(current).show());
        btnList.addActionListener(e -> new ListProduit(current).show());
        addAll(btnAddTask, btnListTasks, btnList);

    }

}
