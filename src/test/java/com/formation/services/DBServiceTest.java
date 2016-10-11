package com.formation.services;

import com.formation.exceptions.MetierException;
import com.formation.services.DBService;

import java.util.List;
import static org.junit.Assert.*;

public class DBServiceTest {

		public void testConfigureWithIpNull(){
			// When
			try {
				DBService.configure(null);
				// Then
				assertTrue(false);
			} catch (MetierException e) {
				assertEquals("L'adresse IP ne peut être nulle", e.getMessage());
			}
		}
}
