/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javafx.scene.image.ImageView;

/**
 *
 * @author ASUS
 */
public class Produit {
    
    private int id;
    private String  categorie_id;
    private String nom_produit;
   private String description;
    private String image;
    private float prix;

    public Produit() {
    }

    public Produit(int id, String categorie_id, String nom_produit, String description, String image, float prix) {
        this.id = id;
        this.categorie_id = categorie_id;
        this.nom_produit = nom_produit;
        this.description = description;
        this.image = image;
        this.prix = prix;
    }


    public Produit(String nom_produit, String description, String image, float prix) {
        this.nom_produit = nom_produit;
        this.description = description;
        this.image = image;
        this.prix = prix;
    }

    public Produit(String nom_produit, String image, float prix) {
        this.nom_produit = nom_produit;
        this.image = image;
        this.prix = prix;
    }

     public Produit(String nom_produit, float prix,String description) {
        this.nom_produit = nom_produit;
        this.prix = prix;
        this.description = description;
    }
  

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", categorie_id=" + categorie_id + ", nom_produit=" + nom_produit + ", description=" + description + ", image=" + image + ", prix=" + prix + '}';
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategorie_id() {
        return categorie_id;
    }

    public void setCategorie_id(String categorie_id) {
        this.categorie_id = categorie_id;
    }

    public String getNom_produit() {
        return nom_produit;
    }

    public void setNom_produit(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

  
    
}
