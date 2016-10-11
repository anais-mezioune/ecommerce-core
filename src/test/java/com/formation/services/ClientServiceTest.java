package com.formation.services;

import com.formation.exceptions.MetierException;
import com.formation.models.Client;
import org.junit.*;


import java.util.List;
import static org.junit.Assert.*;


public class ClientServiceTest {

  @BeforeClass
  public static void avantLaClasse() {
    System.out.println("avant la classe"+System.currentTimeMillis());
    System.out.flush();
  }

  @AfterClass
  public static void apresLaClasse(){
    System.out.println("apres la classe"+System.currentTimeMillis());
    System.out.flush();
  }
  
  @Before
  public void avantToutTest(){
    System.out.println("avant tout test"+System.currentTimeMillis());
    System.out.flush();
  }

  @After
  public void apresToutTest(){
    System.out.println("apres tout test"+System.currentTimeMillis());
    System.out.flush();
  }
  
  @Test
  public void testCreerClientOk(){
	  // Given
	  String nom = "UnNom";
	  String prenom = "UnPrenom";
	  String email = "unprenom.unnom@gmail.com";
	  
	  // When
	  try {
		  Client client = ClientService.creerClient(email, nom, prenom);
		  // Then
		  assertEquals(nom, client.nom);
		  assertEquals(prenom, client.prenom);
		  assertEquals(email, client.email);
	  } catch (MetierException e) {
		  // System.out.println(e.getMessage());
		  assertEquals("", e.getMessage());
	  }
  }
  
  /* ****************************** Nom ****************************** */
  @Test
  public void testCreerClientNomNull(){
	  // When
	  try {
      ClientService.creerClient("unprenom.unnom@gmail.com",null,"UnPrenom");
      // Then
      assertTrue(false);
    } catch (MetierException e) {
      assertEquals("Le nom ne peut être vide",e.getMessage());
    }
  }
  
  @Test
  public void testCreerClientNomRempliEspace(){
	  	// Given
    	String email = "unprenom.unnom@gmail.com";
    	String nom = "   UnNom   ";
    	String prenom = "UnPrenom";
    	String nom_valide = nom.trim();
    	
    	//When
    	try {
    		Client client = ClientService.creerClient(email, nom, prenom);
    		// Then
    		assertEquals(email, client.email);
    		assertEquals(nom_valide, client.nom);
    		assertEquals(prenom, client.prenom);
    	} catch (MetierException e) {
    		assertFalse(true);
    	}
  }
  
  @Test
  public void testCreerClientNomVide(){
    // When
	 try {
      ClientService.creerClient("unprenom.unnom@gmail.com","","UnPrenom");
      // Then
      assertTrue(false);
     } catch (MetierException e) {
      assertEquals("Le nom ne peut être vide",e.getMessage());
    }
  }
  
  /* ****************************** Prénom ****************************** */
  @Test
  public void testCreerClientPrenomNull(){
    // When
	 try {
      ClientService.creerClient("unprenom.unnom@gmail.com","UnNom",null);
      // Then
      assertTrue(false);
    } catch (MetierException e) {
      assertEquals("Le prénom ne peut être vide",e.getMessage());
    }
  }
  
  @Test
  public void testCreerClientPrenomRempliEspace(){
	  // Given
	  String email = "unprenom.unnom@gmail.com";
	  String nom = "UnNom";
	  String prenom = "     UnPrenom      ";
	  String prenom_valide = prenom.trim();
	  
	  // When
	  try{
		Client client = ClientService.creerClient(email, nom, prenom); 
		// Then
		assertEquals(email, client.email);
		assertEquals(nom, client.nom);
		assertEquals(prenom_valide, client.prenom);
	  } catch(MetierException e){
		  assertTrue(false);
	  }
  }
  
  @Test
  public void testCreerClientPrenomVide(){
    // When
	 try {
      Client client = ClientService.creerClient("unprenom.unnom@gmail.com","UnNom","");
      // Then
      assertTrue(false);
    } catch (MetierException e) {
      assertEquals("Le prénom ne peut être vide",e.getMessage());
    }
  }
  
/* ****************************** Mail ****************************** */
  @Test
  public void testCreerClientMailNull(){
	  // Given
	  String email = null;
	  String nom = "UnNom";
	  String prenom = "UnPrenom";
	  
	  //When
	  try{
		  ClientService.creerClient(email, nom, prenom);
		  // Then
		  assertTrue(false);
	  } catch(MetierException e){
		  assertEquals("Le mail ne peut être vide", e.getMessage());
	  }
  }
  
  @Test
  public void testCreerClientMailVide(){
    // When
	try {
      Client client = ClientService.creerClient("","landrein","pierjean");
      // Then
      assertTrue(false);
    } catch (MetierException e) {
      assertEquals("L'email ne peut être vide",e.getMessage());
    }
  }

  @Test
  public void testCreerClientMailInvalid(){
    // When
	try {
      Client client = ClientService.creerClient("hgdljgfod","landrein","pierjean");
      // Then
      assertTrue(false);
    } catch (MetierException e) {
      assertEquals("L'email n'est pas valide",e.getMessage());
    }
  }

}
