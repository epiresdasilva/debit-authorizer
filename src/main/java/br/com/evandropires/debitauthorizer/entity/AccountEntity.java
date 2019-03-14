package br.com.evandropires.debitauthorizer.entity;

/**
 * Created by evandro on 13/03/2019.
 */
public class AccountEntity {

    public enum AccountStatus {
        ACTIVE, INACTIVE
    }

    private Integer agency;
    private Integer accountNumber;
    private AccountStatus status;
    private String name;

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

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
