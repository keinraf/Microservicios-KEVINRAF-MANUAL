package com.kps.kpsconfigservicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class KpsConfigServicioApplication {

    public static void main(String[] args) {
        SpringApplication.run(KpsConfigServicioApplication.class, args);
    }

}
