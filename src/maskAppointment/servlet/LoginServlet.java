package maskAppointment.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import maskAppointment.dao.AdminDAO;
import maskAppointment.dao.AdminDAOImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminDAO adminDAO = new AdminDAOImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nameString = request.getParameter("name");
		String passwdString = request.getParameter("password");
		String passwdResult = adminDAO.getPasswd(nameString);
		if(passwdResult.equals("")) {
			//账号不存在
		}else if(passwdResult.equals(passwdString)) {
			//密码正确
		}else {
			//密码错误
		}
			
		/*if (nameString.equals("admin") && passwdString.equals("123456")) {
			request.getSession().setAttribute("isLogged", "logged");
			request.getRequestDispatcher("userServlet").forward(request,response);
			
		}else {
			System.out.println("passwd error");
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
