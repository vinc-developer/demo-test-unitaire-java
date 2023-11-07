package com.example.demotest.Controller;

import com.example.demotest.controller.SocietesController;
import com.example.demotest.dto.SocieteAvecProduitDTO;
import com.example.demotest.entity.Produits;
import com.example.demotest.entity.Societes;
import com.example.demotest.services.SocietesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SocieteControllerTest {
    private SocietesController societesController;

    @Mock
    private SocietesService societesService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialise les mocks
        societesController = new SocietesController(societesService);
    }

    @Test
    void getSocieteAvecProduitsOK() {
        //Arrange
        int idSociete = 1;
        SocieteAvecProduitDTO societeAvecProduit = retourneSocieteAvecProduitMock();

        //Mock
        when(societesService.getSocietesAvecProduit(idSociete)).thenReturn(societeAvecProduit);

        //Act
        SocieteAvecProduitDTO result = societesController.getSocieteAvecProduits(idSociete);

        //Verify
        assertNotNull(result);
        assertEquals(societeAvecProduit, result);
        assertEquals(3, result.getProduits().size());
        assertEquals("Younup", result.getSocietes().getNom());
        System.out.println("test ok :-)");
    }

    @Test
    void getSocieteAvecProduitsKO() {
        //Arrange
        int idSociete = 1;

        //Mock
        when(societesService.getSocietesAvecProduit(idSociete)).thenThrow(new NullPointerException("Aucune société !"));

        ResponseStatusException exception = assertThrows(ResponseStatusException.class,
                //Act
                () -> societesController.getSocieteAvecProduits(idSociete)
        );

        //Verify
        assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
        assertEquals("Erreur dans la récupérations de la société et des produits", exception.getReason());
        System.out.println("test ok :-)");
    }

    /* METHODE JEUX DE DONNEES */

    private SocieteAvecProduitDTO retourneSocieteAvecProduitMock(){
        SocieteAvecProduitDTO societeAvecProduit = new SocieteAvecProduitDTO();
        societeAvecProduit.setProduits(retourneListesProduitsMock());
        societeAvecProduit.setSocietes(retourneDonneeSocieteMock());
        return societeAvecProduit;
    }

    private Societes retourneDonneeSocieteMock(){
        Societes societes = new Societes();
        societes.setId(1);
        societes.setNom("Younup");
        return societes;
    }

    private List<Produits> retourneListesProduitsMock(){
        List<Produits> listProduits = new ArrayList<>();
        Produits produit1 = new Produits();
        produit1.setId(1);
        listProduits.add(produit1);
        Produits produit2 = new Produits();
        produit2.setId(2);
        listProduits.add(produit2);
        Produits produit3 = new Produits();
        produit3.setId(3);
        listProduits.add(produit3);
        return  listProduits;
    }
}
