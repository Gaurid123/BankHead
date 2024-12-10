package com.ebs.bankhead.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@EnableDiscoveryClient
public class BankHeadApplication 
{

	public static void main(String[] args) {
		SpringApplication.run(BankHeadApplication.class, args);
	}
   @Bean 
   public ObjectMapper objmapper()
   {
	   return new ObjectMapper();
   }
}
