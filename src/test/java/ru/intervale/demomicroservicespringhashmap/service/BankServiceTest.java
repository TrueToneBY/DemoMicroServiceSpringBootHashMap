package ru.intervale.demomicroservicespringhashmap.service;

import org.junit.jupiter.api.Test;
import ru.intervale.demomicroservicespringhashmap.repositorii.BankRepository;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BankServiceTest {

    //нужно  для вызовов бинов
    private BankRepository bankRepository = new BankRepository();
    private BankService bankService = new BankService(bankRepository);

    @Test
    void addMoney() {
        final BigDecimal bigDecimal = bankService.getBalance(1L);
        assertEquals(bigDecimal,BigDecimal.TEN);
    }

    @Test
    void getMoney(){
        final BigDecimal balance = bankService.addMoney(1L,BigDecimal.ONE);
        assertEquals(balance,BigDecimal.valueOf(11));
    }


}