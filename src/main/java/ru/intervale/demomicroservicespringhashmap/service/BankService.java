package ru.intervale.demomicroservicespringhashmap.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.intervale.demomicroservicespringhashmap.model.TransferBalance;
import ru.intervale.demomicroservicespringhashmap.repositorii.BankRepository;

import java.math.BigDecimal;

@Service//Значение может указывать на предложение имени логического компонента, которое будет преобразовано
// в bean-компонент Spring в случае автоматического обнаружения компонента.Возвращает:
//предлагаемое имя компонента, если есть (или пустая строка в противном случае)
@AllArgsConstructor//Если установлено, сгенерированный конструктор будет закрытым, а дополнительный статический «конструктор» будет сгенерирован с тем же списком аргументов, что и реальный конструктор.
// Такой статический «конструктор» в первую очередь полезен, поскольку он выводит аргументы типа.Возвращает:
//Имя статического метода «конструктора», который необходимо сгенерировать (пусто = сгенерировать обычный конструктор).
public class BankService {
    //бизнес логика

    private final BankRepository repository;

    public BigDecimal getBalance(Long accountId) {
        BigDecimal balance =  repository.getBalanceForId(accountId);
        if (balance == null){
            throw new IllegalArgumentException();
        }
        return balance;
    }

    public BigDecimal addMoney(Long to, BigDecimal amount) {
            BigDecimal currntBalance =  repository.getBalanceForId(to);
            if (currntBalance == null){
                repository.save(to,amount);
                return amount;
            }else {
                BigDecimal updatedBalanca = currntBalance.add(amount);
                repository.save(to,updatedBalanca);
                return updatedBalanca;
            }


        }

    public void makeTransfer(TransferBalance transferBalance) {
        BigDecimal fromBalance = repository.getBalanceForId(transferBalance.getFrom());
        BigDecimal toBalance = repository.getBalanceForId(transferBalance.getTo());
        if (fromBalance == null || toBalance == null) throw new IllegalArgumentException(" no ids");
        if (transferBalance.getAmount().compareTo(fromBalance) > 0) throw new IllegalArgumentException("no money");

        BigDecimal updatedfromBalance = fromBalance.subtract(transferBalance.getAmount());
        BigDecimal updatedToBalance = fromBalance.add(transferBalance.getAmount());
        repository.save(transferBalance.getFrom(),updatedfromBalance);
        repository.save(transferBalance.getTo(), updatedToBalance);
        }



}
