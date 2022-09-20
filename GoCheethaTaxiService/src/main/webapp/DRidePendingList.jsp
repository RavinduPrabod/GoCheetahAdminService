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
										<strong class="fa fa-flag"
											style="color: blue; font-weight: bold;"> New Rides</strong>
									</div>
									<div class="col-md-10" align="right"></div>
								</div>
							</div>
							<div class="card-body">
								<form class="row g-5" action="BookingMasterServlet" method="get">
									<table class="table">
										<thead>
											<tr>
												<th>Booking ID</th>
												<th>FROM</th>
												<th>TO</th>
												<th>PickUp Location</th>
												<th>PickUp Date</th>
												<th>PickUp Time</th>
												<th>Status</th>
												<th>View</th>
												<th>Take</th>
												<th>Reject</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${DrvpendingList}" var="DrvpendingList">
												<c:url var="Viewlink" value="BookingMasterServlet">
													<c:param name="command" value="VIEWINFO"></c:param>
													<c:param name="BookingID"
														value="${DrvpendingList.bookingID}"></c:param>
												</c:url>
												<c:url var="updatelink" value="BookingMasterServlet">
													<c:param name="command" value="APPROVE"></c:param>
													<c:param name="BookingID"
														value="${DrvpendingList.bookingID}"></c:param>
												</c:url>
												<c:url var="deletelink" value="BookingMasterServlet">
													<c:param name="command" value="REJECT"></c:param>
													<c:param name="BookingID"
														value="${DrvpendingList.bookingID}"></c:param>
												</c:url>
												<tr>
													<td>${DrvpendingList.bookingID  }</td>
													<td>${DrvpendingList.cityName }</td>
													<td>${DrvpendingList.streetName }</td>
													<td>${DrvpendingList.pickUpLocation }</td>
													<td>${DrvpendingList.pickUpdate }</td>
													<td>${DrvpendingList.pickUptime }</td>
													<td><c:choose>
															<c:when test="${DrvpendingList.status == 1}">
																<span class="badge badge-warning"
																	style="font-size: 15px">Pending</span>
															</c:when>
															<c:otherwise></c:otherwise>
														</c:choose></td>
													<td><a class="btn btn-default" href="${Viewlink}"><i
															class="fa fa-eye" style="color: black; font-size: 24px"></i></a></td>
													<td><a class="fa fa-thumbs-up"
														style="color: lime; font-size: 36px" href="${updatelink}"></a></td>
													<td><a class="fa fa-ban"
														style="color: red; font-size: 36px" href="${deletelink}"></a>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
									<div class="modal fade" id="mediumModal" tabindex="-1"
										role="dialog" aria-labelledby="mediumModalLabel"
										aria-hidden="true">
										<div class="modal-dialog modal-lg" role="document">
											<div class="modal-content">
												<div class="modal-header">
													<h5 class="modal-title" id="mediumModalLabel">Customer
														Info</h5>
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
												</div>
												<div class="modal-body">
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
												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-secondary"
														data-dismiss="modal">Cancel</button>
													<button type="button" class="btn btn-primary">Confirm</button>
												</div>
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
	<!-- /#right-panel -->
	<!-- Right Panel -->
	<jsp:include page="assets/DScript.html"></jsp:include>
	<!-- Scripts -->
	<script type="text/javascript">
		function OpenBootstrapPopup() {
			$("#mediumModal").modal('show');
		}
	</script>
</body>
</html>
