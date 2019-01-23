<%@page import="product.ProductDTO" %>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="dao" class="product.ProductDAO"></jsp:useBean>
<%
 ArrayList<ProductDTO>list=dao.selectAll();
 out.print("전체상품내용"+list.size()+"<br>");
%>
<table border="1">
	<td>상품아이디</td>
	<td>상품제목</td>
	<td>상품설명</td>
	<td>상품가격</td>
</tr>
<%
for(int i=0;i<list.size();i++){
	ProductDTO dto=list.get(i);
%>
<tr>
	<td><%= dto.getId() %></td>
	<td><%= dto.getTitle() %></td>
	<td><%= dto.getName() %></td>
	<td> <%=dto.getPrice() %></td>
</tr> 
 	<%	 
 	} 
 	%> 

	
</table>
</body>
</html>