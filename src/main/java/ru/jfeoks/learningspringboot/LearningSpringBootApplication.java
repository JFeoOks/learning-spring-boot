package ru.jfeoks.learningspringboot;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;

@SpringBootApplication
public class LearningSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearningSpringBootApplication.class, args);
    }

    //https://stackoverflow.com/questions/43256295/how-to-access-in-memory-h2-database-of-one-spring-boot-application-from-another
    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server h2Server() throws SQLException {
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
    }
}
