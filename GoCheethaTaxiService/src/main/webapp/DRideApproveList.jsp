<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
											style="color: red; font-weight: bold;"> Active Rides</strong>
									</div>
									<div class="col-md-10" align="right"></div>
								</div>
							</div>
							<div class="card-body">
								<table class="table">
									<thead>
										<tr>
											<th>Booking ID</th>
											<th>FROM</th>
											<th>TO</th>
											<th>P Location</th>
											<th>P Date</th>
											<th>P Time</th>
											<th>Status</th>
											<th>VIEW</th>
											<th>ONWAY</th>
											<th>PICK</th>
											<th>DROP</th>
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
											<c:url var="onway" value="ConfirmListServlet">
												<c:param name="command" value="ONWAY"></c:param>
												<c:param name="BookingID"
													value="${DrvpendingList.bookingID}"></c:param>
											</c:url>
											<c:url var="pick" value="ConfirmListServlet">
												<c:param name="command" value="PICK"></c:param>
												<c:param name="BookingID"
													value="${DrvpendingList.bookingID}"></c:param>
											</c:url>
											<c:url var="drop" value="ConfirmListServlet">
												<c:param name="command" value="DROP"></c:param>
												<c:param name="BookingID"
													value="${DrvpendingList.bookingID}"></c:param>
											</c:url>
											<c:url var="finish" value="ConfirmListServlet">
												<c:param name="command" value="FINISH"></c:param>
												<c:param name="BookingID"
													value="${DrvpendingList.bookingID}"></c:param>
											</c:url>
											<c:url var="deletelink" value="ConfirmListServlet">
												<c:param name="command" value="REJECT"></c:param>
												<c:param name="BookingID"
													value="${DrvpendingList.bookingID}"></c:param>
											</c:url>
											<tr>
												<td>${DrvpendingList.bookingID  }</td>
												<td>${DrvpendingList.cityName }</td>
												<td>${DrvpendingList.streetName }</td>
												<td hidden="true">${DrvpendingList.amountperKM }</td>
												<td hidden="true">$ {DrvpendingList.amount }</td>
												<td>${DrvpendingList.pickUpLocation }</td>
												<td>${DrvpendingList.pickUpdate }</td>
												<td>${DrvpendingList.pickUptime }</td>
												<td><c:choose>
														<c:when test="${DrvpendingList.status == 2}">
															<span class="badge badge-warning" style="font-size: 15px">Confirm</span>
														</c:when>
														<c:when test="${DrvpendingList.status == 3}">
															<span class="badge badge-info" style="font-size: 15px">OnWay</span>
														</c:when>
														<c:when test="${DrvpendingList.status == 4}">
															<span class="badge badge-primary" style="font-size: 15px">Pick</span>
														</c:when>
														<c:when test="${DrvpendingList.status == 5}">
															<span class="badge badge-dark" style="font-size: 15px">FINSIH
																RIDE</span>
														</c:when>
														<c:when test="${DrvpendingList.status == 5}">
															<span class="badge badge-dark" style="font-size: 15px">Reject</span>
														</c:when>
														<c:otherwise></c:otherwise>
													</c:choose></td>
												<td><a class="btn btn-default" href="${Viewlink}"><i
														class="fa fa-eye" style="color: brown; font-size: 24px;"></i></a></td>
												<td><a class="fa fa-road"
													style="color: black; font-size: 34px;" href="${onway}"></a></td>
												<td><a class="fa fa-male"
													style="color: blue; font-size: 34px" href="${pick}"></a>
												<td><a class="fa fa-flag-checkered"
													style="color: lime; font-size: 34px"
													href="javascript:void(0);"
													onclick="OpenBootstrapPopup('${DrvpendingList.amountperKM}',${DrvpendingList.bookingID},'${DrvpendingList.amount}')"></a>
												<td><a class="fa fa-ban"
													style="color: red; font-size: 34px" href="${deletelink}"></a>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<div class="modal fade" id="mediumModal" tabindex="-1"
								role="dialog" aria-labelledby="mediumModalLabel"
								aria-hidden="true">
								<div class="modal-dialog modal-lg" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
											<h2 class="modal-title" id="mediumModalLabel">
												Booking ID : <input id="txtbookingID" name="BookingID"
													style="border: none;" disabled="disabled">
											</h2>
										</div>
										<div class="modal-body">
											<form method="get" id="frmDrop">
												<input class="form-control" type="hidden" name="command"
													value="DROP" readonly="readonly">
												<div class="row form-group">
													<div class="col col-md-4" align="right">Amoount per
														charges K/M :</div>
													<div class="col col-md-4" align="right">
														<input class="form-control" type="number" step="0.00"
															id="txtamountperKM" name="amountperKM"
															style="text-align: right;" disabled="disabled">
													</div>
												</div>
												<div class="row form-group">
													<div class="col col-md-4" align="right">Total KM
														Covered :</div>
													<div class="col col-md-4">
														<input class="form-control" type="text" id="txtKminput"
															name="KMCovered" placeholder="0" onchange="AddData(this)"
															style="text-align: right;" onKeyUp="AddData(this)">
													</div>
												</div>
												<div class="row form-group">
													<div class="col col-md-4" align="right">Sub Total :</div>
													<div class="col col-md-4" align="right">
														<input class="form-control" type="text" id="txtSubTotal"
															value="0.00" name="SubTotal" style="text-align: right;"
															disabled="disabled">
													</div>
												</div>
												<div class="row form-group">
													<div class="col col-md-4" align="right">Service
														Charge :</div>
													<div class="col col-md-4" align="right">
														<input class="form-control" type="text"
															id="txtServiceCharge" value="0.00" name="ServiceCharge"
															style="text-align: right;" disabled="disabled">
													</div>
												</div>
												<div class="row form-group">
													<div class="col col-md-4" align="right" ><label class="label" style="font-weight: bold;">Net Total</label>   
														:</div>
													<div class="col col-md-4" align="right">
														<input class="form-control" type="text"
															id="txtTotalCharges" value="0.00" name="TotalCharges"
															style="text-align: right; font-size: bold;" disabled="disabled">
													</div>
												</div>
											</form>
										</div>
										<div class="modal-footer">
											<button type="button" onclick="submitForm();"
												class="btn btn-primary">Confirm</button>
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Cancel</button>
										</div>
									</div>
								</div>
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
	<script>
	
	function OpenBootstrapPopup(amt,id,amount) {
		$("#txtamountperKM").val(amt);
		$("#txtbookingID").val(id);
		$("#txtServiceCharge").val(amount);
		$("#mediumModal").modal('show');
	}
	
	function submitForm(){
		$("#frmDrop").submit();
	}
	function AddData(e){
        var kmCovered = $(e).val();
        var chargeperKm = $("#txtamountperKM").val();
        var ServiceCharge = $("#txtServiceCharge").val();

        var  SubAmount = parseFloat(parseFloat(kmCovered) * parseFloat(chargeperKm)).toFixed(2);
        var  TotalAmount = parseFloat(parseFloat(SubAmount) + parseFloat(ServiceCharge)).toFixed(2);
        
        $("#txtSubTotal").val(SubAmount);
        $("#txtTotalCharges").val(TotalAmount);
    }

	</script>
</body>
</html>
