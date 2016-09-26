package io.vertx.example;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.vertx.core.Vertx;

@SpringBootApplication
public class Application {

    @Autowired
    private StaticServer staticServer;

    public static void main(String[] args) {

        // This is basically the same example as the web-examples static site example but it's booted using
        // SpringBoot, not Vert.x
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void deployVerticle() {
        Vertx.vertx().deployVerticle(staticServer);
    }
}
