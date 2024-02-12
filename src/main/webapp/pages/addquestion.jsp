<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add question page</title>
<style>
#textarea
{
padding:30px;
text-align: center;
}

.qution
{
text-align: center;
padding:  50px;
margin: 50px;
}
</style>
</head>
<body>
<form class='qution' id="f">
 <textarea id="textarea" rows="3" cols="28" name='question' placeholder="inter the question"></textarea><br><br>
 
 <input type='text' placeholder='option1' name='opetion1'><br><br>
 
 <input type='text' placeholder='option2' name='opetion2'><br><br>
 
 <input type='text' placeholder='option3' name='opetion3'><br><br>
 
 <input type='text' placeholder='option4' name='opetion4'><br><br>
 
 <input type='text' placeholder='answer' name='answer'><br><br>
 
 <input type='text' placeholder='subject' name='subject'><br><br>
 
 <input type='submit' value='add question' formaction='addquestion'>
 
  <input type='submit' value='back' formaction='showlogin'> 
</form>
  ${smg}
</body>
</html>


