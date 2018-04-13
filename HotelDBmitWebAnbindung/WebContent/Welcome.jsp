<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Hotel xyz</title>
</head>
<body>
<div>
<%
Object username = session.getAttribute("name");
%>
<h1>Wilkommen <%= username %></h1>
</div>
<div>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Buchungen</a></li>
      <li><a href="http://localhost:8080/SWP-W3/WelcomeBuchen.jsp">Buchen</a></li>
    </ul>
  </div>
</nav>
</div>
<div>
<p>Ihre Buchungen:</p>
<button type="button" onclick="loadDoc()">Aktualisieren</button>
</div>
<div id="demo">
</div>
<script>
function loadDoc() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
	var arr = JSON.parse(this.responseText);
    drawTable(arr);
    }
  };
  xhttp.open("Post", "WbuchView", true);
  xhttp.send();
}

function drawTable(arr)
{
	var s ="<table class=\"table table-bordered\">";
	s+= "<thead>";
	s+= "<tr>";
	s+= "<th>BID</th>";
	s+= "<th>ZID</th>";
	s+= "<th>GID</th>";
	s+= "<th>Von</th>";
	s+= "<th>Bis</th>";
	s+= "<th>Personen</th>";
	s+= "<th>Bezahlt?</th>";
	s+= "</tr>";
	s+= "</thead>";
	s+= "<tbody>";
	for(var i=0; i<arr.length;i++){
		var row = arr[i];
		s += "<tr>";
			s += "<td>";
			s += row.field1;
			s += "</td>";
			s += "<td>";
			s += row.field2;
			s += "</td>";
			s += "<td>";
			s += row.field3;
			s += "</td>";
			s += "<td>";
			s += row.field4;
			s += "</td>";
			s += "<td>";
			s += row.field5;
			s += "</td>";
			s += "<td>";
			s += row.field6;
			s += "</td>";
			s += "<td>";
			s += row.field7;
			s += "</td>";
		s += "</tr>";
	}
	s+= "</tbody>";
	s += "</table>";
	
	document.getElementById("demo").innerHTML =s;
}
</script>
</body>
</html>