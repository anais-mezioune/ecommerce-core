package com.formation.services;

import com.formation.exceptions.MetierException;
import com.formation.models.Client;
import org.junit.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.*;


public class ClientServiceTest {

    @Before
    public void avantToutTest() throws MetierException {
        System.out.println("avantToutTest");
        DBService.configure("192.168.1.39", "ecommerce-test");

        try {
            Statement statement = DBService.getInstance().createStatement();
            statement.executeUpdate("DELETE FROM Client");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @After
    public void apresToutTest() {
        System.out.println("apresToutTest");
        DBService.reset();
    }

    @Test
    public void testCreerClientNomVide() {
        // Given
        String nom = "";
        String prenom = "aa";
        String email = "aa@aaaa.fr";

        //When
        try {
            Client client = ClientService.creerClient(email, nom, prenom);
            assertTrue(false);
        } catch (MetierException e) {
            //Then
            assertEquals("Le nom ne peut être vide", e.getMessage());
        }
    }

    @Test
    public void testCreerClientNomPleinVide() {
        // Given
        String nom = "    jjbnj    ";
        String prenom = "aa";
        String email = "aa@aaaa.fr";
        String nom_valide = nom.trim();

        //When
        try {
            //Then
            Client client = ClientService.creerClient(email, nom, prenom);
            assertEquals(nom_valide, client.nom);
            assertEquals(prenom, client.prenom);
            assertEquals(email, client.email);

        } catch (MetierException e) {
            assertTrue(false);
        }
    }

    @Test
    public void testCreerClientPrenomPleinVide() {
        // Given
        String nom = "jjbnj";
        String prenom = "         aa     ";
        String email = "aa@aaaa.fr";
        String prenom_valide = prenom.trim();

        //When
        try {
            //Then
            Client client = ClientService.creerClient(email, nom, prenom);
            assertEquals(nom, client.nom);
            assertEquals(prenom_valide, client.prenom);
            assertEquals(email, client.email);

        } catch (MetierException e) {
            assertTrue(false);
        }
    }

    @Test
    public void testCreerClientPrenomVide() {
        // Given
        String nom = "aaa";
        String prenom = "";
        String email = "aa@aaaa.fr";

        //When
        try {
            Client client = ClientService.creerClient(email, nom, prenom);
            assertTrue(false);
        } catch (MetierException e) {
            //Then
            assertEquals("Le prenom ne peut être vide", e.getMessage());
        }
    }

    @Test
    public void testCreerClientEmailVide() {
        // Given
        String nom = "aaa";
        String prenom = "aa";
        String email = "";

        //When
        try {
            Client client = ClientService.creerClient(email, nom, prenom);
            assertTrue(false);
        } catch (MetierException e) {
            //Then
            assertEquals("L'email ne peut être vide", e.getMessage());
        }
    }

    @Test
    public void testCreerClientEmailInvalide() {
        // Given
        String nom = "aaa";
        String prenom = "aa";
        String email = "aaaa.fr";

        //When
        try {
            Client client = ClientService.creerClient(email, nom, prenom);
            assertTrue(false);
        } catch (MetierException e) {
            //Then
            assertEquals("L'email n'est pas valide", e.getMessage());
        }
    }

    @Test
    public void testCreerClientOk() {
        // Given
        String nom = "aaa";
        String prenom = "aa";
        String email = "aa@aaaa.fr";

        //When
        try {
            Client client = ClientService.creerClient(email, nom, prenom);
            //Then
            assertEquals(nom, client.nom);
            assertEquals(prenom, client.prenom);
            assertEquals(email, client.email);
        } catch (MetierException e) {
            assertTrue(false);
        }
    }

    @Test
    public void testEnregistrerClientNull(){
        // Given
        Client client = null;

        // When
        try {
            ClientService.enregistrer(client);
            assertTrue(false);
        } catch (MetierException e) {
            // Then
            assertEquals("Le client ne peut être null", e.getMessage());
        }

    }

    @Test
    public void testEnregistrerClientOk(){
        // Given
        Client client = null;
        try {
            client = ClientService.creerClient("a@gmail.com", "a", "bb");
        } catch (MetierException e) {
            e.printStackTrace();
        }

        // When
        try {
            ClientService.enregistrer(client);

            // Then
            String requete = "SELECT count(id) as nbClient FROM Client";
            try {
                ResultSet result = DBService.getInstance().executeSelect(requete);
                result.next();
                assertEquals(1, result.getInt("nbClient"));
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (MetierException e) {
            assertTrue(false);
        }
    }
}