package exersize7.event_simulation.des.src.main.java.edu.hm.cs.algdat17.des.generic;

public abstract class TimedEvent<T> implements Comparable<TimedEvent<T>> {
	
	private Double time;

	/**
	 * @return Aktivierungszeitpunkt.
	 */
	protected Double getTime() {
		return time;
	}

	/**
	 * Konstruktor.
	 * 
	 * @param time
	 *            Aktivierungszeitpunkt.
	 */
	public TimedEvent(double time) {
		this.time = time;
	}

	/**
	 * Bearbeitet ein Event, d.h. passt das Zustandsobjekt an und erstellt
	 * Nachfolgeevents
	 * 
	 * @param simulator
	 *            Simulator
	 * @param world
	 *            Zustandsobjekt
	 */
	protected abstract void execute(AbstractSimulator<T> simulator, T world);

	@Override
	public String toString() {
		return getClass().getSimpleName() + "@" + time;
	}

	@Override
	public int compareTo(TimedEvent<T> o) {
		return time.compareTo(o.time);
	}
}
