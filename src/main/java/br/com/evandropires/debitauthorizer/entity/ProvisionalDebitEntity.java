package br.com.evandropires.debitauthorizer.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by evandro on 13/03/2019.
 */
public class ProvisionalDebitEntity {

    public enum ProvisionalDebitStatus {
        REGISTERED, PENDING
    }

    private Integer id;
    private Integer agency;
    private Integer accountNumber;
    private BigDecimal value;
    private Date date;
    private ProvisionalDebitStatus status;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ProvisionalDebitStatus getStatus() {
        return status;
    }

    public void setStatus(ProvisionalDebitStatus status) {
        this.status = status;
    }
}
