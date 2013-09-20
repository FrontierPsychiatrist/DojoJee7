package jee7;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
import java.io.StringWriter;

/**
 * @author Gregor Tudan
 */
public class ChatMessageEncoder implements Encoder.Text<ChatMessage> {
	@Override
	public String encode(ChatMessage chatMessage) throws EncodeException {
		StringWriter writer = new StringWriter();
		JsonGenerator generator = Json.createGenerator(writer);
		generator.writeStartObject()
				.write("user", chatMessage.getUser())
				.write("message", chatMessage.getMessage())
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
