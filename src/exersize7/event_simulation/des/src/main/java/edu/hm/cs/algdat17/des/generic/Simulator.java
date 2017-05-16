package exersize7.event_simulation.des.src.main.java.edu.hm.cs.algdat17.des.generic;

import java.util.PriorityQueue;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Konrete Simulator-Umgabung. Verwendet eine Priority-Queue zur Auswahl des
 * nächsten Events.
 * 
 * @author katz.bastian
 *
 * @param <T>
 *            typ des Zustandsobjektes.
 */
public class Simulator<T> extends AbstractSimulator<T> {
	private static final Logger LOG = LoggerFactory.getLogger(Simulator.class);
	private static Random random = new Random();

	/**
	 * Zustandsobjekt zur Repräsentation der beobachteten Welt und Sammlung von
	 * Analysedaten.
	 */
	private T world;

	/** Ende der Simulation spätere Ereignisse werden ignoriert. */
	private double end;

	/**
	 * Interne PQ zur Verwaltung der Ereignisse.
	 */
	private PriorityQueue<TimedEvent<T>> events = new PriorityQueue<>();

	public Simulator(T world, double end) {
		super();
		this.world = world;
		this.end = end;
	}

	@Override
	public void insert(TimedEvent<T> e) {
		if (e.getTime() > end) {
			LOG.debug("Discarding event {} (event after end of simulation).", e);
		} else {
			LOG.debug("Inserting event {}.", e);
			events.add(e);
		}
	}

	@Override
	public boolean hasMoreEvents() {
		return !events.isEmpty();
	}

	@Override
	public void handleNextEvent() {
		if (!hasMoreEvents()) {
			throw new RuntimeException("No more events to handle.");
		}
		TimedEvent<T> e = events.poll();
		LOG.debug("Executing event {}.", e);
		e.execute(this, world);
	}

	@Override
	public Random getRandom() {
		return random;
	}

}
