package rs;

/**
 * @author Gregor Tudan
 */
public class FortuneCookie {

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
}
