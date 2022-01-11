package ru.intervale.demomicroservicespringhashmap.repositorii;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
//Указывает, что аннотированный класс представляет собой «Репозиторий», первоначально определенный в Domain-Driven Design (Evans, 2003) как «механизм для инкапсуляции поведения хранения
// , извлечения и поиска, который эмулирует набор объектов».Команды, реализующие традиционные шаблоны Java EE, такие как «Объект доступа к данным», также могут применять этот стереотип к классам DAO,
// хотя перед этим следует позаботиться о понимании различий между объектами доступа к данным и репозиториями в стиле DDD. Эта аннотация является стереотипом общего назначения,
// и отдельные группы могут сузить свою семантику и использовать ее по мере необходимости.
@Repository
public class BankRepository {
    private final Map<Long, BigDecimal> storage = new HashMap<>(Map.of(1L,BigDecimal.TEN));

    public BigDecimal getBalanceForId(Long accountId) {
        return storage.get(accountId);
    }

    public void save(Long id, BigDecimal amount) {
        storage.put(id, amount);

    }
    public BigDecimal delete(Long accountId){
        return storage.remove(accountId);
    }


}
