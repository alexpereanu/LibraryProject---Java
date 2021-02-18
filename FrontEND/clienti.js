$(function (){

var $clients = $('#clients');

var clientsTemplate = "" +
	"<li>" +
	"<p><strong>Nume:</strong> {{nume}}</p>" +
	"<p><strong>Prenume:</strong> {{prenume}}</p>" +
	"<p><strong>Telefon:</strong> {{telefon}}</p>" +
	"<p><strong>cartiImprumutate:</strong> {{cartiImprumutate}}</p>" +
	"<button data-id='{{nume}}' class='remove'>Delete</button>" +
	"</li>";


function addClient(client){
		$clients.append(Mustache.render(clientsTemplate, client));
	}

	$('#add-client').on('click', function(){

			var $nume = $('#nume').val();
			var $prenume = $('#prenume').val();
			var $telefon = $('#telefon').val();		
		
			var myClient = {

				nume: $('#nume').val(),
				prenume: $('#prenume').val(),
				telefon: $('#telefon').val()
			};

		$.ajax({
			type: 'POST',
			url:'http://localhost:8080/client/createNewClient/'+$nume+'/'+$prenume+'/'+$telefon,
			dataType: 'json',
			success: function(){
				alert('Bravo ma !');
				addClient(myClient);
			},
			error:function(){
				alert('Bravo ma !');
				addClient(myClient);
			}

		});
	});

$("#request_temp").click(function(){
	$.ajax({
		type: 'GET',
		url: 'http://localhost:8080/client/getClients',
		dataType: 'json',
		success: function(clients){
			$.each(clients, function(i, client){
				addClient(client);
			});
		},
		error: function(){
			alert('error loading clients');
		}

	});
  });

$clients.delegate('.remove', 'click', function(){

	var $li = $(this).closest('li');

	$.ajax({
		type: 'POST',
		url: 'http://localhost:8080/client/deleteClientByName/' + $(this).attr('data-id'),
		success: function(){
			$li.fadeOut(800, function(){
				$(this).remove();
			});
		}
	});

	});
});