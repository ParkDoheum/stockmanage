<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.*" %>
<%@ page import="hrd.*" %>    
<%
	List<ProductVo> list = (List<ProductVo>)request.getAttribute("list");
%>

<table>
	<tr>
		<th>상품 번호</th>
		<th>상품 이름</th>
		<th>누적 입고</th>
		<th>잔존 수량</th>
		<th>상품 단가</th>
		<th>동작</th>
	</tr>
	<% for(ProductVo vo : list) { %>
	<tr>
		<td><%=vo.getP_no() %></td>
		<td><%=vo.getP_name() %></td>
		<td><%=vo.getP_cnt_sum() %></td>
		<td><%=vo.getP_cnt_rem() %></td>
		<td><%=vo.getP_price() %></td>
		<td>
			<a href="productRegMod?p_no=<%=vo.getP_no()%>"><button>정정</button></a>
			<a href="productIm?p_no=<%=vo.getP_no()%>"><button>입고</button></a>
			<button onclick="delConfirm(<%=vo.getP_no()%>)">삭제</button>
		</td>
	</tr>
	<% } %>
</table>

<a href="productRegMod"><button>신규상품추가</button></a>
<script>
	function delConfirm(p_no) {
		if(confirm('정말로 해당 상품을 삭제합니까?')){
				location.href = 'productDel?p_no=' + p_no;
		} 
	}
</script>









