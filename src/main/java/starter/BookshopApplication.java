package starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("models")
public class BookshopApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookshopApplication.class);
    }
}
