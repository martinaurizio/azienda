package azienda;

import java.sql.Date;
import java.util.ArrayList;

public class AziendaView {
	
	/**
	 * Display the list of all tasks included in the database
	 * @param listOfTasks is the ArrayList that contains the tasks retrieved from the database.
	 */
	public void displayListOfTasks (ArrayList<Task> listOfTasks) {
		System.out.println(listOfTasks);
	}
	
	public void displayNewCreatedTask (Task newCreatedTask) {
		System.out.println("New task created: " + newCreatedTask);
	}
	
	public void displayNewAssignedTask(String IDforTaskToAssign, String CFofDevForNewTaskToAssign) {
		System.out.println("The task " + IDforTaskToAssign + " has been assigned to " + CFofDevForNewTaskToAssign);
	}
	
	public void displayNewAssignedTask(Task newAssignedTask, Dev devToAssignTask) {
		System.out.println("The task " + newAssignedTask.getCodice() + " has been assigned to " + devToAssignTask.getCF());
	}

	public void displayDeletedTaskFromDev(String CFDev, String IDofTaskToDelete) {
		System.out.println("The task " + IDofTaskToDelete + " is not more assigned to " + CFDev);
	}
	
	public void displayPm(Pm pmToDisplay) {
		System.out.println(pmToDisplay);
	}
	
	public void displayListOfProjects(ArrayList<Progetto> listOfCrossTeamProjects) {
		System.out.println(listOfCrossTeamProjects);
	}
	
	public void displayEmployee(String newName, String newSurname, String newCF) {
		System.out.println("New Employee created: name= " + newName + ", surname= " + newSurname
				+ ", CF= " + newCF);
	}
	
	public void displayDev(int newMatricola, Date newDataAssunzione, 
			String newCF, String newCFAgente) {
		System.out.println("New DEV created: matricola= " + newMatricola + ", recruitment date= "
				+ newDataAssunzione + ", CF= " + newCF + ", CF of Contact PM= " + newCFAgente);
	}
	
	public void displayNewAssignedTeam(String nameTeamToAssign, String CFofDevForNewTeamToAssign) {
		System.out.println("The DEV " + CFofDevForNewTeamToAssign + " has been assigned to team " + nameTeamToAssign);
	}

}
