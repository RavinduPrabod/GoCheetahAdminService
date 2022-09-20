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
								<strong class="card-title">Street Add New</strong>
							</div>
							<div class="card-body card-block">
								<form action="StreetMasterServlet" method="post" class="form-horizontal">
									<input type="hidden" name="command" value="ADDDATA" />
									<div class="row form-group">
										<div class="col col-md-3" align="right">
												<label for="select" class=" form-control-label">City</label>
											</div>
											<div class="col-4 col-md-3">
											<select name="CityID" class="form-control" required="required">	
											    <c:forEach items="${cityDrp}" var="city">
											        <option value="${city.cityID}">${city.cityName}</option>
											    </c:forEach>
											</select>
										</div>
									</div>
									<div class="row form-group">
										<div class="col col-md-3" align="right">
											<label for="text-input" class=" form-control-label">Street
												Name</label>
										</div>
										<div class="col col-md-5">
											<input type="text" id="text-input" name="StreetName"
												placeholder="enter street name" class="form-control"
												id="StreetName">
										</div>
										<div class="col col-md-4"></div>
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
