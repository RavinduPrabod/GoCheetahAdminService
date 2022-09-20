<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="assets/Head.html"></jsp:include>
</head>
<body>
	<!-- Left Panel -->
	<jsp:include page="assets/DLeft.html"></jsp:include>
	<!-- Left Panel -->
	<!-- Right Panel -->
	<div id="right-panel" class="right-panel">
		<!-- Header-->
		<header id="header" class="header">
			<jsp:include page="assets/Nav.html"></jsp:include>
		</header>
		<div class="content">
			<div class="animated fadeIn">
				<div class="row">
					<div class="col-md-12">
						<div class="card">
							<div class="card-header">
								<div class="row form-group">
									<div class="col-md-2">
										<strong class="fa fa-location-arrow"
											style="color: blue; font-weight: bold; font-size: large;">
											Customer Details</strong>
									</div>
									<div class="col-md-10" align="right"></div>
								</div>
								<div class="row form-group">
										<div class="col col-md-3" align="right">
											<label for="text-input" class=" form-control-label">Booking ID</label>
										</div>
										<div class="col col-md-3">
											<input type="text" id="text-input" name="FirstName"
												value="${custinfo.lastName}" class="form-control"
												readonly="readonly">
										</div>
									</div>
							</div>
							<div class="card-body">
								<form class="row g-3" action=BookingMasterServlet method="get">
									<div class="row form-group">
										<div class="col col-md-3" align="right">
											<label for="text-input" class=" form-control-label">Customer
												Name </label>
										</div>
										<div class="col col-md-5">
											<input type="text" id="text-input" name="FirstName"
												value="${custinfo.firstName}" class="form-control"
												readonly="readonly">
										</div>
										<div class="col col-md-4"></div>
										<div class="col col-md-3" align="right">
											<label for="text-input" class=" form-control-label">City</label>
										</div>
										<div class="col col-md-5">
											<input type="text" id="text-input" name="City"
												value="${custinfo.city}" class="form-control"
												readonly="readonly">
										</div>
										<div class="col col-md-4"></div>
										<div class="col col-md-3" align="right">
											<label for="text-input" class=" form-control-label">Mobile
												No </label>
										</div>
										<div class="col col-md-5">
											<input type="text" id="text-input" name="MobileNo"
												value="${custinfo.mobileNo}" class="form-control"
												readonly="readonly">
										</div>
										<div class="col col-md-4"></div>
										<div class="col col-md-3" align="right">
											<label for="text-input" class=" form-control-label">Email</label>
										</div>
										<div class="col col-md-5">
											<input type="text" id="text-input" name="Email"
												value="${custinfo.email}" class="form-control"
												readonly="readonly">
										</div>
										<div class="col col-md-4"></div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- .animated -->
		</div>
		<!-- .content -->
		<div class="clearfix"></div>
	</div>
	<!-- /#right-panel -->
	<!-- Right Panel -->
	<jsp:include page="assets/DScript.html"></jsp:include>
</body>
</html>
