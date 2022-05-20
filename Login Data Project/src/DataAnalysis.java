import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataAnalysis {

	public static void main(String[] args) throws FileNotFoundException
	{
		File file = new File("dataLog.txt");   
		Scanner input = new Scanner(file);
		ArrayList<User> userList = new ArrayList<User>();
		String next =input.nextLine();
		while (!next.equals("end")) {
			String email=next;
			String password="";
			
			int logins =Integer.parseInt(input.nextLine());
			int[] loginArray=new int[logins];
			
			for (int i = 0; i<logins;i++) {
				int time = Integer.parseInt(input.nextLine());
				loginArray[i]=time;
	
			}
				
			password = input.nextLine();
			User user=new User(email, loginArray, password);
			userList.add(user);
			next =input.nextLine();
		}
		printUserData(userList);
	
	
		input.close();
	}
	public static void printUserData(ArrayList<User> users) {
		for (int i = 0; i < users.size() && users.get(i) != null; i++) {
			System.out.println(users.get(i).getUsername());
			System.out.println("Password: " + users.get(i).getPassword());
			System.out.println("Logged in " + users.get(i).getSessionTimes().length + " times");
			System.out.println("Total Time spent: " + users.get(i).getTotalTimeSpent());
			System.out.println("Average session length: " + users.get(i).average());
			System.out.println("");
		}
	}

	public static void removeInactiveUser(ArrayList<User> users) {
		for (int i = 0; i < users.size(); i++) {
			if(users.get(i).getTotalTimeSpent() < 10) {
				users.remove(i);
			}
		}
	}
	public static String mostExperiencedUser(ArrayList<User> users) {
		String mostExpUsr=users.get(0).getUsername();
		int most = 0;
		for (int i = 1; i < users.size() && users.get(i) != null; i++) {
			if (users.get(i).getTotalTimeSpent() > most) {
				mostExpUsr = users.get(i).getUsername();
				most = users.get(i).getTotalTimeSpent();
			}
		}
		return mostExpUsr;
	}
	public static void addUser(ArrayList<User> users, String email, int timeInFirstSession) {
		int[] array = new int[] {timeInFirstSession};
		User user = new User(email, array);
		users.add(user);	
	}
	
}
