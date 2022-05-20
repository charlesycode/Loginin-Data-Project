import java.util.ArrayList;

//denise dreyer
//December 6, 2021
//Class to represent a user and all it's login data


public class User {
	private String email;
	private String password;
	private int[] sessionTimes;
	private String username;
	
	//constructor
	public User(String email, int[] sessionTimes, String password) {
		this.email=email;
		this.password = password;
		this.sessionTimes=sessionTimes;
	}
	
	
	//getter for email field
	public String getEmail() {
		return email;
	}
	//getter for password
	public String getPassword() {
		return password;
	}
	//getter for SessionTimes field
	public int[] getSessionTimes() {
		return sessionTimes;
	}
	
	//returns the username
	public String getUsername() {
		int a = email.indexOf("@") - 2;
		username = email.charAt(a-1) + email.substring(2, a-1);;
		return username;
	}
	
	//strips the domain and extra numbers from the email.  
	//puts the first initial before the last name
//	public String emailToUserName() {
//		return "";
//	}
//	
	//adds up all the session times
	public int getTotalTimeSpent() {
		int totalTime = 0;
		for (int i = 0; i < sessionTimes.length; i ++) {
			totalTime+= sessionTimes[i];
		}
		return totalTime;
	}
	
	//calculates the average session time
	public double average() {
		double total = getTotalTimeSpent();
		return total/(sessionTimes.length);
	}
	
	//returns a string describing all the info for a user
	public String toString(User user) {
		String str = user.getUsername() + "\nPassword: " + user.getPassword() + "\nLogged in: " +  user.getSessionTimes().length + " times\nTotal time spent: " + user.getTotalTimeSpent() + "\nAverage Session Length: " + user.getAverage();
		return str;
	}
	
	private String getAverage() {
		// TODO Auto-generated method stub
		return null;
	}


	//rounds to 2 decimal places
	public static double round2(double x) { //accepts a double and rounds it to 2 decimal places
		if (x>0) {
			double result1 = (x * 100) + 0.5;
			int result2 = (int)result1;
			double result3 = (double)result2;
			double result4 = result3 / 100;
			return result4;
		}else {
			double result1 = (x * 100) - 0.5;
			int result2 = (int)result1;
			double result3 = (double)result2;
			double result4 = result3 / 100;
			return result4;
		}
	}
	private void setDefaultPassword() {
		if (getUsername().length()<=5) {
			password = getUsername().substring(1) + "_" + getUsername().substring(0,1) + "_2021";
		} else {
			password = getUsername().substring(1,5) + "_" + getUsername().substring(0,1) + "_2021";
		}
	}
	public User(String email, int[] sessionTimes) {
		this.email = email;
		this.sessionTimes = sessionTimes;
		setDefaultPassword();
	}
	public void removeInactiveUser(ArrayList<User> users) {
		for (int i = 0; i < users.size(); i++) {
			if(users.get(i).getTotalTimeSpent() < 10) {
				users.remove(i);
			}
		}
	}
	//changes password
	public void changePassword(String newPwd) {
		this.password = newPwd;
	}
	
	//accepts a new time and adds it to the existing array
	public void addNewSession(int newtime) {
		int[] arr = new int[sessionTimes.length + 1];
		for (int i = 0; i < sessionTimes.length; i ++) {
			arr[i] = sessionTimes[i];
		}
		arr[sessionTimes.length]= newtime;
		this.sessionTimes = arr;

	}
}

