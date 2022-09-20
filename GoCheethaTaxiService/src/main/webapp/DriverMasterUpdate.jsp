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
								<strong class="card-title">Driver Update</strong>
							</div>
							<div class="card-body card-block">
								<form action="DriverMasterServlet" method="post"
									class="form-horizontal">
									<input type="hidden" name="command" value="UPDATEDATA" /> <input
										type="hidden" name="DriverID" value="${oDriverMaster.driverID}" />
									<div class="row form-group">
										<div class="col col-md-3" align="right">
											<label for="text-input" class=" form-control-label">Driver
												Name</label>
										</div>
										<div class="col col-md-5">
											<input type="text" name="DriverName"
												value="${oDriverMaster.driverName}" placeholder=""
												class="form-control">
										</div>
										<div class="col col-md-4"></div>
									</div>
									<div class="row form-group">
										<div class="col col-md-3" align="right">
											<label for="text-input" class=" form-control-label">Contact
												No</label>
										</div>
										<div class="col col-md-5">
											<input type="text" id="text-input" name="ContactNo"
												value="${oDriverMaster.contactNo}" placeholder=""
												class="form-control">
										</div>
										<div class="col col-md-4"></div>
									</div>
									<div class="row form-group">
										<div class="col col-md-3" align="right">
											<label for="text-input" class=" form-control-label">NIC</label>
										</div>
										<div class="col col-md-5">
											<input type="text" name="NIC" value="${oDriverMaster.NIC}"
												placeholder="" class="form-control">
										</div>
										<div class="col col-md-4"></div>
									</div>
									<div class="row form-group">
										<div class="col col-md-3" align="right">
											<label for="text-input" class="form-control-label">License
												No</label>
										</div>
										<div class="col col-md-5">
											<input type="text" name="LicenseNo"
												value="${oDriverMaster.licenseNo}" placeholder=""
												class="form-control">
										</div>
										<div class="col col-md-4"></div>
									</div>
									<div class="row form-group">
										<div class="col col-md-3" align="right">
											<label for="select" class=" form-control-label">Branch</label>
										</div>
										<div class="col-4 col-md-3">
											<select id="cmbBrID" class="form-control" required="required"
												name="cmbBrID">
												<c:forEach items="${BrnDrp}" var="branch">
													<option value="${branch.branchID }">${branch.branchLocation}</option>
												</c:forEach>
											</select> <input type="hidden" name="branchID" id="txtbranchID"
												value="${oDriverMaster.branchID }">
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
											<select id="cmbvhVal" class="form-control"
												required="required" name="cmbvhVal">
												<c:forEach items="${vhlist}" var="vehicleT">
													<option value="${vehicleT.vehicleNo}">${vehicleT.vehicleNo}</option>
												</c:forEach>
											</select> <input type="text" name="vehicleType" id="txtcmbvhVal"
												value="${oDriverMaster.vehicleNo }">
										</div>
										<div class="col-1 col-md-2"></div>
										<div class="form-group">
											<div class="input-group">
												<div class="input-group-addon">Username</div>
												<input type="text" id="username3" name="username3" value="${oDriverMaster.UserName}"
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
											<select id="cmbStatus" class="form-control"
												required="required" name="cmbStatus">
												<c:forEach items="${slist}" var="status">
													<option value="${status.value}">${status.text}</option>
												</c:forEach>
											</select> <input type="text" name="Status" id="txtStatusvalue"
												value="${DriverList.status }">
										</div>
										<div class="col-1 col-md-2"></div>
										<div class="form-group">
											<div class="input-group">
												<div class="input-group-addon">Password</div>
												<input type="password" id="password3" name="password3" value="${oDriverMaster.Password}"
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
											<input class="btn btn-Infor" type="submit" value="Update">
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
	<script type="text/javascript">
		$(document).ready(function() {
			get_txtVId();
		});

		$("#cmbvhVal").change(function(event) {
			set_txtVId();
		});

		function set_txtVId() {
			var VId = $("#cmbvhVal").val();
			$("#txtcmbvhVal").val(VId);
		}

		function get_txtVId() {
			var VId = $("#txtcmbvhVal").val();
			$('select[name="cmbvhVal"]').first().val(VId);
		}

		$(document).ready(function() {

			get_txtBrID();
		});

		$("#cmbBrID").change(function(event) {
			set_txtBrID();
		});

		function set_txtBrID() {
			var BrID = $("#cmbBrID").val();
			$("#txtbranchID").val(BrID);
		}

		function get_txtBrID() {
			var BrID = $("#txtbranchID").val();
			$('select[name="cmbBrID"]').first().val(BrID);

		}

		$(document).ready(function() {

			get_txtCityId();
		});

		$("#cmbStatus").change(function(event) {
			set_txtCityId();
		});

		function set_txtCityId() {
			var CityId = $("#cmbStatus").val();
			$("#txtStatusvalue").val(CityId);
		}

		function get_txtCityId() {
			var CityId = $("#txtStatusvalue").val();
			$('select[name="cmbStatus"]').first().val(CityId);

		}
	</script>
</body>
</html>
