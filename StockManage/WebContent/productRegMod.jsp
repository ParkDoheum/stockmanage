<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="hrd.*" %>
<%
	ProductVo vo = (ProductVo) request.getAttribute("vo");
	String price = vo.getP_price() == 0 ? "" : Integer.toString(vo.getP_price());
	
	String btnValue = "상품 정보 정정";	
	if(vo.getP_no() == 0) {
		btnValue = "신규 상품 추가";		
	}
%>    
<form method="post">
	<% if(vo.getP_no() != 0)  { %>
	상품번호 : <input type="number" name="p_no" value="<%=vo.getP_no() %>" readonly><br>
	<% } %>
	상품이름 : <input type="text" name="p_name" value="<%=vo.getP_name() %>"><br>
	상품단가 : <input type="number" name="p_price" value="<%=price %>"><br>
	<input type="submit" value="<%=btnValue %>">
</form>
<a href="productList"><button>취소</button></a>