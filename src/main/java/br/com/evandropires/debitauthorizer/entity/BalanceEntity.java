package br.com.evandropires.debitauthorizer.entity;

import java.math.BigDecimal;

/**
 * Created by evandro on 13/03/2019.
 */
public class BalanceEntity {

    private Integer agency;
    private Integer accountNumber;
    private BigDecimal value;

    public Integer getAgency() {
        return agency;
    }

    public void setAgency(Integer agency) {
        this.agency = agency;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
