package Task1_School;

import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlSchoolData {
	private Connection connection;
	
	public MySqlSchoolData() {
		try {
			String url = "jdbc:mysql://localhost:3306/school";
			String username = "root";
			String password = "sofiyabulgaria1989";
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection successful");
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void insertDataForTeacher() {
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(
			"INSERT INTO teachers(id, name, email, salary, addressT_id)"
		   +"VALUES(5, 'Ivan Petrov', 'ivan@abv.bg', 1500.00, 5)");
			System.out.println("Insert successful");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void getTeachers(int id) {
		Statement statement = null;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(
			"SELECT name "
		   +"FROM teachers "
		   + "WHERE id="+ id);
			while(resultSet.next()) {
				System.out.println(resultSet.getString("name"));
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void getTeachers() {
		Statement statement = null;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(
			"SELECT name "
		   +"FROM teachers "
		   + "WHERE salary BETWEEN 1000 AND 1900");
			while(resultSet.next()) {
				System.out.println(resultSet.getString("name") + " " + 
								   resultSet.getDouble("salary"));
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void insertDataForStudent() {
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(
			"INSERT INTO students(id, name, enrollmentDate)"
		   +"VALUES(5, 'Ivanka Pavlova', '2006-02-10')");
			System.out.println("Insert successful");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void getStudents() {
		Statement statement = null;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(
					"SELECT name "
				   +"FROM students "
				   +"WHERE enrollmentDate >'2006-10-10'");
			while(resultSet.next()) {
				System.out.println(resultSet.getString("name"));
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void getTeachersAndDisciplines(int id) {
		Statement statement = null;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(
					"SELECT teachers.name, "
					+ "		disciplines.name "
					+ "FROM teachers "
					+ "JOIN disciplines "
					+ "ON teachers.id = disciplines.id "
					+ "WHERE teachers.id = " + id);
					
					
					
					
					
				

			while(resultSet.next()) {
				System.out.println(resultSet.getString("disciplines.name")+ " " +
								   resultSet.getString("teachers.name"));
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
}	
