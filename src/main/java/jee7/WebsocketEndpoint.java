package jee7;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * User: moritz
 */
@ServerEndpoint("/websocket")
public class WebsocketEndpoint {

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("session = [" + session + "]");
    }

    @OnMessage
    public void onMessage(String message, Session session) {
	    try {
		    session.getBasicRemote().sendText(message);
	    } catch (IOException ignored) {  }
    }
}
