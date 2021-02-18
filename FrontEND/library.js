$(function (){

    var $library = $('#library');

   var libraryTemplate = "" +
	"<li>" +
	"<p><strong>numeClient:</strong> {{numeClient}}</p>" +
	"<p><strong>numeCarteImprumutata:</strong> {{numeCarte}}</p>" +
	"<button data-id='{{client}}' class='remove'>Delete</button>" +
	"</li>";
    
    function addRent(book){
		$library.append(Mustache.render(libraryTemplate, book));

	}

	$('#showAllRents').click(function(){
		$('#showAllRents').fadeOut(1000, function(){	
	$.ajax({
		type:'GET',
		url: 'http://localhost:8080/library/getLibrary',
		dataType: 'json',
		success: function(library){
			console.log(library);
			$.each(library, function(i, lib){
				  addRent(lib);
			$('#showAllRents').fadeIn(1000,function(){});
			});
		},
		error: function(){
			alert('error loading RENTS from library !');
		}
	  }); 
	 });
	});

	$('#addNewRent').on('click', function(){

			var $numeClient = $('#numeClient').val();
			var $numeCarte = $('#numeCarte').val();		
		
			var myRent = {

				numeClient: $('#numeClient').val(),
				numeCarte: $('#numeCarte').val()
				
			};

		$.ajax({
			type: 'POST',
			url:'http://localhost:8080/library/createNewRent/'+$numeClient+'/'+$numeCarte,
			dataType: 'json',
			success: function(){
				alert('Bravo ma !');
				addRent(myRent);
			},
			error:function(){
				alert($numeClient + ' 	SAU		' + $numeCarte + '	nu exista in baza de date !');
			}

		});
	});
});
