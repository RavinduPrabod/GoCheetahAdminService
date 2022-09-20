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
					<div class="col-lg-3 col-md-6">
						<div class="card">
							<div class="card-body">
								<div class="stat-widget-five">
									<div class="stat-icon dib flat-color-2">
										<i class="ti-agenda"></i>
									</div>
									<div class="stat-content">
										<div class="text-left dib">
											<div class="stat-text">
												<span class="count">${oDash.pendingCount}</span>
											</div>
											<div class="stat-heading">Pending</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-md-6">
						<div class="card">
							<div class="card-body">
								<div class="stat-widget-five">
									<div class="stat-icon dib flat-color-4">
										<i class="ti-rss-alt"></i>
									</div>
									<div class="stat-content">
										<div class="text-left dib">
											<div class="stat-text">
												<span class="count">${oDash.activeCount}</span>
											</div>
											<div class="stat-heading">Active</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-md-6">
						<div class="card">
							<div class="card-body">
								<div class="stat-widget-five">
									<div class="stat-icon dib flat-color-3">
										<i class="ti-cup"></i>
									</div>
									<div class="stat-content">
										<div class="text-left dib">
											<div class="stat-text">
												<span class="count">${oDash.completeCount}</span>
											</div>
											<div class="stat-heading">Complete</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-md-6">
						<div class="card">
							<div class="card-body">
								<div class="stat-widget-five">
									<div class="stat-icon dib flat-color-4">
										<i class="ti-close"></i>
									</div>
									<div class="stat-content">
										<div class="text-left dib">
											<div class="stat-text">
												<span class="count">${oDash.cancelCount}</span>
											</div>
											<div class="stat-heading">Cancel</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-sm-12 mb-4">
					<div class="card-group">
						<div class="card col-md-6 no-padding ">
							<div class="card-body">
								<div class="h1 text-muted text-right mb-4">
									<i class="fa fa-coin"></i>
								</div>

								<div class="h4 mb-0">
									<span class="count">2600</span> -/ LKR
								</div>

								<small class="text-muted text-uppercase font-weight-bold">Revenue</small>
								<div class="progress progress-xs mt-3 mb-0 bg-flat-color-1"
									style="width: 5%; height: 5px;"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- .row -->
			<!--  /Traffic -->
			<div class="clearfix"></div>
		</div>
		<!-- .animated -->
	</div>
	<!-- .content -->
	<div class="clearfix"></div>
	<!-- /#right-panel -->
	<!-- Right Panel -->
	<jsp:include page="assets/DScript.html"></jsp:include>
	<!-- Scripts -->
</body>
</html>
