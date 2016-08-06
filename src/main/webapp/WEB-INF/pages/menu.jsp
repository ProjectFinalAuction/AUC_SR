<!-- ================ Starting Header Section ================= -->
<header>
	<div class="container">
		<div class="row">
			<!-- ================ Logo Section ================= -->
			<div class="col-md-6">
				<img src="${pageContext.request.contextPath}/resources/static/images/iwantlogo1.png" class="img-responsive"
					style="width: 80%">
			</div>
			<!-- ================ Service Section ================= -->
			<div class="col-md-6 service">
				<a href="${pageContext.request.contextPath}/register"> Create Account</a> <a href="${pageContext.request.contextPath}/login">
					Log in</a>
				<p>Customer Service (+855) 070 730-619</p>
				<!-- ================ Form SearchTop Section ================= -->
				<form class="form-inline navbar-form navbar-right" id="searchTop"
					style="display: none; opacity: 1">
					<div class="form-group">
						<div class="input-group">
							<input type="text" class="form-control" id="exampleInputAmount"
								placeholder="Enter keyword">
							<div class="input-group-addon">Search</div>
						</div>
					</div>
				</form>
				<!-- ================ End form SearchTop Section ================= -->
			</div>
			<!-- ================ End Service Section ================= -->
		</div>
		<!-- ================ End Row Section ================= -->
	</div>
	<!-- ================ End Container Section ================= -->
</header>
<!-- ================ Ending Header Section ================= -->

<!-- ================ Starting MenuBar Section ================= -->
<div id="menu">
	<nav class="navbar navbar-default">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"></a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav slide">
					<li class="active"><a href="index.html">Home <span
							class="sr-only">(current)</span></a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Categories<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Technology</a></li>
							<li><a href="#">House/Industries</a></li>
							<li><a href="#">Automotive</a></li>
							<li><a href="#">Jewelry</a></li>
							<li><a href="#">Clothes</a></li>
							<li><a href="#">Furniture</a></li>
							<li><a href="#">Miscellaneous</a></li>
						</ul></li>
					<li><a href="sell_first_step.html">Seller</a></li>
					<li><a href="#">Buyer</a></li>
					<li><a href="contact.html">Contact</a></li>
					<li><a href="about.html">About</a></li>
					<li><a href="#" style="border-right: none; display: none"
						id="search"><i class="fa fa-search"></i> search </a></li>
				</ul>
				<!-- ================ Form Search on Menu bar Section ================= -->
				<form class="form-inline navbar-form navbar-right" id="formsearch">
					<div class="form-group">
						<div class="input-group">
							<input type="text" class="form-control" id="exampleInputAmount"
								placeholder="Enter keyword">
							<div class="input-group-addon">Search</div>
						</div>
					</div>
				</form>
				<!-- ================ End Form Search on Menu bar Section ================= -->
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-->
	</nav>
</div>
<!-- ================ Ending MenuBar Section ================= -->