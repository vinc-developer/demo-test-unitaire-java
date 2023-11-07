package com.example.demotest.repository;

import com.example.demotest.entity.Societes;
import org.springframework.stereotype.Repository;

@Repository
public class SocieteRepo {

    /**
     * Fonction qui retour des données
     * Le repository retournerais des données issue d'une base de données
     * @param idSociete
     * @return
     */
    public Societes getSocieteById(int idSociete) {
        Societes societes = new Societes();
        societes.setId(idSociete);
        societes.setNom("Younup");
        societes.setResponsable("Pierre-Marie Passet");
        return societes;
    }
}
