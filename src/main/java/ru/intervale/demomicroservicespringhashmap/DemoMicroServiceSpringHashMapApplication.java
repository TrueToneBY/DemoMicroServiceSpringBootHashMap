package ru.intervale.demomicroservicespringhashmap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//класс для запуска java приложения,точка входа
//аннотация берет текущею директорию и сканирует её в глубь
@SpringBootApplication
public class DemoMicroServiceSpringHashMapApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoMicroServiceSpringHashMapApplication.class, args);
    }

}
