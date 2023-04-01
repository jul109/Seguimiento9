package ui;

import java.util.Scanner;
import model.Controller;
import java.util.GregorianCalendar;


public class Main{

	private Scanner reader;
	private Controller controller;
	public static final int TOTAL_PROJECT_TYPES=3;

	public Main() {

		reader = new Scanner(System.in);
		controller = new Controller();
	}

	public static void main(String[] args) {

		Main exe = new Main();	
		exe.menu();
		System.out.println("Bye");
		
	}


	public void menu() {
		
		boolean execute=true;
		int option=-1;
		while(execute){
			System.out.println("Type 1 to register a project");
			System.out.println("Type 2 to search a project that ends before a date");
			System.out.println("Type 3 to search a project that begins after a date");
			System.out.println("Type 4 to exit the program");
			option=validateIntegerInput();
			switch (option) {
				case 1:
					RegisterProject();
					break;
				case 2:
					searchProjectsBeforeDate();
					break;
				case 3:
					searchProjectsAfterDate();
					break;
				case 4:
					execute=false;
					break;
				default:
					System.out.println("Invalid option");
			}
		}
	}

	public void RegisterProject() {
		
		String name,clientName;
		double budget;
		GregorianCalendar initialCalendar;
		GregorianCalendar finalCalendar;
		int projectType;
		
		System.out.println("Type the name of the project");
		name=reader.next();
		reader.nextLine();
		
		System.out.println("Type the name of the client");
		clientName=reader.next();
		reader.nextLine();
		
		System.out.println("Type the budget");
		budget=validatePositiveDouble();
		
		System.out.println("Type the type of the project");
		projectType=validateProjectType();

		System.out.println("Register the initial date");
		initialCalendar=requestDate();
		System.out.println("Initial date registered");
		System.out.println("Register the final date");
		finalCalendar=requestDate();
		System.out.println("Final date registered");

		
		boolean isAdded= controller.RegisterProject(name,clientName,budget,projectType,initialCalendar,finalCalendar);
		if(isAdded){
			System.out.println("The project was added");
		}else{
			System.out.println("The project the total of projects is at limit");
		}
		
	}

	public void searchProjectsAfterDate(){
		GregorianCalendar date=requestDate();
		String msg= controller.searchProjectsAfterDate(date);
		System.out.println(msg);
	}
	public void searchProjectsBeforeDate(){
		GregorianCalendar date=requestDate();
		String msg= controller.searchProjectsBeforeDate(date);
		System.out.println(msg);
	}

	
	





	/*|||||||||||||||||||||||||||||||||||||||||||||| VALIDATIONS||||||||||||||||||||||||||||||||*/
	public int validateIntegerInput(){
		int x=-1;
		if(reader.hasNextInt()){
			x=reader.nextInt();
		}else{
			reader.nextLine();
		}
		return x;
	}


	public double validateDoubleInput(){
		double x=-1;
		if(reader.hasNextDouble()){
			x=reader.nextDouble();
		}else{
			reader.nextLine();
		}
		return x;
	}
	public double validatePositiveDouble(){
		double x=-1;
		while(x<=0){
			x=validateDoubleInput();
			if(x<=0){
				System.out.println("Invalid value");
			}
		}
		return x;
	}

	public GregorianCalendar requestDate(){
		int day=-1,month=-1,year=-1;

		while(! (1<=day&& day<=31  ) ){
			System.out.println("Type the day");
			day=validateIntegerInput();
			if( !(1<=day&& day<=31)  ){
				System.out.println("Invalid value");
			}
		}
		
		while(! (1<=month&&month<=12  ) ){
			
			System.out.println("Type the month");
			month=validateIntegerInput();
			if(!  (1<=month&&month<=12)  ){
				System.out.println("Invalid value");
			}
		}
		
		while(year<=0){
			System.out.println("Type the year");
			year=validateIntegerInput();
			if(year<=0){
				System.out.println("Invalid year");
			}
		}
		GregorianCalendar calendar=new GregorianCalendar(year,month-1,day);
		return calendar;
	}
	
	public int validateProjectType(){
		int projectType=-1;
		while( !(1<=projectType &&projectType<=TOTAL_PROJECT_TYPES) ){
			
			System.out.println("Choose the project type. 1 DEVELOPMENT. 2 MAINTENANCE. 3 DEPLOYMENT");
			
			projectType=validateIntegerInput();
			if( !  (1<=projectType &&projectType<=TOTAL_PROJECT_TYPES) ){
				System.out.println("Invalid option");
			}
		}
		return projectType;

	}

}
