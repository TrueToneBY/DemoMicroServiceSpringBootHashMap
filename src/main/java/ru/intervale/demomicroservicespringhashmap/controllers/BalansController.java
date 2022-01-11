package ru.intervale.demomicroservicespringhashmap.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;
import ru.intervale.demomicroservicespringhashmap.model.TransferBalance;
import ru.intervale.demomicroservicespringhashmap.repositorii.BankRepository;
import ru.intervale.demomicroservicespringhashmap.service.BankService;

import java.math.BigDecimal;

@Slf4j//логирование для @ExceptionHandler
@RestController//Удобная аннотация, которая сама снабжена аннотациями @Controller и @ResponseBody.
//Типы, несущие эту аннотацию, обрабатываются как контроллеры, где методы @RequestMapping предполагают семантику @ResponseBody по умолчанию.
@AllArgsConstructor//делает конструктор банк сервиса для бинов

public class BalansController {

    private final BankService bankService;
    private final BankRepository bankRepository;

//    public BalansController(BankRepository bankRepository) {
//        this.bankRepository = bankRepository;
//    }

//    public BalansController(BankService bankService) {
//        this.bankService = bankService;
//    }

    @GetMapping("/{accountId}")
    public BigDecimal getBigDecimal(@PathVariable Long accountId)  {
        return bankService.getBalance(accountId);


        //преобразование из модели в джейсон
//       TransferBalance transferBalance =  new ObjectMapper().readValue("{\n" +
//                "\"from\":2,\n" +
//                "\"to\":3,\n" +
//                "\"amount\":300\n" +
//                "}",TransferBalance.class);
    }


    @PostMapping("/add")
    public BigDecimal addMoney(@RequestBody TransferBalance transferBalance){
        return bankService.addMoney(transferBalance.getTo(),transferBalance.getAmount());

    }


    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferBalance transferBalance){

        bankService.makeTransfer(transferBalance);
    }

    @DeleteMapping("/{id}")
    public BigDecimal delete(@PathVariable("id")Long id){
        bankRepository.delete(id);
        return bankRepository.getBalanceForId(id);
        //return new ResponseEntity<>("Delete ",HttpStatus.OK);
    }

    //занимается обработкой исключений на уровне контроллера.
    //Достаточно объявить метод,в котором будет содержаться
    //вся логика обработки нужношо исключения status 404 (замена на собщение)
    @ExceptionHandler(IllegalArgumentException.class)
    public String handle(IllegalArgumentException e){
        log.error(e.getMessage());
        return "Mama ya slomalsay";
    }
}
