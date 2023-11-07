package com.example.demotest.dto;

import com.example.demotest.entity.Produits;
import com.example.demotest.entity.Societes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SocieteAvecProduitDTO {
    private Societes societes;
    private List<Produits> produits;
}
