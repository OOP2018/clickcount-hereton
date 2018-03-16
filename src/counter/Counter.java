package counter;

import java.util.Observable;

/**
 * A simple counter.
 */

public class Counter extends Observable {
	private int count = 0;

	public void add(int howmuch) {
		count += howmuch;
		// TODO notify the observers that the value has changed!
		// TODO to minimize call-backs from the Observers, include
		// TODO the new counter value as a parameter to notifyObserver().
		// Its like if the Bank sends you an SMS whenever money
		// is deposited in your account. If the SMS just says
		// "you received a deposit" then you need to login to check it.
		// If the SMS says "you received 5,000 Bt from xxx" then you
		// have everything you need.
		setChanged();
		notifyObservers(this.count);
	}

	public int getCount() {
		return count;
	}
}
