<%@page import="product.ProductDAO"%>
<%@page import="product.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--jsp주석: include지시자<%include  %>  
taglib지시자 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="yellow">
	<%
	  String id=request.getParameter("id");
	  ProductDAO dao=new ProductDAO();
	  
	  ProductDTO dto=dao.select(id);
	%>
	
	<center>
		<font color="blue" size="6">회원정보 확인</font>
		<hr>
		<form action="update.jsp">
		<table>
			<tr align="center">
				<td bgcolor="yellow" width="100">항목</td>
				<td bgcolor="green" width="300">내&nbsp;용</td>
			</tr>
			<tr align="center">
				<td bgcolor="yellow" width="100">상품아이디</td>
				<td bgcolor="green" width="300">
					<input type="text" name="id" value="<%=dto.getId()%>" readonly="readonly"size="45"> 	
				</td>
			</tr>
			<tr align="center">
				<td bgcolor="yellow" width="100">상품제목</td>
				<td bgcolor="green" width="300">
				<input type="text" name="title" size="45" value="<%=dto.getTitle() %>"> 
				</td>
			</tr>
			<tr align="center">
				<td bgcolor="yellow" width="100">상품내용</td>
				<td bgcolor="green" width="300">
				<input type="text" name="name"size="45" value="<%= dto.getName()%>"> 
				</td>
			</tr>
			<tr align="center">
				<td bgcolor="yellow" width="100">상품가격</td>
				<td bgcolor="green" width="300">
				<input type="text" name="price" size="45" value="<%=dto.getPrice() %>">
						</td>
			</tr>
					<tr align="center">
					<td bgcolor="yellow" colspan="2">
					<input type="submit" value="회원정보 수정 완료"></td>
					</tr>			
			</table>
		</form>
	</center>	
</body>
</html>