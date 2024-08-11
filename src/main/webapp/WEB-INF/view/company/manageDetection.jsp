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

<%-- <link rel="stylesheet"
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
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/videoPreview.css">
<!-- endinject -->
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/adminResources/images/favicon.png" />
 --%>
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
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/videoPreview.css">
<!-- endinject -->
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/adminResources/images/favicon.png" />
</head>
<body>
	<div class="container-scroller">
		<!-- partial:../../partials/_navbar.html -->


		<jsp:include page="header.jsp"></jsp:include>


		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			<!-- partial:../../partials/_settings-panel.html -->
			<!-- partial -->
			<!-- partial:../../partials/_sidebar.html -->


			<jsp:include page="menu.jsp"></jsp:include>

			<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">
					<div class="card">
						<div class="card-header custom-card-header">
							<h4 class="text-white m-0">Detection</h4>
						</div>
						<div class="card-body">
							<div class="row">
								<div class="col-lg-12">
									<div class="table-responsive">
										<table id="order-listing" class="table">
											<thead>
												<tr>
													<th>Sr. No</th>
													<th>Employee UserName</th>
													<th>Video</th>
													<th>Detection Time</th>
													<th>Date</th>
													<th>Face Count</th>
													<th>Status</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${detectionList}" var="p" varStatus="j">
													<tr>
														<td>${j.count}</td>
														<td>${p.employeeVO.userName}</td>
														<td>
															<!-- Video For loop start here  -  !!! don't change SRC !!! video path give in title and name in alt -->
															<img id="myImg" onclick="videoPreview(this)"
															src="<%=request.getContextPath()%>/adminResources/images/videoImg.jpg"
															title="<%=request.getContextPath()%>/detection_videos/${p.detectionVideo}"
															alt="${p.employeeVO.userName}" style="width: 70%;"> <%-- <video width="100" height="100" controls>
															<source
																src="<%=request.getContextPath()%>/detection_videos/${p.detectionVideo}"
																type="video/mp4"></video> --%>
														</td>
														<td>${p.timeDiff}</td>
														<%-- <%@ taglib prefix="fmt"
															uri="http://java.sun.com/jsp/jstl/fmt"%>
														<td><fmt:parseDate value="${p.detectionDateTime}" var="parsedDate" pattern="dd-MM-yyyy" /></td> --%>
														<td>${p.detectionDateTime}</td>
														<%-- <td>${parsedDate}</td> --%>
														<td>${p.faceCount}</td>
														<td>${p.detectionStatus}</td>
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


		<!-- The Modal for Video Preview  -->
		<div id="myModal" class="custon-modal">
			<span class="custom-close">&times;</span>
			<video class="custon-modal-content" id="img01" controls></video>
			<div id="caption"></div>
		</div>
	</div>
	<!-- container-scroller -->
	<!-- plugins:js -->
	<script
		src="<%=request.getContextPath()%>https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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

	<script>
		// Get the modal
		var modal = document.getElementById("myModal");

		// Get the image and insert it inside the modal - use its "alt" text as a caption
		var img = document.getElementById("myImg");
		var modalVideo = document.getElementById("img01");
		var captionText = document.getElementById("caption");

		function videoPreview(id) {
			modal.style.display = "block";
			modalVideo.src = id.title;
			captionText.innerHTML = id.alt;
		}

		// Get the <span> element that closes the modal
		var span = document.getElementsByClassName("custom-close")[0];

		// When the user clicks on <span> (x), close the modal
		span.onclick = function() {
			modal.style.display = "none";
		}
	</script>


</body>

</html>
