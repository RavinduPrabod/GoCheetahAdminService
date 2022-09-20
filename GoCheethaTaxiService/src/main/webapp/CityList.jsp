<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
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
										<strong class="card-title">City List</strong>
									</div>
									<div class="col-md-10" align="right">
										<div class="col-md-10" align="right">
											<a class="btn btn-success" href="CityAdd.jsp"> Add New </a>
										</div>
									</div>
								</div>
							</div>
							<div class="card-body">
								<table class="table table-striped table-bordered">
									<thead>
										<tr>
											<th>City ID</th>
											<th>Name</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${CityList}" var="city">
											<c:url var="updatelink" value="CityMasterServlet">
												<c:param name="command" value="SHOW-UPDATE"></c:param>
												<c:param name="CityID" value="${city.cityID}"></c:param>
											</c:url>

											<c:url var="deletelink" value="CityMasterServlet">
												<c:param name="command" value="DELETE-LIST"></c:param>
												<c:param name="CityID" value="${city.cityID}"></c:param>
											</c:url>
											<tr>
												<td>${city.cityID }</td>
												<td>${city.cityName }</td>
												<td><a href="${updatelink}" class="btn btn-warning">Edit</a>
													<button class="btn btn-danger" type="button"
														class="btn btn-primary"
														onclick="ConfirmDelete('${city.cityID }');">Delete</button>

												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<div class="modal" id="ConfirmDelete" tabindex="-1"
									role="dialog" aria-labelledby="exampleModalLabel">
									<div class="modal-dialog" role="document">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title" id="exampleModalLabel">Modal
													title</h5>
												<button type="button" class="close" data-dismiss="modal"
													aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
											</div>
											<div class="modal-body">
												<p>Are you sure want to delete this record ?</p>
												<input type="hidden" id="txtID" value="" />
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-secondary"
													data-dismiss="modal">Cancel</button>
												<button type="button" class="btn btn-primary"
													onclick="DeleteRecord()">Confirm</button>
											</div>
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
	<jsp:include page="assets/Scripts.html"></jsp:include>



	<script title="Task">
		$(document).ready(function() {
			$('#ConfirmDelete').modal('hide');
		});

		var ConfirmDelete = function(ID) {
			$("#txtID").val(ID);
			$('#ConfirmDelete').appendTo("body").modal('show');
		}

		var DeleteRecord = function() {
			var id = $("#txtID").val();
			var command = "DELETE-LIST";

			var url = 'CityMasterServlet';

			var ParamPart = "&";
			ParamPart = ParamPart
					+ ((command != "") ? '&command=' + command : '');
			ParamPart = ParamPart + ((id != "") ? '&id=' + id : '');

			ParamPart = ParamPart.replace("&&", "");

			window.location.href = url + '?' + ParamPart;
			event.preventDefault();
		}
	</script>


	<!-- Scripts -->
</body>
</html>
