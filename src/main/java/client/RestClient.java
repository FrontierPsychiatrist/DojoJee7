package client;

import rs.FortuneCookie;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Gregor Tudan
 */
public class RestClient {
	public String invokeService() {
		Response xml = ClientBuilder.newClient().target("http://localhost:8080/jaxrs/asnyc").request(MediaType.APPLICATION_XML_TYPE).get();
		FortuneCookie cookie = (FortuneCookie) xml.getEntity();
		return cookie.getWisdom();
	}
}
