package pl.zajavka.miniProject;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
public class BankTransaction {
    private final Long ID;
    private BankAccount account;
    private BigDecimal amount;
    private LocalDate date;



}
