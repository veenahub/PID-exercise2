package exercise2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

public class Userinterface {
	public static void main(String[] args) throws IOException, ParseException {
		Json json = new Json();
		HashMap<String, String> membersList = json.loadJsonandCheckId();
		HashMap<String, String> memberList = new HashMap();
		Scanner s = new Scanner(System.in);
		while (true) {
			String userinput = s.nextLine();
			// Switch case for user to select option.
			switch (userinput) {
			case "1":
				// Taking attendence.user should enter date  
				//for taking attendence user should enter True or False
				System.out.println("Enter the date");
				String date = s.nextLine();
				List<Memberpojo> members = new ArrayList<>();
				for (String id : membersList.keySet()) {
					Memberpojo pojo = new Memberpojo();
					String name = membersList.get(id);
					pojo.setName(name);
					pojo.setId(id);
					System.out.println("Enter the attendence for" + name);
					boolean attendence = s.nextBoolean();
					pojo.setAttendence(attendence);
					members.add(pojo);
				}
				json.attendence(date, members);
				break;
			case "2":
                json.save();
				break;	
			case "3":
				// exit method to save
				System.out.println("Thank you");
				return;
			default:
				System.out.println("you should enter the number between 1 to 5");
				System.out.println("Pick an option");
				System.out.println("1 for take attendence");
				System.out.println("2 for save attendence sheet");
				System.out.println("3 for Exit");
				
			}
		}

	}

}
