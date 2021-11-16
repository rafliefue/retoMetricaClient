package com.everis.bootcamp.patronesClient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}
	
	public void run(String... args) throws Exception{
		
		StatusService status = new StatusService();
		Coche coche = new Coche.CocheBuilder("open").build();
	
		for(int i=0; i <= 5 && coche.getStatus().equals("open"); i++) {
			
			coche.setStatus("half-open");
			status.halfOpen();
			Thread.sleep(3000);
			if(i >= 3) {
				coche.setStatus("close");
				status.close();
				Thread.sleep(3000);
			} else {
				coche.setStatus("open");
				status.close();
				Thread.sleep(3000);
			}
		}
		
		
		
		
		
	}
}
	


