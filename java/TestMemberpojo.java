package exercise2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import org.junit.Test;
import java.util.List;
public class TestMemberpojo {
	@Test
	public void test1() {
	List<String> members = new ArrayList<>();
	members.add("name1");
	String result = members.get(0);
	assertEquals("name1",result);
	}
	@Test
	public void testFailcondition() {
	List<String> members = new ArrayList<>();
	members.add("name1");
	String result = members.get(1);
	assertEquals("name1",result);
	}
	@Test
	public void test3() {
	List<String> members = new ArrayList<>();
	members.add("name1");	
	members.add("name12");
	String result = members.get(1);
	assertEquals("name12gi",result);
	}
}
