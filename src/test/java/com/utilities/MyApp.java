package com.utilities;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyApp {
	
	
	public static boolean data(String projectName, String json, String  savedParamters) {

		JSONArray savedParametersArray = new JSONArray(savedParamters);
		for (int i = 0; i < savedParametersArray.length(); i++) {
			  System.out.println("JSON: " + json);
			  JSONObject obj =  savedParametersArray.optJSONObject(i);
			  if(obj != null) {
				  String jsonkey = obj.optString("value");
				  String propertiesKey = obj.optString("key");
				  JsonParser p = new JsonParser();
			        check(jsonkey, p.parse(json));
			        System.out.println("list size: " + list.size());
			        if(list.size() >0 ) {
						writepropertiesFile(projectName, propertiesKey + " = " + list.get(0), propertiesKey);
						System.out.println(list);
					}
			  }
		        
		}
		return false;
	      
	}
	
	
	private static void writepropertiesFile(String projectName, String content, String propKey) {
		String path = "." + File.separator + "ConfigFiles" + File.separator + projectName + ".properties";
		File file = new File(path);
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Checking If The File Exists At The Specified Location Or Not
        Path filePathObj = Paths.get(path);
        boolean fileExists = Files.exists(filePathObj);
        if(fileExists) {
            try {
            	List<String> fileContent = new ArrayList<>(Files.readAllLines(file.toPath(), StandardCharsets.UTF_8));
            	boolean isOverwrited = false;
            	for (int i = 0; i < fileContent.size(); i++) {
            	    if (fileContent.get(i).contains(propKey + " = ")) {
            	        fileContent.set(i, content);
            	        isOverwrited = true;
            	        break;
            	    }
            	}
            	if(isOverwrited) {
            		Files.write(file.toPath(), fileContent, StandardCharsets.UTF_8);
            	} else {
            		 Files.write(filePathObj, content.getBytes(), StandardOpenOption.APPEND);
            	}
            	
            } catch (IOException ioExceptionObj) {
                System.out.println("Problem Occured While Writing To The File= " + ioExceptionObj.getMessage());
            }
        } else {
            System.out.println("File Not Present! Please Check!");
        }     
	}
	

    static List<String> list = new ArrayList<String>();
    private static void check(String key, JsonElement jsonElement) {

        if (jsonElement.isJsonArray()) {
            for (JsonElement jsonElement1 : jsonElement.getAsJsonArray()) {
                check(key, jsonElement1);
            }
        } else {
            if (jsonElement.isJsonObject()) {
                Set<Map.Entry<String, JsonElement>> entrySet = jsonElement
                        .getAsJsonObject().entrySet();
                for (Map.Entry<String, JsonElement> entry : entrySet) {
                    String key1 = entry.getKey();
                    if (key1.equals(key)) {
                        list.add(entry.getValue().toString());
                    }
                    check(key, entry.getValue());
                }
            } else {
                if (jsonElement.toString().equals(key)) {
                    list.add(jsonElement.toString());
                }
            }
        }
    }

}