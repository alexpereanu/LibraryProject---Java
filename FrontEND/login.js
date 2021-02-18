$(function(){

	var $submit = $('#submit');
	var $us = document.getElementById("username").value;

	var attempt = 2;

	$('#submit').click(function(){
 

	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;

	if ( username == "admin" && password == "admin"){
		alert ("Login successfully");
		window.location = "clienti.html"; 
	return false;
	}

	else{
		$.ajax({

			type:'GET',
			url: 'http://localhost:8080/client/getClientByName/'+username,
			dataType: 'json',

		success: function(library){
			alert("Bine ati revenit, 	" + username + ' !');
			window.location = "clientBooks.html";
		},
		error: function(){
			alert('Clientul	' + username + ' nu are cont la noi !');
			attempt--;
			console.log(attempt);
		}
	  }); 
	
  }

	if( attempt == 0){
		document.getElementById("username").disabled = true;
		document.getElementById("password").disabled = true;
		document.getElementById("submit").disabled = true;

	return false;	
	}
  

	});

});