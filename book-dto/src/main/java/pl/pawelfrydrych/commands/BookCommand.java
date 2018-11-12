package pl.pawelfrydrych.commands;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookCommand {

	private String author;
	private String title;
	private String isbn;

}
