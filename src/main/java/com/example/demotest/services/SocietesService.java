package com.example.demotest.services;

import com.example.demotest.dto.SocieteAvecProduitDTO;
import com.example.demotest.entity.Produits;
import com.example.demotest.entity.Societes;
import com.example.demotest.repository.SocieteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocietesService {
    private final SocieteRepo societeRepo;
    private final ProduitsService produitsService;

    @Autowired
    public SocietesService(SocieteRepo societeRepo, ProduitsService produceService){
        this.societeRepo = societeRepo;
        this.produitsService = produceService;
    }

    /**
     * La methode va récupérer différentes information afin de créer un objet de
     * @param idSociete
     * @return
     */
    public SocieteAvecProduitDTO getSocietesAvecProduit(int idSociete) throws NullPointerException {
            SocieteAvecProduitDTO societeAvecProduit = new SocieteAvecProduitDTO();
            Societes societes = getSocietes(idSociete);
            if(societes == null){
                throw new NullPointerException("Aucune société !");
            }
            List<Produits> produits = produitsService.getAllProduits(idSociete);
            societeAvecProduit.setProduits(produits);
            societeAvecProduit.setSocietes(societes);
            return societeAvecProduit;
    }

    /**
     * Fonction qui permet de récuperer les données d'une société par son id
     * @param idSociete
     * @return
     */
    private Societes getSocietes(int idSociete) {
        return societeRepo.getSocieteById(idSociete);
    }
}
