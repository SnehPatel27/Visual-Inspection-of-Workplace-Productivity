$().ready(function() {
	$("#signupForm").validate({
		rules : {
			complainsubject : {
				required : true,
			},
			complaindescription : {
				required : true,
			},
		},
		messages : {
			complainsubject : {
				required : "Please Enter Subject of Complain",
			},
			complaindescription : {
				required : "Please Enter description",
			},
		}
	});
})