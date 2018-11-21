package br.com.evandropires.debitauthorizer.function;

import br.com.evandropires.debitauthorizer.service.ProvisionalDebitProvider;
import br.com.evandropires.debitauthorizer.service.ProvisionalDebitService;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.math.BigDecimal;
import java.util.Iterator;

/**
 * Created by evandro on 11/11/2018.
 */
public class ProvisionalDebitRegisterFunction {
	public static JsonObject main(JsonObject params) {
		ProvisionalDebitProvider provisionalDebitProvider = new ProvisionalDebitProvider();
		ProvisionalDebitService provisionalDebitService = new ProvisionalDebitService(provisionalDebitProvider);
		if (params.has("messages")) {
			JsonArray messages = params.getAsJsonArray("messages");
			Iterator<JsonElement> messagesIterator = messages.iterator();
			while (messagesIterator.hasNext()) {
				JsonObject message = messagesIterator.next().getAsJsonObject();
				JsonObject value = message.getAsJsonObject("value");
				Long id = value.get("id").getAsLong();
				provisionalDebitService.registerProvisionalDebit(id);
			}
			return params;
		}
		Long id = params.get("id").getAsLong();
		provisionalDebitService.registerProvisionalDebit(id);
		return params;
	}
}
