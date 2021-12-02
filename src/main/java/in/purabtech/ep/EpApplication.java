package in.purabtech.ep;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class EpApplication {

	public static void main(String[] args) {
		log.info("starting app...");
		SpringApplication.run(EpApplication.class, args);
	}

}
