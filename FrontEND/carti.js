$(function (){

	var $books = $('#books');

	var booksTemplate = "" +
	"<li>" +
	"<p><strong>Titlu:</strong> {{title}}</p>" +
	"<p><strong>Autor:</strong> {{author}}</p>" +
	"<p><strong>numarDeCopii:</strong> {{numberOfCopies}}</p>" +
	"<button data-id='{{title}}' class='remove'>Delete</button>" +
	"</li>";


	function addBook(book){
		$books.append(Mustache.render(booksTemplate, book));

	}

	

	$('#showAllBooks').click(function(){
		$('#showAllBooks').fadeOut(1000, function(){	
	$.ajax({
		type:'GET',
		url: 'http://localhost:8080/books/getBooks',
		dataType: 'json',
		success: function(books){
			console.log(books);
			$.each(books, function(i, book){
				  addBook(book);
			$('#showAllBooks').fadeIn(10000,function(){});
			});
		},
		error: function(){
			alert('error loading books from library !');
		}
	  }); 
	 });
	});

	$('#deleteAllBooks').click(function(){
		$('#books').fadeOut(1000, function(){
			$('#books').remove();
		});
	});

	$('#add-book').on('click', function(){

			var $title = $('#title').val();
			var $author = $('#author').val();
			var $numberOfCopies = $('#numberOfCopies').val();		
		
			var myBook = {

				title: $('#title').val(),
				author: $('#author').val(),
				numberOfCopies: $('#numberOfCopies').val()
			};

		$.ajax({
			type: 'POST',
			url:'http://localhost:8080/books/addBook/'+$title+'/'+$author+'/'+$numberOfCopies,
			dataType: 'json',
			success: function(){
				alert('Bravo ma !');
				addBook(myBook);
			},
			error:function(){
				alert('Bravo ma !');
				addBook(myBook);
			}

		});
	});
	
	$books.delegate('.remove', 'click', function(){

	var $li = $(this).closest('li');

	$.ajax({
		type: 'POST',
		url: 'http://localhost:8080/books/deleteBookByTitle/' + $(this).attr('data-id'),
		success: function(){
			$li.fadeOut(800, function(){
				$(this).remove();
			});
		}
	});

	});
	
});
