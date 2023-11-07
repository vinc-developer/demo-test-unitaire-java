package com.example.demotest.Service;

import com.example.demotest.dto.SocieteAvecProduitDTO;
import com.example.demotest.entity.Produits;
import com.example.demotest.entity.Societes;
import com.example.demotest.repository.SocieteRepo;
import com.example.demotest.services.ProduitsService;
import com.example.demotest.services.SocietesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SocieteServiceTest {

    private SocietesService societesService;

    @Mock
    private SocieteRepo societeRepo;

    @Mock
    private ProduitsService produitsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialise les mocks
        societesService = new SocietesService(societeRepo, produitsService);
    }

    @Test
    void getSocietesAvecProduitOK(){
        //Arrange
        int idSociete = 1;
        Societes societes = retourneDonneeSocieteMock();
        List<Produits> listProduits = retourneListesProduitsMock();

        //Mock
        when(societeRepo.getSocieteById(idSociete)).thenReturn(societes);
        when(produitsService.getAllProduits(idSociete)).thenReturn(listProduits);

        //Act
        SocieteAvecProduitDTO societeAvecProduit = societesService.getSocietesAvecProduit(idSociete);

        //Verify
        assertEquals(3, societeAvecProduit.getProduits().size());
        assertEquals("Younup", societeAvecProduit.getSocietes().getNom());
        System.out.println("test ok :-)");
    }

    @Test
    void getSocietesAvecProduitSocietesNull() {
        //Arrange
        int idSociete = 2;

        //Mock
        when(societeRepo.getSocieteById(idSociete)).thenReturn(null);

        //Act & Verify
        assertThrows(NullPointerException.class,
                () -> societesService.getSocietesAvecProduit(idSociete)
        );
    }


    /* METHODE JEUX DE DONNEES */

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
