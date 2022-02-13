package com.zoomcarseller.ZoomCarSeller;

import com.zoomcarseller.ZoomCarSeller.Repository.AuthRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = AuthRepository.class)
public class ZoomCarSellerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZoomCarSellerApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return  new RestTemplate();
	}

}
