package fr.diginamic.utils;

import java.util.HashMap;
import java.util.Map;

public class ConfigUtils {
	
	public static Map<String, String> getPassword() {
		String password = System.getProperty("password");
		Map<String, String> result = new HashMap<>();
		result.put("javax.persistence.jdbc.password", password);
		return result;
	}

}
