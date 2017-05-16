package exersize7.event_simulation.des.src.main.java.edu.hm.cs.algdat17.des.generic;

import java.util.Random;

/**
 * Abstrakte Simulator-Klasse. Nimmt {@link TimedEvent}s entgehen und wählt das
 * nächste Event zur Abarbeitung aus und stößt die Abarbeitung an.
 * 
 * @author katz.bastian
 *
 */
public abstract class AbstractSimulator<T> {
	/**
	 * @return eine einheitliche Instanz von {@link Random} zur Verwendung in
	 *         den Events.
	 */
	public abstract Random getRandom();

	/**
	 * Fügt ein Event zur Abarbeitung ein.
	 * 
	 * @param e
	 *            neues Event.
	 */
	public abstract void insert(TimedEvent<T> e);

	/**
	 * @return true genau dann, wenn es noch mehr Events zu bearbeiten gibt.
	 */
	public abstract boolean hasMoreEvents();

	/**
	 * Führt das nächste Event aus.
	 */
	public abstract void handleNextEvent();
}
