package pl.pawelfrydrych.services;

import org.modelmapper.ModelMapper;
import pl.pawelfrydrych.commands.BookCommand;
import pl.pawelfrydrych.domains.Book;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class BookService {

	private List<Book> books = new ArrayList<>();

	public Response getAllBooks() {
		return Response.ok(books).build();
	}

	public Response addBook(BookCommand bookCommand) {
		Book book = new ModelMapper().map(bookCommand, Book.class);
		books.add(book);
		return Response.ok(book).status(201).build();
	}

}
