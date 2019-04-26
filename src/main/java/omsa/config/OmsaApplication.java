package omsa.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"omsa.domain","endpoints","repositoryImpl","repositoryAdapter","serviceAdapters","serviceImpl"})
public class OmsaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmsaApplication.class, args);
	}

}
