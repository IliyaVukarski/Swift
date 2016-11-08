package Task2_AddressDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class MySqlAddressData {
	private Connection connection;
	
	public MySqlAddressData() {
		try {
			String url = "jdbc:mysql://localhost:3306/addressdb";
			String username = "root";
			String password = "sofiyabulgaria1989";
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection successful");
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void getFullAddress(int id) {
		Statement statement = null;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(""
					+ "SELECT * "
					+ "FROM addresses "
					+ "JOIN streets "
					+ "ON addresses.id = streets.id "
					+ "WHERE addresses.id = 1");
					
			while(resultSet.next()) {
				System.out.println(
				"Number " +	resultSet.getInt("addresses.number") + " " +	
				"Name "	 +	resultSet.getString("streets.name") + " " +
				"Appartment " + resultSet.getInt("addresses.apartmentNo"));	
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void addAddress() {
		
		java.sql.PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(""
					+ "INSERT INTO addresses(id, street_id, number, appartmentNo) "
					+ "VALUES(?, ?, ?, ?)");
			statement.setInt(1, 5);
			statement.setInt(2, 5);
			statement.setInt(3, 14);
			statement.setInt(4, 64);
			System.out.println("Insert successful");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void getAddresses(int id) {
		Statement statement = null;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(
					"SELECT "
					+ "addresses.number, "
					+ "addresses.apartmentNo, "
					+ "streets.name "
					+ "FROM addresses "
					+ "JOIN streets "
					+ "ON addresses.id = streets.id "
					+ "WHERE municipality_id =" + id);
			
			while(resultSet.next()) {
				System.out.println("Number " + resultSet.getInt("addresses.number") + " " +
								   "App No " + resultSet.getInt("addresses.apartmentNo") + " " +
								   "name " + resultSet.getString("streets.name"));
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
}