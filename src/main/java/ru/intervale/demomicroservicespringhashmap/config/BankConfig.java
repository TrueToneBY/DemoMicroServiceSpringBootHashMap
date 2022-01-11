package ru.intervale.demomicroservicespringhashmap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//указывает, что класс объявляет один или несколько методов @Bean
// и может обрабатываться контейнером Spring для генерации определений
// компонентов и запросов на обслуживание для этих компонентов во время выполнения
@Configuration
public class BankConfig {

    //Методы компонентов в облегченном режиме будут рассматриваться контейнером как простые фабричные методы
    // (аналогично объявлениям фабричных методов в XML) с надлежащим применением обратных вызовов области действия и жизненного цикла.
    // В этом случае содержащий класс остается неизменным, и нет никаких необычных ограничений для содержащего класса или фабричных методов.

//    @Bean
//    public BankConrtroller bankConrtroller(){
//        return new BankConrtroller();
//    }
}
