<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="hrd.*" %>    
<%
	ProductVo vo = (ProductVo) request.getAttribute("vo");
%>    
<form id="frm" method="post" onsubmit="return chk()">
	상품번호 : <input type="text" name="p_no" value="<%=vo.getP_no()%>" readonly><br>
	상품이름 : <input type="text" value="<%=vo.getP_name()%>" readonly><br>
	입고수량 : <input type="number" name="i_cnt">
	 <input type="submit" value="입고">
</form>
<a href=""><button>취소</button></a>
<script>
	function chk() {
		if(frm.i_cnt.value == '' || frm.i_cnt.value < 1) {
			alert('입고수량을 확인해 주세요.');
			return false;
		}
		
		return true;
	}
</script>