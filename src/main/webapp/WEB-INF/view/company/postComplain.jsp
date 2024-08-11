<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Company</title>
<!-- plugins:css -->
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
	<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
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
					<div class="row">
						<div class="col-lg-12">
							<div class="card">
								<div class="card-header custom-card-header">
									<h4 class="text-white m-0">Complain</h4>
								</div>
								<div class="card-body">
									<f:form class="cmxform" id="signupForm" method="post"
										action="saveComplaint" modelAttribute="complain"
										enctype="multipart/form-data">
										<fieldset>
											<div class="form-group">
												<label for="complainsubject">Subject</label>
												<f:input path="complainsubject" id="complainsubject"
													class="form-control" name="complainsubject" />
											</div>
											<div class="form-group">
												<label for="complaindescription">Description</label>
												<f:textarea path="complaindescription"
													id="complaindescription" class="form-control"
													name="complaindescription" type="text" />
											</div>

											<div class="form-group">
												<label>File upload</label> <input type="file" name="file"
													class="file-upload-default">
												<div class="input-group col-xs-12">
													<input type="text" class="form-control file-upload-info"
														disabled placeholder="Upload Image"> <span
														class="input-group-append">
														<button class="file-upload-browse btn btn-primary"
															type="button">Upload</button>
													</span>
												</div>
											</div>

											<!-- <div class="form-group">
												<label>File upload</label> <input type="file" name="file"
													class="form-control">
												<div class="input-group col-xs-12">
													<input type="text" class="form-control file-upload-info"
														 placeholder="Upload Image"> <span
														class="input-group-append">
														<button class="file-upload-browse btn btn-primary"
															type="button">Upload</button>
													</span>
												</div> 
											</div> -->

											<input class="btn btn-primary" type="submit" value="Post">
										</fieldset>
									</f:form>
								</div>
							</div>

						</div>
					</div>
				</div>
			<%-- 	<div class="content-wrapper">
					<div class="card">
						<div class="card-header custom-card-header">
							<h4 class="text-white m-0">View Complaint</h4>
						</div>
						<div class="card-body">
							<div class="row">
								<div class="col-12">
									<div class="table-responsive">
										<table id="order-listing" class="table">
											<thead>
												<tr>
													<th>Sr No</th>
													<th>Complain Subject</th>
													<th>Complain Description</th>
													<th>Attachment</th>
													<th>Complain Date</th>
													<th>Complain Reply Date</th>
													<th>Reply</th>
													<th>Status</th>
													<th>Action</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${Complainlist}" var="i" varStatus="j">
													<tr>
														<td>${j.count}</td>
														<td>${i.complainsubject}</td>
														<td class="text-tomcat" title="${i.complaindescription}">
															<span class="tooltiptext">${i.complaindescription}</span>
														</td>

														<td><a
															href="<%=request.getContextPath()%>/complaint-docs/${i.fileName}"
															target="_blank"><span class="mdi mdi-attachment"
																style="font-size: 20px;"></span></a></td>
														<td>${i.complaindate}</td>
														<td>${i.complainreplydate}</td>

														<td class="text-tomcat" title="${i.complainreply}"><span
															class="tooltiptext">${i.complainreply }</span></td>
														<td>${i.status}</td>
														<td><a href="editComplain?id=${i.id}"><i
																class="mdi mdi-pencil lead"></i></a> <a
															href="deleteComplain?id=${i.id}"><i
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
 --%>

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
	<script
		src="<%=request.getContextPath()%>/adminResources/js/jquery.validate.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/jquery.validate.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/validation/complain.js"></script>
	<!-- endinject -->
	<!-- Custom js for this page-->
	<script
		src="<%=request.getContextPath()%>/adminResources/js/file-upload.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/form-validation.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/bt-maxLength.js"></script>
	<!-- End custom js for this page-->
</body>

</html>
