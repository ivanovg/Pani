package exersize7.event_simulation.des.src.main.java.edu.hm.cs.algdat17.des.bar;

import exersize7.event_simulation.des.src.main.java.edu.hm.cs.algdat17.des.generic.Simulator;

/**
 * Created by Panteha on 5/16/2017.
 */
public class BarSimulation {

    public static void main(String[] args) {

        // Erzeuge Zustandsobjekt
        Bar bar = new Bar();

        // Erzeuge Simulation mit Zeithorizont 3*3600 (3 Stunden = 3*3600 Sekunden)
        Simulator<Bar> sim = new Simulator<Bar>(bar, 3*3600);

        // Lege initialles Event (Erster Kunde bestellt Bier) ab.
        sim.insert(new OrderBierEvent(0.0));

        // Lasse Simulator laufen
        while (sim.hasMoreEvents()) {
            sim.handleNextEvent();
        }

        // Werte Simulation aus
        System.out.println("Durchschnittliche Wartezeit fuer Bier ist: " + bar.getAverageTime() + " Sekunden");
    }
}
