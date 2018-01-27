package ru.asemenov.boom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;

/**
 * @author a.semenov
 */
@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "ru.asemenov.boom")
@EnableMBeanExport(defaultDomain = "boom")
public class BoomApplication {
    public static void main(String[] args) {
        SpringApplication.run(BoomApplication.class, args);
    }
}
