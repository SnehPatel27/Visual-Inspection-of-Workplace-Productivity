<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Admin</title>
<!-- plugins:css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/custom.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/materialdesignicons.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/vendor.bundle.base.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/vendor.bundle.addons.css">
<!-- endinject -->
<!-- plugin css for this page -->
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/style.css">
<!-- endinject -->
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/adminResources/images/favicon.png" />
</head>

<body>
	<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="x"%>
	<div class="container-scroller">
		<!-- partial:../../partials/_navbar.html -->


		<jsp:include page="header.jsp"></jsp:include>


		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			<!-- partial:../../partials/_settings-panel.html -->
			<!-- partial -->
			<!-- partial:../../partials/_sidebar.html -->


			<jsp:include page="menu.jsp"></jsp:include>


			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">
					<div class="card">
						<div class="card-header custom-card-header">
							<h4 class="text-white m-0">Complain Details</h4>
						</div>
						<div class="card-body">
							<div class="row">
								<div class="col-12">
									<div class="table-responsive">
										<table id="order-listing" class="table">
											<thead>
												<tr>
													<!-- <th>Company Name</th> -->
													<th>Sr.No</th>
													<th>Company Username</th>
													<th>Subject</th>
													<th>Description</th>
													<th>Date</th>
													<th>Attachments</th>
													<th>Status</th>
													<th>Reply</th>
													<th>Reply Date</th>
													<th>Actions</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${list}" var="i" varStatus="j">
													<tr>
														<td>${j.count}</td>
														<td>${i.loginvo.userName}</td>
														<td>${i.complainsubject}</td>
														<td class="text-tomcat" title="${i.complaindescription}">
															<span class="tooltiptext">${i.complaindescription}</span>
														</td>
														<td>${i.complaindate}</td>
														<td><a
															href="<%=request.getContextPath()%>/complaint-docs/${i.fileName}"
															target="_blank"><span class="mdi mdi-attachment"
																style="font-size: 20px;"></span></a></td>

														<td><x:if test="${i.status eq 'Pending'}">
																<a href="complainReply?id=${i.id}">
																	<button class="btn btn-outline-primary">Reply</button>
																</a>
															</x:if> <x:if test="${i.status ne 'Pending'}">
															Replied
														</x:if></td>

														<td class="text-tomcat" title="${i.complainreply}"><span
															class="tooltiptext">${i.complainreply}</span></td>
														<td>${i.complainreplydate}</td>
														<td><a href="deleteComplain?id=${i.id}"><i
																class="mdi mdi-delete lead text-danger ml-2"></i></a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- content-wrapper ends -->
				<!-- partial:../../partials/_footer.html -->


				<jsp:include page="footer.jsp"></jsp:include>


				<!-- partial -->
			</div>
			<!-- main-panel ends -->
		</div>
		<!-- page-body-wrapper ends -->
	</div>
	<!-- container-scroller -->
	<!-- plugins:js -->
	<script
		src="<%=request.getContextPath()%>/adminResources/js/vendor.bundle.base.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/vendor.bundle.addons.js"></script>
	<!-- endinject -->
	<!-- inject:js -->
	<script
		src="<%=request.getContextPath()%>/adminResources/js/off-canvas.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/hoverable-collapse.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/template.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/settings.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/todolist.js"></script>
	<!-- endinject -->
	<!-- Custom js for this page-->
	<script
		src="<%=request.getContextPath()%>/adminResources/js/data-table.js"></script>
	<!-- End custom js for this page-->
</body>
</html>