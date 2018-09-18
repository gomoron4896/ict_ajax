package com.ict.ajax;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class ParseTest {

	public static void main(String[] args) {

		String param = "{\"name\":\"김기섭\"}";
		Gson gson = new Gson();

		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap = gson.fromJson(param, Map.class);
		
		
	}
}
