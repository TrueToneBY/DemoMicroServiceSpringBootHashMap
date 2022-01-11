package ru.intervale.demomicroservicespringhashmap.model;

import lombok.Data;

import java.math.BigDecimal;
//Генерирует геттеры для всех полей, полезный метод toString и реализации hashCode и equals,
// которые проверяют все непереходные поля. Также будут генерироваться сеттеры для всех неконечных полей, а также конструктор.
//Эквивалент @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode.
@Data
public class TransferBalance {
    private Long from;
    private Long to;
    private BigDecimal amount;
}
