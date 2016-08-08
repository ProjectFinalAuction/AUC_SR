<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AUCTION SYSTEM</title>
<!-- header -->
<jsp:include page="header.jsp"></jsp:include>
<!-- menu -->
<jsp:include page="menu.jsp"></jsp:include>
<!-- left content -->
<jsp:include page="left-content.jsp"></jsp:include>

<!-- Start right Content here -->
<!-- ============================================================== -->
<div class="content-page">
	<!-- Start content -->
	<div class="content">
		<div class="container">

			<!-- Page-Title -->
			<div class="row">
				<div class="col-sm-12">
					<h4 class="page-title">Dashboard</h4>
					<p class="text-muted page-title-alt">Welcome to iWantAuction
						admin panel !</p>
				</div>
			</div>

			<div class="row">
				<div class="col-md-6 col-lg-3">
					<div class="widget-bg-color-icon card-box fadeInDown animated">
						<div class="bg-icon bg-info pull-left">
							<i class="md md-attach-money text-white"></i>
						</div>
						<div class="text-right">
							<h3 class="">
								<b class="counter">31,570</b>
							</h3>
							<p class="text-muted">Total Revenue</p>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>

				<div class="col-md-6 col-lg-3">
					<div class="widget-bg-color-icon card-box">
						<div class="bg-icon bg-pink pull-left">
							<i class="md md-add-shopping-cart text-white"></i>
						</div>
						<div class="text-right">
							<h3 class="">
								<b class="counter">280</b>
							</h3>
							<p class="text-muted">Today's Sales</p>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>

				<div class="col-md-6 col-lg-3">
					<div class="widget-bg-color-icon card-box">
						<div class="bg-icon bg-purple pull-left">
							<i class="md md-equalizer text-white"></i>
						</div>
						<div class="text-right">
							<h3 class="">
								<b class="counter">0.16</b>%
							</h3>
							<p class="text-muted">Conversion</p>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>

				<div class="col-md-6 col-lg-3">
					<div class="widget-bg-color-icon card-box">
						<div class="bg-icon bg-success pull-left">
							<i class="md md-remove-red-eye text-white"></i>
						</div>
						<div class="text-right">
							<h3 class="">
								<b class="counter">64,570</b>
							</h3>
							<p class="text-muted">Today's Visits</p>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
			</div>
			<!-- end row -->

			<div class="row">
				<div class="col-lg-4">
					<div class="card-box">
						<h4 class="header-title m-t-0 m-b-30">Total Revenue</h4>

						<div class="widget-chart text-center">
							<div id="sparkline1"></div>
							<ul class="list-inline m-t-15">
								<li>
									<h5 class="text-muted m-t-20">Target</h5>
									<h4 class="m-b-0">$1000</h4>
								</li>
								<li>
									<h5 class="text-muted m-t-20">Last week</h5>
									<h4 class="m-b-0">$523</h4>
								</li>
								<li>
									<h5 class="text-muted m-t-20">Last Month</h5>
									<h4 class="m-b-0">$965</h4>
								</li>
							</ul>
						</div>
					</div>

				</div>

				<div class="col-lg-4">
					<div class="card-box">
						<h4 class="header-title m-t-0 m-b-30">Total Revenue</h4>

						<div class="widget-chart text-center">
							<div id="sparkline2"></div>
							<ul class="list-inline m-t-15">
								<li>
									<h5 class="text-muted m-t-20">Target</h5>
									<h4 class="m-b-0">$1000</h4>
								</li>
								<li>
									<h5 class="text-muted m-t-20">Last week</h5>
									<h4 class="m-b-0">$523</h4>
								</li>
								<li>
									<h5 class="text-muted m-t-20">Last Month</h5>
									<h4 class="m-b-0">$965</h4>
								</li>
							</ul>
						</div>
					</div>

				</div>

				<div class="col-lg-4">
					<div class="card-box">
						<h4 class="header-title m-t-0 m-b-30">Total Revenue</h4>

						<div class="widget-chart text-center">
							<div id="sparkline3"></div>
							<ul class="list-inline m-t-15">
								<li>
									<h5 class="text-muted m-t-20">Target</h5>
									<h4 class="m-b-0">$1000</h4>
								</li>
								<li>
									<h5 class="text-muted m-t-20">Last week</h5>
									<h4 class="m-b-0">$523</h4>
								</li>
								<li>
									<h5 class="text-muted m-t-20">Last Month</h5>
									<h4 class="m-b-0">$965</h4>
								</li>
							</ul>
						</div>
					</div>

				</div>

			</div>
			<!-- end row -->

			<div class="row">
				<!-- INBOX -->
				<div class="col-lg-4">
					<div class="card-box">
						<h4 class="m-t-0 m-b-20 header-title">
							<b>Inbox</b>
						</h4>

						<div class="inbox-widget nicescroll mx-box">
							<a href="#">
								<div class="inbox-item">
									<div class="inbox-item-img">
										<img src="assets/images/users/avatar-1.jpg" class="img-circle"
											alt="">
									</div>
									<p class="inbox-item-author">Chadengle</p>
									<p class="inbox-item-text">Hey! there I'm available...</p>
									<p class="inbox-item-date">13:40 PM</p>
								</div>
							</a> <a href="#">
								<div class="inbox-item">
									<div class="inbox-item-img">
										<img src="assets/images/users/avatar-2.jpg" class="img-circle"
											alt="">
									</div>
									<p class="inbox-item-author">Tomaslau</p>
									<p class="inbox-item-text">I've finished it! See you so...</p>
									<p class="inbox-item-date">13:34 PM</p>
								</div>
							</a> <a href="#">
								<div class="inbox-item">
									<div class="inbox-item-img">
										<img src="assets/images/users/avatar-3.jpg" class="img-circle"
											alt="">
									</div>
									<p class="inbox-item-author">Stillnotdavid</p>
									<p class="inbox-item-text">This theme is awesome!</p>
									<p class="inbox-item-date">13:17 PM</p>
								</div>
							</a> <a href="#">
								<div class="inbox-item">
									<div class="inbox-item-img">
										<img src="assets/images/users/avatar-4.jpg" class="img-circle"
											alt="">
									</div>
									<p class="inbox-item-author">Kurafire</p>
									<p class="inbox-item-text">Nice to meet you</p>
									<p class="inbox-item-date">12:20 PM</p>
								</div>
							</a> <a href="#">
								<div class="inbox-item">
									<div class="inbox-item-img">
										<img src="assets/images/users/avatar-5.jpg" class="img-circle"
											alt="">
									</div>
									<p class="inbox-item-author">Shahedk</p>
									<p class="inbox-item-text">Hey! there I'm available...</p>
									<p class="inbox-item-date">10:15 AM</p>
								</div>
							</a> <a href="#">
								<div class="inbox-item">
									<div class="inbox-item-img">
										<img src="assets/images/users/avatar-6.jpg" class="img-circle"
											alt="">
									</div>
									<p class="inbox-item-author">Adhamdannaway</p>
									<p class="inbox-item-text">This theme is awesome!</p>
									<p class="inbox-item-date">9:56 AM</p>
								</div>
							</a> <a href="#">
								<div class="inbox-item">
									<div class="inbox-item-img">
										<img src="assets/images/users/avatar-8.jpg" class="img-circle"
											alt="">
									</div>
									<p class="inbox-item-author">Arashasghari</p>
									<p class="inbox-item-text">Hey! there I'm available...</p>
									<p class="inbox-item-date">10:15 AM</p>
								</div>
							</a> <a href="#">
								<div class="inbox-item">
									<div class="inbox-item-img">
										<img src="assets/images/users/avatar-9.jpg" class="img-circle"
											alt="">
									</div>
									<p class="inbox-item-author">Joshaustin</p>
									<p class="inbox-item-text">I've finished it! See you so...</p>
									<p class="inbox-item-date">9:56 AM</p>
								</div>
							</a>
						</div>
					</div>

				</div>
				<!-- end col -->

				<!-- CHAT -->
				<div class="col-lg-4">
					<div class="card-box">
						<h4 class="m-t-0 m-b-20 header-title">
							<b>Chat</b>
						</h4>

						<div class="chat-conversation">
							<ul class="conversation-list nicescroll">
								<li class="clearfix">
									<div class="chat-avatar">
										<img src="assets/images/users/avatar-1.jpg" alt="male">
										<i>10:00</i>
									</div>
									<div class="conversation-text">
										<div class="ctext-wrap">
											<i>John Deo</i>
											<p>Hello!</p>
										</div>
									</div>
								</li>
								<li class="clearfix odd">
									<div class="chat-avatar">
										<img src="assets/images/users/avatar-3.jpg" alt="Female">
										<i>10:01</i>
									</div>
									<div class="conversation-text">
										<div class="ctext-wrap">
											<i>Smith</i>
											<p>Hi, How are you? What about our next meeting?</p>
										</div>
									</div>
								</li>
								<li class="clearfix">
									<div class="chat-avatar">
										<img src="assets/images/users/avatar-1.jpg" alt="male">
										<i>10:01</i>
									</div>
									<div class="conversation-text">
										<div class="ctext-wrap">
											<i>John Deo</i>
											<p>Yeah everything is fine</p>
										</div>
									</div>
								</li>
								<li class="clearfix odd">
									<div class="chat-avatar">
										<img src="assets/images/users/avatar-3.jpg" alt="male">
										<i>10:02</i>
									</div>
									<div class="conversation-text">
										<div class="ctext-wrap">
											<i>Smith</i>
											<p>Wow that's great</p>
										</div>
									</div>
								</li>
							</ul>
							<div class="row">
								<div class="col-sm-9 chat-inputbar">
									<input type="text" class="form-control chat-input"
										placeholder="Enter your text">
								</div>
								<div class="col-sm-3 chat-send">
									<button type="submit"
										class="btn btn-md btn-info btn-block waves-effect waves-light">Send</button>
								</div>
							</div>
						</div>
					</div>

				</div>
				<!-- end col-->


				<!-- Todos app -->
				<div class="col-lg-4">
					<div class="card-box">
						<h4 class="m-t-0 m-b-20 header-title">
							<b>Todo</b>
						</h4>
						<div class="todoapp">
							<div class="row">
								<div class="col-sm-6">
									<h4 id="todo-message">
										<span id="todo-remaining"></span> of <span id="todo-total"></span>
										remaining
									</h4>
								</div>
								<div class="col-sm-6">
									<a href="#"
										class="pull-right btn btn-primary btn-sm waves-effect waves-light"
										id="btn-archive">Archive</a>
								</div>
							</div>

							<ul class="list-group no-margn nicescroll todo-list"
								style="height: 280px" id="todo-list"></ul>

							<form name="todo-form" id="todo-form" role="form" class="m-t-20">
								<div class="row">
									<div class="col-sm-9 todo-inputbar">
										<input type="text" id="todo-input-text" name="todo-input-text"
											class="form-control" placeholder="Add new todo">
									</div>
									<div class="col-sm-3 todo-send">
										<button
											class="btn-primary btn-md btn-block btn waves-effect waves-light"
											type="button" id="todo-btn-submit">Add</button>
									</div>
								</div>
							</form>
						</div>
					</div>

				</div>
				<!-- end col -->
			</div>
			<!-- end row -->





		</div>
		<!-- container -->

	</div>
	<!-- content -->

	<!-- <footer class="footer text-right">
                    © 2016. All rights reserved.
                </footer> -->

</div>


<!-- ============================================================== -->
<!-- End Right content here -->
<!-- ============================================================== -->


<!-- Right Sidebar -->
<div class="side-bar right-bar nicescroll">
	<h4 class="text-center">Chat</h4>
	<div class="contact-list nicescroll">
		<ul class="list-group contacts-list">
			<li class="list-group-item"><a href="#">
					<div class="avatar">
						<img src="assets/images/users/avatar-1.jpg" alt="">
					</div> <span class="name">Chadengle</span> <i class="fa fa-circle online"></i>
			</a> <span class="clearfix"></span></li>
			<li class="list-group-item"><a href="#">
					<div class="avatar">
						<img src="assets/images/users/avatar-2.jpg" alt="">
					</div> <span class="name">Tomaslau</span> <i class="fa fa-circle online"></i>
			</a> <span class="clearfix"></span></li>
			<li class="list-group-item"><a href="#">
					<div class="avatar">
						<img src="assets/images/users/avatar-3.jpg" alt="">
					</div> <span class="name">Stillnotdavid</span> <i
					class="fa fa-circle online"></i>
			</a> <span class="clearfix"></span></li>
			<li class="list-group-item"><a href="#">
					<div class="avatar">
						<img src="assets/images/users/avatar-4.jpg" alt="">
					</div> <span class="name">Kurafire</span> <i class="fa fa-circle online"></i>
			</a> <span class="clearfix"></span></li>
			<li class="list-group-item"><a href="#">
					<div class="avatar">
						<img src="assets/images/users/avatar-5.jpg" alt="">
					</div> <span class="name">Shahedk</span> <i class="fa fa-circle away"></i>
			</a> <span class="clearfix"></span></li>
			<li class="list-group-item"><a href="#">
					<div class="avatar">
						<img src="assets/images/users/avatar-6.jpg" alt="">
					</div> <span class="name">Adhamdannaway</span> <i
					class="fa fa-circle away"></i>
			</a> <span class="clearfix"></span></li>
			<li class="list-group-item"><a href="#">
					<div class="avatar">
						<img src="assets/images/users/avatar-7.jpg" alt="">
					</div> <span class="name">Ok</span> <i class="fa fa-circle away"></i>
			</a> <span class="clearfix"></span></li>
			<li class="list-group-item"><a href="#">
					<div class="avatar">
						<img src="assets/images/users/avatar-8.jpg" alt="">
					</div> <span class="name">Arashasghari</span> <i
					class="fa fa-circle offline"></i>
			</a> <span class="clearfix"></span></li>
			<li class="list-group-item"><a href="#">
					<div class="avatar">
						<img src="assets/images/users/avatar-9.jpg" alt="">
					</div> <span class="name">Joshaustin</span> <i
					class="fa fa-circle offline"></i>
			</a> <span class="clearfix"></span></li>
			<li class="list-group-item"><a href="#">
					<div class="avatar">
						<img src="assets/images/users/avatar-10.jpg" alt="">
					</div> <span class="name">Sortino</span> <i class="fa fa-circle offline"></i>
			</a> <span class="clearfix"></span></li>
		</ul>
	</div>
</div>
<!-- /Right-bar -->

</div>
<!-- END wrapper -->

<!-- footer -->
<jsp:include page="footer.jsp"></jsp:include>