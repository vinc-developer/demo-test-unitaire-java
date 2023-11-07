package com.example.demotest.controller;

import com.example.demotest.entity.Produits;
import com.example.demotest.services.ProduitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitsController {
    private final ProduitsService produitsService;

    @Autowired
    public ProduitsController(ProduitsService produitsService){
        this.produitsService = produitsService;
    }

    @GetMapping("/get-by-id-societe/{idSociete}")
    public List<Produits> getByIdSociete(@PathVariable int idSociete){
        try {
            return produitsService.getAllProduits(idSociete);
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erreur dans la récupérations des produits");
        }
    }
}
