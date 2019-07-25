package hrd;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/productIm")
public class ProductImport extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String p_no = request.getParameter("p_no");		
		ProductVo vo = new ProductVo();
		vo.setP_name("");
		
		System.out.println("p_no : " + p_no);
		if(p_no != null && !p_no.equals("")) { //정정
			vo = DAO.getProduct(Integer.parseInt(p_no));
		}
		request.setAttribute("vo", vo);
		request.setAttribute("view", "productIm.jsp");
		request.getRequestDispatcher("temp.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int p_no = Integer.parseInt(request.getParameter("p_no"));
		int i_cnt = Integer.parseInt(request.getParameter("i_cnt"));
		
		int result = DAO.regProductIm(p_no, i_cnt);
		if(result == 1) {
			DAO.updateProductStock(p_no, i_cnt);
		}
		
		response.sendRedirect("productList");
		
	}

}
