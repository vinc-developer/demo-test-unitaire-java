package com.example.demotest.services;

import com.example.demotest.entity.Produits;
import com.example.demotest.repository.ProduitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitsService {
    private final ProduitRepo produitRepo;

    @Autowired
    public ProduitsService(ProduitRepo produitRepo){
        this.produitRepo = produitRepo;
    }

    /**
     * Fonction qui permet de récupérer tout les produits d'une société par son id
     * @param idSociete
     * @return
     */
    public List<Produits> getAllProduits(int idSociete) {
        return produitRepo.getAllProduitByIdSociete(idSociete);
    }
}
