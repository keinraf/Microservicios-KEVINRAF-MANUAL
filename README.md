LISTO no ejecute GIT config-data

LISTO Paso 1: ms-config-server

LISTO Paso 2: ms-gateway-service

LISTO Paso 3: ms-registry-server

LISTO Paso 4: ms_catalogos_productos(todoTipoDeMicroservices)

=================================================

1. JDK (Java Development Kit)
Requisito: Java 17 o 21

¿Por qué?: La aplicación está desarrollada usando Spring Boot, que requiere Java para funcionar.

Descargar: JDK de Oracle o OpenJDK.

Verificación: Abre una terminal o CMD y ejecuta el comando java -version para verificar que Java está instalado correctamente.

2. Maven o Gradle
Requisito: Herramienta de construcción (Build tool) para gestionar dependencias y empaquetar la aplicación.

¿Por qué?: Spring Boot usa Maven (o Gradle) para compilar y construir el proyecto.

Descargar:

Para Maven: Maven Downloads

Para Gradle: Gradle Downloads

Verificación: Ejecuta mvn -version o gradle -v en la terminal para verificar que Maven o Gradle esté instalado correctamente.

3. Spring Boot
Requisito: Framework que estás utilizando para crear los microservicios.

¿Por qué?: Spring Boot hace que el desarrollo de aplicaciones Java sea más sencillo, proporcionando una estructura predefinida y configuraciones automáticas.

Instalación: No requiere instalación adicional si usas Maven o Gradle para compilar el proyecto. Solo tienes que importar las dependencias correspondientes en el archivo pom.xml (si usas Maven) o build.gradle (si usas Gradle).

4. PostgreSQL / MySQL / H2 (Base de datos)
Requisito: Sistema de gestión de bases de datos (DBMS)

¿Por qué?: Según el proyecto, probablemente uses una base de datos para almacenar la información de los estudiantes y apoderados.

Descargar:

PostgreSQL: PostgreSQL Downloads

MySQL: MySQL Downloads

H2: Si es para un entorno en memoria o pruebas, puedes usar H2 (generalmente no requiere instalación).

Verificación:

Para PostgreSQL o MySQL, asegúrate de que el servicio está corriendo y de que puedes conectarte a la base de datos a través de su cliente o herramientas como pgAdmin o MySQL Workbench.

Para H2, puede ser configurado en el archivo application.properties de Spring Boot.

5. Docker (Opcional, para contenedores)
Requisito: Contenedores Docker para desplegar aplicaciones en contenedores.

¿Por qué?: Si quieres contenerizar tus microservicios y hacer despliegue en un entorno aislado.

Descargar: Docker Desktop

Verificación: Ejecuta docker --version para verificar la instalación.

6. Eclipse / IntelliJ IDEA / VS Code (IDE para desarrollo)
Requisito: Entorno de desarrollo integrado (IDE) para programar.

¿Por qué?: Necesitas un IDE que soporte Java y Spring Boot para facilitar el desarrollo, depuración y ejecución de los microservicios.

Descargar:

Eclipse: Eclipse Downloads

IntelliJ IDEA: IntelliJ IDEA

VS Code: VS Code

Recomendación: IntelliJ IDEA es ampliamente usado para el desarrollo de Spring Boot debido a su integración excelente con frameworks Java.

7. Git
Requisito: Herramienta de control de versiones.

¿Por qué?: Si estás utilizando Git para el control de versiones de tu código, necesitarás tenerlo instalado.

Descargar: Git Downloads

Verificación: Ejecuta git --version para verificar la instalación.

8. Spring Cloud Config Server (Opcional)
Requisito: Si estás utilizando un servidor de configuración externo (como parece indicar tu archivo application.yml con la URL del Config Server).

¿Por qué?: Necesitas configurar un servidor de configuración en el cual almacenar las configuraciones centralizadas para tus microservicios.

Instalación: Spring Cloud Config

Verificación: Debes tener una instancia de Config Server corriendo en localhost:7070, tal como se indica en tu archivo de configuración application.yml.

9. Postman / Insomnia (Para probar las APIs)
Requisito: Herramienta para probar y hacer peticiones HTTP a tus microservicios REST.

¿Por qué?: Te permite realizar pruebas a las APIs que implementes en los microservicios.

Descargar:

Postman: Postman

Insomnia: Insomnia

10. RabbitMQ / Kafka (Opcional, para mensajería entre microservicios)
Requisito: Si usas mensajería asíncrona entre microservicios.

¿Por qué?: RabbitMQ o Kafka son sistemas de mensajería que puedes usar para comunicar tus microservicios de manera eficiente y escalable.

Descargar:

RabbitMQ: RabbitMQ Downloads

Kafka: Kafka Downloads

Verificación: Debes asegurarte de que los servidores de RabbitMQ o Kafka estén corriendo.

Resumen de las herramientas a instalar:
Java JDK 8+

Maven o Gradle

Spring Boot (no requiere instalación adicional si usas Maven o Gradle)

Base de datos (PostgreSQL, MySQL, H2, etc.)

Docker (opcional)

IDE (Eclipse, IntelliJ IDEA o VS Code)

Git (si usas control de versiones)

Spring Cloud Config Server (si usas un servidor de configuración centralizada)

Postman o Insomnia (para probar APIs)

RabbitMQ / Kafka (si implementas mensajería entre microservicios)

Con estas herramientas instaladas, deberías estar listo para desarrollar, ejecutar y probar los microservicios en tu PC.