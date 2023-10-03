package dias.matheus.backendv1.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "http://localhost:4200")
public class BackendBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendBlogApplication.class, args);
	}

}
