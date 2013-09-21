package rs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;

/**
 * @author Gregor Tudan
 */
@Path("/fortune")
@Produces({APPLICATION_JSON, APPLICATION_XML})
public class FortuneCookieService {

	@GET
	public FortuneCookie getCookie() {
		return FortuneCookie.random();
	}
}
