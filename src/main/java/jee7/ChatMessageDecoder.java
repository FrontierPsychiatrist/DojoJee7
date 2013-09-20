package jee7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
 * @author Gregor Tudan
 */

public class ChatMessageDecoder implements Decoder.Text<ChatMessage> {

	private Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public ChatMessage decode(String s) throws DecodeException {
		log.debug("Decoding {}",s);
		JsonReader reader = Json.createReader(new StringReader(s));
		JsonObject jsonObject = reader.readObject();
		String user = jsonObject.getString("user");
		String message = jsonObject.getString("message");
		return new ChatMessage(user, message);

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
