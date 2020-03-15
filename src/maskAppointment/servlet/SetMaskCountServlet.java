package maskAppointment.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import maskAppointment.dao.AdminDAO;
import maskAppointment.dao.AdminDAOImpl;
import maskAppointment.dao.MaskDAO;
import maskAppointment.dao.MaskDAOImpl;
import maskAppointment.pojo.Mask;
/**
 * Servlet implementation class SetMaskCountServlet
 */
@WebServlet("/setMaskCountServlet")
public class SetMaskCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MaskDAO maskDAO = new MaskDAOImpl();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetMaskCountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Mask maskCntMask = new Mask();
		maskCntMask = maskDAO.getMask();
		System.out.println("total:"+maskCntMask.getTotalCount());
		System.out.println("remain:"+maskCntMask.getRemainCount());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
