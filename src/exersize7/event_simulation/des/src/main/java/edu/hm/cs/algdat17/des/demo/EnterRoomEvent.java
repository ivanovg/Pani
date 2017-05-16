package exersize7.event_simulation.des.src.main.java.edu.hm.cs.algdat17.des.demo;

import exersize7.event_simulation.des.src.main.java.edu.hm.cs.algdat17.des.generic.AbstractSimulator;
import exersize7.event_simulation.des.src.main.java.edu.hm.cs.algdat17.des.generic.TimedEvent;

/**
 * Event, das das Betreten des Raumes durch einen Kunden repräsentiert.
 * @author katz.bastian
 */
public class EnterRoomEvent extends TimedEvent<Room> {

	
	public EnterRoomEvent(double time) {
		super(time);		
	}

	@Override
	protected void execute(AbstractSimulator<Room> simulator, Room room) {
		// Änderung am Zustand: Person betritt den Raum
		room.enter(getTime());
		
		
		// Verlassen des Raumes erzeugen (gleichverteilt nach 20-30 Sekunden)
		simulator.insert(new LeaveRoomEvent(getTime()+20+simulator.getRandom().nextInt(10)));
		
		// Ankunft des nächsten Gastes erzeugen (zufälliger Zeitabstand 0 bis 1 Minuten)
		simulator.insert(new EnterRoomEvent(getTime()+simulator.getRandom().nextInt(60)));
	}
	
}
