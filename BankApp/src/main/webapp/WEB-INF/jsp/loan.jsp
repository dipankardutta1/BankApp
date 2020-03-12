<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
<head>


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>





<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav">
    	<c:forEach items="${menus}" var="row">
    		<li><a href="${row.menuUrl}">${row.menuName}</a></li>
    	</c:forEach>
    </ul>
  </div>
</nav>




<div class="panel panel-primary">
  <div class="panel-heading">
    <h3 class="panel-title">Student List</h3>
  </div>
  <div class="panel-body">
  
  	<table class="table">
  		<thead>
  			<tr>
  				<th>ID</th>
  				<th>Loan Amount</th>
  				<th>Loan Sanction Date</th>
  				<th>Loan Reason</th>
  				
  			</tr>
  		</thead>
  		
  		<tbody>
  			
  			
  			<c:forEach items="${loans}" var="row" varStatus="status">
  				
  				<tr>
  					<td> ${status.count}  </td>
  					<td> ${row.loanAmount} </td>
  					<td> ${row.loanSanctionDate} </td>
  					<td> ${row.loanReason} </td> 
  				</tr>
  			
  			</c:forEach>
  		
  		
  		
  			
  		</tbody>
  		
  		
  	</table>
  
  
  
    
  </div>
</div>




</body>
</html>