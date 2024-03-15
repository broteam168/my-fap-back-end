package broteam.myfap.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class BackEndApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BackEndApplication.class, args);

    }

}
