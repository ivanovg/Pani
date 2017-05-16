package exersize7.event_simulation.des.src.main.java.edu.hm.cs.algdat17.des.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Room {
	private static final Logger LOG = LoggerFactory.getLogger(Room.class);

	/** Zähler für die aktuell im Raum befindlichen Kunden. */
	private int peopleInRoom = 0;

	/** Analysegröße: Maximale Anzahl der Personen im Raum. */
	private int maxNumberOfPeople = 0;

	public void setPeopleInRoom(int peopleInRoom) {
		this.peopleInRoom = peopleInRoom;
	}

	public int getMaxNumberOfPeople() {
		return maxNumberOfPeople;
	}

	/**
	 * Erhöht die Anzahl der Personen im Raum um 1.
	 * 
	 * @param time
	 *            Zeitpunkt des Betretens
	 */
	public void enter(double time) {
		peopleInRoom++;
		LOG.info("{}s: Kunde betritt den Raum; jetzt {} Personen im Raum.", time, peopleInRoom);
		maxNumberOfPeople = Math.max(peopleInRoom, maxNumberOfPeople);
	}

	/**
	 * Verringert die Anzahl der Personen im Raum um 1.
	 * 
	 * @param time
	 *            Zeitpunkt des Verlassens
	 */
	public void leave(double time) {
		LOG.info("{}s: Kunde betritt den Raum; jetzt {} Personen im Raum.", time, peopleInRoom);
		peopleInRoom--;
	}
}
