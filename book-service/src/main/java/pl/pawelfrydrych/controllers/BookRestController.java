package pl.pawelfrydrych.controllers;

import pl.pawelfrydrych.commands.BookCommand;
import pl.pawelfrydrych.services.BookService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("books")
public class BookRestController {

	@Inject
	private BookService bookService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllBooks() {
		return bookService.getAllBooks();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addBook(BookCommand bookCommand){
		return bookService.addBook(bookCommand);
	}

}
