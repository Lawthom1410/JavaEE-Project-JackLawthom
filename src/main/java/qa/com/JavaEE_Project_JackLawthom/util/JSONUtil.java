package qa.com.JavaEE_Project_JackLawthom.util;

import com.google.gson.Gson;

public class JSONUtil {
	
	private Gson gson = new Gson();
	
	public String getJson(Object obj) {
		return gson.toJson(obj);
	}
	
	public <T> T convertJson(String json, Class<T> clazz) {
		return gson.fromJson(json, clazz);
	}

}
