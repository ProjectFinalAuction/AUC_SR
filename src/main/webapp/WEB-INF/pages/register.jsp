<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register New Account</title>
<jsp:include page="header.jsp"/>
<body>
<!-- menu -->
<jsp:include page="menu.jsp"/>

<!-- content -->
<div class="content" id="register">
		<div class="container-fluid">
			<div class="col-md-12">
				<div class="panel panel-default">
				  <div class="panel-body"><small>CREATE AN ACCOUNT</small></div>
				</div>
			</div>
			<!-- form register -->
			<div class="col-md-12">
				<div class="list-group">
					<div class="list-group-item"><small>CREATE LOGIN</small></div>
					<div class="list-group-item">
						<form class="form-horizontal" role="form">
						  <div class="form-group">
						    <label class="control-label col-sm-3" for="uname">Username <sup><i class="glyphicon glyphicon-star"></i></sup></label>
						    <div class="col-sm-7">
						      <input type="text" class="form-control" id="uname">
						      <p>Your username will be shown when you bid, buy, and sell.</p>
						    </div>
						  </div>
						  <div class="form-group">
						    <label class="control-label col-sm-3" for="pwd">Password <sup><i class="glyphicon glyphicon-star"></i></sup></label>
						    <div class="col-sm-7"> 
						      <input type="password" class="form-control" id="pwd">
						    </div>
						  </div>
						  <div class="form-group">
						    <label class="control-label col-sm-3" for="cpwd">Confirm Password <sup><i class="glyphicon glyphicon-star"></i></sup></label>
						    <div class="col-sm-7"> 
						      <input type="password" class="form-control" id="cpwd">
						      <p>Your Password must be at least 6 characters long. Passwords are case sensitive</p>
						    </div>
						  </div>
						</form>
					</div>
				</div>
			</div> <!-- end div col-md-12 -->

			<div class="col-md-12">
				<div class="list-group">
					<div class="list-group-item"><small>YOUR CONTACT INFORMATION</small></div>
					<div class="list-group-item">
						<form class="form-horizontal" role="form">
						  <div class="form-group">
						    <label class="control-label col-sm-3" for="email">Email <sup><i class="glyphicon glyphicon-star"></i></sup></label>
						    <div class="col-sm-7">
						      <input type="email" class="form-control" id="email">
						    </div>
						  </div>
						  <div class="form-group">
						    <label class="control-label col-sm-3" for="cemail">Confirm Email <sup><i class="glyphicon glyphicon-star"></i></sup></label>
						    <div class="col-sm-7">
						      <input type="email" class="form-control" id="cemail">
						    </div>
						  </div>
						</form>
					</div>
				</div>
			</div> <!-- end div col-md-12 -->

			<div class="col-md-12">
				<div class="list-group">
					<div class="list-group-item"><small>ADDITIONAL INFORMATION</small></div>
					<div class="list-group-item">
						<form class="form-horizontal" role="form">
						  <div class="form-group">
						    <label class="control-label col-sm-3" for="fname">First Name <sup><i class="glyphicon glyphicon-star"></i></sup></label>
						    <div class="col-sm-7">
						      <input type="text" class="form-control" id="fname">
						    </div>
						  </div>
						  <div class="form-group">
						    <label class="control-label col-sm-3" for="lname">Last Name <sup><i class="glyphicon glyphicon-star"></i></sup></label>
						    <div class="col-sm-7">
						      <input type="text" class="form-control" id="lname">
						    </div>
						  </div>
						  <div class="form-group">
						  	<div class="col-sm-3"></div>
						  	<div class="col-sm-3">
						    	<button type="button" class="btn btn-success btn-block">Complete Registration</button>
						    </div>
						    <div class="col-sm-4"><p><small>ALL FIELDS MARKED WITH " <sup><i class="glyphicon glyphicon-star"></i></sup> " ARE REQUIRED</small></p></div>
						  </div>
						</form>
					</div>
				</div>
			</div> <!-- end div col-md-12 -->
		</div> <!-- end div container -->
	</div> <!-- end div main content information -->
	
<!-- footer -->
<jsp:include page="footer.jsp"/>
</body>
</html>