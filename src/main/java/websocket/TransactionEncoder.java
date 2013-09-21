package websocket;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import domain.Transaction;

import java.io.StringWriter;

/**
 * @author Gregor Tudan + Thomas Krämer
 */
public class TransactionEncoder implements Encoder.Text<Transaction> {
	@Override
	public String encode(Transaction transaction) throws EncodeException {
		StringWriter writer = new StringWriter();
		JsonGenerator generator = Json.createGenerator(writer);
		
		generator.writeStartObject()
				.write("name", transaction.getName())
				.write("number1", Integer.toString(transaction.getWert1()))
				.write("number2", Integer.toString(transaction.getWert2()))
				.write("expression", transaction.getExpression())
				.writeEnd()
				.close();

		return writer.toString();
	}

	@Override
	public void init(EndpointConfig endpointConfig) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void destroy() {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
