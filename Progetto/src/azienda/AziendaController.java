package azienda;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Methods for read/write/update/query the db "azienda"
 * @author Martina Urizio
 *
 */

public class AziendaController {
	
	private AziendaView view;
		
	public AziendaController(AziendaView view) {
		super();
		this.view = view;
	}
	
	/**
	 * List all the tasks in the database
	 * @throws SQLException
	 */
	public void getListOfTasks() throws SQLException {
		ArrayList<Task> listTask = new ArrayList<Task>();
		Connection cn;
		Statement st;
		ResultSet rs;
		String sql;
		//connection
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}
		
		//connection with database
		cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/azienda?user=root&password=");
		//query
		sql="SELECT * FROM task;";
		
		try {
			st = cn.createStatement(); //Once created a Statement object, it can be used...
			rs = st.executeQuery(sql); //...to execute an SQL statement
			//executeQuery (String sql) returns a ResultSet object, with the expected data to be retrieved
			
			while (rs.next() == true) {
				Task taskForList = new Task(rs.getString("ID"), rs.getString("codice"), 
						rs.getString("descrizione"), rs.getBoolean("status"), 
						rs.getDate("deadline"), rs.getString("CF_pm"));
				listTask.add(taskForList);
			}
		} catch (SQLException e) {
			System.out.println("error: " + e.getMessage());
		}
		cn.close(); //close connection
		view.displayListOfTasks(listTask); //display the list of all tasks
	}
	
	/**
	 * Delete a task from the list of assigned task of a DEV.
	 * @param devForDeletingTask is the String that contains the fiscal code of Dev to which delete the chosen task
	 * @param taskToDelete is the String that contains the ID of the task to delete/not assign anymore to devForDeletingTask
	 */
	public void deleteTaskDev(String CFofDevForDeletingTask, String IDofTaskToDelete) {
		Connection cn;
		Statement st;
		String sql;
		//connection
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("com.mysql.jdbc.Driver");
			System.err.println(e.getMessage());
		}
		
		try {
			//connection with database
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/azienda?user=root&password=");
			
			sql = "DELETE FROM task_dev WHERE ID='" + IDofTaskToDelete + "' AND CF='" + CFofDevForDeletingTask + "'";
			
			st = cn.createStatement();  //Once created a Statement object, it can be used...
			st.execute(sql); 			//...to execute an SQL statement
			//execute(String sql) returns a boolean value of true if a ResultSet object can be retrieved; 
			//otherwise, it returns false.
			cn.close(); //close connection
			view.displayDeletedTaskFromDev(CFofDevForDeletingTask, IDofTaskToDelete); //display the performed deletion
		} catch (SQLException e) {
			System.out.println("error: " + e.getMessage());
		}
	}
	
	/**
	 * Delete a task from the list of assigned task of a DEV.
	 * @param devForDeletingTask is the object Dev to which delete the chosen task
	 * @param taskToDelete is the object Task to delete/not assign anymore to devForDeletingTask
	 */
	public void deleteTaskDev(Dev devForDeletingTask, Task taskToDelete) {
		Connection cn;
		Statement st;
		String sql;
		//connection
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("com.mysql.jdbc.Driver");
			System.err.println(e.getMessage());
		}
		
		try {
			//connection with database
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/azienda?user=root&password=");
			
			String IDofTaskToDelete = taskToDelete.getID();
			String CFDev = devForDeletingTask.getCF();
			
			sql = "DELETE FROM task_dev WHERE ID='" + IDofTaskToDelete + "' AND CF='" + CFDev + "'";
			
			st = cn.createStatement();  //Once created a Statement object, it can be used...
			st.execute(sql); 			//...to execute an SQL statement
			//execute(String sql) returns a boolean value of true if a ResultSet object can be retrieved; 
			//otherwise, it returns false.
			cn.close(); //close connection
			view.displayDeletedTaskFromDev(CFDev, IDofTaskToDelete); //display the performed deletion
		} catch (SQLException e) {
			System.out.println("error: " + e.getMessage());
		}
	}
	
	/**
	 * Create a new task to insert in the database.
	 * @param IDforNewTask is the String that contains the new task ID
	 * @param codiceForNewTask is the String that represents the new task code
	 * @param descrizioneForNewTask is the String that contains the new task description
	 * @param statusForNewTask is the boolean value that describes the status for the new task:
	 * if it is true, the task is not yet completed (before the deadline date), otherwise it is closed.
	 * This parameter becomes, respectively, 1 or 0 as database value.
	 * The database contains a trigger which forces status to be 0 if the deadline date exceed the current date. 
	 * @param deadlineForNewTask is the deadline date for the task.
	 * @param CFforNewTask is the String that contains the fiscal code of the PM that creates the task.
	 * @throws SQLException
	 */
	public void createNewTask(String IDforNewTask, String codiceForNewTask, String descrizioneForNewTask, 
			boolean statusForNewTask, Date deadlineForNewTask, String CFforNewTask) throws SQLException {
		Connection cn;
		Statement st;
		String sql;
		//connection
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("com.mysql.jdbc.Driver");
			System.err.println(e.getMessage());
		}
		
		try {
			//connection with database
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/azienda?user=root&password=");
			
			//Status becomes, respectively, 1 or 0 as database value.
			int statusTask = 0;
			if (statusForNewTask == true) {
				statusTask = 1;
			}
			
			Task newCreatedTask = new Task(IDforNewTask, codiceForNewTask, descrizioneForNewTask, statusForNewTask,
					deadlineForNewTask, CFforNewTask);
			
			sql = "INSERT INTO task (ID, codice, descrizione, status, deadline, CF_pm) VALUES ('" + 
					IDforNewTask + "', '" + codiceForNewTask + "', '" + descrizioneForNewTask + "', " + 
					statusTask + ", DATE '" + deadlineForNewTask + "', '" + CFforNewTask + "')";
			
			st = cn.createStatement(); //Once created a Statement object, it can be used...
			st.execute(sql); //...to execute an SQL statement
			//execute(String sql) returns a boolean value of true if a ResultSet object can be retrieved; 
			//otherwise, it returns false.
			cn.close(); //close connection
			view.displayNewCreatedTask(newCreatedTask); //display the data of created task
		} catch (SQLException e) {
			System.out.println("error: " + e.getMessage());
		}
	}
	
	/**
	 * Assign a task to a chosen DEV.
	 * @param IDforTaskToAssign is the String that contains the ID of the task to be assigned. 
	 * @param CFofDevForNewTaskToAssign is the String that contains the fiscal code of the DEV to which assign the task.
	 */
	public void assignNewTaskToDev (String IDforTaskToAssign, String CFofDevForNewTaskToAssign) {
		Connection cn;
		Statement st;
		ResultSet rs;
		String sql;
		String codiceOfProjectForNewTask = "";
		//connection
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("com.mysql.jdbc.Driver");
			System.err.println(e.getMessage());
		}

		try {
			//connection with database
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/azienda?user=root&password=");
			
			sql = "SELECT codice FROM task WHERE ID = '" + IDforTaskToAssign + "'";
			
			st = cn.createStatement(); //Once created a Statement object, it can be used...
			rs = st.executeQuery(sql); //...to execute an SQL statement
			if(rs.next()){
				codiceOfProjectForNewTask = rs.getString("codice");
			}
			//executeQuery (String sql) returns a ResultSet object, with the expected data to be retrieved
			
			sql = "INSERT INTO task_dev (ID, CF, codice) VALUES ('" + IDforTaskToAssign + "', '" + 
					CFofDevForNewTaskToAssign + "', '"+ codiceOfProjectForNewTask + "')";
			
			st.execute(sql); 
			//execute(String sql) returns a boolean value of true if a ResultSet object can be retrieved; 
			//otherwise, it returns false.
			cn.close(); //close connection
			view.displayNewAssignedTask(IDforTaskToAssign, CFofDevForNewTaskToAssign); //display the performed assignment
		} catch (SQLException e) {
			System.out.println("error: " + e.getMessage());
		}
		
	}
	
	/**
	 * Assign a task to a chosen DEV.
	 * @param taskToAssign is the object Task that represents the task to be assigned
	 * @param devForNewTaskAssignment is the object DEV to which assign the taskToAssign
	 */
	public void assignNewTaskToDev (Task taskToAssign, Dev devForNewTaskAssignment) {
		Connection cn;
		Statement st;
		String sql;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("com.mysql.jdbc.Driver");
			System.err.println(e.getMessage());
		}
		
		try {
			//connection with database
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/azienda?user=root&password=");
			
			String IDforTaskToAssign = taskToAssign.getID();
			String CFofDevForNewTaskToAssign = devForNewTaskAssignment.getCF();
			String CodiceOfProjectForNewTask = taskToAssign.getCodice();

			sql = "INSERT INTO task_dev (ID, CF, codice) VALUES ('" + IDforTaskToAssign + "', '" + 
					CFofDevForNewTaskToAssign + "', '"+CodiceOfProjectForNewTask +"')";
			
			st = cn.createStatement();  //Once created a Statement object, it can be used...
			st.execute(sql); 			//...to execute an SQL statement
			//execute(String sql) returns a boolean value of true if a ResultSet object can be retrieved; 
			//otherwise, it returns false.
			cn.close(); //close connection
			view.displayNewAssignedTask(taskToAssign, devForNewTaskAssignment); //display the performed assignment
		} catch (SQLException e) {
			System.out.println("error: " + e.getMessage());
		}
	}
	
	/**
	 * List all the current task that a DEV is working on.
	 * @param devWorkingOnTasks is an object Dev that represents the DEV to check for tasks
	 * @throws SQLException
	 */
	public void getListOfCurrentTaskDev(Dev devWorkingOnTasks) throws SQLException {
		ArrayList<Task> listTask = new ArrayList<Task>();
		Connection cn;
		Statement st;
		ResultSet rs;
		String sql;
		//connection
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}
		
		//Connection with database
		cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/azienda?user=root&password=");
		
		String CFofDevToCheckTasks = devWorkingOnTasks.getCF();
		
		//query
		sql="SELECT `task`.`ID`, `task`.`codice`, `task`.`descrizione`, `task`.`status`, "
				+ "`task`.`deadline`, `task`.`CF_pm`, `task_dev`.`CF` FROM `task` INNER JOIN "
				+ "`task_dev` ON `task`.`ID` = `task_dev`.`ID` "
				+ "WHERE `task_dev`.`CF` = '" + CFofDevToCheckTasks + "' AND `task`.`status` = 1";
		
		try {
			st = cn.createStatement(); //Once created a Statement object, it can be used...
			rs = st.executeQuery(sql); //...to execute an SQL statement
			//executeQuery (String sql) returns a ResultSet object, with the expected data to be retrieved
			
			while (rs.next() == true) {
				Task taskForList = new Task(rs.getString("ID"), rs.getString("codice"), 
						rs.getString("descrizione"), rs.getBoolean("status"), 
						rs.getDate("deadline"), rs.getString("CF"));
				listTask.add(taskForList);
			}
		} catch (SQLException e) {
			System.out.println("error: " + e.getMessage());
		}
		cn.close(); //close connection
		view.displayListOfTasks(listTask); //display the list of current tasks of the chosen dev
	}
	
	/**
	 * Get the contact PM for a chosen DEV.
	 * @param devToCheckForContactPm is the object Dev that represents the DEV to check for her contact PM.
	 * @throws SQLException
	 */
	public void checkContactPmForDev(Dev devToCheckForContactPm) throws SQLException {
		Pm contactPm = new Pm();
		Connection cn;
		Statement st;
		ResultSet rs;
		String sql;
		//connection
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}
		
		//connection with database
		cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/azienda?user=root&password=");
		
		String CFofDevToCheckTasks = devToCheckForContactPm.getCF();
		
		//query
		sql= "SELECT DISTINCT `impiegato`.`nome`, `impiegato`.cognome, `pm`.`matricola`, "
				+ "`pm`.`dataAssunzione`, `pm`.`CF`, `pm`.`CFAgente` FROM `team_dev` INNER JOIN "
				+ "(`team_pm` INNER JOIN (`pm` INNER JOIN `impiegato` ON `pm`.`CF`=`impiegato`.`CF`) "
				+ "ON `team_pm`.`CF` = `pm`.`CF`) ON `team_pm`.`nome`=`team_dev`.`nome` WHERE "
				+ "`team_dev`.`CF` = '" + CFofDevToCheckTasks + "'";
		
		try {
			st = cn.createStatement(); //Once created a Statement object, it can be used...
			rs = st.executeQuery(sql); //...to execute an SQL statement
			//executeQuery (String sql) returns a ResultSet object, with the expected data to be retrieved
			
			while (rs.next() == true) {
				contactPm.setNome(rs.getString("nome"));
				contactPm.setCognome(rs.getString("cognome"));
				contactPm.setMatricola(rs.getInt("matricola"));
				contactPm.setDataAssunzione(rs.getDate("dataAssunzione"));
				contactPm.setCF(rs.getString("CF"));
				contactPm.setCFAgente(rs.getString("CFAgente"));
			}
		} catch (SQLException e) {
			System.out.println("error: " + e.getMessage());
		}
		cn.close(); //close connection
		view.displayPm(contactPm); //display the contact PM
	}

	/**
	 * Get the list of all cross team projects.
	 * A project is cross team if it involves in its tasks at least two DEVs that belong to different teams. 
	 * @throws SQLException
	 */
	public void getListOfCrossTeamProjects() throws SQLException {
		ArrayList<Progetto> listOfCrossTeamProjects = new ArrayList<Progetto>();
		Connection cn;
		Statement st;
		ResultSet rs;
		String sql;
		//connection
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}
		
		//Connection with database
		cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/azienda?user=root&password=");
	
		//query
		sql = "SELECT COUNT(*) AS NumberOfTeams, SUB.`codice`, SUB.`CF` FROM (SELECT DISTINCT "
				+ "`progetto`.`CF`, `task_dev`.`codice`, `team_dev`.`nome` FROM `team_dev` "
				+ "INNER JOIN (`task_dev` INNER JOIN `progetto` ON `task_dev`.`codice` = "
				+ "`progetto`.`codice`) ON `team_dev`.`CF` = `task_dev`.`CF`) SUB GROUP BY "
				+ "SUB.`codice` HAVING NumberOfTeams > 1";
		
		try {
			st = cn.createStatement(); //Once created a Statement object, it can be used...
			rs = st.executeQuery(sql); //...to execute an SQL statement
			//executeQuery (String sql) returns a ResultSet object, with the expected data to be retrieved
			
			while (rs.next() == true) {
				Progetto taskForList = new Progetto(rs.getString("codice"), rs.getString("CF"));
				listOfCrossTeamProjects.add(taskForList);
			}
		} catch (SQLException e) {
			System.out.println("error: " + e.getMessage());
		}
		cn.close(); //close connection
		view.displayListOfProjects(listOfCrossTeamProjects); //display list of all cross team projects
	}
	
	/**
	 * Create a new Employee to insert in the database.
	 * @param newName is the String that contains the name for the new employee
	 * @param newSurname is the String that contains the surname for the new employee
	 * @param newCF is the String that contains the fiscal code of the new employee
	 */
	private void createNewEmployee(String newName, String newSurname, String newCF) {
		Connection cn;
		Statement st;
		String sql;
		//connection
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("com.mysql.jdbc.Driver");
			System.err.println(e.getMessage());
		}

		try {
			//connection with database
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/azienda?user=root&password=");
			
			sql = "INSERT INTO impiegato (nome, cognome, CF) VALUES ('" + newName + "', '" + 
					newSurname + "', '" + newCF +"')";
			
			st = cn.createStatement(); //Once created a Statement object, it can be used...
			st.execute(sql); //...to execute an SQL statement
			//execute(String sql) returns a boolean value of true if a ResultSet object can be retrieved; 
			//otherwise, it returns false.
			cn.close(); //close connection
			view.displayEmployee(newName, newSurname, newCF); //display the data of the performed insertion
		} catch (SQLException e) {
			System.out.println("error: " + e.getMessage());
		}
	}
	
	/**
	 * Create a new DEV to insert in the database.
	 * @param newMatricola is the int that contains the registration number of the new DEV
	 * @param newDataAssunzione is the recruitment date of the DEV
	 * @param newCF is the fiscal code of the new DEV
	 * @param newCFAgente is the fiscal code of the CEO that hired the new DEV
	 */
	private void createNewDevWithOnlyDevData(int newMatricola, Date newDataAssunzione, 
			String newCF, String newCFAgente) {
		Connection cn;
		Statement st;
		String sql;
		//connection
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("com.mysql.jdbc.Driver");
			System.err.println(e.getMessage());
		}

		try {
			//connection with database
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/azienda?user=root&password=");
			
			sql = "INSERT INTO dev (matricola, dataAssunzione, CF, CFAgente) VALUES ('" + newMatricola 
					+ "', '" + newDataAssunzione + "', '" + newCF + "', '" + newCFAgente + "')";
			
			st = cn.createStatement(); //Once created a Statement object, it can be used...
			st.execute(sql); //...to execute an SQL statement
			//execute(String sql) returns a boolean value of true if a ResultSet object can be retrieved; 
			//otherwise, it returns false.
			cn.close(); //close connection
			view.displayDev(newMatricola, newDataAssunzione, newCF, newCFAgente); //display the data of the performed insertion
		} catch (SQLException e) {
			System.out.println("error: " + e.getMessage());
		}
	}
	
	/**
	 * Insertion of a new DEV.
	 * @param newName is the String that contains the name for the new employee
	 * @param newSurname is the String that contains the surname for the new employee
	 * @param newMatricola is the int that contains the registration number of the new DEV
	 * @param newDataAssunzione is the recruitment date of the DEV
	 * @param newCF is the String that contains the fiscal code of the new employee
	 * @param newCFAgente is the fiscal code of the CEO that hired the new DEV
	 */
	public void createNewDev (String newName, String newSurname, int newMatricola, Date newDataAssunzione, 
			String newCF, String newCFAgente) {
		createNewEmployee(newName, newSurname, newCF);
		createNewDevWithOnlyDevData(newMatricola, newDataAssunzione, newCF, newCFAgente);
	}
	
	/**
	 * Assign a DEV to an existing team.
	 * @param nameTeamToAssign is a String that contains the unique name of an existing team
	 * @param CFofDevForNewTeamToAssign is a String that contains the fiscal code of the DEV
	 */
	public void assignNewDevToTeam (String nameTeamToAssign, String CFofDevForNewTeamToAssign) {
		Connection cn;
		Statement st;
		String sql;
		//connection
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("com.mysql.jdbc.Driver");
			System.err.println(e.getMessage());
		}

		try {
			//connection with database
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/azienda?user=root&password=");
			
			sql = "INSERT INTO team_dev (nome, CF) VALUES ('" + nameTeamToAssign + "', '" + 
					CFofDevForNewTeamToAssign +"')";
			
			st = cn.createStatement(); //Once created a Statement object, it can be used...
			st.execute(sql); //...to execute an SQL statement
			//execute(String sql) returns a boolean value of true if a ResultSet object can be retrieved; 
			//otherwise, it returns false.
			cn.close(); //close connection
			view.displayNewAssignedTeam(nameTeamToAssign, CFofDevForNewTeamToAssign); //display the performed assignment
		} catch (SQLException e) {
			System.out.println("error: " + e.getMessage());
		}
	}
	
}
