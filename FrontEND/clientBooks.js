$(function (){

	
	var $booksClient = $('#books');

	var booksTemplateClient = "" +
	"<li>" +
	"<p><strong>Titlu:</strong> {{title}}</p>" +
	"<p><strong>Autor:</strong> {{author}}</p>" +
	"<p><strong>numarDeCopii:</strong> {{numberOfCopies}}</p>" +
	"</li>";


	function addBookClient(book){
		$booksClient.append(Mustache.render(booksTemplateClient, book));

	}

	$('#showAllBooksClient').click(function(){
		$('#showAllBooksClient').fadeOut(1000, function(){	
	$.ajax({
		type:'GET',
		url: 'http://localhost:8080/books/getBooks',
		dataType: 'json',
		success: function(booksClient){
			console.log(booksClient);
			$.each(booksClient, function(i, book){
				  addBookClient(book);
			});
		},
		error: function(){
			alert('error loading books from library !');
		}
	  }); 
	 });
	});

	
	$('#rentABook').on('click', function(){

			var $numeClient = $('#numeClient').val();
			var $numeCarte = $('#numeCarteDorita').val();		
		
			var myRent = {

				numeClient: $('#numeClient').val(),
				numeCarte: $('#numeCarteDorita').val()
				
			};

		$.ajax({
			type: 'POST',
			url:'http://localhost:8080/library/createNewRent/'+$numeClient+'/'+$numeCarte,
			dataType: 'text',
			success: function(){
				alert('Ai imprumutat cartea ' + $numeCarte + '. Lectura placuta !');
			},
			error:function(){
				alert($numeClient + ' 	SAU		' + $numeCarte + '	nu exista in baza de date !');
				console.log($numeCarte);
			}

		});
	});

	$('#returnABook').on('click', function(){

			var $numeClient = $('#numeClient').val();
			var $numeCarte = $('#numeCarteDorita').val();		
		
			var myRent = {

				numeClient: $('#numeClient').val(),
				numeCarte: $('#numeCarteDorita').val()
				
			};

		$.ajax({
			type: 'POST',
			url:'http://localhost:8080/library/returnBook/'+$numeClient+'/'+$numeCarte,
			dataType: 'text',
			success: function(){
				alert('Ai returnat cartea  ' + $numeCarte + '. Multumim !');
			},
			error:function(){
				alert($numeClient + ' SAU	' + $numeCarte + '	nu exista in baza de date !');
				console.log($numeCarte);
			}

		});
	});
});
