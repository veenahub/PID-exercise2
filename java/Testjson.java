package exercise2;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

public class Testjson {
	@Test
	public void testingAdd() {
		HashMap<String, String> memberslist = new HashMap<String, String>();
		memberslist.put("1", "member1");
		String result = memberslist.get("1");
		assertEquals("member1",result);
	}
	@Test
	public void testingAddFalseCondition() {
		HashMap<String, String> memberslist = new HashMap<String, String>();
		memberslist.put("1", "member1");
		String result = memberslist.get("1");
		assertEquals("Fayad",result);
	}
	@Test
	public void testingtwoelements() {
		HashMap<String, String> memberslist = new HashMap<String, String>();
		memberslist.put("1", "member1");
		memberslist.put("2", "member2");
		String result = memberslist.get("2");
		assertEquals("member2",result);
	}
}
