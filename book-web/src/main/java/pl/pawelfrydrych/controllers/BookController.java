package pl.pawelfrydrych.controllers;

import com.google.gson.Gson;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.ws.rs.core.MediaType;

import pl.pawelfrydrych.commands.BookCommand;
import pl.pawelfrydrych.domains.Book;
import pl.pawelfrydrych.utils.BookUtil;

@ViewScoped
@ManagedBean
public class BookController {

	private static final Logger LOG = LoggerFactory.getLogger(BookController.class);

	@ManagedProperty(value = "#{restClient}")
	@Getter
	@Setter
	private RestClient restClient;

	@Getter
	@Setter
	private Book[] books;

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
		Gson gson = new Gson();
		ClientResponse clientResponse = restClient.clientGetResponse("books");

		String response = clientResponse.getEntity(String.class);
		books = gson.fromJson(response, Book[].class);
	}

	public void saveForm() {

		BookCommand bookCommand = new BookCommand(this.author, this.title, this.isbn);
		LOG.info("Saving book: {} ", bookCommand);

		makePostRequest(bookCommand);

		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success! Book saved successfully", "");
		FacesContext.getCurrentInstance().addMessage(null, message);

		BookUtil.redirect("list.xhtml");
	}

	private void makePostRequest(BookCommand bookCommand) {
		WebResource webResource = restClient.getWebResource("books");

		ClientResponse clientResponse = webResource
				.accept("application/json")
				.type(MediaType.APPLICATION_JSON_TYPE)
				.post(ClientResponse.class, bookCommand);

		if (clientResponse.getStatus() != 201) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ clientResponse.getStatus());
		}
	}

}
