<%@page import="com.aloha.spring.service.BoardService"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>게시글 수정</h1>
   
   
   

   <form action="${pageContext.request.contextPath }/board/update"
      method="POST">
      <input type="hidden" name="no" value="${board.no}" />
      <table>
         <tr>
            <td><label for="title">제목</label></td>
            <td><input type="text" name="title" value="${board.title}" /></td>
         </tr>
         <tr>
            <td><label for="writer">작성자</label></td>
            <td><input type="text" name="writer" value="${board.writer}" /></td>
         </tr>
         <tr>
            <td><label for="title">내용</label></td>
            <td><textarea rows="5" cols="20" name="content">${board.content}</textarea>
            </td>
         </tr>
      </table>
      <div>
         
         <input type="submit" value="수정" />
               
      </div>
      
      
   </form>
   
   <form action="${pageContext.request.contextPath }/board/delete"
      method="POST">
      <input type="hidden" name="no" value="${board.no}" />
      <input type="submit" value="삭제" />
   </form>
</body>


</html>