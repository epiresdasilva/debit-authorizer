package br.com.evandropires.debitauthorizer.test.dto;

import java.math.BigDecimal;

/**
 * Created by evandro on 21/05/2019.
 */
public class Balance {

    private Integer agency;
    private Integer account;
    private BigDecimal balance;
    private String name;
    private String status;

    public Integer getAgency() {
        return agency;
    }

    public void setAgency(Integer agency) {
        this.agency = agency;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
