package com.jxfslookup;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
	String constantsUri = System.getProperty("user.dir") + "/src/main/resources/constants.min.json";

	public HashMap<String, String> querycode(Object code) {
		System.out.println();
		code = code.toString();
		result = new HashMap<String, String>();
		try {
			BufferedInputStream bis = new BufferedInputStream(
					JxfsLookup.class.getClassLoader().getResourceAsStream("constants.min.json"));
			DataInputStream dis = new DataInputStream(bis);
			String data = "";
			while (dis.available() > 0) {
				data += dis.readLine();
			}
			JSONObject jsonInterfaces = new JSONObject(data);
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
