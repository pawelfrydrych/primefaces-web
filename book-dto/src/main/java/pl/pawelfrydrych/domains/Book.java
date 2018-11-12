package pl.pawelfrydrych.domains;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {

	private String author;
	private String title;
	private String isbn;

}
