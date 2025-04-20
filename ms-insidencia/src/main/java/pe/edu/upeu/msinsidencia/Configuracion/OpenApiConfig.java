package pe.edu.upeu.msinsidencia.Configuracion;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Indica que esta clase es de configuración de Spring
public class OpenApiConfig {

    // Bean para configurar Swagger/OpenAPI con la documentación personalizada del microservicio
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("OPEN API MICROSERVICIO DE INSIDENCIA") // Título de la documentación en Swagger UI
                .version("0.0.1") // Versión del servicio
                .description("Servicios web Insidencias") // Descripción general
                .termsOfService("http://swagger.io/terms") // Términos de servicio
                .license(new License().name("Apache 2.0").url("http://springdoc.org")) // Información de licencia
        );
    }

    /*
     * Ejemplo de JSON para hacer pruebas en Swagger (POST o PUT /insidencias)
     * Este cuerpo se utiliza para crear o actualizar una incidencia.
     * Puedes pegarlo directamente en Swagger UI al probar los endpoints.
     *
     * {
     *   "descripcion": "Este es un problema de prueba.",
     *   "estudianteId": 1
     * }
     */
}
