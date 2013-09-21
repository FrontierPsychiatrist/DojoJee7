package websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.Transaction;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParserFactory;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import java.io.StringReader;

/**
 * @author Gregor Tudan + Thomas Krämer
 */

public class TransactionDecoder implements Decoder.Text<Transaction> {

	private Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public Transaction decode(String s) throws DecodeException {
		log.debug("Decoding {}",s);
		JsonReader reader = Json.createReader(new StringReader(s));
		JsonObject jsonObject = reader.readObject();
		Transaction transaction = new Transaction(jsonObject.getString("expression"));
		transaction.setName(jsonObject.getString("name"));
		transaction.setWert1(jsonObject.getInt("number1"));
		transaction.setWert2(jsonObject.getInt("number2"));
		return transaction;

	}

	@Override
	public boolean willDecode(String s) {
		return true;
	}

	@Override
	public void init(EndpointConfig endpointConfig) {
	}

	@Override
	public void destroy() {
	}
}
