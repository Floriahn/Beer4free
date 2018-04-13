<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">


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
      <li><a href="http://localhost:8080/SWP-W3/Welcome.jsp">Buchungen</a></li>
      <li class="active"><a href="#">Buchen</a></li>
    </ul>
  </div>
</nav>
</div>
<div class="span3">
    <h2>Buchung</h2>
    <form method="get" action="Wbuchung">
    <label>Von (YYYY-MM-DD)</label>
    <input type="text" name="von" class="span3">
    <label>Bis (YYYY-MM-DD)</label>
    <input type="text" name="bis" class="span3">
    <label>Personen (wie viele?)</label>
    <input type="text" name="anz" class="span3">
    <input type="submit" value="Buchen" class="btn btn-primary pull-right">
    <div class="clearfix"></div>
    </form>
</div>
</body>
</html>