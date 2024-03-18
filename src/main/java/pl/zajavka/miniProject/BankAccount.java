package pl.zajavka.miniProject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@ToString
public class BankAccount {
    @Getter
    private final Long ID;
    private String owner;
    @Getter
    @Setter
    private BigDecimal balance;


}
