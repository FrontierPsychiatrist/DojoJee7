package websocket;

import org.slf4j.LoggerFactory;

import cdi.ProcessingCompleteEvent;
import domain.Transaction;
import domain.TransactionReport;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jms.producer.SenderBean;

/**
 * User: moritz
 */
@ServerEndpoint(value="/websocket", decoders = TransactionDecoder.class, encoders = TransactionEncoder.class)
public class WebsocketEndpoint {
	
	private static List<Session> sessions = new ArrayList<>();
	
	private org.slf4j.Logger log = LoggerFactory.getLogger(getClass());
	
	@Inject
	SenderBean senderbean;
	
    @OnMessage
    public void onMessage(Transaction transaction, Session session) {
        try {
                senderbean.sendMessageJavaEE7(transaction);
            } catch (Exception e) {
           log.error(e.getMessage(),e);
        }
    }
    
    @OnOpen
    public void onOpen (Session session){
    	sessions.add(session);  	
    }
    @OnClose
    public void onClose (Session session){
    	sessions.remove(session);    	
    }
    
    public void fireEvent (@Observes ProcessingCompleteEvent event){
    	
    	try {
        	for (Session s : sessions) {
        		s.getBasicRemote().sendObject(event.getResult().toString());
            }
        } catch (IOException | EncodeException e) {
           log.error(e.getMessage(),e);
        }
    	
    }
}
