package com.vm.service.claims.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vm.service.claims.entitys.Claims;
import com.vm.service.claims.repo.ClaimsRepository;

@Configuration
public class DataLoader {
	
	 @Bean
	 CommandLineRunner initDatabase(ClaimsRepository claimsRepo) {
	        return args -> {

	            Claims c1 = new Claims();
	            c1.setClaimType("Motor");
	            c1.setClaimStatus("OPEN");
	            c1.setDescription("Motor accident claim");

	            Claims c2 = new Claims();
	            c2.setClaimType("Health");
	            c2.setClaimStatus("APPROVED");
	            c2.setDescription("Health insurance claim approved");

	            Claims c3 = new Claims();
	            c3.setClaimType("Property");
	            c3.setClaimStatus("IN_REVIEW");
	            c3.setDescription("Property fire damage claim");

	            Claims c4 = new Claims();
	            c4.setClaimType("Travel");
	            c4.setClaimStatus("REJECTED");
	            c4.setDescription("Travel insurance rejected due to documentation");

	            Claims c5 = new Claims();
	            c5.setClaimType("Life");
	            c5.setClaimStatus("PENDING");
	            c5.setDescription("Life insurance pending for verification");

	            claimsRepo.save(c1);
	            claimsRepo.save(c2);
	            claimsRepo.save(c3);
	            claimsRepo.save(c4);
	            claimsRepo.save(c5);

	            System.out.println("Inserted 5 sample Claims at startup.");
	        };
	    }

}
