package counter;

import java.util.Scanner;

public class ObserverTest {
	public static void main(String[] args) {
		final Scanner console = new Scanner(System.in);
		Counter counter = new Counter(); // The observable subject
		ConsoleView view = new ConsoleView(counter);
		counter.addObserver(view);

		while (true) {
			System.out.print("Count how many? ");
			int howmany = console.nextInt();
			if (howmany == 0) {
				console.close();
				System.exit(0);
			}
			counter.add(howmany);
		}
	}
}