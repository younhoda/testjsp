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
String id=request.getParameter("id");
String title=request.getParameter("title");
String name=request.getParameter("name");
String price=request.getParameter("price");

ProductDAO dao=new ProductDAO();
ProductDTO dto=new ProductDTO();

dto.setId(id);
dto.setTitle(title);
dto.setName(name);
dto.setPrice(price);

dao.insert(dto);
%>
상품아이디:<%=id %>입니다.<br>
상품제목:<%=title %>입니다.<br>
상품설명:<%=name %>입니다.<br>
상품가격:<%=price %>입니다.<br>
</body>
</html>