package websocket;

import org.slf4j.LoggerFactory;

import domain.Transaction;

import javax.inject.Inject;
import javax.websocket.EncodeException;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import java.io.IOException;

import jms.producer.SenderBean;

/**
 * User: moritz
 */
@ServerEndpoint(value="/websocket", decoders = TransactionDecoder.class, encoders = TransactionEncoder.class)
public class WebsocketEndpoint {

	private org.slf4j.Logger log = LoggerFactory.getLogger(getClass());
	
	@Inject
	SenderBean senderbean;
	
    @OnMessage
    public void onMessage(Transaction transaction, Session session) {
        try {
        	for (Session s : session.getOpenSessions()) {
        		
        		senderbean.sendMessageJavaEE7(transaction);
        		
        		//s.getBasicRemote().sendObject(transaction);
        		
            }
        } catch (Exception e) {
           log.error(e.getMessage(),e);
        }
    }
}
