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
<%
String title=request.getParameter("title");
ProductDAO dao=new ProductDAO();
ProductDTO dto=new ProductDTO();

dao.delete(title);
%>
<h3>글이 삭제되었습니다.</h3>
</body>
</html>