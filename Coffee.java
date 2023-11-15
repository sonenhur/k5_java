import java.util.Arrays;

public class Coffee {
	private String name;
	private int price;

	public Coffee(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return this.name;
	}

	public int getPrice() {
		return this.price;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Coffee[] coffees = new Coffee[] { new Coffee("Americano", 3500), new Coffee("Green tea Latte", 5500),
				new Coffee("Vanilla Latte", 4500), new Coffee("Espresso", 3000) };

		Arrays.sort(coffees); // ERROR
		for (Coffee coffee : coffees) {
			System.out.println(coffee.toString());
		}
	}

}
