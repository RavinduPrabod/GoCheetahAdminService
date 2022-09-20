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
	<jsp:include page="assets/Left.html"></jsp:include>
	<!-- Left Panel -->
	<!-- Right Panel -->
	<div id="right-panel" class="right-panel">
		<!-- Header-->
		<header id="header" class="header">
			<jsp:include page="assets/Nav.html"></jsp:include>
		</header>
		<!-- /header -->
		<!-- Header-->
		<div class="content">
			<div class="animated fadeIn">
				<div class="row">
					<div class="col-md-12">
						<div class="card">
							<div class="card-header">
								<strong class="card-title">Driver Add New</strong>
							</div>
							<div class="card-body card-block">
								<form action="DriverMasterServlet" method="post"
									class="form-horizontal">
									<input type="hidden" name="command" value="ADDDATA" />
									<div class="row form-group">
										<div class="col col-md-3" align="right">
											<label for="text-input" class=" form-control-label">Driver
												Name</label>
										</div>
										<div class="col col-md-5">
											<input type="text" id="text-input" name="DriverName"
												placeholder="" class="form-control">
										</div>
										<div class="col col-md-4"></div>
									</div>
									<div class="row form-group">
										<div class="col col-md-3" align="right">
											<label for="text-input" class=" form-control-label">Contact No</label>
										</div>
										<div class="col col-md-5">
											<input type="text" id="text-input" name="ContactNo"
												placeholder="" class="form-control">
										</div>
										<div class="col col-md-4"></div>
									</div>
									<div class="row form-group">
										<div class="col col-md-3" align="right">
											<label for="text-input" class=" form-control-label">NIC</label>
										</div>
										<div class="col col-md-5">
											<input type="text" id="text-input" name="NIC" placeholder=""
												class="form-control">
										</div>
										<div class="col col-md-4"></div>
									</div>
									<div class="row form-group">
										<div class="col col-md-3" align="right">
											<label for="text-input" class=" form-control-label">License
												No</label>
										</div>
										<div class="col col-md-5">
											<input type="text" id="text-input" name="LicenseNo"
												placeholder="" class="form-control">
										</div>
										<div class="col col-md-4"></div>
									</div>
									<div class="row form-group">
										<div class="col col-md-3" align="right">
											<label for="select" class=" form-control-label">Branch</label>
										</div>
										<div class="col-4 col-md-3">
											<select name="BranchID" class="form-control"
												required="required">
												<c:forEach items="${BrnDrp}" var="Branch">
													<option value="${Branch.branchID}">${Branch.branchLocation}</option>
												</c:forEach>
											</select>
										</div>
										<div class="col-1 col-md-2"></div>
										<div class="col col-md-3" align="right">
											<label for="select" class=" form-control-label"
												style="font-weight: bold;">Driver User Account</label>
										</div>
									</div>
									<div class="row form-group">
										<div class="col col-md-3" align="right">
											<label for="select" class=" form-control-label">Vehicle
												No</label>
										</div>
										<div class="col-4 col-md-3">
											<select name="VehicleNo" class="form-control"
												required="required">
												<c:forEach items="${vnDrp}" var="vhn">
													<option value="${vhn.vehicleNo}">${vhn.vehicleNo}</option>
												</c:forEach>
											</select>
										</div>
										<div class="col-1 col-md-2"></div>
										<div class="form-group">
											<div class="input-group">
												<div class="input-group-addon">Username</div>
												<input type="text" id="username3" name="UserName"
													class="form-control">
												<div class="input-group-addon">
													<i class="fa fa-user"></i>
												</div>
											</div>
										</div>
									</div>
									<div class="row form-group">
										<div class="col col-md-3" align="right">
											<label for="select" class=" form-control-label">Status</label>
										</div>
										<div class="col-4 col-md-3">
											<select name="Status" id="select" class="form-control">
												<option value="0">Please Select</option>
												<option value="1">Active</option>
												<option value="2">Inactive</option>
											</select>
										</div>
										<div class="col-1 col-md-2"></div>
										<div class="form-group">
											<div class="input-group">
												<div class="input-group-addon">Password</div>
												<input type="password" id="password3" name="Password"
													class="form-control">
												<div class="input-group-addon">
													<i class="fa fa-asterisk"></i>
												</div>
											</div>
										</div>
									</div>
									<div class="row form-group">
										<div class="col col-md-3"></div>
										<div class="col col-md-3">
											<input class="btn btn-success" type="submit" value="Add">
											<input class="btn btn-warning" type="button" value="Cancel">
										</div>
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
	<jsp:include page="assets/Scripts.html"></jsp:include>
	<!-- Scripts -->
</body>
</html>
