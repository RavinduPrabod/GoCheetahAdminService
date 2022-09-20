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
					<div class="col-lg-3 col-md-6">
						<div class="card">
							<div class="card-body">
								<div class="stat-widget-four">
									<div class="stat-icon dib">
										<i class="ti-user text-muted"></i>
									</div>
									<div class="stat-content">
										<div class="text-left dib">
											<div class="stat-heading">Users</div>
											<div class="stat-text">Total: ${oDash.userCount}</div>
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
									<div class="stat-icon dib flat-color-1">
										<i class="pe-7s-cash"></i>
									</div>
									<div class="stat-content">
										<div class="text-left dib">
											<div class="stat-text">
												<span class="count"> 13350</span>/- LKR
											</div>
											<div class="stat-heading">Revenue</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-md-6">
						<div class="card">
							<div class="card-body">
								<div class="stat-widget-four">
									<div class="stat-icon dib">
										<i class="ti-stats-up text-muted"></i>
									</div>
									<div class="stat-content">
										<div class="text-left dib">
											<div class="stat-heading">Daily Margin</div>
											<div class="stat-text">Total:3000</div>LKR
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-md-6">
						<div class="card">
							<div class="card-body">
								<div class="stat-widget-one">
									<div class="stat-icon dib">
										<i class="ti-money text-success border-success"></i>
									</div>
									<div class="stat-content dib">
										<div class="stat-text">Total Profit</div>
										<div class="stat-digit">1,012</div> LKR
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
									<i class="fa fa-users"></i>
								</div>

								<div class="h4 mb-0">
									<span class="count">${oDash.customerCount}</span>
								</div>

								<small class="text-muted text-uppercase font-weight-bold">Customers</small>
								<div class="progress progress-xs mt-3 mb-0 bg-flat-color-1"
									style="width: ${oDash.customerCount}%; height: 5px;"></div>
							</div>
						</div>
						<div class="card col-md-6 no-padding ">
							<div class="card-body">
								<div class="h1 text-muted text-right mb-4">
									<i class="fa fa-users"></i>
								</div>
								<div class="h4 mb-0">
									<span class="count">${oDash.driverCount}</span>
								</div>
								<small class="text-muted text-uppercase font-weight-bold">Drivers</small>
								<div class="progress progress-xs mt-3 mb-0 bg-flat-color-2"
									style="width: ${oDash.driverCount}%; height: 5px;"></div>
							</div>
						</div>
						<div class="card col-md-6 no-padding ">
							<div class="card-body">
								<div class="h1 text-muted text-right mb-4">
									<i class="fa fa-truck"></i>
								</div>
								<div class="h4 mb-0">
									<span class="count">${oDash.vehicleCount}</span>
								</div>
								<small class="text-muted text-uppercase font-weight-bold">Vehicle Total</small>
								<div class="progress progress-xs mt-3 mb-0 bg-flat-color-3"
									style="width: ${oDash.vehicleCount}%; height: 5px;"></div>
							</div>
						</div>
						<div class="card col-md-6 no-padding ">
							<div class="card-body">
								<div class="h1 text-muted text-right mb-4">
									<i class="fa fa-pie-chart"></i>
								</div>
								<div class="h4 mb-0">
									<span class="count">${oDash.branchCount}</span>%
								</div>
								<small class="text-muted text-uppercase font-weight-bold">Island Coverage</small>
								<div class="progress progress-xs mt-3 mb-0 bg-flat-color-4"
									style="width: ${oDash.branchCount}%; haeight: 5px;"></div>
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
	<jsp:include page="assets/Scripts.html"></jsp:include>
	<!-- Scripts -->
</body>
</html>
