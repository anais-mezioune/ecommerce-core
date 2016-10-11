package test.java.com.formation.services;

import com.formation.services.DBService;

public class Test {
	
	@Before
	public void avantToutTest() throws MetierException {
		System.out.println("avantToutTest");
		DBService.configure("192.168.1.13");
	}
	
	@After
	public void apresToutTest(){
		System.out.println("avantToutTest");
		//DBService.reset();
	}
	
	public void creerClientTest(){
		
	}
}
