package pe.edu.upeu.msestudiante;  // Paquete donde se encuentra la clase principal de la aplicación

import org.springframework.boot.SpringApplication;  // Importación de la clase SpringApplication para iniciar la aplicación
import org.springframework.boot.autoconfigure.SpringBootApplication;  // Anotación que habilita la configuración automática de Spring Boot
import org.springframework.cloud.openfeign.EnableFeignClients;  // Habilita los clientes Feign para hacer llamadas HTTP a otros servicios

// Anotación que marca esta clase como la clase principal de la aplicación
@SpringBootApplication
// Habilita el uso de clientes Feign para la comunicación con otros microservicios
@EnableFeignClients
public class MsEstudianteApplication {

    // Método principal que ejecuta la aplicación Spring Boot
    public static void main(String[] args) {
        // Inicia la aplicación Spring Boot
        SpringApplication.run(MsEstudianteApplication.class, args);
    }
}
