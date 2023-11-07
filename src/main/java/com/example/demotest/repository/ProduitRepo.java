package com.example.demotest.repository;

import com.example.demotest.entity.Produits;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProduitRepo {

    /**
     * Fonction qui retour des données
     * Le repository retournerais des données issue d'une base de données
     * @param idSociete
     * @return
     */
    public List<Produits> getAllProduitByIdSociete(int idSociete){
        List<Produits> listProduits = new ArrayList<>();
        Produits produit1 = new Produits();
        produit1.setId(1);
        produit1.setPrix(13);
        produit1.setNom("Miel");
        produit1.setQuantite(50);
        listProduits.add(produit1);
        Produits produit2 = new Produits();
        produit2.setId(2);
        produit2.setPrix(21);
        produit2.setNom("Hydromel");
        produit2.setQuantite(45);
        listProduits.add(produit2);
        Produits produit3 = new Produits();
        produit3.setId(3);
        produit3.setPrix(7);
        produit3.setNom("Pain épice");
        produit3.setQuantite(65);
        listProduits.add(produit3);
        return listProduits;
    }
}
