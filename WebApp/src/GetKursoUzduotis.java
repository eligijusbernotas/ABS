

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import BaluSistema.BaluSistema;
import BaluSistema.Uzduotis;

/**
 * Servlet implementation class GetKursoUzduotis
 */
@WebServlet("/GetKursoUzduotis")
public class GetKursoUzduotis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetKursoUzduotis() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BaluSistema bs = new BaluSistema();
		List<Uzduotis> dataList = bs.getKursoUzduotis(request.getParameter("kursoKodas"));
		String json = new Gson().toJson(dataList);
		 response.getWriter().write(json);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BaluSistema bs = new BaluSistema();
		List<Uzduotis> dataList = bs.getKursoUzduotis(request.getParameter("kursoKodas"));
		request.setAttribute("data", dataList);
		 RequestDispatcher dispatcher = request.getRequestDispatcher("KursoUzduotys.jsp");

		  if (dispatcher != null){

		  dispatcher.forward(request, response);

		  } 

		doGet(request, response);
	}

}
