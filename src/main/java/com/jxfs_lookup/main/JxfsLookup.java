package com.jxfs_lookup.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * J/XFS Constant Field Values Lookup 
 *
 */
public class JxfsLookup {
	
	HashMap<String, String> result = new HashMap<String, String>();
	String constantsUri = System.getProperty("user.dir") + "/src/main/java/com/jxfs_lookup/res/constants.min.json";

	public HashMap<String, String> querycode(Object code) {
		code = code.toString();
		result = new HashMap<String, String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(constantsUri));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			String everything = sb.toString();
			JSONObject jsonInterfaces = new JSONObject(everything);
			Iterator<?> interfaceKeys = jsonInterfaces.keys();
			while (interfaceKeys.hasNext()) {
				String interfaceKey = (String) interfaceKeys.next();
				if (jsonInterfaces.get(interfaceKey) instanceof JSONObject) {
					JSONObject interfaceValues = (JSONObject) jsonInterfaces.get(interfaceKey);
					JSONArray valuesArray = (JSONArray) interfaceValues.get("values");
					for (int i = 0; i < valuesArray.length(); i++) {
						JSONObject values = (JSONObject) valuesArray.get(i);
						if (values.get("code").equals(code)) {
							result.put(interfaceKey, values.toString());
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public void printHashMap(HashMap<String, String> hm) {
	    Iterator<Entry<String, String>> it = hm.entrySet().iterator();
	    while (it.hasNext()) {
	        Entry<String, String> pair = it.next();
	        System.out.println(pair.getKey() + " = " + pair.getValue());
	    }
	}
	
	public HashMap<String, String> getResult() {
		return this.result;
	}
}
