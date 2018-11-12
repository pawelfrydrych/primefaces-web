package pl.pawelfrydrych.controllers;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

import pl.pawelfrydrych.domains.Book;
import pl.pawelfrydrych.utils.BookUtil;

@ApplicationScoped
@ManagedBean
public class BookController {

	private static final Logger LOG = LoggerFactory.getLogger(BookController.class);

	@Getter
	@Setter
	private List<Book> books;

	@Getter
	@Setter
	private String isbn;

	@Getter
	@Setter
	private String author;

	@Getter
	@Setter
	private String title;

	@PostConstruct
	private void init() {
		books = new ArrayList<>();
	}

	public void saveForm() {

		Book newBook = new Book(this.author, this.title, this.isbn);
		LOG.info("Saving book: {} ", newBook);

		books.add(newBook);

		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success! Book saved successfully", "");
		FacesContext.getCurrentInstance().addMessage(null, message);

		this.title = null;
		this.author = null;
		this.isbn = null;

		BookUtil.redirect("list.xhtml");
	}

}
