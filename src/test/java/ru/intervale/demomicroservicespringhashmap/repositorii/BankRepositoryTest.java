package ru.intervale.demomicroservicespringhashmap.repositorii;

import org.junit.jupiter.api.Test;
import ru.intervale.demomicroservicespringhashmap.service.BankService;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BankRepositoryTest {

    private BankRepository bankRepository = new BankRepository();

    @Test
    void delete() {
        final BigDecimal delete = bankRepository.delete(1L);
        assertEquals(delete,BigDecimal.valueOf(10));
    }
}