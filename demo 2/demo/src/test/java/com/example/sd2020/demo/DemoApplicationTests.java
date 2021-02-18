package com.example.sd2020.demo;

import com.example.sd2020.demo.model.Book;
import com.example.sd2020.demo.model.Client;
import com.example.sd2020.demo.model.FacadeBook;
import com.example.sd2020.demo.model.FacadeClient;
import com.example.sd2020.demo.repository.BookRepository;
import com.example.sd2020.demo.repository.ClientRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class DemoApplicationTests {

	@Mock
	BookRepository bookRepository;
	ClientRepository clientRepository;

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	private FacadeBook facadeBook;
	private FacadeClient facadeClient;


	@Before
	public void init2(){
		facadeBook = new FacadeBook(bookRepository);
		facadeClient = new FacadeClient(clientRepository);
	}


	@Test
	public void testBook(){
		facadeBook.getBookId(5);
		verify(bookRepository).findById(5);

	}

	@Test
	public void testAssert() {
		Book expectedBook = new Book("Ion","Liviu Rebreanu",7);

		when(bookRepository.findById(5)).thenReturn(expectedBook);
		Book x = facadeBook.getBookId(5);

		assertEquals(x,expectedBook);

	}

	@Test
	public void testAssert2(){

		Book x = new Book();
		Book expectedBook = new Book("Ion", "Liviu Rebreanu", 7);
		when(bookRepository.getBookByTitle("Ion")).thenReturn(expectedBook);

		try{
			x = facadeBook.getBookByTitle("Ion");
		}
		catch (Exception e){
			e.printStackTrace();
		}
		assertEquals(x, expectedBook);

	}

	@Test
	public void testAssert3(){

		bookRepository.deleteAll();
		List<Book> books = bookRepository.findAll();
		List<Book> expectedList = new ArrayList<>();

		assertEquals(expectedList, books);


	}

	@Test
	public void testAssert4() {

		Book rent = new Book("Ionica","Liviu Rebreanu",7);
		Client client = new Client("A","B","123");

	}

	@Test
	public void testAssert5() {

		Client expectedClient = new Client("Murea", "Marius", "0258");
		when(clientRepository.findById(5)).thenReturn(expectedClient);
		Client client = facadeClient.getClientId(5);
		assertEquals(client, expectedClient);


	}

	@Test
	public void testAssert6(){

		Client x = new Client();
		Client expectedClient = new Client("Murea", "Marius", "0258");
		when(clientRepository.findClientByName("Murea")).thenReturn(expectedClient);
		x = facadeClient.getClientByName("Murea");
		assertEquals(x, expectedClient);


	}

	@Test
	public void testClient(){
		facadeClient.getClientId(5);
		verify(clientRepository).findById(5);
	}
}
