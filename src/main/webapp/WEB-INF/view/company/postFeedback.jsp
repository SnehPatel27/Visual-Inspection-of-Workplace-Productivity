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
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/adminResources/css/star.css">
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
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
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
									<h4 class="text-white m-0">Feedback</h4>
								</div>
								<div class="card-body">
									<f:form class="cmxform" id="signupForm" method="post"
										action="savefeedback" modelAttribute="feedback">
										<fieldset class="">
											<div class="form-group rating">

												<f:radiobutton path="stars" id="star5" name="rating"
													value="5" />
												<label class="full" for="star5" title="Awesome - 5 stars"></label>
												<f:radiobutton path="stars" id="star4" name="rating"
													value="4" />
												<label class="full" for="star4"
													title="Pretty good - 4 stars"></label>
												<f:radiobutton path="stars" id="star3" name="rating"
													value="3" />
												<label class="full" for="star3" title="Meh - 3 stars"></label>
												<f:radiobutton path="stars" id="star2" name="rating" value="2" />
												<label class="full" for="star2" title="Kinda bad - 2 stars"></label>
												<f:radiobutton path="stars" id="star1" name="rating"
													value="1" />
												<label class="full" for="star1"
													title="Sucks big time - 1 star"></label>


											</div>

											<div class="form-group">
												<f:textarea path="feedbackdescription"
													id="maxlength-textarea" class="form-control"
													maxlength="100" rows="5"
													placeholder="Provide your Feedback..." />
											</div>
											<input class="btn btn-primary" type="submit" value="Save">
										</fieldset>
									</f:form>

								</div>
							</div>
						</div>
<%-- 						<div class="card">
						<div class="card-header custom-card-header">
							<h4 class="text-white m-0">Feedbacks</h4>
						</div>
						<div class="card-body">
							<div class="row">
								<div class="col-12">
									<div class="table-responsive">
										<table id="order-listing" class="table">
											<thead>
												<tr>
													<th>Sr.No</th>
													<th>Rating</th>
													<th>Description</th>
													<th>Actions</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${list}" var="i" varStatus="j">
													<tr>
														<td>${j.count}</td>
														<td><c:forEach begin="1" end="${i.stars}">
																<i class="mdi mdi-star lead"></i>
															</c:forEach></td>
														
														<td class="text-tomcat" title="${i.feedbackdescription}">
															<span class="tooltiptext">${i.feedbackdescription}</span>
														</td>

														<td><i class="mdi mdi-delete lead text-danger ml-2"></i>
														</td>
												</c:forEach>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
 --%>						
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
		src="<%=request.getContextPath()%>/adminResources/js/form-validation.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/bt-maxLength.js"></script>
	<!-- End custom js for this page-->
</body>

</html>
