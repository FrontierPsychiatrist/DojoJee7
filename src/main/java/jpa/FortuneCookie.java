package jpa;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Gregor Tudan
 */
@XmlRootElement
@Entity
@NamedQuery(name="FortuneCookie.getCount", query = "select count(f) from FortuneCookie f")
public class FortuneCookie {

	@Id
	@GeneratedValue
	private Long id;

	private String wisdom;

	protected FortuneCookie() {
	}

	private FortuneCookie(String wisdom) {
		this.wisdom = wisdom;
	}

	public String getWisdom() {
		return wisdom;
	}

	public void setWisdom(String wisdom) {
		this.wisdom = wisdom;
	}

	public static FortuneCookie random(){
		return new FortuneCookie("There might be no multi tenancy in JEE7");
	}

	public Long getId() {
		return id;
	}
}
