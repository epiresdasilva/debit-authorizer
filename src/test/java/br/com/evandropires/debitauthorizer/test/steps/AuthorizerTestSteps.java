package br.com.evandropires.debitauthorizer.test.steps;

import br.com.evandropires.debitauthorizer.test.dto.Authorizer;
import br.com.evandropires.debitauthorizer.test.dto.AuthorizerTransaction;
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

public class AuthorizerTestSteps {

    private Authorizer authorizer;
    private AuthorizerTransaction authorizerTransaction;
    private BalanceRepository balanceRepository = new BalanceRepository();
    private AuthorizerRepository authorizerRepository = new AuthorizerRepository();

    @Dado("^que tenho cartao de debito ativo com conta corrente ativa com saldo \"(.*?)\"$")
    public void cartaoAtivoContaCorrenteAtiva(BigDecimal saldo) throws Throwable {
        authorizerTransaction = new AuthorizerTransaction(111,123,123456);
        adjustBalance(saldo);
    }

    @Dado("^que tenho cartao de debito inativo com conta corrente ativa com saldo \"(.*?)\"$")
    public void cartaoInativoContaCorrenteAtiva(BigDecimal saldo) {
        authorizerTransaction = new AuthorizerTransaction(111,456,456789);
        adjustBalance(saldo);
    }

    @Dado("^que tenho cartao de debito ativo com conta corrente inativa com saldo \"(.*?)\"$")
    public void cartaoAtivoContaCorrenteInativa(BigDecimal saldo) {
        authorizerTransaction = new AuthorizerTransaction(222,123,999999);
        adjustBalance(saldo);
    }

    private void adjustBalance(BigDecimal saldo) {
        Balance balance = balanceRepository.findBalance(authorizerTransaction.getAgency(), authorizerTransaction.getAccount());

        BigDecimal diferenca = balance.getBalance().subtract(saldo).negate();
        if (!BigDecimal.ZERO.equals(diferenca)) {
            balanceRepository.updateBalance(authorizerTransaction.getAgency(), authorizerTransaction.getAccount(), diferenca);
        }
    }

    @Quando("^executo um lancamento de “(.*?)”$")
    public void executarLancamento(BigDecimal valorLancamento) throws Throwable {
        authorizer = authorizerRepository.authorizer(authorizerTransaction.getCardNumber(), valorLancamento);
    }

    @E("^verifico o saldo atualizado “(.*?)”$")
    public void saldoAtualizado(BigDecimal saldo) throws Throwable {
        Balance balance = balanceRepository.findBalance(authorizerTransaction.getAgency(), authorizerTransaction.getAccount());
        assertTrue("O saldo não é igual ao inicial - valor da transacao",
                saldo.setScale(2, BigDecimal.ROUND_HALF_UP).equals(balance.getBalance().setScale(2, BigDecimal.ROUND_HALF_UP)));
    }

    @Entao("^obtenho o retorno “(.*?)”$")
    public void retornoAutorizado(String status) throws Throwable {
        assertEquals("O status deve ser Autorizado, mas retornou " + status, authorizer.getMessage(),
                status);
    }
}