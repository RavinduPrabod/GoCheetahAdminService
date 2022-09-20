<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="assets/Head.html"></jsp:include>
</head>
<body>
	<div class="content" align="center">
		<div class="animated fadeIn" align="center">
			<div class="row">
				<div class="col-md-1 offset-md-3 mr-auto ml-auto"></div>
				<div class="col-md-5 offset-md-3 mr-auto ml-auto">
					<img alt="" src="assets/logo.png" height="290px">
				</div>
				<div class="col-md-1 offset-md-3 mr-auto ml-auto"></div>
			</div>
			<br>
			<div class="row">
				<div class="col-lg-12">
					<div class="card">
						<div class="card-header" style="color: white; background-color: blue;">
							<h4>Choose your User Type</h4>
						</div>
						<div class="card-body">
							<div class="row">
								<div class="col-lg-4"></div>
								<div class="col-lg-4">
									<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
										<li class="nav-item"><a class="nav-link active"
											id="pills-home-tab" data-toggle="pill" href="#pills-home"
											role="tab" aria-controls="pills-home" aria-selected="true">Administrator</a>
										</li>
										<li class="nav-item"><a class="nav-link"
											id="pills-profile-tab" data-toggle="pill"
											href="#pills-profile" role="tab"
											aria-controls="pills-profile" aria-selected="false">Driver</a>
										</li>
									</ul>
								</div>
								<div class="col-lg-4"></div>
							</div>

							<div class="tab-content" id="pills-tabContent">
								<div class="tab-pane fade show active" id="pills-home"
									role="tabpanel" aria-labelledby="pills-home-tab">
									<div class="col-md-5 offset-md-3 mr-auto ml-auto">
										<section class="card">
											<div class="card-header" style="background-color: lime;">
												<strong class="card-title mb-3">Admin Login</strong> <i
													class="fa fa-user fa-lg"></i>
											</div>
											<div class="card-body card-block">
												<form action="LoginServlet" method="post">
													<div class="form-group d-none">
														<input type="hidden" class="form-control" name="type"
															value="Administration" />
													</div>
													<div class="form-group">
														<div class="input-group">
															<input type="text" id="username2" name="username"
																placeholder="Username" class="form-control">
															<div class="input-group-addon">
																<i class="fa fa-user"></i>
															</div>
														</div>
													</div>
													<div class="form-group">
														<div class="input-group">
															<input type="password" id="password2" name="password"
																placeholder="Password" class="form-control">
															<div class="input-group-addon">
																<i class="fa fa-asterisk"></i>
															</div>
														</div>
													</div>
													<div class="form-actions form-group">
														<button type="submit" class="btn btn-primary btn-lg"
															name="btnLogingA">LOGIN</button>
													</div>
												</form>
											</div>
										</section>
									</div>
								</div>
								<div class="tab-pane fade" id="pills-profile" role="tabpanel"
									aria-labelledby="pills-profile-tab">
									<div class="col-md-5 offset-md-3 mr-auto ml-auto">
										<section class="card">
											<div class="card-header" style="background-color: yellow;">
												<strong class="card-title mb-3">Driver Login</strong> <i
													class="fa fa-truck fa-lg"></i>
											</div>
											<div class="card-body card-block">
												<form action="LoginServlet" method="post">
													<div class="form-group d-none">
														<input type="hidden" class="form-control" name="type"
															value="Driver" />
													</div>
													<div class="form-group">
														<div class="input-group">
															<input type="text" id="username2" name="username"
																placeholder="Username" class="form-control">
															<div class="input-group-addon">
																<i class="fa fa-user"></i>
															</div>
														</div>
													</div>
													<div class="form-group">
														<div class="input-group">
															<input type="password" id="password2" name="password"
																placeholder="Password" class="form-control">
															<div class="input-group-addon">
																<i class="fa fa-asterisk"></i>
															</div>
														</div>
													</div>
													<div class="form-actions form-group">
														<button type="submit" class="btn btn-warning btn-lg"
															name="btnLogingD">LOGIN</button>
													</div>
												</form>
											</div>
										</section>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	<jsp:include page="assets/Scripts.html"></jsp:include>
</body>
</html>
