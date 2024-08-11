$(document).ready(function() {
	$("#signupForm").validate({
		rules : {
			ceoname : {
				required : true,	
			},
			
			ceocontact : {
				required : true,
				number : true,
				minlength : 8,
				maxlength : 10,
			},
			ceoemailid : {
				required : true,
				email : true
			},
			hrname : {
				required : true,
			},
			
			hrcontact : {
				required : true,
				number : true,
				minlength : 8,
				maxlength : 10,
			},
			hremailid : {
				required : true,
				email : true
			},
		},
		messages : {
			ceoname : {
				required : "Please Enter CEO's Name",
			},
			ceoemailid : {
				required : "Please Enter valid Email address"
			},
			ceocontact : {
				required : "Please Enter the mobile number",
				number : "Just Enter number",
				minlength : "Please Enter a valid number",
				maxlength : "Please Enter a valid number",
			},
			hrname : {
				required : "Please Enter HR's Name",
			},
			hremailid : {
				required : "Please Enter valid Email address"
			},
			hrcontact : {
				required : "Please Enter the mobile number",
				number : "Just Enter number",
				minlength : "Please Enter a valid number",
				maxlength : "Please Enter a valid number",
			},
		}
		
	});
})