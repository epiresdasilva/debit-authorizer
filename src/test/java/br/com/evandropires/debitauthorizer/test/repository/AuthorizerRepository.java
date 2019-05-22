package br.com.evandropires.debitauthorizer.test.repository;

import br.com.evandropires.debitauthorizer.test.dto.Authorizer;
import com.google.gson.JsonObject;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;

/**
 * Created by evandro on 21/05/2019.
 */
public class AuthorizerRepository {

    public static final String URL_BASE = "https://6454a6e5.us-south.apiconnect.appdomain.cloud/debitauthorizer";

    public Authorizer authorizer(Integer cardNumber, BigDecimal debitValue) {
        Client client = ClientBuilder.newBuilder().newClient();
        WebTarget target = client.target(URL_BASE)
                .path("authorizer");
        Invocation.Builder builder = target.request();
        JsonObject payload = new JsonObject();
        payload.addProperty("cardNumber", cardNumber);
        payload.addProperty("debitValue", debitValue);
        Response response = builder.post(Entity.entity(payload.toString(), MediaType.APPLICATION_JSON_TYPE));
        return response.readEntity(Authorizer.class);
    }

}
