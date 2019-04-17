
import java.io.IOException;
import java.util.Set;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BaluSistema.BaluSistema;
import BaluSistema.Kursas;

/**
 * Servlet implementation class GetStudentoKursai
 */
@WebServlet("/GetStudentoKursai")
public class GetStudentoKursai extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetStudentoKursai() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BaluSistema bs = new BaluSistema();
		Set<Kursas> dataList = bs.getStudentoKursai(Integer.parseInt(request.getParameter("stud_id")));
		String json = new Gson().toJson(dataList);
		 response.getWriter().write(json);
	}

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
