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
		<div class="breadcrumbs">
			<div class="breadcrumbs-inner">
				<div class="row m-0">
					<div class="col-sm-4">
						<div class="page-header float-left">
							<div class="page-title">
								<h1>Dashboard</h1>
							</div>
						</div>
					</div>
					<div class="col-sm-8">
						<div class="page-header float-right">
							<div class="page-title">
								<ol class="breadcrumb text-right">
									<li><a href="#">Dashboard</a></li>
									<li><a href="#">Table</a></li>
									<li class="active">Data table</li>
								</ol>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="content">
			<div class="animated fadeIn">
				<div class="row">
					<div class="col-md-12">
						<div class="card">
							<div class="card-header">
								<div class="row form-group">
									<div class="col-md-2">
										<strong class="card-title">Customer List</strong>
									</div>
								</div>
							</div>
							<div class="card-body">
								<form class="row g-3" action="CustomerMasterServlet" method="get">
									<table class="table table-striped table-bordered">
										<thead>
											<tr>
												<th>Customer ID</th>
												<th>Name</th>
												<th>City</th>
												<th>MobileNo</th>
												<th>Email</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${CustomerList}" var="Customer">
												<c:url var="updatelink" value="CustomerMasterServlet">
													<c:param name="command" value="SHOW-UPDATE"></c:param>
													<c:param name="CustomerID " value="${Customer.customerID }"></c:param>
												</c:url>

												<c:url var="deletelink" value="CustomerMasterServlet">
													<c:param name="command" value="DELETE-LIST"></c:param>
													<c:param name="CustomerID " value="${Customer.customerID}"></c:param>
												</c:url>
												<tr>
													<td>${Customer.customerID}</td>
													<td>${Customer.firstName}</td>
													<td>${Customer.city }</td>
													<td>${Customer.mobileNo }</td>
													<td>${Customer.email }</td>
													
												</tr>
											</c:forEach>
										</tbody>
									</table>
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