$().ready(function() {
	$("#signupForm").validate({
		rules : {
			employeename : {
				required : true,
			},
			employeeid: {
				required : true,
				number : true,
			},
			employeecontact : {
				required : true,
				number : true,
				minlength : 8,
				maxlength : 10,
			},
			employeemail : {
				required : true,
				email : true
			},
			doj : {
				required : true,
			},
			designation : {
				required : true,
			},
		},
		messages : {
			employeename : {
				required : "Please Enter Employee Name",
			},
			employeeid : {
				required : "Please Enter a number",
			},
			employeemail : {
				required : "Please Enter valid Email address"
			},
			employeecontact : {
				required : "Please Enter the mobile number",
				number : "Just Enter number",
				minlength : "Please Enter a valid number",
				maxlength : "Please Enter a valid number",
			},
			doj : {
				required : "Please Enter Date of Joining",
			},
			designation : {
				required : "Please Enter the Designation",
			},
		}
	});
})