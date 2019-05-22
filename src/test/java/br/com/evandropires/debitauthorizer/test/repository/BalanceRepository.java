package br.com.evandropires.debitauthorizer.test.repository;

import br.com.evandropires.debitauthorizer.test.dto.Balance;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;

/**
 * Created by evandro on 21/05/2019.
 */
public class BalanceRepository {

    public static final String URL_BASE = "https://6454a6e5.us-south.apiconnect.appdomain.cloud/debitauthorizer";

    public Balance findBalance(Integer agency, Integer account) {
        Client client = ClientBuilder.newBuilder().newClient();
        WebTarget target = client.target(URL_BASE)
                .path("balance")
                .queryParam("agency", agency)
                .queryParam("account", account);
        Invocation.Builder builder = target.request();
        String json = builder.get(String.class);
        JsonParser parser = new JsonParser();
        JsonObject balanceJson = parser.parse(json).getAsJsonObject();
        Balance balance = new Balance();
        balance.setAgency(balanceJson.get("agency").getAsInt());
        balance.setAccount(balanceJson.get("account").getAsInt());
        balance.setBalance(balanceJson.get("balance").getAsBigDecimal());
        balance.setName(balanceJson.get("name").getAsString());
        balance.setStatus(balanceJson.get("status").getAsString());
        return balance;
    }

    public void updateBalance(Integer agency, Integer account, BigDecimal balance) {
        Client client = ClientBuilder.newBuilder().newClient();
        WebTarget target = client.target(URL_BASE)
                .path("balance");
        Invocation.Builder builder = target.request();
        JsonObject payload = new JsonObject();
        payload.addProperty("agency", agency);
        payload.addProperty("account", account);
        payload.addProperty("operationValue", balance);
        builder.put(Entity.entity(payload.toString(), MediaType.APPLICATION_JSON_TYPE));
    }

}
