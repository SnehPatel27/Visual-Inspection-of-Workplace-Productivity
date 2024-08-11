$().ready(function() {
	$("#signupForm").validate({
		rules : {
			compname : {
				required : true,
			},
			
			contact : {
				required : true,
				number : true,
				minlength : 8,
				maxlength : 10,
			},
			emailid : {
				required : true,
				email : true
			},
		},
		messages : {
			compname : {
				required : "Please Enter Company Name",
			},
			emailid : {
				required : "Please Enter valid Email address"
			},
			contact : {
				required : "Please Enter the mobile number",
				number : "Just Enter number",
				minlength : "Please Enter a valid number",
				maxlength : "Please Enter a valid number",
			},
		}
	});
})