package prw.stwr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "prw.stwr")
@EntityScan(basePackages = "prw.stwr")
public class PrwstwrApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrwstwrApplication.class, args);
	}

}
