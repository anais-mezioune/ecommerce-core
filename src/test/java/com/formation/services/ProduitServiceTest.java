package com.formation.services;

import org.junit.rules.ExpectedException;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;

import com.formation.exceptions.MetierException;
import com.formation.models.Produit;

import java.sql.SQLException;



public class ProduitServiceTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testCreerProduitProduitNul(){
		// Given
		String nom = "UnNom";
		Float prixUnitaire = 2.25f;
		
		// When
		try{
			Produit produit = ProduitService.creerProduit(nom, prixUnitaire);
			// Then
			assertNotNull("Le produit ne doit pas être nul", produit);
			assertEquals(nom, produit.nom);
			assertEquals(prixUnitaire, produit.prixUnitaire);
			assertNotNull("L'id ne peut être nul", produit.id);
			assertNotEquals("", produit.id);
		} catch (MetierException e){
			fail("Le produit n'a pas été créé correctement");
		}
	}
	
	@Test
	public void testCreerProduitPrixNegatif(){
		
	}
}
