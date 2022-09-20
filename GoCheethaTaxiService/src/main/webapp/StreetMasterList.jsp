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
										<strong class="card-title">Street List</strong>
									</div>
									<div class="col-md-10" align="right">
										<div class="col-md-10" align="right">
										 <a class="btn btn-success" href="StreetMasterServlet?command=ADDNEW">
										 Add New
										 </a>
									</div>
									</div>
								</div>
							</div>
							<div class="card-body">
								<form class="row g-3" action="StreetMasterServlet" method="get">
									<table
										class="table table-striped table-bordered">
										<thead>
											<tr>
											<th>ID</th>
												<th>City</th>
												<th>Street Name</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${StreetList}" var="Street">
												<c:url var="updatelink" value="StreetMasterServlet">
													<c:param name="command" value="SHOW-UPDATE"></c:param>
													<c:param name="StreetID" value="${Street.streetID}"></c:param>
												</c:url>
												<c:url var="deletelink" value="StreetMasterServlet">
													<c:param name="command" value="DELETE-LIST"></c:param>
													<c:param name="StreetID" value="${Street.streetID}"></c:param>
												</c:url>
												<tr>
												<td>${Street.streetID }</td>
													<td>${Street.cityName }</td>
													<td>${Street.streetName }</td>
													<td><a href="${updatelink}" class="btn btn-warning">Edit</a>
														<a href="${deletelink}" class="btn btn-danger"
														onclick="if(!confirm('Are you sure want to delete this ?')) return false">Delete</a>
													</td>
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
