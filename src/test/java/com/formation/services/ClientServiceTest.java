package com.formation.services;

import com.formation.exceptions.MetierException;
import com.formation.models.Client;
import org.junit.*;

import static org.junit.Assert.*;


public class ClientServiceTest {

    @Before
    public void avantToutTest() throws MetierException {
        System.out.println("avantToutTest");
        DBService.configure("192.168.1.39", "ecommerce-test");
    }

    @After
    public void apresToutTest() {
        System.out.println("apresToutTest");
        DBService.reset();
    }

    @Test
    public void testCreerClientOk() {
        // Given
        String nom = "aaa";
        String prenom = "aa";
        String email = "aa@aaaa.fr";


        //When
        try {
            Client client = ClientService.creerClient(email,nom,prenom);
            //Then
            assertEquals(nom, client.nom);
            assertEquals(prenom, client.prenom);
            assertEquals(email, client.email);
        } catch (MetierException e) {
            assertTrue(false);
        }
    }
}