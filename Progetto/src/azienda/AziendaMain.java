package azienda;

import java.sql.Date;
import java.sql.SQLException;

/**
 *  
 * @author Martina Urizio
 *
 */

public class AziendaMain {
	
	public static void main (String[] args) throws SQLException {		
		AziendaView view = new AziendaView();
		AziendaController controller = new AziendaController(view);
		
		String str="2023-04-06";
		Date dateOfDevAssumption =Date.valueOf(str);
		String str1 = "2023-04-30";
		Date dateOfNewTask = Date.valueOf(str1);
		
		Dev d1 = new Dev("Chiara", "Scura", 182, dateOfDevAssumption, "CHRSCR90FEPS902D", "RSSMRA78RADP293S");
		Task t1 = new Task("AAABBBCCC111", "WEB0000381000000000002201VE", "Provare esperimento aggiunta", 
						false, dateOfDevAssumption, "SNDLSA84FWOQ201S");
		
		//controller.getListOfTasks();
		
		//controller.deleteTaskDev(d1, t1);
		//controller.deleteTaskDev("CHRSCR90FEPS902D", "AAABBBCCC111");
		
		//controller.createNewTask("AAABBBCCC111", "WEB0000381000000000002201VE", "Provare esperimento aggiunta", 
		//				false, dateOfNewTask, "SNDLSA84FWOQ201S");
		//controller.assignNewTaskToDev("AAABBBCCC111", "CHRSCR90FEPS902D");
		
		//controller.getListOfCurrentTaskDev(d1);
		
		//controller.checkContactPmForDev(d1);
		
		//controller.getListOfCrossTeamProjects();
		
		//controller.createNewDev("Alex", "Andro", 200, dateOfDevAssumption, "LXANDR94PANO294T", "RSSMRA78RADP293S");
		//controller.assignNewDevToTeam("TeamA", "LXANDR94PANO294T");
	}
}
