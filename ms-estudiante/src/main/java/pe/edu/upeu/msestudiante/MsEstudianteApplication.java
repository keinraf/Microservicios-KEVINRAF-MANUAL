package pe.edu.upeu.msestudiante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsEstudianteApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsEstudianteApplication.class, args);
    }

}
