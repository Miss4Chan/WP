package mk.ukim.finki.wpaud2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class WpAud2Application {

    public static void main(String[] args) {
        SpringApplication.run(WpAud2Application.class, args);
    }

}
