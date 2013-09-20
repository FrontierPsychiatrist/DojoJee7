package jee7;

import org.slf4j.LoggerFactory;

import javax.websocket.EncodeException;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * User: moritz
 */
@ServerEndpoint(value="/websocket", decoders = ChatMessageDecoder.class, encoders = ChatMessageEncoder.class)
public class WebsocketEndpoint {

	private org.slf4j.Logger log = LoggerFactory.getLogger(getClass());

    @OnMessage
    public void onMessage(ChatMessage chatMessage, Session session) {
        try {
        	for (Session s : session.getOpenSessions()) {
        		s.getBasicRemote().sendObject(chatMessage);
            }
        } catch (IOException | EncodeException e) {
           log.error(e.getMessage(),e);
        }
    }
}
