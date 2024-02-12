<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>wellcome page</title>
<link href="/css/style.css" rel="stylesheet">
<script>
var xmlhttp;

function getSubjects()
{
	xmlhttp=new XMLHttpRequest();

	xmlhttp.onload=showAllSubjects;
	
	xmlhttp.open("get","getSubjects",true);

	xmlhttp.send();
	
}

function showAllSubjects()
{
	
	var allsubjects =JSON.parse(xmlhttp.responseText);
	// alert(allsubjects); 
	
	var combobox=document.getElementById("selectedSubject");

	for(var i=0;i<allsubjects.length;i++)
	{
		var option=document.createElement('option');
		option.text=allsubjects[i];//java
		option.value=allsubjects[i];//java
		combobox.add(option);
	}
}

</script>

</head>
<body onload="getSubjects()">
<h3>${msg}</h3>
<form>
<select name="subject" id='selectedSubject'>
 <option value='select subject' >select subject</option>

 </select>
<input type="submit" value="start exame" class="btn" formmethod="post" formaction='startexame'>
</form>
</body>
<style>
#selectedSubject:hover
{
background-color: black;
color: white;
height: 40px;
width: 100px;
margin-right: 80px;
border-radius: 10px;

}
#selectedSubject
{
background-color: white;
color: black;
height: 40px;
width:100px;
margin-right: 80px;
border-radius: 10px;
}

</style>
</html>