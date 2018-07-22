package pl.sdacademy.tdd;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class PizzaLombok {

	private String dough = "";
	private String sauce = "";
	private String topping = "";

}
