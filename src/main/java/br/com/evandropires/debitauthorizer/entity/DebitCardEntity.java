package br.com.evandropires.debitauthorizer.entity;

/**
 * Created by evandro on 13/03/2019.
 */
public class DebitCardEntity {

    public enum DebitCardStatus {
        ACTIVE, INACTIVE
    }

    private Integer cardnumber;
    private Integer agency;
    private Integer accountNumber;
    private DebitCardStatus status;

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

    public DebitCardStatus getStatus() {
        return status;
    }

    public void setStatus(DebitCardStatus status) {
        this.status = status;
    }

    public Integer getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(Integer cardnumber) {
        this.cardnumber = cardnumber;
    }
}
