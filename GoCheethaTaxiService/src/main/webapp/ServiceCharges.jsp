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
								<strong class="card-title">Service Charges</strong>
							</div>
							<div class="card-body card-block">
								<table class="table table-striped table-bordered">
									<thead>
										<tr>
											<th>Vehicle Type</th>
											<th>Amount</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${SerCharge}" var="SerCharge">
											<c:url var="updatelink" value="ServiceChargeServlet">
												<c:param name="command" value="SHOW-UPDATE"></c:param>
												<c:param name="VehicleType" value="${SerCharge.vehicleType}"></c:param>
												<c:param name="VehicleType" value="${SerCharge.amount}"></c:param>
											</c:url>
											<tr>
												<td class="text-primary"><c:choose>
														<c:when test="${SerCharge.vehicleType == 1}">Tuk-tuk</c:when>
														<c:when test="${SerCharge.vehicleType == 2}">Car</c:when>
														<c:when test="${SerCharge.vehicleType == 3}">Van</c:when>
														<c:when test="${SerCharge.vehicleType == 4}">Lorry</c:when>
														<c:otherwise>None</c:otherwise>
													</c:choose></td>
												<td>${SerCharge.amount }</td>
												<td><button class="btn btn-danger" type="button"
														class="btn btn-primary"
														onclick="ConfirmDelete('${SerCharge.vehicleType }');">Delete</button>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<form action="ServiceChargeServlet" method="post"
									class="form-horizontal">
									<div id="showAdd">
										<input type="hidden" name="command" value="ADDDATA" />
										<div class="row form-group">
											<div class="col col-md-3" align="right">
												<label for="text-input" class=" form-control-label">Vehicle
													Type </label>
											</div>
											<div class="col col-md-5">
												<select name="VehicleType" id="select" class="form-control">
													<option value="0">-Select-</option>
													<option value="1">Tuk-tuk</option>
													<option value="2">Car</option>
													<option value="3">Van</option>
													<option value="4">Lorry</option>
												</select>
											</div>
											<div class="col col-md-4"></div>
										</div>
										<div class="row form-group">
											<div class="col col-md-3" align="right">
												<label for="text-input" class=" form-control-label">Service
													Charge Amount </label>
											</div>
											<div class="col col-md-5">
												<input type="text" id="text-input" name="Amount"
													placeholder="0.00" class="form-control">
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
	<jsp:include page="assets/Scripts.html"></jsp:include>
	<script type="text/javascript">
		
	</script>
</body>
</html>
