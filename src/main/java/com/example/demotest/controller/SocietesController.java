package com.example.demotest.controller;

import com.example.demotest.dto.SocieteAvecProduitDTO;
import com.example.demotest.services.SocietesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/societes")
public class SocietesController {
    private final SocietesService societesService;

    @Autowired
    public SocietesController(SocietesService societesService){
        this.societesService = societesService;
    }

    @GetMapping("/get-all-by-id-societe/{idSociete}")
    public SocieteAvecProduitDTO getSocieteAvecProduits(@PathVariable int idSociete) {
        try {
            return societesService.getSocietesAvecProduit(idSociete);
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erreur dans la récupérations de la société et des produits");
        }
    }
}
