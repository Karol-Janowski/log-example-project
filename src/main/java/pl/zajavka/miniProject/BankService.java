package pl.zajavka.miniProject;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public class BankService {

    @Getter
    private static List<BankAccount> bankAccountsList = new ArrayList<>();

    public static void createNewAccount(Long ID, String owner, BigDecimal balance) {
        try {
            BankAccount bankAccount = new BankAccount(ID, owner, balance);
            bankAccountsList.add(bankAccount);
            log.info("new account created, ID: {}, owner: {}, balance: {}", ID, owner, balance);
        } catch (Exception e) {
            log.error("Error in creating account, ID: {}, owner: {}, balance: {}", ID, owner, balance);
        }

    }

    public static void searchForAccount(Long ID) {
        try {
            for (BankAccount bankAccount : bankAccountsList) {
                if (bankAccount.getID() == ID) {
                    log.info("Account found, ID: {}", ID);
                    System.out.println(bankAccount);
                }
            }

        } catch (Exception e) {
            log.error("Account not found, ID: {}", ID, e);
            throw new RuntimeException("Account not found");
        }
    }

    public static void depositMoney(Long ID, BigDecimal money) {
        try {
            bankAccountsList.stream()
                    .filter(bankAccount -> bankAccount.getID().equals(ID))
                    .forEach(bankAccount -> bankAccount.setBalance(bankAccount.getBalance().add(money)));
            log.info("Money deposited succesfully");
        } catch (Exception e) {
            log.error("Error in deposing money, ID: {}, money: {}", ID, money);
            throw new RuntimeException("Error in deposit money");
        }
    }

    public static void withdrawMoney(Long ID, BigDecimal money) {
        try {
            bankAccountsList.stream()
                    .filter(bankAccount -> bankAccount.getID().equals(ID))
                    .forEach(bankAccount -> bankAccount.setBalance(bankAccount.getBalance().subtract(money)));
            log.info("Money withdraw succesfully");
        } catch (Exception e) {
            log.error("Error in withdrawingg money, ID: {}, money: {}", ID, money);
            throw new RuntimeException("Error in withdrawing money");
        }
    }

    public static void transferMoney(Long senderID, Long reciverID, BigDecimal money) {
        BankAccount senderBankAccount = bankAccountsList.stream()
                .filter(bankAccount -> bankAccount.getID().equals(senderID))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Sender ID not found"));

        BankAccount reciverBankAccount = bankAccountsList.stream()
                .filter(bankAccount -> bankAccount.getID().equals(reciverID))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Reciver ID not found"));

        try {
            if (senderBankAccount != null && reciverBankAccount != null) {
                senderBankAccount.setBalance(senderBankAccount.getBalance().subtract(money));
                reciverBankAccount.setBalance(reciverBankAccount.getBalance().add(money));
                log.info("Transfer succeded, senderID: {}, reciverID: {}. moneyAmmount: {}", senderID, reciverID, money);
            } else {
                log.error("Transfer failed, senderID: {}, reciverID: {}. moneyAmmount: {}", senderID, reciverID, money);
                System.err.println("Transfer failed");

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}



