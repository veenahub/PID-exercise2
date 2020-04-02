package exercise2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Json {
	HashMap<String, List> attendenceList = new HashMap<String, List>();

	public HashMap<String, String> loadJsonandCheckId() throws IOException, ParseException {
		Boolean fileWarning = false;
		JSONParser parser = new JSONParser();
		HashMap<String, String> memberslist = new HashMap<String, String>();
		try {
			Reader reader = new FileReader("/Users/sdalund/Desktop/gitllab/pid-exercise-2/example-member-list.json");
			JSONObject jsonObject = (JSONObject) parser.parse(reader);
			JSONArray members = (JSONArray) jsonObject.get("members");
			// for(Object member:members) {
			// System.out.println(member.toString());
			Iterator<Object> iterator = members.iterator();
			while (iterator.hasNext()) {
				JSONObject obj = (JSONObject) iterator.next();
				String name = (String) obj.get("name");
				String id = (String) obj.get("id");
				if (memberslist.containsKey(id)) {
					fileWarning = true;
				}
				memberslist.put(id, name);
			}
			if (fileWarning) {
				System.out.println("invalid file we have duplicate values");
			} else {
				System.out.println("no duplicates");
			}
			for (String id : memberslist.keySet()) {
				System.out.println("Name:" + memberslist.get(id));
				System.out.println("id:" + id);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memberslist;
	}

	public void attendence(String date, List<Memberpojo> members) {
		attendenceList.put(date, members);
		System.out.println("HAI" + attendenceList.size());
	}

	public void save() {
		JSONObject jsonobjmain = new JSONObject();
		JSONArray jsonArr1 = new JSONArray();
		
		
		for (String details : attendenceList.keySet()) {
			JSONObject jsonobj2 = new JSONObject();
			jsonobj2.put("date", details);
			List<Memberpojo> jsonfile = attendenceList.get(details);
			
			JSONArray jsonArr2 = new JSONArray();
			for (Memberpojo mem : jsonfile) {
				JSONObject jsonobj1 = new JSONObject();
				jsonobj1.put("Name", mem.getName());
				jsonobj1.put("Id", mem.getId());
				jsonobj1.put("Name", mem.getAttendence());
				jsonArr2.add(jsonobj1);
			}
			jsonobj2.put("member", jsonArr2);
			jsonArr1.add(jsonobj2);

		}
		jsonobjmain.put("Attendence", jsonArr1);
		System.out.println("" + jsonobjmain.toString());
		 try (FileWriter file = new FileWriter("Users/sdalund/Desktop/gitllab/pid-exercise-2/test.json")) {
	            file.write(jsonobjmain.toJSONString());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		

	}

}
