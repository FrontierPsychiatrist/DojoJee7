package cdibean;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;


@Named("mandant")
@ApplicationScoped
public class Mandant implements Serializable {
	
	@Inject
	Logger logger;
	
	private String firmenname;
	private String name;
	private String vorname;
	private int anzahlMitarbeiter;

	public String toString(){
		logger.info("Mandant:\n Firmenname :" + firmenname + "\n Name: " + vorname + " " + name + "\n AnzahlMitarbeiter:" + anzahlMitarbeiter);
		return "Mandant:\n Firmenname :" + firmenname + "\n Name: " + vorname + " " + name + "\n AnzahlMitarbeiter:" + anzahlMitarbeiter;
	}

	/**
	 * @return the firmenname
	 */
	public String getFirmenname() {
		return firmenname;
	}

	/**
	 * @param firmenname the firmenname to set
	 */
	public void setFirmenname(String firmenname) {
		this.firmenname = firmenname;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the vorname
	 */
	public String getVorname() {
		return vorname;
	}

	/**
	 * @param vorname the vorname to set
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	/**
	 * @return the anzahlMitarbeiter
	 */
	public int getAnzahlMitarbeiter() {
		return anzahlMitarbeiter;
	}

	/**
	 * @param anzahlMitarbeiter the anzahlMitarbeiter to set
	 */
	public void setAnzahlMitarbeiter(int anzahlMitarbeiter) {
		this.anzahlMitarbeiter = anzahlMitarbeiter;
	}
	
}
