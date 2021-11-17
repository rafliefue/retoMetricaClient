package com.everis.bootcamp.patronesClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.micrometer.core.instrument.MeterRegistry;

@SpringBootApplication
public class ClientApplication implements CommandLineRunner {

	@Autowired
	EndpointEstados a;
	
	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}
	
	public void run(String... args) throws Exception{
		
		/**Aqui lo que hago es el circuit breaker y las escrituras de los
		estados por los que pasa en el end point**/
		
		StatusService status = new StatusService();
		
		for(int i=0; i <= 5; i++) {
			a.writeOperation("half-open");
			status.halfOpen();
			Thread.sleep(3000);
			if(i >= 3) {
				a.writeOperation("close");
				status.close();
				Thread.sleep(3000);
			} else {
				a.writeOperation("open");
				status.close();
				Thread.sleep(3000);
			}
		}
		
		
		
		
		
	}
}
	


