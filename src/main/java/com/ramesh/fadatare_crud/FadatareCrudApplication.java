package com.ramesh.fadatare_crud;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Documentation about my Spring Boot app", description = "This is documentation", version = "1.0.0", contact = @Contact(name = "Sasha Polozov", email = "polspa88@yandex.com"
        , url = "polozov.com"), license = @License(name = "Apache 2.0")),
        externalDocs = @ExternalDocumentation(
                description = "External documentation about this app", url = "polozov/docs.com"))
public class FadatareCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(FadatareCrudApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
