package registrationformdao;
import java.sql.*;

import registrationformmodel.Student;


public class StudentDao {

    private static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

	public int registerStudent(Student student) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		String INSERT_USERS_SQL = "INSERT INTO student" +
	            "  (id, firstname, lastname, username, password) VALUES " +
	            " (?, ?, ?, ?, ?);";

	        int result = 0;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

	            
	        
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
	            preparedStatement.setInt(1, 1);
	            preparedStatement.setString(2, student.getFirstname());
	            preparedStatement.setString(3, student.getLastname());
	            preparedStatement.setString(4, student.getUsername());
	            preparedStatement.setString(5, student.getPassword());
	            System.out.println(preparedStatement);
	            
	            result = preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            
	            printSQLException(e);
	        }
	        return result;
		
	}




		
	
}