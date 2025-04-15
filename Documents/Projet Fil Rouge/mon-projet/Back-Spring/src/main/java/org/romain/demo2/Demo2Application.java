package org.romain.demo2;

// Importation des annotations et classes nécessaires

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.TimeZone;

// Annotation principale indiquant que cette classe est une application Spring Boot.
// Elle combine plusieurs annotations : @Configuration, @EnableAutoConfiguration et @ComponentScan.
@SpringBootApplication
public class Demo2Application {

    // Méthode principale (point d'entrée de l'application Java).
    public static void main(String[] args) {
        // Démarre l'application Spring Boot en utilisant la classe Demo2Application comme configuration principale.
        SpringApplication.run(Demo2Application.class, args);
    }

    // Méthode annotée avec @PostConstruct, qui sera exécutée automatiquement après que le bean a été initialisé.
    @PostConstruct
    public void init() {
        // Définit le fuseau horaire par défaut de l'application sur UTC (Temps Universel Coordonné).
        // Cela garantit que toutes les opérations liées à la date/heure dans l'application utilisent ce fuseau horaire.
        TimeZone.setDefault(TimeZone.getTimeZone("UTC")); // Indique le fuseau horaire UTC = +0 Londres.
    }

    @Bean // créé la dépendence
    public PasswordEncoder passwordEncoder() { // appelle l'interface "PasswordEncoder"
        return new BCryptPasswordEncoder();
    }
}
