package model;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;




public class Project{
	enum ProjectType{
		DEVELOPMENT,
		MAINTENANCE,
		DEPLOYMENT;
	}
	
	private String name;
	private String clientName;
	private GregorianCalendar initialDate;
	private GregorianCalendar finalDate;
	private double budget;
	private ProjectType type;

	public Project(String name, String clientName, double budget, int type, GregorianCalendar initialDate, GregorianCalendar finalDate){

		this.name = name;	
		this.clientName = clientName;
		this.type=fromIntToProjectType(type);
		this.budget = budget;
		this.initialDate=initialDate;
		this.finalDate=finalDate;
	}

	public String getName(){
		return name;
	}
	
	public String getClientName(){
		return clientName;
	}

	public GregorianCalendar getInitialDate(){
		return initialDate;
	}
	
	public String getInitialDateFormated() {
		return calendarToString(initialDate);

	}

	public GregorianCalendar getFinalDate(){
		return finalDate;
	}

	public String getFinalDateFormated(){
		return calendarToString(finalDate);
	}		

	public double getBudget(){
		return budget;
	}

	public String getProjectInfo(){
		return "\nName: " + name + "\nClient: " + clientName + "\nInitial Date: " + getInitialDateFormated() + 
		"\nFinal Date: " + getFinalDateFormated() + "\nTotalBudget: " + budget +"\nProjectType: "+ type.name()+"\n";
	}
	public ProjectType fromIntToProjectType(int option){
		ProjectType possibleValues[]=ProjectType.values();
		return possibleValues[option-1];
	}
	public String calendarToString(GregorianCalendar calendar) {
    	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    	String dateInTxtx = format.format(calendar.getTime());
    	return dateInTxtx;
	}

}


