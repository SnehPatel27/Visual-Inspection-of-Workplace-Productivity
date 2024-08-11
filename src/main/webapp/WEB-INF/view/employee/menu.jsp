<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<nav class="sidebar sidebar-offcanvas" id="sidebar">
	<ul class="nav">
		<li class="nav-item"><a class="nav-link" href="index"> <i
				class="mdi mdi-home menu-icon"></i> <span class="menu-title">Home</span>
		</a></li>
		<li class="nav-item"><a class="nav-link" href="#" onclick="fn('${employeeVO.companyLoginVO.id}','${employeeVO.employeeLoginVO.id}')"> <i
				class="mdi mdi-cctv menu-icon"></i> <span class="menu-title">Detection</span>
		</a></li>
		<!-- <li class="nav-item"><a class="nav-link" data-toggle="collapse"
			href="#ui-advanced" aria-expanded="false" aria-controls="ui-advanced">
				<i class="mdi mdi-domain menu-icon"></i> <span class="menu-title">Company</span>
				<i class="menu-arrow"></i>
		</a>
			<div class="collapse" id="ui-advanced">
				<ul class="nav flex-column sub-menu">
					<li class="nav-item"><a class="nav-link"
						href="manageCompany">Manage Company</a></li>
				</ul>
			</div></li>
		<li class="nav-item"><a class="nav-link" data-toggle="collapse"
			href="#form-elements" aria-expanded="false"
			aria-controls="form-elements"> <i
				class="mdi mdi-account menu-icon"></i> <span class="menu-title">Employee</span>
				<i class="menu-arrow"></i>
		</a>
			<div class="collapse" id="form-elements">
				<ul class="nav flex-column sub-menu">
					<li class="nav-item"><a class="nav-link"
						href="manageEmployee">Manage Employee</a></li>
					<li class="nav-item"><a class="nav-link"
						href="viewEmployee">View Employee</a></li>
				</ul>
			</div></li>
		<li class="nav-item"><a class="nav-link" href="manageDetection">
				<i class="mdi mdi-cctv menu-icon"></i> <span class="menu-title">Detection</span></i>
		</a></li>
		<li class="nav-item"><a class="nav-link" href="complains">
				<i class="mdi mdi-comment-alert menu-icon"></i> <span
				class="menu-title">Complains</span>
		</a></li>
		<li class="nav-item"><a class="nav-link" href="feedback">
				<i class="mdi mdi-thumb-up menu-icon"></i> <span class="menu-title">Feedback</span>
		</a></li>-->
		<li class="nav-item"><a class="nav-link" href="/logout">
				<i class="mdi mdi-logout menu-icon"></i> <span class="menu-title">Logout</span>
		</a></li> 
	</ul>
</nav>
	<script type="text/javascript">
			function fn(companyId,empId) {
				var htp = new XMLHttpRequest();
				htp.onreadystatechange = function() {
					if (htp.readyState == 4) {
						console.log(htp.responseText);
					}
				}
	
				htp.open("get", "http://127.0.0.1:5000?empId="+empId+"&companyId="+companyId, true);
				htp.send();
			}
		</script>
