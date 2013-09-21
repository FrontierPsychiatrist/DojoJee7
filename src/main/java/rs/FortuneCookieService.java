package rs;

import jpa.FortuneCookie;

import javax.inject.Inject;
import javax.persistence.Cacheable;
import javax.ws.rs.*;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import java.net.URI;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;

/**
 * @author Gregor Tudan
 */
@Path("/fortune")
@Produces({APPLICATION_JSON, APPLICATION_XML})
public class FortuneCookieService {

	@Inject
	private FortuneCookieBean provider;

	@GET
	public FortuneCookie random() {
		return FortuneCookie.random();
	}

	@GET
	@Path("/{nr}")
	public Response getCookie(@PathParam("nr") Long id) {
		CacheControl cacheControl = new CacheControl();
		cacheControl.setMaxAge(3600);
		FortuneCookie cookie = provider.getFortuneCookie(id);
		return Response.ok(cookie).cacheControl(cacheControl).build();
	}

	@POST
	@Consumes({APPLICATION_JSON, APPLICATION_XML})
	public Response addFortuneCookie(FortuneCookie c) {
		provider.createFortuneCookie(c);
		URI location = UriBuilder.fromPath("/fortune").path(c.getId().toString()).build();
		return Response.created(location).build();
	}
}
