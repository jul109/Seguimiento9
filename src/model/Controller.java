package model;
import java.util.GregorianCalendar;

public class Controller {

	private Project[] projects;
	public static final int MAX_PROJECTS=10;

	public Controller() {

		projects = new Project[MAX_PROJECTS];
	
	}
	

	public boolean RegisterProject(String name, String clientName, double budget, int projectType, GregorianCalendar initialDate, GregorianCalendar finalDate) {
		boolean add=false;
		int pos=firstValidPos();
		if(pos!=-1){
			projects[pos]=new Project(name,clientName,budget,projectType,initialDate,finalDate);
			add=true;
		}

		return add;
	}

	public String searchProjectsAfterDate(GregorianCalendar date) {

		String msg = "";
		for(int i=0;i<MAX_PROJECTS;i++){
			if(projects[i]!=null){
				if( date.compareTo(projects[i].getInitialDate()) <0){
					msg+=projects[i].getProjectInfo();
				}
			}
		}
		if(msg==""){
			msg="no project found";
		}

		return msg;

	}

	public String searchProjectsBeforeDate(GregorianCalendar date) {
		String msg = "";
		for(int i=0;i<MAX_PROJECTS;i++){
			if(projects[i]!=null){
				if( date.compareTo(projects[i].getFinalDate()) >0){
					msg+=projects[i].getProjectInfo();
				}
			}
		}
		if(msg==""){
			msg="no project found";
		}

		return msg;

	}
	private int firstValidPos(){
		int pos=-1;
		boolean isFound=false;
		for(int i=0;i<MAX_PROJECTS&&!isFound;i++){
			if(projects[i]==null){
				pos=i;
				isFound=true;
			}
		}
		return pos;
	}


}
