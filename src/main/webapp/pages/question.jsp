<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>question page</title>
<link href="/css/style.css" rel="stylesheet">
</head>
<body onload="changeColor()">
	<!-- ${question} -->
	<form name='questionForm'>
		Remaining Time:<input type='text' id="time" value="" style="border: none"><br>
		<br> <input type='text' style='border: none' name='qno'
			value='${question.qno}'><br>
		<br>

		<textarea rows="4" cols="30" name='question'>${question.question}</textarea>
		<br>
		<br> <input type='radio' name="option" onclick='saveAnswer()'
			value='${question.opetion1}'> <span>${question.opetion1}
		</span><br>
		<br> <input type='radio' name="option" onclick='saveAnswer()'
			value='${question.opetion2}'> <span>${question.opetion2}
		</span><br>
		<br> <input type='radio' name="option" onclick='saveAnswer()'
			value='${question.opetion3}'> <span>${question.opetion3}
		</span><br>
		<br> <input type='radio' name="option" onclick='saveAnswer()'
			value='${question.opetion4}'> <span>${question.opetion4}
		</span><br>
		<br> <input type='submit' class="btn" value="previous" formaction='previous'>

		<input type='submit' value='next' class="btn"  formmethod="post" formaction="next">

		<input type='submit' value='end exame' class="btn"  formmethod="post" formaction="endeexame"> <br> <br>
		
		<input type='text' style="border: hidden" class="btn"  name="previousAnswer" value='${priviousAnswer}'>
	</form>
	${error}
</body>
<style>
</style>
<script>
	function saveAnswer() {
		var qno = document.questionForm.qno.value;
		var selectedOption = document.questionForm.option.value;
		var question = document.questionForm.question.value;

		var xmlhttp = new XMLHttpRequest();

		//alert("saveAnswer " + qno+" "+selectedOption+" "+question);
		xmlhttp.open("post", "saveResponse?qno=" + qno + "&yourAnswer="
				+ selectedOption + "&question=" + question, true);
		xmlhttp.send();

	}

	function changeColor() {

		var allAnswers = document.getElementsByTagName("span");
		var allRedioButtons = document.getElementsByName("option");
		var previousAnswer = document.questionForm.previousAnswer.value;

		for (var i = 0; i < allAnswers.length; i++) {
			if (allAnswers[i].innerText == previousAnswer) {
				//alert("in if conditon "+allAnswers[i].innerText);
				allAnswers[i].style.color = "red";
				allRedioButtons[i].checked = true;
			}
		}
	}
	var xmlHttp;
	function getTime() {
		xmlHttp = new XMLHttpRequest();
		xmlHttp.onload = showTime;
		xmlHttp.open("get", "getRemeningTime", true);
		xmlHttp.send();

	}

	function showTime() {
		var totalSec = xmlHttp.responseText;
		//alert(totalSec);
		var min=Math.floor(totalSec/60).toString().padStart(2,'0');
		var sec=(totalSec-min*60).toString().padStart(2,'0');
		document.getElementById("time").value = min+":"+sec;
		if (totalSec < 0) {
			alert("Time up");
			location.href = "endeexame"
		}

	}
	setInterval(getTime, 1000);
	</script>
</html>


