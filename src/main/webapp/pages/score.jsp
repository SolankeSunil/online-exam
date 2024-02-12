<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">   
<title>score</title>
<script>

</script>
</head>
<body >
  <div>
<!-- ${answerList} --> 
 <span>Your Score is: ${score}</span>
 <table>
 <tr>
  <th>qno</th>
  <th>Question</th>
  <th>Submitted Question</th>
  <th>Correct Answer</th>
 </tr>
 <tbody>
 <c:forEach var="answer" items="${answerList}">
 <tr>
 <td>${answer.qno}</td>
 <td>${ answer.question}</td>
 <td>${ answer.yourAnswer}</td>
 <td>${answer.currectAnswer}</td>
 </tr>
 </c:forEach>
 </tbody>
 </table>
 
  <a href="login?username=${username}&password=${password}">Home</a> <br> <br>
   <a href="logOut">Log out</a>
</div>

</body>
<style>
span{
font-size: 20px;
color : red;
}
table{
margin-top: 50px;
}

table,th,td{
border: 1px solid black;
border-collapse: collapse;

}
th,td{
padding: 15px;
}
th{
background-color: gray;
color: white;
}
td{
background-color: teal;
color: white;
}
body{
background-color: yellow;
}
  
</style>

</html>