

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Scanner;


public class UserTest 
{
    public static User[] createUserArray()
    {
        //Makes an array of users to test from
        User[] monsters = new User[3];
        
        int[] mikesTimes = {5, 10, 11};  //total: 26, avg: 8.67
        monsters[0] = new User("22wozowskim15@stu.smuhsd.org", mikesTimes, "1eyeRulz");
        
        int[] sullysTimes = {20, 30, 40, 50, 51};  //total: 191, avg: 38.2 
        monsters[1] = new User("22sullivanj07@stu.smuhsd.org", sullysTimes, "bigHairyBoss");
        
        int[] randallsTimes = {2, 60};  // total: 62, avg: 31
        monsters[2] = new User("23boggsr13@stu.smuhsd.org", randallsTimes, "inVISIBLEme");
        
        return monsters;
    }
    
    
    @Test
    public void testGetEmail() {
        //Calls static method at the top of this file to create an array of users
        //This test array contains monsters and not teachers from your school
        User[] theUsers = createUserArray();
        
        //Gets and tests emails
        String[] expected = {"22wozowskim15@stu.smuhsd.org", "22sullivanj07@stu.smuhsd.org", "23boggsr13@stu.smuhsd.org"};
        String[] actual = new String[theUsers.length];
        for(int i=0; i<theUsers.length; i++)
        {
            actual[i] = theUsers[i].getEmail();
            assertEquals(expected[i], actual[i]);
        }
    }
    
    @Test
    public void testGetUsername() {
        //Calls static method at the top of this file to create an array of users
        //This test array contains monsters and not teachers from your school
        User[] theUsers = createUserArray();
                
        //Gets and tests usernames
        String[] expected = {"mwozowski", "jsullivan", "rboggs"};
        String[] actual = new String[theUsers.length];
        for(int i=0; i<theUsers.length; i++)
        {
            actual[i] = theUsers[i].getUsername();
            assertEquals(expected[i], actual[i]);
        }
    }
    
    @Test
    public void testGetPassword() {
        //Calls static method at the top of this file to create an array of users
        //This test array contains monsters and not teachers from your school
        User[] theUsers = createUserArray();
                
        //Gets and tests passwords
        String[] expected = {"1eyeRulz", "bigHairyBoss", "inVISIBLEme"};
        String[] actual = new String[theUsers.length];
        for(int i=0; i<theUsers.length; i++)
        {
            actual[i] = theUsers[i].getPassword();
            assertEquals(expected[i], actual[i]);
        }
    }
    
    @Test
    public void testGetSessionTimes() {
        //Calls static method at the top of this file to create an array of users
        //This test array contains monsters and not teachers from your school
        User[] theUsers = createUserArray();
                
        //Gets and tests arrays of times users spent in each session
        int[][] expected = {{5, 10, 11}, {20, 30, 40, 50, 51}, {2, 60}};
        for(int i=0; i<theUsers.length; i++)
        {
            int[] actual = theUsers[i].getSessionTimes();
            assertArrayEquals(expected[i], actual);
        }
    }
    
    @Test
    public void testToString() {
        //Calls static method at the top of this file to create an array of users
        //This test array contains monsters and not teachers from your school
        User[] theUsers = createUserArray();
                
        //Gets and tests passwords
        String[] expected = new String[theUsers.length];
        int[] totalTime = {26, 191, 62};
        double[] averageTime = {8.67, 38.2, 31};
                
        for(int i=0; i<theUsers.length; i++)
        {
            expected[i] = theUsers[i].getUsername() + "\nPassword: " + theUsers[i].getPassword() + "\nLogged in " + theUsers[i].getSessionTimes().length + " times\nTotal time spent: " + totalTime[i] +"\nAverage session length: " + averageTime[i];
            String[] actual = new String[theUsers.length];
            actual[i] = theUsers[i].toString();
            assertEquals(expected[i], actual[i]);
        }
    }

}