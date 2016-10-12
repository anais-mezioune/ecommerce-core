package com.formation.services;

import com.formation.exceptions.MetierException;
import com.formation.services.DBService;
import com.mysql.jdbc.Connection;

import java.util.List;
import static org.junit.Assert.*;

public class DBServiceTest {

		public void testConfigureWithIpNull(){
			// When
			try {
				DBService.configure(null, "NomBd");
				// Then
				assertTrue(false);
			} catch (MetierException e) {
				assertEquals("L'adresse IP ne peut être nulle", e.getMessage());
			}
		}
		
		public void testConfigureWithDbNull(){
			// When
			try {
				DBService.configure("UneAdresseIp", null);
				// Then
				assertTrue(false);
			} catch (MetierException e) {
				assertEquals("Le dbName ne peut être nul ou vide", e.getMessage());
			}
		}
		
}
