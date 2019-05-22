package br.com.evandropires.debitauthorizer.test.dto;

/**
 * Created by evandro on 22/05/2019.
 */
public class AuthorizerTransaction {

    private Integer agency;
    private Integer account;
    private Integer cardNumber;

    public AuthorizerTransaction(Integer agency, Integer account, Integer cardNumber) {
        this.agency = agency;
        this.account = account;
        this.cardNumber = cardNumber;
    }

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

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }
}
