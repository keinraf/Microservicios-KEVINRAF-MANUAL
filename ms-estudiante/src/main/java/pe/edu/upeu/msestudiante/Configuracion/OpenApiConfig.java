package pe.edu.upeu.msestudiante.Configuracion;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // Anotación que indica que esta clase es una clase de configuración de Spring.
public class OpenApiConfig {

    @Bean  // Anotación que marca este método como un "Bean" que será gestionado por el contenedor de Spring.
    public OpenAPI customOpenAPI() {
        return new OpenAPI()  // Se crea una nueva instancia de OpenAPI que describe la API del microservicio.
                .info(new Info()  // Se proporciona información general sobre la API.
                        .title("OPEN API MICROSERVICIO DE ESTUDIANTE")  // Título de la API.
                        .version("0.0.1")  // Versión de la API.
                        .description("Servicios web Estudiantes")  // Descripción de lo que hace la API.
                        .termsOfService("http://swagger.io/terms")  // Enlace a los términos de servicio.
                        .license(new License()  // Información de la licencia de la API.
                                .name("Apache 2.0")  // Nombre de la licencia.
                                .url("http://springdoc.org"))  // URL de la licencia.
                );
    }
}
