package rs;

import jpa.FortuneCookie;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Gregor Tudan
 */
@LocalBean
@Stateless
public class FortuneCookieBean {

	@PersistenceContext
	private EntityManager em;

	public FortuneCookie getFortuneCookie(Long id) {
		return em.find(FortuneCookie.class,id);
	}

	public void createFortuneCookie(FortuneCookie cookie) {
		em.persist(cookie);
	}
}
