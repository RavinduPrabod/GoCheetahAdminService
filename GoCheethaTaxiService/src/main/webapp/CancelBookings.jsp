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
								<div class="row form-group">
									<div class="col-md-2">
										<strong class="card-title" style="color: orange;">Cancel
											Bookings</strong>
									</div>
								</div>
							</div>
							<div class="card-body">
								<input type="hidden" name="command" value="ACTIVE" />
									<table class="table table-striped table-bordered">
										<thead>
											<tr>
												<th>ID</th>
												<th>Customer ID</th>
												<th>Cancel By ID</th>
												<th>Cancel By Name</th>
												<th>Vehicle Type</th>
												<th>Vehicle No</th>
												<th>Status</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${CancelList}" var="CancelList">
												<tr>
													<td>${CancelList.bookingID  }</td>
													<td>${CancelList.customerID  }</td>
													<td>${CancelList.driverID }</td>
													<td>${CancelList.driverName }</td>
													<td class="text-primary"><c:choose>
															<c:when test="${CancelList.vehicleType == 1}">Tuk-tuk</c:when>
															<c:when test="${CancelList.vehicleType == 2}">Car</c:when>
															<c:when test="${CancelList.vehicleType == 3}">Van</c:when>
															<c:when test="${CancelList.vehicleType == 4}">Lorry</c:when>
															<c:otherwise>None</c:otherwise>
														</c:choose></td>
													<td>${CancelList.vehicleNo }</td>
													<td><c:choose>
															<c:when test="${CancelList.status == 0}">
																<span class="badge badge-warning">Canceled</span>
															</c:when>
															<c:otherwise></c:otherwise>
														</c:choose></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
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