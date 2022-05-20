import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Scanner;

class DataAnalysisTest {

	public static ArrayList<User> createUserArrayList()
	{
		//Makes an ArrayList of users to test from
		ArrayList<User> composers = new ArrayList<User>();
		
		int[] mozartTimes = {1, 27, 17, 56};
		composers.add(new User("22mozartw35@stu.smuhsd.org", mozartTimes, "wolfy_MozArts"));
		
		int[] beethovenTimes = {12, 16, 17, 70};
		composers.add(new User("22beethovenl56@stu.smuhsd.org", beethovenTimes, "furE_Lise"));
		
		int[] chopinTimes = {3, 1, 18, 10};
		composers.add(new User("22chopinf39@stu.smuhsd.org", chopinTimes, "choppinBoard"));
		
		return composers;
	}
	
	
	@Test
	public void testAddUserWithLessThanFour() {
		//Calls addUser for a composer with a six letter name and then checks for their password
		//This test array contains musical composers and not teachers from your school
		
		ArrayList<User> theUsers = createUserArrayList();
		
		//Adds User and tests for default password
		DataAnalysis.addUser(theUsers, "22ahok79@stu.smuhsd.org", 3);
		String expected = "aho_k_2021";
		String actual = theUsers.get(3).getPassword();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testAddUserWithMoreThanFour() {
		//Calls static method at the top of this file to create an array of users
		//This test array contains musical composers and not teachers from your school
		ArrayList<User> theUsers = createUserArrayList();
				
		//Adds User and tests for default password
		DataAnalysis.addUser(theUsers, "22haydnj77@stu.smuhsd.org", 3);
		String expected = "hayd_j_2021";
		String actual = theUsers.get(3).getPassword();
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void testSecondUserConstructor() {
		//Calls the second User constructor without a password
		//This test array contains musical composers and not teachers from your school
		ArrayList<User> theUsers = createUserArrayList();
				
		//Creates a new User and checks their data
		int[] schubertTimes = {4, 2, 8};
		theUsers.add(new User("22schubertf31@stu.smuhsd.org", schubertTimes));
		String expected = "fschubert\nPassword: schu_f_2021\nLogged in 3 times\nTotal time spent: 14\nAverage session length: 4.67";
		String actual = theUsers.get(3).toString();
		
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void testMostExperiencedUser() {
		//Calls static method checking for Users with greatest total time
		//This test array contains composers and not teachers from your school
		
		ArrayList<User> theUsers = createUserArrayList();
		
		//Getting total time
		String expected = theUsers.get(1).getUsername();
		String actual = DataAnalysis.mostExperiencedUser(theUsers);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMostExperiencedUser2() {
		//Calls static method checking for Users with greatest total time
		//This test array contains composers and not teachers from your school
		
		ArrayList<User> theUsers = createUserArrayList();
		
		//Adding Users
		int[] bachTimes = {1685, 331, 65};
		theUsers.add(new User("22bachj65@stu.smuhsd.org", bachTimes, "im_Bach"));
		
		int[] lisztTimes = {10, 22, 1, 3, 6, 7, 9};
		theUsers.add(new User("22lisztf74@stu.smuhsd.org", bachTimes, "shoppin_liszt"));
		
		
		String expected = theUsers.get(3).getUsername();
		String actual = DataAnalysis.mostExperiencedUser(theUsers);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testRemoveInactiveUser() {
		// Creates a bunch more users with fewer than 10 min total. 
		// Calls removeInactiveUser to remove all users with < 10 min time spent
		
		// Create users: some are "inactive"
		ArrayList<User> theUsers = createUserArrayList();
		int[] bachTimes = {9};
		theUsers.add(new User("24bachj11@stu.smuhsd.org", bachTimes));
		
		int[] debussyTimes = {3, 1, 1};
		theUsers.add(new User("24debussyc15@stu.smuhsd.org", debussyTimes));
		
		int[] schubertTimes = {4, 2, 8};
		theUsers.add(new User("22schubertf31@stu.smuhsd.org", schubertTimes));
		
		int[] tchaikovskyTimes = {2, 5};
		theUsers.add(new User("25tchaikovskyp07@stu.smuhsd.org", tchaikovskyTimes));
		
		// Remove inactive users and see if the length of the list is correct
		DataAnalysis.removeInactiveUser(theUsers);
		int expected = theUsers.size();
		int actual = 4;
		assertEquals(expected, actual);
	}
}
