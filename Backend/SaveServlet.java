

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Servlet implementation class SaveServlet
 */
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String url = "jdbc:mysql://localhost/tasktodolistdb";
    private static final String user = "root"; 
    private static final String password = "Programmerrina2002*"; 
    
   
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String startDate = request.getParameter("start date");
        String dueDate = request.getParameter("Due Date");
        String status = request.getParameter("status");

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            TaskManager taskManager = new TaskManager();
            taskManager.addTask(name, description, startDate, dueDate, status);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        request.getRequestDispatcher("HtmlPage1.html").include(request, response);
        out.close();
    }

}
			
		
