package exersize7.event_simulation.des.src.main.java.edu.hm.cs.algdat17.des.demo;


import exersize7.event_simulation.des.src.main.java.edu.hm.cs.algdat17.des.generic.Simulator;

public class DemoSimulation {
	
	public static void main(String[] args) {
		
		// Erzeuge Zustandsobjekt
		Room room = new Room();
		
		// Erzeuge Simulation mit Zeithorizont 3600 (Sekunden)
		Simulator<Room> sim = new Simulator<Room>(room, 3600);

		// Lege initiales Event (erster Kunden betritt den Raum) ab.
		sim.insert(new EnterRoomEvent(0.0));
		
		// Lasse Simulation laufen
		while (sim.hasMoreEvents()) {
			sim.handleNextEvent();
		}
		
		// Werte Simulation aus.
		System.out.println("Maximale Anzahl gleichzeitiger Besucher "+room.getMaxNumberOfPeople());
		
	}
}
