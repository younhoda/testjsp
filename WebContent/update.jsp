<%@page import="product.ProductDTO"%>
<%@page import="product.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<body>



<jsp:useBean id="dto" class="product.ProductDTO"/> 
<jsp:setProperty property="*" name="dto"/>

	<%
	ProductDAO dao = new ProductDAO();
	
	%>
	<div align="center">
		<font size="3">게시글이 다음과 같이 수정되었습니다.</font>
		<hr>
		<table border="1">
			<tr align="center">
				<td bgcolor="white" width="100">항목</td>
				<td bgcolor="green" width="300">내용</td>
			</tr>
			<tr align="center">
				<td bgcolor="white" width="100">상품아이디</td>
				<td bgcolor="green" width="300"><%=dto.getId()%></td>
			</tr>
			<tr align="center">
				<td bgcolor="white" width="100">상품제목</td>
				<td bgcolor="green" width="300"><%=dto.getTitle()%></td>

			</tr>
			<tr align="center">
				<td bgcolor="white" width="100">상품설명</td>
				<td bgcolor="green" width="300"><%=dto.getName()%></td>

			</tr>
			<tr align="center">
				<td bgcolor="white" width="100">내용</td>
				<td bgcolor="green" width="300"><%=dto.getPrice()%></td>

			</tr>



		</table>
	</div>
</body>
</html>