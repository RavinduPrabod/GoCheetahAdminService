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
								<strong class="card-title">City Update</strong>
								<div class="card-body card-block">
									<form action="CityMasterServlet" method="post"
										class="form-horizontal">
										<input type="hidden" name="command" value="UPDATEDATA" />
										<input type="hidden" name="CityID" value="${CityList.cityID}"/>
										<div class="row form-group">
											<div class="col col-md-3" align="right">
												<label for="text-input" class=" form-control-label" id="CityName">City
													Name</label>
											</div>
											<div class="col col-md-5">
												<input type="text" id="text-input" name="CityName" value="${CityList.cityName}"
													placeholder="enter city name" class="form-control" required="required">
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
							<div class="card-body"></div>
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
