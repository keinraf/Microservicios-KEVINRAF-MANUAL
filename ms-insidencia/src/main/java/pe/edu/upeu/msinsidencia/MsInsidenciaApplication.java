package pe.edu.upeu.msinsidencia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsInsidenciaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsInsidenciaApplication.class, args);
    }

}
