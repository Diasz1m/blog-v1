package dias.matheus.backendv1.blog;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    // @Override
     public void addCorsMappings(CorsRegistry registry) {
         registry.addMapping("/**")
             .allowedOrigins("https://blog-devs.netlify.app/")
             .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
     }

}
