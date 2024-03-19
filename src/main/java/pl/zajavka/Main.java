package pl.zajavka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.zajavka.miniProject.BankAccount;
import pl.zajavka.miniProject.BankException;
import pl.zajavka.miniProject.BankService;

import java.math.BigDecimal;
import java.util.Optional;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws BankException {

        BankService.createNewAccount(1L, "Karol Janowski", BigDecimal.valueOf(1000));
        BankService.createNewAccount(2L, "Marcel Kawalec", BigDecimal.valueOf(5000));
        BankService.createNewAccount(3L, "Milosz Grabowski", BigDecimal.valueOf(2500));
        BankService.createNewAccount(4L, "Janusz Transportu", BigDecimal.valueOf(500));

//        BankService.depositMoney(4L, BigDecimal.valueOf(1000));
//        BankService.withdrawMoney(1L, BigDecimal.valueOf(500));

        BankService.transferMoney(1L, 4L, BigDecimal.valueOf(500));

       for (BankAccount bankAccount : BankService.getBankAccountsList()) {
           System.out.println(bankAccount);
       }
    }
}