package hrd;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/productRegMod")
public class ProductRegMod extends HttpServlet {
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
		request.setAttribute("view", "productRegMod.jsp");
		request.getRequestDispatcher("temp.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String p_no = request.getParameter("p_no");
		String p_name = request.getParameter("p_name");
		String p_price = request.getParameter("p_price");
		
		int i_p_no = p_no == null ? 0 : Integer.parseInt(p_no);
		
		ProductVo vo = new ProductVo();
		vo.setP_no(i_p_no);
		vo.setP_name(p_name);
		vo.setP_price(Integer.parseInt(p_price));
		
		if(i_p_no == 0) { //등록			
			DAO.insertProduct(vo);
		} else { //수정
			DAO.updateProduct(vo);
		}
		
		response.sendRedirect("productList");
		
	}
	
	
	
	
	
	
	

}
