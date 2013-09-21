package client;

import jpa.FortuneCookie;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

/**
 * @author Gregor Tudan
 */
@ApplicationScoped
public class RestClient {
	public String invokeService() {
		FortuneCookie cookie = ClientBuilder.newClient()
				.target("http://localhost:8080/jaxrs/fortune")
				.request(MediaType.APPLICATION_JSON)
				.get(FortuneCookie.class);
		return cookie.getWisdom();
	}
}
