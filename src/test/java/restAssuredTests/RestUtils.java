package restAssuredTests;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	public static String getFirstName() {
		String geneatedString = RandomStringUtils.randomAlphabetic(1);
		return ("John"+geneatedString);
	}
	public static String getLastName() {
		String geneatedString = RandomStringUtils.randomAlphabetic(2);
		return ("John"+geneatedString);
	}
	public static String getEmail() {
		String geneatedString = RandomStringUtils.randomAlphabetic(4);
		return (geneatedString+"@gmail.com");
	}
	public static String getPassword() {
		String geneatedString = RandomStringUtils.randomAlphanumeric(3);
		return geneatedString;
	}
	public static String empName() {
		String geneatedString = RandomStringUtils.randomAlphabetic(1);
		return ("john"+geneatedString);
	}
	public static String empSalaray() {
		String geneatedString = RandomStringUtils.randomNumeric(5);
		return geneatedString;
	}






}
