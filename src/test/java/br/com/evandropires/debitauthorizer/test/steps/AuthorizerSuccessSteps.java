package br.com.evandropires.debitauthorizer.test.steps;

import br.com.evandropires.debitauthorizer.test.dto.Authorizer;
import br.com.evandropires.debitauthorizer.test.dto.Balance;
import br.com.evandropires.debitauthorizer.test.repository.AuthorizerRepository;
import br.com.evandropires.debitauthorizer.test.repository.BalanceRepository;
import cucumber.api.java.es.Dado;
import cucumber.api.java.it.E;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Entao;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AuthorizerSuccessSteps {

    public static final Integer AGENCY = 111;
    public static final Integer ACCOUNT = 123;
    public static final int CARD_NUMBER = 123456;

    private Authorizer authorizer;
    private BalanceRepository balanceRepository = new BalanceRepository();
    private AuthorizerRepository authorizerRepository = new AuthorizerRepository();

    @Dado("^que tenho cartao de debito ativo com conta corrente ativa com saldo \"(.*?)\"$")
    public void cartaoAtivoContaCorrenteAtiva(BigDecimal saldo) throws Throwable {
        Balance balance = balanceRepository.findBalance(AGENCY, ACCOUNT);

        BigDecimal diferenca = balance.getBalance().subtract(saldo).negate();
        if (!BigDecimal.ZERO.equals(diferenca)) {
            balanceRepository.updateBalance(AGENCY, ACCOUNT, diferenca);
        }
    }

    @Quando("^executo um lancamento de “(.*?)”$")
    public void executarLancamento(BigDecimal valorLancamento) throws Throwable {
        authorizer = authorizerRepository.authorizer(CARD_NUMBER, valorLancamento);
    }

    @E("^verifico o saldo atualizado “(.*?)”$")
    public void saldoAtualizado(BigDecimal saldo) throws Throwable {
        Balance balance = balanceRepository.findBalance(AGENCY, ACCOUNT);
        System.out.println(balance.getBalance());
        assertTrue("O saldo não é igual ao inicial - valor da transacao",
                saldo.setScale(2, BigDecimal.ROUND_HALF_UP).equals(balance.getBalance().setScale(2, BigDecimal.ROUND_HALF_UP)));
    }

    @Entao("^obtenho o retorno “(.*?)”$")
    public void retornoAutorizado(String status) throws Throwable {
        assertEquals("O status deve ser Autorizado, mas retornou " + status, authorizer.getMessage(),
                status);
    }
}