import java.sql.*;
import java.util.Date;

public class TaskManager {
	private static final String url = "jdbc:mysql://localhost/tasktodolistdb";
    private static final String user = "root"; 
    private static final String password = "Programmerrina2002*"; 
    private static  Connection conn;

    public TaskManager() {
        try {
            conn = DriverManager.getConnection(url, user, password);
         
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addTask(String taskName, String description, String startDate, String dueDate, String status) {
        try {
        	if (conn == null) {
        	    // handle the error here, e.g. throw an exception or print an error message
        	    return;
        	}
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Tasks (TaskName, Description, StartDate, DueDate, Status) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, taskName);
            ps.setString(2, description);
            ps.setString(3, startDate);
            ps.setString(4, dueDate);
            ps.setString(5, status);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  void removeTask(int taskId) {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Tasks WHERE TaskId = ?");
            ps.setInt(1, taskId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  void updateTask(int taskId, String taskName, String description, String startDate, String dueDate, String status) {
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE Tasks SET TaskName = ?, Description = ?, StartDate = ?, DueDate = ?, Status = ? WHERE TaskId = ?");
            ps.setString(1, taskName);
            ps.setString(2, description);
            ps.setString(3, startDate);
            ps.setString(4,  dueDate);
            ps.setString(5, status);
            ps.setInt(6, taskId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  ResultSet getTasks() {
    	
        ResultSet rs = null;
        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM Tasks");
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
        
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}


