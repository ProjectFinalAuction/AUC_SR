<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login System</title>
</head>
<jsp:include page="header.jsp"/>
<body>
<!-- menu -->
<jsp:include page="menu.jsp"/>

<!-- content -->
	<div class="content" id="login">
		<div class="container-fluid">
			<!-- form register -->
		  <div class="row">
			<div class="col-md-6">
				<div class="list-group">
					<div class="list-group-item"><small>LOG IN</small></div>
					<div class="list-group-item">
						<form class="form-horizontal" role="form">
						  <div class="form-group">
						    <label class="control-label col-sm-3" for="uname">Username</label>
						    <div class="col-sm-8">
						      <input type="email" class="form-control" id="uname">
						    </div>
						  </div>
						  <div class="form-group">
						    <label class="control-label col-sm-3" for="pwd">Password</label>
						    <div class="col-sm-8"> 
						      <input type="password" class="form-control" id="pwd">
						    </div>
						  </div>
						  <div class="form-group"> 
						    <div class="col-sm-offset-3 col-sm-10">
						      <div class="checkbox">
						        <label><input type="checkbox"> Remember me</label>
						      </div>
						    </div>
						  </div>
						  <div class="form-group"> 
						    <div class="col-sm-offset-3 col-sm-10">
						      <button type="submit" class="btn btn-primary">Submit</button>
						    </div>
						  </div>
						</form>
					</div>
				</div>
			</div> <!-- end div col-md-6 -->

			<div class="col-md-6">
				<h3>Not Registered?</h3>
				<p>If you are not already a registered member, please <a href="${pageContext.request.contextPath}/register">Register Now</a></p>
			</div>
		  </div> <!-- end div container -->
		</div> <!-- end div main content information -->
	</div>

<!-- footer -->
<jsp:include page="footer.jsp"/>
</body>
</html>