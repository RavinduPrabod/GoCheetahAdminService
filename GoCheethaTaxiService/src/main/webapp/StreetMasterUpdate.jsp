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
								<strong class="card-title">Street update</strong>
							</div>
							<div class="card-body card-block">
								<form action="StreetMasterServlet" method="post"
									class="form-horizontal">
									<input type="hidden" name="command" value="UPDATEDATA" /> <input
										type="text" name="StreetID" value="${Street.streetID }"
										hidden="hidden">
									<div class="row form-group">
										<div class="col col-md-3" align="right">
											<label for="text-input" class=" form-control-label">City</label>
										</div>
										<div class="col col-md-5">
											<select id="cmbCityId" class="form-control"
												required="required" name="cmbCityId">
												<c:forEach items="${cityDrp}" var="city">
													<option value="${city.cityID}">${city.cityName}</option>
												</c:forEach>
											</select> <input type="text" name="CityID" id="txtcity_Id"
												value="${Street.cityID }" hidden="hidden">
										</div>
										<div class="col col-md-4"></div>
									</div>
									<div class="row form-group">
										<div class="col-4 col-md-3"></div>
									</div>
									<div class="row form-group">
										<div class="col col-md-3" align="right">
											<label for="text-input" class=" form-control-label">Street
												Name</label>
										</div>
										<div class="col col-md-5">
											<input type="text" id="text-input" name="StreetName"
												value="${Street.streetName }"
												placeholder="enter street name" class="form-control"
												id="StreetName">
										</div>
										<div class="col col-md-4"></div>
									</div>
									<div class="row form-group">
										<div class="col col-md-3"></div>
										<div class="col col-md-3">
											<input class="btn btn-info" type="submit" value="Update">
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
	<jsp:include page="Scripts.html"></jsp:include>

	<script type="text/javascript">
	  $(document).ready(function () {

		  get_txtCityId();
      });
	
	$("#cmbCityId").change(function (event) {
        set_txtCityId();
    });
		
	function set_txtCityId() {
		var CityId = $("#cmbCityId").val();
		$("#txtcity_Id").val(CityId);	
	}
	
	function get_txtCityId() {
		var CityId = $("#txtcity_Id").val();
		$('select[name="cmbCityId"]').first().val(CityId);
				
	}
	</script>
	
	<!-- Scripts -->
</body>
</html>
